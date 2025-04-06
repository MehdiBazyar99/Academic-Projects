// smartbin_gateway_nodemcu.ino

/*****************************************************************************************
 * SMART TRASH BIN MONITORING SYSTEM (NodeMCU ESP8266)
 * ----------------------------------------------------------------------------------------
 * This sketch receives JSON data from the Arduino UNO (distance, weight) via SoftwareSerial,
 * and publishes these values to an MQTT server (HiveMQ or EMQX) over WiFi using a secure
 * TLS connection with certificate validation.
 *****************************************************************************************/

#include <ESP8266WiFi.h>
#include <PubSubClient.h>
#include <time.h>
#include <TZ.h>
#include <FS.h>
#include <LittleFS.h>
#include <CertStoreBearSSL.h>

// Update these with values suitable for your network.
const char* ssid       = "Raphael";
const char* password   = "2380401632";
const char* mqtt_server = "ua4c7dcc.ala.us-east-1.emqxsl.com";

// A single, global CertStore for certificate validation
BearSSL::CertStore certStore;
WiFiClientSecure espClient;
PubSubClient *client;

// Connection / timing
unsigned long lastMsg = 0;
#define MSG_BUFFER_SIZE 500
char msg1[MSG_BUFFER_SIZE];
char msg2[MSG_BUFFER_SIZE];
int value = 0;

// SoftwareSerial for communication from Arduino Uno => NodeMCU
#include <SoftwareSerial.h>
#include <ArduinoJson.h>

// NodeMCU pins: D6 = Rx, D5 = Tx
SoftwareSerial nodemcu(D6, D5);

// Received sensor data
int distanceVal;
int weightVal;


/*************************************************************************************************
 *  FUNCTION: setup_wifi()
 *  DESCRIPTION:
 *    - Connects NodeMCU to the specified WiFi network
 *************************************************************************************************/
void setup_wifi() {
  delay(10);
  Serial.println();
  Serial.print("Connecting to ");
  Serial.println(ssid);

  // Start WiFi in Station mode
  WiFi.mode(WIFI_STA);
  WiFi.begin(ssid, password);

  // Wait for connection
  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }
  randomSeed(micros());

  // Print network info
  Serial.println();
  Serial.println("WiFi connected");
  Serial.println("IP address: ");
  Serial.println(WiFi.localIP());
}


/*************************************************************************************************
 *  FUNCTION: setDateTime()
 *  DESCRIPTION:
 *    - Syncs time with an NTP server, required for TLS certificate validation
 *************************************************************************************************/
void setDateTime() {
  configTime(TZ_Asia_Tehran, "asia.pool.ntp.org", "time.nist.gov");
  Serial.print("Waiting for NTP time sync: ");

  time_t now = time(nullptr);
  while (now < 8 * 3600 * 2) {
    delay(100);
    Serial.print(".");
    now = time(nullptr);
  }
  Serial.println();

  struct tm timeinfo;
  gmtime_r(&now, &timeinfo);
  Serial.printf("%s %s", tzname[0], asctime(&timeinfo));
}


/*************************************************************************************************
 *  MQTT callback
 *************************************************************************************************/
void callback(char* topic, byte* payload, unsigned int length) {
  Serial.print("Message arrived [");
  Serial.print(topic);
  Serial.print("] ");
  for (int i = 0; i < length; i++) {
    Serial.print((char)payload[i]);
  }
  Serial.println();

  // Basic LED blink to indicate a message
  if (length > 0) {
    digitalWrite(LED_BUILTIN, LOW);
    delay(500);
    digitalWrite(LED_BUILTIN, HIGH);
  } else {
    digitalWrite(LED_BUILTIN, HIGH);
  }
}


/*************************************************************************************************
 *  FUNCTION: reconnect()
 *  DESCRIPTION:
 *    - Ensures the MQTT connection is active; attempts reconnection with credentials if not
 *************************************************************************************************/
void reconnect() {
  while (!client->connected()) {
    Serial.print("Attempting MQTT connection…");
    String clientId = "ESP8266Client - MyClient";

    // Attempt to connect (MQTT user & password placeholders)
    if (client->connect(clientId.c_str(), "iotbin", "mehdi1648")) {
      Serial.println("connected");
      client->publish("testTopic", "hello world");
      client->subscribe("testTopic");
    } else {
      Serial.print("failed, rc = ");
      Serial.print(client->state());
      Serial.println(" try again in 5 seconds");
      delay(5000);
    }
  }
}


/*************************************************************************************************
 *  FUNCTION: setup()
 *************************************************************************************************/
void setup() {
  delay(500);
  Serial.begin(9600);
  
  // Initialize SoftwareSerial for incoming data from Arduino
  nodemcu.begin(9600);
  
  while (!Serial) {
    // Wait for serial to be available
  }

  // Initialize LittleFS for certificate store
  LittleFS.begin();

  // Connect to WiFi
  setup_wifi();

  // Sync local time for TLS
  setDateTime();

  // Set LED pin mode
  pinMode(LED_BUILTIN, OUTPUT);

  // Initialize certStore
  int numCerts = certStore.initCertStore(LittleFS, PSTR("/certs.idx"), PSTR("/certs.ar"));
  Serial.printf("Number of CA certs read: %d\n", numCerts);
  if (numCerts == 0) {
    Serial.println("No certs found. Did you run certs-from-mozilla.py & upload LittleFS?");
    return;
  }

  // Create a secure client from BearSSL
  BearSSL::WiFiClientSecure *bear = new BearSSL::WiFiClientSecure();
  bear->setCertStore(&certStore);

  // Initialize global PubSubClient with secure connection
  client = new PubSubClient(*bear);
  client->setServer(mqtt_server, 8883);
  client->setCallback(callback);
}


/*************************************************************************************************
 *  FUNCTION: loop()
 *************************************************************************************************/
void loop() {
  // Ensure MQTT is connected
  if (!client->connected()) {
    reconnect();
  }
  client->loop();

  // Process incoming data from Arduino (distance, weight)
  processSerialData();
}


/*************************************************************************************************
 *  FUNCTION: publishData(weight, distance)
 *  DESCRIPTION:
 *    - Publishes the parsed weight and distance values to MQTT
 *************************************************************************************************/
void publishData(int weight, int distance) {
  unsigned long now = millis();
  // Publish every 2 seconds
  if (now - lastMsg > 2000) {
    lastMsg = now;
    value++;
    snprintf(msg1, MSG_BUFFER_SIZE, "weight: %d grams", weight);
    snprintf(msg2, MSG_BUFFER_SIZE, "distance: %d cm", distance);

    Serial.print("Publish message: ");
    Serial.println(weight);
    Serial.println(distance);

    client->publish("weight", msg1);
    delay(100); // small gap to avoid collisions
    client->publish("distance", msg2);
  }
}


/*************************************************************************************************
 *  FUNCTION: processSerialData()
 *  DESCRIPTION:
 *    - Reads JSON from the Arduino over SoftwareSerial
 *    - Extracts "distance" and "weight" from JSON
 *    - Publishes to MQTT
 *************************************************************************************************/
void processSerialData() {
  // Increase buffer size from 48 → 128 for safety
  StaticJsonDocument<128> data;

  DeserializationError error = deserializeJson(data, nodemcu);
  if (error) {
    Serial.print(F("deserializeJson() failed: "));
    Serial.println(error.f_str());
    return;
  }

  distanceVal = data["distance"]; // e.g. 54
  weightVal   = data["weight"];   // e.g. 120

  Serial.println("JSON object received:");
  Serial.print("Distance = ");
  Serial.println(distanceVal);
  Serial.print("Weight   = ");
  Serial.println(weightVal);
  Serial.println("-----------------------------------------");

  // Publish the data via MQTT
  publishData(weightVal, distanceVal);
}
