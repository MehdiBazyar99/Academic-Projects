# 🎓 Akademische Projekte

Willkommen zu meiner Sammlung von universitären Projekten, Übungen und praktischen Arbeiten. Diese wurden während meines Informatikstudiums entwickelt, um praktische Erfahrung in den folgenden Bereichen zu sammeln:

- Systemprogrammierung
- Desktop-Anwendungsentwicklung
- Netzwerk- und Low-Level-Programmierung
- Kryptographische Konzepte

> ⚠️ **Hinweis:** Viele dieser Projekte wurden unter Zeitdruck oder im Rahmen von Kursarbeiten erstellt. Sie können unvollständige Funktionen, ineffizienten Code oder Fehler enthalten. Die Projekte dienen ausschließlich zu Lern- und Demonstrationszwecken.

---

### ♻️ Projekt 1: Smart Trash Bin Monitoring System (Arduino + ESP8266)

#### 📌 Beschreibung  
Ein IoT-basiertes System zur Überwachung von Müllbehältern. Es misst Füllstand, Gewicht und erkennt potenzielle Gefahren wie Rauch oder Flammen. Die Daten werden per MQTT an einen Cloud-Server (HiveMQ) übertragen. Das Projekt kombiniert **Sensorik**, **Embedded Systems** und **Cloud-Kommunikation**.

**Architektur (erste Version):**
- **Arduino Uno**: Liest Sensoren (Ultraschall, Flamme, MQ2 Gas, Gewicht) aus und sendet JSON-Daten über SoftwareSerial.
- **NodeMCU ESP8266**: Empfängt die Daten, verbindet sich mit WLAN und sendet sie an den MQTT-Broker.

#### 🔍 Funktionen
- Füllstandserkennung per Ultraschallsensor
- Gewichtsmessung mit Wägezelle und HX711
- Gas- und Flammenerkennung
- JSON-basierte Kommunikation über serielle Schnittstelle
- MQTT-Publishing über WLAN

#### 📁 Projektstruktur
```
SmartBin/
├── smartbin_sensor_uno.ino       # Arduino-Code (Sensorik)
├── smartbin_gateway_nodemcu.ino  # NodeMCU-Code (MQTT)
└── project_notes.txt             # Projektdokumentation und Roadmap
```

#### 🧠 Konzepte
- Integration von Sensoren
- Kommunikation zwischen Mikrocontrollern
- Datenformatierung mit JSON
- WLAN + MQTT-Integration
- Grundlegende IoT-Systemarchitektur

#### 📈 Zukünftige Verbesserungen
Die zweite Version soll alle Funktionen auf dem NodeMCU bündeln. Geplante Erweiterungen:
- OLED-Display zur lokalen Anzeige
- LEDs über Multiplexer (CD4051) gesteuert
- Tasten zur Kalibrierung und Neustart
- Alarmgeber (Buzzer) für Rauch/Flamme
- Optimiertes Strom- und GPIO-Management

---

Weitere Projekte und technische Details findest du in den jeweiligen Ordnern. Rückmeldungen und Verbesserungsvorschläge sind jederzeit willkommen!
