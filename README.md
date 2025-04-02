
# 👨‍💻 University Projects

Welcome to my collection of university projects. These projects were developed as part of my coursework and personal learning.

---

## 📁 Project 1: Per-Core CPU Usage Monitor (`PerC5.py`)

### 📌 Description
This project is a low-level Linux CPU monitoring tool written in Python. It reads from the `/proc` filesystem to display **per-core CPU usage** in real time, using raw process statistics.

The goal was to build a utility similar to `top` or `htop`, but from scratch — using only Python and Linux system files — to understand how the operating system manages processes, CPU time, and core scheduling.

### 🧠 Key Features
- Real-time **interval-based CPU usage** calculation per core
- Parses `/proc/<pid>/stat` manually to extract process times
- Groups CPU usage by the core each process is running on
- Dynamically adapts to the number of available CPU cores
- Simple terminal output showing total usage per core
- Uses no external libraries (pure Python + Linux)

### 🔧 Usage
```bash
python3 PerC5.py <wait_time_in_seconds>
```

---

## 🎮 Project 2: Snake Game (Java)

### 📌 Description
A feature-rich Snake game written in Java using Swing for the GUI. It was created as a university project and includes multiple levels, a menu system, image-based resources, and custom maps.

> ⚠️ This project is **incomplete** and may contain bugs or unfinished features. It was originally developed for coursework and hasn’t been fully debugged.

### 🧠 Key Features
- Classic snake gameplay across multiple levels (`Board1` to `Board7`)
- Main menu and level selector (with UI in `Menu.java`)
- Custom assets (sprites, map layout, etc.)
- Level logic and player control using Java's KeyListener

### 📁 Structure
```
SnakeGame/
├── doc/                 # Project documentation (e.g. Snake Project.docx)
├── nbproject/Snake/     # NetBeans project with source code and build setup
├── src/                 # Resources and source files (Java + images)
```

### ▶️ Run Instructions
**In NetBeans**
- Open `nbproject/Snake` in NetBeans
- Click Run


---

## 🏨 Project 3: Hotel Management System (Java + SQL)

### 📌 Description
A Java Swing-based desktop application simulating a hotel management system. It allows management of rooms, employees, and customers with backend logic supported by SQL scripts.

> ⚠️ This project is **incomplete** and may contain bugs or partially implemented features. It was developed for a university course.

### 🧠 Key Features
- Room and employee registration
- Customer check-in/check-out system
- Login screen and simple authentication
- Backend logic supported by SQL queries
- ER diagrams and schema documentation included

### 📁 Structure
```
HMS_Project/
├── docs/         # ER diagrams, schema, Word documentation
├── sql/          # SQL scripts for table creation and queries
└── src/          # Java Swing GUI source code (Login.java, Dashboard.java, etc.)
```

### ▶️ Run Instructions
1. Set up a local MySQL database using scripts from the `sql/` folder
2. Ensure database credentials are configured in `conn.java`
3. Run the application starting from `Login.java`

## 🧮 Project 4: Assembly Language Examples (`AssemblyProjects/`)

### 📌 Description
This folder contains simple x86 Assembly programs written using NASM syntax for 32-bit Linux. These projects were developed for learning purposes during university and focus on low-level logic, bitwise arithmetic, and control flow using registers and memory manipulation.

> ⚠️ **Note:** These are **educational examples** and may not represent fully optimized or polished production code. They are meant to demonstrate basic assembly concepts.

---

### 📁 Files Included

#### 🔢 `64bit_Addition.asm`
- **Purpose**: Simulates **64-bit addition** using two 64-bit integers by combining two 32-bit values for each operand.
- **Concepts**: Register-level arithmetic, `adc` for carry handling, multi-precision operations.
- **Learning Focus**: Understanding how CPUs process numbers larger than the register size.

#### 🔍 `Perfect_Numbers.asm`
- **Purpose**: Finds and prints all **perfect numbers** from 1 to 1000.
- **Concepts**: Loops, modulo using `div`, nested iteration, conditional logic, summing factors.
- **Learning Focus**: Classic algorithm implemented at the register/memory level.
---

### 🛠️ Requirements
- **Assembler**: NASM
- **OS**: Linux (with `asm_io.inc` support)
- **Build & Run**:
```bash
nasm -f elf <filename>.asm
ld -m elf_i386 -o <filename> <filename>.o asm_io.o
./<filename>


📁 Project 5: Age Calculator in MIPS Assembly (AgeCalculator.asm)
📌 Description
This project is a MIPS Assembly language program that calculates a user's age based on their birth date and the current date. It uses basic system calls and arithmetic operations in MIPS, simulating user interaction through console input/output in the MARS 4.5 simulator.

The program was originally written in Java and manually converted into MIPS Assembly to better understand how low-level architectures handle logic, branching, and memory management.

🧠 Key Concepts
MIPS system calls for I/O

Labeling and branching for condition checks

Data and text sections for memory management

Control structures implemented in assembly (conditional jumps)

Array and memory offset management

Age calculation algorithm implemented in low-level code

📄 Files
AgeCalculator.asm — The MIPS assembly code

Report.pdf — Detailed explanation (in Persian) of the program logic, system calls used, and architecture background

⚠️ Note
Like some of the other projects, this one may contain bugs or incomplete features. It was created for educational purposes during university coursework.

