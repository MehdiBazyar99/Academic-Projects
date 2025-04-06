// smartbin_sensor_uno.ino

/*****************************************************************************************
 * SMART TRASH BIN MONITORING SYSTEM (Arduino UNO)
 * ----------------------------------------------------------------------------------------
 * This sketch reads data from multiple sensors (Ultrasonic, HX711 for weight, MQ2, etc.)
 * and sends a JSON object {distance, weight} to the NodeMCU (ESP8266) via SoftwareSerial.
 *****************************************************************************************/

// Library HX711 by Bogdan Necula: https://github.com/bogde/HX711
// Library Pushbutton by Pololu: https://github.com/pololu/pushbutton-arduino

#include "HX711.h"
#include <Wire.h>
#include <Adafruit_GFX.h>
#include <Adafruit_SSD1306.h>
#include <Pushbutton.h>

// Serial Comm: Arduino to NodeMCU
#include <SoftwareSerial.h>
#include <ArduinoJson.h>

// Configure SoftwareSerial Pins for Uno -> NodeMCU (5=Rx & 6=Tx)
SoftwareSerial nodemcu(5, 6);

// MQ2 Sensor
#define MQ2pin 8
float sensorValue;  // variable to store MQ2 sensor (digital) reading

// Ultrasonic Sensor SRF05
/*
   VCC to +5V
   GND to GND
   TRIG to digital pin 12
   ECHO to digital pin 13
*/
const int TRIG_PIN = 12;
const int ECHO_PIN = 13;
int distanceCm;

// Display (SSD1306)
#define OLED_RESET 0  // GPIO0 for some boards
Adafruit_SSD1306 display(OLED_RESET);

// HX711 Weight Sensor
// LOADCELL_DOUT_PIN = 2, LOADCELL_SCK_PIN = 3
// REPLACE WITH YOUR CALIBRATION FACTOR
#define LOADCELL_DOUT_PIN 2
#define LOADCELL_SCK_PIN 3
#define CALIBRATION_FACTOR 101

HX711 scale;
int reading;
int lastReading;

// Button for Tare operation
#define BUTTON_PIN 4
Pushbutton button(BUTTON_PIN);


void setup() {
  // Initialize Serial for debugging
  Serial.begin(9600);

  // Initialize the SoftwareSerial for NodeMCU communication
  nodemcu.begin(9600);

  // Initialize Display
  displayInit();

  // Initialize Ultrasonic sensor
  ultraInit();

  // Initialize scale (HX711)
  scaleInit();

  // Initialize MQ2 sensor
  initMq2();
}


void loop() {
  // Clear display and delay
  display.clearDisplay();
  delay(2000);

  // Measure weight via HX711
  getWeight();

  // Clear display again
  display.clearDisplay();
  delay(2000);

  // Measure distance with Ultrasonic
  ultraDistance();

  // Read MQ2 smoke sensor (digital)
  getSmoke();

  // Send the collected distance & weight to NodeMCU as JSON
  sendDataToNodeMCU();
}


/*************************************************************************************************
 *  FUNCTION: sendDataToNodeMCU()
 *  DESCRIPTION:
 *    - Packages the sensor data (distance, weight) into a JSON object
 *    - Sends the JSON to the NodeMCU over SoftwareSerial
 *************************************************************************************************/
void sendDataToNodeMCU() {
  // Increase buffer size for safety (original was 16, which might be too small)
  StaticJsonDocument<64> data;

  data["distance"] = distanceCm;
  data["weight"]   = reading;

  // Serialize to nodemcu serial
  serializeJson(data, nodemcu);

  // Optionally add a newline for clarity (not strictly required):
  // nodemcu.println();

  delay(2000);  // wait 2s (Note: consider reducing this if quicker data flow is desired)
}


/*************************************************************************************************
 *  FUNCTION: getSmoke()
 *  DESCRIPTION:
 *    - Reads the MQ2 sensor (digital read)
 *    - Logs to Serial (not transmitted via JSON)
 *************************************************************************************************/
void getSmoke() {
  sensorValue = digitalRead(MQ2pin); // read digital output pin
  Serial.print("Digital Output: ");
  Serial.print(sensorValue);

  // Determine the status
  if (sensorValue) {
    Serial.println("  |  Smoke: -");
  } else {
    Serial.println("  |  Smoke: Detected!");
  }

  delay(2000); // wait 2s (could be adjusted if needed)
}


/*************************************************************************************************
 *  FUNCTION: getWeight()
 *  DESCRIPTION:
 *    - Checks if user pressed button to tare (zero) the scale
 *    - Reads weight from HX711
 *    - Prints to Serial and updates OLED display if there's a new reading
 *************************************************************************************************/
void getWeight() {
  // If button is pressed, tare the scale
  if (button.getSingleDebouncedPress()) {
    Serial.print("Tare...");
    scale.tare();
  }

  if (scale.wait_ready_timeout(200)) {
    reading = round(scale.get_units());
    Serial.print("Weight: ");
    Serial.println(reading);

    // Only update display if there's a change
    if (reading != lastReading) {
      displayText(reading, "g", "Weight");
    }
    lastReading = reading;
  }
  else {
    Serial.println("HX711 not found.");
  }
}


/*************************************************************************************************
 *  FUNCTION: ultraDistance()
 *  DESCRIPTION:
 *    - Triggers ultrasonic sensor to measure distance
 *    - Updates global variable distanceCm
 *    - Prints to Serial and displays on OLED
 *************************************************************************************************/
long ultraDistance() {
  long duration, distanceIn;

  digitalWrite(TRIG_PIN, LOW);
  delayMicroseconds(2);
  digitalWrite(TRIG_PIN, HIGH);
  delayMicroseconds(10);
  digitalWrite(TRIG_PIN, LOW);

  duration = pulseIn(ECHO_PIN, HIGH);

  // Convert the time into a distance
  distanceCm = duration / 29.1 / 2;
  distanceIn = duration / 74 / 2;

  if (distanceCm <= 0) {
    Serial.println("Out of range");
  } else {
    Serial.print(distanceCm);
    Serial.println(" cm");
    displayText(distanceCm, "cm", "Distance");
  }

  return distanceCm;
}


/*************************************************************************************************
 *  FUNCTION: displayInit()
 *  DESCRIPTION:
 *    - Initializes the SSD1306 OLED display
 *************************************************************************************************/
void displayInit() {
  display.begin(SSD1306_SWITCHCAPVCC, 0x3C);  // I2C addr 0x3C for the 64x48 display
  display.clearDisplay();
  display.setTextColor(WHITE);
}


/*************************************************************************************************
 *  FUNCTION: displayText(value, unit, name)
 *  DESCRIPTION:
 *    - Clears the display
 *    - Prints name and value + unit
 *************************************************************************************************/
void displayText(int value, String unit, String name) {
  display.clearDisplay();
  display.setTextSize(1);
  display.setTextColor(WHITE);
  display.setCursor(0, 10);
  display.println(name + " :");
  display.display();

  display.setCursor(0, 30);
  display.setTextSize(2);
  display.print(value);
  display.print(" ");
  display.print(unit);
  display.display();
}


/*************************************************************************************************
 *  FUNCTION: ultraInit()
 *  DESCRIPTION:
 *    - Sets up the pinMode for ultrasonic sensor TRIG and ECHO
 *************************************************************************************************/
void ultraInit() {
  pinMode(TRIG_PIN, OUTPUT);
  pinMode(ECHO_PIN, INPUT);
}


/*************************************************************************************************
 *  FUNCTION: scaleInit()
 *  DESCRIPTION:
 *    - Initializes HX711 scale
 *    - Applies calibration factor and tares
 *************************************************************************************************/
void scaleInit() {
  Serial.println("Initializing the scale");
  scale.begin(LOADCELL_DOUT_PIN, LOADCELL_SCK_PIN);
  scale.set_scale(CALIBRATION_FACTOR); // this value is obtained by calibrating with known weights
  scale.tare(); // reset scale to 0
}


/*************************************************************************************************
 *  FUNCTION: initMq2()
 *  DESCRIPTION:
 *    - Warms up the MQ2 sensor (20s delay)
 *************************************************************************************************/
void initMq2() {
  pinMode(MQ2pin, INPUT);
  Serial.println("MQ2 warming up!");
  delay(20000); // allow the MQ2 to warm up
}
