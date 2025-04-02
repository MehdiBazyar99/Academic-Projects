# 👨‍💻 University Projects

Welcome to my collection of university assignments and practice projects. These were developed throughout my undergraduate studies to gain hands-on experience in systems programming, desktop development, networking, low-level logic, and basic cryptography.

> ⚠️ **Disclaimer:** Many of these projects were written under time constraints or as part of coursework and may include bugs, incomplete features, or inefficient practices. They are shared here purely for educational purposes.

---

## 🧠 Project 1: Per-Core CPU Usage Monitor (`PerC5.py`)

### 📌 Description
A low-level Linux CPU monitoring tool written in pure Python. It reads from the `/proc` filesystem to calculate **real-time per-core CPU usage**, similar to `top` or `htop`, but without using any external libraries.

### 🔍 Features
- Real-time, interval-based CPU usage display
- Parses `/proc/<pid>/stat` to calculate process CPU time
- Groups CPU usage by the core each process runs on
- Adapts to any number of CPU cores
- Pure Python (no dependencies)

### 🚀 Usage
```bash
python3 PerC5.py <wait_time_in_seconds>
```

---

## 🎮 Project 2: Snake Game (Java)

### 📌 Description
A classic Snake game built with Java Swing. The project includes multiple levels (`Board1` to `Board7`), a main menu (`Menu.java`), and image-based resources.

> ⚠️ **Note:** The game is incomplete and may contain bugs or unpolished code. Originally developed for a university assignment.

### 🔍 Features
- Multiple hand-coded levels with varying difficulty
- Menu system for level selection
- Graphical assets (PNG-based snake, apples, obstacles)
- Player control via keyboard input

### 📁 Structure
```
SnakeGame/
├── doc/                  # Documentation (e.g., Snake Project.docx)
├── nbproject/Snake/      # NetBeans project with Java source and build configs
├── src/                  # Source code + image resources
```

### ▶️ Run Instructions
Open the `nbproject/Snake` folder in NetBeans and run the project.

---

## 🏨 Project 3: Hotel Management System (Java + SQL)

### 📌 Description
A GUI-based hotel management system written in Java Swing, with SQL scripts to support data storage for employees, rooms, and customer check-ins.

> ⚠️ **Note:** This project is partially implemented and may not include complete error handling or advanced validations.

### 🔍 Features
- Employee, customer, and room management
- Login authentication via `Login.java`
- Check-in and check-out functionality
- SQL backend with table creation, insertion, and queries
- Includes schema diagrams and ER diagrams in the `/docs` folder

### 📁 Structure
```
HMS_Project/
├── docs/    # ER Diagrams, Schema PDFs, Word files
├── sql/     # SQL scripts for DB structure and queries
└── src/     # Java Swing GUI (Login, Dashboard, Room, etc.)
```

### ▶️ Run Instructions
1. Set up a MySQL database using scripts in `sql/`
2. Update DB credentials in `conn.java`
3. Compile and run the project starting from `Login.java`

---

## 🧮 Project 4: Assembly Language Examples (`AssemblyProjects/`)

### 📌 Description
This directory contains beginner-level **x86 Assembly programs** using **NASM** for 32-bit Linux. They demonstrate basic algorithms like multi-precision arithmetic and number classification at the register level.

> ⚠️ Educational code — not optimized for performance or completeness.

### 📄 Included Files
- `64bit_Addition.asm`: Simulates 64-bit addition using two 32-bit numbers with carry handling (`adc`)
- `Perfect_Numbers.asm`: Finds all perfect numbers from 1 to 1000 using loops and factor summing
- `AgeCalculator.asm`: (See Project 5 below)

### 🛠 Requirements
- Assembler: NASM  
- Platform: Linux (32-bit)  
- I/O Support: [`asm_io.inc`](https://www.plantation-productions.com/Webster/)

### ▶️ Build Instructions
```bash
nasm -f elf filename.asm
ld -m elf_i386 -o filename filename.o asm_io.o
./filename
```

---

## 📏 Project 5: Age Calculator in MIPS Assembly (`AgeCalculator.asm`)

### 📌 Description
A simple **MIPS Assembly program** to calculate a person’s age using console input for current date and birth date. Built for the MARS 4.5 simulator.

The program simulates logic translation from a Java version to a RISC-based architecture using branches, memory offsets, and MIPS system calls.

### 🧠 Key Concepts
- Console input/output via system calls
- Conditional branching and arithmetic
- Memory layout with `.data` and `.text`
- Basic control flow and logic structures

### 📄 Files
- `AgeCalculator.asm`: MIPS source code
- `گزارش کار.pdf`: Persian documentation explaining the logic and implementation

---

## 🐍 Project 6: Python Programming & Cryptography Exercises (`PythonCryptoExercises/`)

### 📌 Description
A collection of small Python programs covering basic logic, data manipulation, and beginner cryptographic concepts like brute-force attacks and bit-flipping.

These scripts explore how simple algorithms work behind the scenes using Python’s built-in data structures and libraries like `pycryptodome`.

### 📄 Included Files

| File Name                     | Description |
|------------------------------|-------------|
| `ManualStringReversal.py`    | Reverses a string without slicing; uses loops only |
| `IndexBasedSwap.py`          | Swaps two elements in a list by index |
| `DESBruteForceParallel.py`   | Brute-forces DES with an 8-digit key using multithreading |
| `BitFlipBase64Attack.py`     | Bit-flipping attack on Base64-encoded DES cipher to modify plaintext |

### 🛠 Requirements
Install the required dependency:
```bash
pip install pycryptodome
```

### ▶️ Run Example
```bash
python3 DESBruteForceParallel.py
```
