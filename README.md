
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

