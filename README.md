
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
---

### 🧮 Project 4: Assembly Language Examples (`AssemblyProjects/`)

#### 📌 Description  
This folder contains simple **x86 Assembly** programs written using **NASM syntax** for 32-bit Linux. These projects were created for educational purposes during university and focus on low-level logic, bitwise arithmetic, and control flow using registers and memory manipulation.

> ⚠️ These are learning exercises and may not be optimized for performance or best practices. They are meant to demonstrate basic assembly programming concepts.

#### 📁 Files Included

- **`64bit_Addition.asm`**  
  🧮 Simulates 64-bit addition by combining two 32-bit values for each operand.  
  **Concepts:** Multi-precision arithmetic, register handling, `adc` (add with carry).  
  **Learning Focus:** Understanding how to process large integers beyond native register size.

- **`Perfect_Numbers.asm`**  
  🔍 Finds and prints all perfect numbers from 1 to 1000.  
  **Concepts:** Loops, modulo (`div`), nested iterations, factor summing.  
  **Learning Focus:** Classic algorithm implemented at the low-level using registers and memory.

- **`AgeCalculator.asm`** (See Project 5 below)

#### 🛠️ Requirements
- **Assembler:** NASM  
- **OS:** Linux (32-bit)  
- **Dependencies:** [`asm_io.inc`](https://www.plantation-productions.com/Webster/) (used for input/output)

#### ▶️ Build & Run Instructions:
```bash
nasm -f elf <filename>.asm
ld -m elf_i386 -o <filename> <filename>.o asm_io.o
./<filename>
```

---

### 📁 Project 5: Age Calculator in MIPS Assembly (`AgeCalculator.asm`)

#### 📌 Description  
This is a **MIPS Assembly language program** that calculates a person's age based on their birth date and the current date. It was written using the **MARS 4.5 simulator**, and simulates interactive input/output through system calls.

The original logic was written in Java, then manually translated to MIPS to explore how control flow, branching, and memory access are handled in a RISC architecture.

#### 🧠 Key Concepts
- MIPS system calls for console I/O  
- Labels and conditional branching  
- Control structures using jump and comparison instructions  
- Memory layout via `.data` and `.text` sections  
- Manual date comparison and arithmetic  
- Educational conversion from high-level logic to low-level assembly

#### 📄 Files
- **`AgeCalculator.asm`** — Complete MIPS assembly source code  
- **`گزارش کار.pdf`** — Persian report explaining the program, its logic, and system call usage in detail

> ⚠️ Like other university projects, this one may contain bugs or incomplete features. It was developed for learning purposes and is not production-grade.

---


