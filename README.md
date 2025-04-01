# 👨‍💻 University Projects

Welcome to my collection of university projects. These projects were developed as part of my coursework and personal learning.


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
