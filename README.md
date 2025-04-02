# 🎓 Academic Projects

Welcome to my collection of university assignments and practice projects. These were developed throughout my undergraduate studies to gain hands-on experience in:

- Systems programming
- Desktop application development
- Networking and low-level logic
- Cryptographic concepts

> ⚠️ **Disclaimer:** Many of these projects were written under time constraints or as coursework. Some may include bugs, incomplete features, or inefficient code. They are shared here for educational purposes only.

---

### 🧠 Project 1: Per-Core CPU Usage Monitor (`PerC5.py`)

#### 📌 Description
A low-level Linux CPU monitoring tool written in pure Python. It reads from the `/proc` filesystem to calculate real-time per-core CPU usage, similar to `top` or `htop`, but implemented from scratch using no external libraries.

#### 🔍 Features
- Real-time, interval-based CPU usage display
- Parses `/proc/<pid>/stat` to extract process CPU time
- Groups CPU usage by the core each process runs on
- Adapts to any number of CPU cores
- No dependencies — pure Python

#### 🚀 Usage
```bash
python3 PerC5.py <wait_time_in_seconds>
```

---

### 🎮 Project 2: Snake Game (Java)

#### 📌 Description
A classic Snake game built with Java Swing. This version includes multiple levels (`Board1` to `Board7`), a main menu (`Menu.java`), and custom image-based resources.

> ⚠️ **Note:** This project is incomplete and may contain bugs or unpolished logic. Developed as part of a university assignment.

#### 🔍 Features
- Multiple hand-coded levels
- Menu system for level selection
- Graphical sprites for snake, apples, and walls
- Keyboard-based player control

#### 📁 Structure
```
SnakeGame/
├── doc/                  # Documentation (e.g., Snake Project.docx)
├── nbproject/Snake/      # NetBeans project structure
├── src/                  # Java source files + image resources
```

#### ▶️ Run Instructions
- Open the `nbproject/Snake` folder in NetBeans
- Click **Run**

---

### 🏨 Project 3: Hotel Management System (Java + SQL)

#### 📌 Description
A Java Swing-based desktop app simulating a hotel management system. It supports employee, room, and customer management with SQL backend support.

> ⚠️ **Note:** Partially implemented. May lack input validation and complete error handling.

#### 🔍 Features
- Room and employee registration
- Customer check-in/check-out
- Simple login authentication
- Backend powered by custom SQL scripts
- ER diagrams and schema documentation included

#### 📁 Structure
```
HMS_Project/
├── docs/    # ER diagrams, schema visuals, project reports
├── sql/     # SQL scripts (create, insert, query)
└── src/     # Java GUI (Login.java, Dashboard.java, etc.)
```

#### ▶️ Run Instructions
1. Create a MySQL database using the scripts in `sql/`
2. Update DB credentials in `conn.java`
3. Compile and run from `Login.java`

---

### 🧮 Project 4: Assembly Language Examples (`AssemblyProjects/`)

#### 📌 Description
A collection of simple x86 Assembly programs using **NASM** for 32-bit Linux. These demonstrate low-level concepts like register operations, multi-precision arithmetic, and control flow.

> ⚠️ These examples are educational and not optimized for production use.

#### 📄 Included Files
- `64bit_Addition.asm` — Simulates 64-bit addition using `adc` and two 32-bit registers
- `Perfect_Numbers.asm` — Finds all perfect numbers from 1 to 1000
- `AgeCalculator.asm` — See Project 5 below

#### 🛠 Requirements
- Assembler: NASM
- OS: Linux (32-bit)
- Support File: `asm_io.inc` (for I/O operations)

#### ▶️ Build & Run
```bash
nasm -f elf filename.asm
ld -m elf_i386 -o filename filename.o asm_io.o
./filename
```

---

### 📏 Project 5: Age Calculator in MIPS Assembly (`AgeCalculator.asm`)

#### 📌 Description
A **MIPS Assembly** program that calculates a person's age based on their birth date and current date. Built using the **MARS 4.5 simulator**, this project demonstrates how high-level logic (originally written in Java) can be implemented in a RISC-based architecture.

#### 🧠 Key Concepts
- User input/output via MIPS system calls
- Conditional branching and arithmetic operations
- Memory layout using `.data` and `.text` segments
- Basic control flow and register usage

#### 📄 Files
- `AgeCalculator.asm` — MIPS Assembly source
- `گزارش کار.pdf` — Detailed explanation in Persian (includes system call logic)

---

### 🐍 Project 6: Python Programming & Cryptography Exercises (`PythonCryptoExercises/`)

#### 📌 Description
A set of small Python programs focused on basic programming logic and introductory cryptography concepts. Includes brute-force attacks, bit manipulation, and manual logic implementations.

#### 📄 Included Files

| File Name                  | Description |
|---------------------------|-------------|
| `ManualStringReversal.py` | Reverses a string without slicing or built-ins |
| `IndexBasedSwap.py`       | Swaps two elements in a list by index |
| `DESBruteForceParallel.py`| Brute-forces DES using multithreading |
| `BitFlipBase64Attack.py`  | Demonstrates bit-flipping in Base64-encoded DES |

#### 🛠 Requirements
Install required libraries:

```bash
pip install pycryptodome
```

#### ▶️ Run Example
```bash
python3 DESBruteForceParallel.py
```

---

If you'd like to explore the code, feel free to browse each folder. Feedback and contributions are welcome!
```
