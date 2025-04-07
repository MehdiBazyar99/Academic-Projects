> 🇩🇪 **Für die deutsche Version dieses Projekts, siehe [README_de.md](README_de.md).**

# 🎓 Academic Projects

Welcome to my collection of university coursework, coding exercises, and personal practice projects. These were developed throughout my undergraduate studies to build hands-on experience in areas like:

- Systems programming
- Desktop application development
- Networking and low-level logic
- Cryptographic techniques and secure coding

> ⚠️ **Disclaimer:** Many of these projects were developed under time constraints or as part of academic assignments. As such, some may contain incomplete features, inefficient logic, or bugs. They are shared here for educational purposes only.

---

### ♻️ Project 1: Smart Trash Bin Monitoring System (Arduino + ESP8266)

#### 📌 Description  
A real-world IoT project designed to monitor trash bin fill levels, weight, and environmental hazards (like gas or flame), then transmit the data to a cloud MQTT server (HiveMQ). This project explores **sensor networks**, **embedded programming**, and **cloud-based communication**.

The current version uses a two-board architecture:
- **Arduino Uno** reads sensors (ultrasonic, flame, MQ2 gas, load cell) and sends data via JSON over serial.
- **NodeMCU ESP8266** receives the data, connects to Wi-Fi, and publishes to an MQTT topic.

#### 🔍 Features
- Ultrasonic sensor for bin fill level
- Load cell + HX711 for weight measurement
- Gas and flame detection (MQ2 + IR)
- JSON-formatted serial communication
- MQTT publishing via NodeMCU + PubSubClient

#### 📁 Structure
```
SmartBin/
├── smartbin_sensor_uno.ino       # Sensor logic (Arduino Uno)
├── smartbin_gateway_nodemcu.ino  # MQTT logic (NodeMCU)
└── project_notes.txt             # Design overview and future plans
```

#### 🧠 Key Concepts
- Embedded system communication
- Sensor data aggregation and formatting
- Serial protocols between microcontrollers
- Wi-Fi and MQTT integration in IoT
- Lightweight JSON handling with ArduinoJson

#### 📈 Future Roadmap
A second version is in development to consolidate all functionality into a single NodeMCU board. Planned upgrades include:
- OLED display for live status
- Multiplexer-controlled LED indicators
- Calibration and restart buttons
- Audio alerts via buzzer
- More efficient GPIO and power management

---

### 🧠 Project 2: Per-Core CPU Usage Monitor (`PerC5.py`)

#### 📌 Description  
A low-level Linux CPU monitor written in pure Python. It reads directly from the `/proc` filesystem to compute real-time CPU usage per core — like a simplified `top` or `htop`, implemented from scratch.

#### 🔍 Features
- Monitors each core individually
- Parses `/proc/<pid>/stat` for process CPU time
- Aggregates usage by CPU core
- Pure Python, no external libraries

#### 🚀 Usage
```bash
python3 PerC5.py <wait_time_in_seconds>
```

---

### 🎮 Project 3: Snake Game (Java)

#### 📌 Description  
A graphical Snake game implemented in Java Swing with multiple levels and image-based assets. Created to explore GUI programming, game loops, and event handling in Java.

> ⚠️ **Note:** This version is a work-in-progress and may contain bugs or incomplete features.

#### 🔍 Features
- Level system with multiple custom maps
- Menu UI with level selection
- Image assets for snake, apples, and obstacles
- Keyboard input handling

#### 📁 Structure
```
SnakeGame/
├── doc/                  # Documentation and report
├── nbproject/Snake/      # NetBeans project setup
├── src/                  # Java classes and image resources
```

---

### 🏨 Project 4: Hotel Management System (JavaFX + MySQL)

#### 📌 Description  
A Hotel Management System developed as part of my university coursework, using **JavaFX** for the GUI and **MySQL** for data persistence. The project was built to practice object-oriented design, JavaFX development, and relational database modeling.

It provides a basic simulation of a hotel’s operations, including booking, guest registration, room and service management, and analytical queries for business insights.

> ⚠️ **Note:** The project is incomplete and was created primarily for educational purposes. Some features are still under development or use placeholder logic (e.g., hardcoded login credentials).

---

#### 🔍 Features
- JavaFX-based UI with multiple tabs and data views
- Login screen (basic session simulation)
- Guest, hotel, room, and service management (CRUD operations)
- Booking system with check-in/check-out tracking
- Analytical features, such as:
  - Most profitable guests
  - Most frequently used rooms, hotels, and services
  - Most profitable cities
  - Hotels not visited by a guest in a specific city

---

#### 🧩 Technologies Used
- Java 8+
- JavaFX (FXML + SceneBuilder)
- MySQL (via JDBC)
- SQL-based reporting

---

#### 📁 Structure
```
HMS-Real/
├── docs/            # Schema diagrams and documentation
├── resources/       # FXML UI files (JavaFX)
├── src/sample/      # Java classes (controllers, models)
├── sql/             # Schema creation, insert scripts, and analysis queries
└── FileList.txt     # Auto-generated file listing
```

---

#### 🗃️ Database Design

The system uses a normalized relational schema, with separate tables for:
- Hotels, guests, rooms, services
- Bookings and service usage
- Addresses (linked to both hotels and guests)
- Room types and invoices

📌 See `docs/schemaV3.png` for the full ER diagram.  
📄 SQL scripts for schema creation and queries are included under `sql/`.

---

### 🧮 Project 5: x86 Assembly Examples (`AssemblyProjects/`)

#### 📌 Description  
A small collection of x86 Assembly programs using NASM for Linux. These examples demonstrate bit-level operations, loops, conditionals, and working with registers.

> ⚠️ Educational only — not optimized or structured for production.

#### 📄 Notable Files
- `64bit_Addition.asm` — Adds two 64-bit integers using 32-bit registers
- `Perfect_Numbers.asm` — Finds perfect numbers from 1 to 1000
- `AgeCalculator.asm` — Moved to next project (MIPS variant)

#### 🛠 Requirements
- NASM assembler
- Linux (32-bit support)
- `asm_io.inc` for I/O

---

### 📏 Project 6: Age Calculator in MIPS Assembly (`AgeCalculator.asm`)

#### 📌 Description  
A MIPS Assembly implementation of an age calculator based on input birth date and current date. Built using the MARS 4.5 IDE and translated from an earlier Java version.

#### 🧠 Concepts Explored
- User interaction with MIPS syscalls
- Conditional logic and branching
- Working with `.data` and `.text` memory segments
- Manual date calculations

#### 📄 Files
- `AgeCalculator.asm` — Source code
- `گزارش کار.pdf` — Persian-language report with breakdown

---

### 🐍 Project 7: Python Cryptography & Programming Exercises (`PythonCryptoExercises/`)

#### 📌 Description  
A set of beginner-to-intermediate Python scripts exploring basic logic and cryptographic attacks. Includes experiments with brute-force search, bit manipulation, and attack simulations.

#### 📄 Key Files

| File Name                  | Purpose |
|---------------------------|---------|
| `ManualStringReversal.py` | Reverses strings manually |
| `IndexBasedSwap.py`       | Swaps list elements |
| `DESBruteForceParallel.py`| Brute-forces DES keys using multithreading |
| `BitFlipBase64Attack.py`  | Demonstrates bit-flipping attacks on Base64-encoded ciphertext |

#### 🛠 Requirements
```bash
pip install pycryptodome
```

---

Feel free to explore any project folder. Feedback and suggestions are always welcome!
