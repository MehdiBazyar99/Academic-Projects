> 🇬🇧 **For the English version of this project, see [README.md](README.md).**

# 🎓 Akademische Projekte

Willkommen zu meiner Sammlung von Kursarbeiten, Programmierübungen und persönlichen Projekten aus dem Studium. Diese Projekte wurden entwickelt, um praktische Erfahrungen in Bereichen wie:

- Systemprogrammierung
- Desktop-Anwendungsentwicklung
- Netzwerk- und Low-Level-Logik
- Kryptografie und sichere Programmierung

> ⚠️ **Hinweis:** Viele dieser Projekte sind unter Zeitdruck oder im Rahmen von Kursarbeiten entstanden. Einige enthalten möglicherweise unvollständige Funktionen, ineffiziente Logik oder Bugs. Sie dienen ausschließlich zu Lern- und Demonstrationszwecken.

---

### ♻️ Projekt 1: Smart Trash Bin Monitoring System (Arduino + ESP8266)

#### 📌 Beschreibung  
Ein praxisnahes IoT-Projekt zur Überwachung des Füllstands, Gewichts und potenzieller Gefahren (z. B. Gas oder Flammen) in einem Müllbehälter. Die gesammelten Daten werden per MQTT an einen Cloud-Server (HiveMQ) gesendet. Dieses Projekt behandelt **Sensornetzwerke**, **Embedded Programming** und **Cloud-Kommunikation**.

Die aktuelle Version basiert auf einer Zwei-Board-Architektur:
- **Arduino Uno** liest Sensoren (Ultraschall, Flamme, MQ2, Wägezelle) und sendet JSON-formatierte Daten über Serial.
- **NodeMCU ESP8266** empfängt diese Daten, stellt eine WLAN-Verbindung her und veröffentlicht sie über MQTT.

#### 🔍 Funktionen
- Füllstandserkennung über Ultraschallsensor
- Gewichtsmessung mit Wägezelle + HX711
- Erkennung von Gas (MQ2) und Flamme (IR)
- Serielle Kommunikation im JSON-Format
- MQTT-Publishing über PubSubClient

#### 📁 Struktur
```
SmartBin/
├── smartbin_sensor_uno.ino       # Arduino-Code für Sensorik
├── smartbin_gateway_nodemcu.ino  # NodeMCU-Code für MQTT-Kommunikation
└── project_notes.txt             # Projektskizze und zukünftige Erweiterungen
```

#### 🧠 Schlüsselkonzepte
- Kommunikation zwischen eingebetteten Systemen
- Aggregation und Formatierung von Sensordaten
- Serielle Protokolle zwischen Mikrocontrollern
- WLAN- und MQTT-Integration im IoT
- Leichtgewichtige JSON-Verarbeitung mit ArduinoJson

#### 📈 Zukunftspläne
Eine zweite Version ist in Arbeit, die alle Funktionen auf einem einzigen NodeMCU-Board konsolidiert. Geplante Erweiterungen:
- OLED-Display zur Live-Anzeige
- Multiplexer-gesteuerte LED-Indikatoren
- Kalibrierungs- und Reset-Taster
- Summer für akustische Warnungen
- Effizienteres GPIO- und Energiemanagement

---

### 🧠 Projekt 2: CPU-Auslastung pro Kern (`PerC5.py`)

#### 📌 Beschreibung  
Ein Low-Level-CPU-Monitor für Linux, geschrieben in reinem Python. Er liest direkt aus dem `/proc`-Dateisystem, um die Auslastung pro CPU-Kern in Echtzeit zu berechnen – ähnlich wie `top` oder `htop`, aber komplett eigenständig implementiert.

#### 🔍 Funktionen
- Echtzeitüberwachung jedes einzelnen Kerns
- Analyse von `/proc/<pid>/stat` zur Ermittlung von Prozesszeiten
- Gruppierung der Nutzung nach CPU-Kern
- Keine Abhängigkeiten – reines Python

#### 🚀 Verwendung
```bash
python3 PerC5.py <wartezeit_in_sekunden>
```

---

### 🎮 Projekt 3: Snake Game (Java)

#### 📌 Beschreibung  
Ein grafisches Snake-Spiel in Java Swing mit mehreren Levels und Bildressourcen. Erstellt zur Übung von GUI-Programmierung, Game Loops und Event Handling in Java.

> ⚠️ **Hinweis:** Dieses Projekt ist noch in Arbeit und kann Fehler oder unfertige Logik enthalten.

#### 🔍 Funktionen
- Levelsystem mit mehreren selbstgebauten Karten
- Menüsystem zur Levelauswahl
- Grafiken für Schlange, Äpfel und Hindernisse
- Tastatursteuerung

#### 📁 Struktur
```
SnakeGame/
├── doc/                  # Dokumentation und Bericht
├── nbproject/Snake/      # NetBeans-Projekt
├── src/                  # Java-Code + Bilddateien
```

---

### 🏨 Projekt 4: Hotelverwaltungssystem (Java + SQL)

#### 📌 Beschreibung  
Eine Java-Desktopanwendung zur Simulation eines Hotelmanagementsystems. Beinhaltet UIs für Mitarbeiter-, Raum- und Gästeverwaltung sowie eine MySQL-Datenbankanbindung.

> ⚠️ Eingeschränkte Fehlerbehandlung und Validierung – noch in Entwicklung.

#### 🔍 Funktionen
- Mitarbeiter- und Zimmerregistrierung
- Check-in/Check-out von Gästen
- Einfache Login-Authentifizierung
- Datenbank mit eigenen SQL-Skripten
- Dokumentation mit ER-Diagrammen

#### 📁 Struktur
```
HMS_Project/
├── docs/    # Berichte und Diagramme
├── sql/     # SQL-Skripte
└── src/     # Java Swing UI
```

#### ▶️ Anleitung
1. MySQL-Datenbank mit `sql/`-Skripten erstellen
2. Zugangsdaten in `conn.java` eintragen
3. Projekt starten über `Login.java`

---

### 🧮 Projekt 5: x86-Assembly-Beispiele (`AssemblyProjects/`)

#### 📌 Beschreibung  
Eine Sammlung einfacher x86-Assembly-Programme mit NASM für Linux. Die Beispiele zeigen Bitmanipulation, Schleifen, Registerlogik und bedingte Anweisungen.

> ⚠️ Nur zu Lernzwecken – nicht optimiert.

#### 📄 Wichtige Dateien
- `64bit_Addition.asm` — 64-Bit-Addition mit 32-Bit-Registern
- `Perfect_Numbers.asm` — Perfekte Zahlen von 1–1000
- `AgeCalculator.asm` — Siehe nächstes Projekt (MIPS)

#### 🛠 Voraussetzungen
- NASM Assembler
- Linux (32-Bit)
- `asm_io.inc` für I/O

---

### 📏 Projekt 6: Altersrechner in MIPS Assembly (`AgeCalculator.asm`)

#### 📌 Beschreibung  
Ein MIPS-Assembly-Programm zur Berechnung des Alters anhand von Geburts- und aktuellem Datum. Entwickelt in **MARS 4.5**, übersetzt aus einer früheren Java-Variante.

#### 🧠 Behandelte Konzepte
- Benutzereingaben mit Syscalls
- Bedingte Verzweigungen und Rechenlogik
- Nutzung von `.data`- und `.text`-Segmenten
- Datumsberechnung in Assembly

#### 📄 Dateien
- `AgeCalculator.asm` — Quellcode
- `گزارش کار.pdf` — Erklärung auf Persisch

---

### 🐍 Projekt 7: Python-Kryptografie- und Programmierübungen (`PythonCryptoExercises/`)

#### 📌 Beschreibung  
Eine Sammlung von Python-Skripten zu Programmierlogik und einfachen Kryptografieangriffen. Beinhaltet Brute-Force, Bit-Manipulation und Demonstration von Angriffen auf Base64-kodierte Daten.

#### 📄 Wichtige Dateien

| Datei                      | Beschreibung |
|---------------------------|--------------|
| `ManualStringReversal.py` | String-Umkehr ohne Built-ins |
| `IndexBasedSwap.py`       | Vertauscht Listenelemente |
| `DESBruteForceParallel.py`| Parallel-Brute-Force auf DES |
| `BitFlipBase64Attack.py`  | Bitflipping auf Base64-Daten |

#### 🛠 Abhängigkeiten
```bash
pip install pycryptodome
```

---

Du kannst alle Ordner frei erkunden. Feedback und Anregungen sind jederzeit willkommen!
