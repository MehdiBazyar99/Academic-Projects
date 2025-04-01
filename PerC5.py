import os
import sys
import time

# Read wait time from command line
if len(sys.argv) == 2:
    wait_time = int(sys.argv[1])
else:
    print("No Wait Time specified.")
    sys.exit(1)

# Get number of CPU cores
core_count = os.cpu_count()
core_keys = [str(i) for i in range(core_count)]

# Get number of clock ticks per second (usually 100)
HZ = os.sysconf(os.sysconf_names['SC_CLK_TCK'])

# Function to read memory info
def mem_info():
    meminfo = dict((line.split()[0].rstrip(':'), int(line.split()[1])) 
                   for line in open('/proc/meminfo').readlines())
    mem_kib = meminfo['MemTotal']
    print(f"Total Memory: {mem_kib} KiB")

# Collect a snapshot of process CPU times mapped by PID
def get_process_stats():
    stats = {}
    for pid in [d for d in os.listdir('/proc') if d.isdigit()]:
        try:
            with open(f"/proc/{pid}/stat", 'r') as f:
                fields = f.readline().split()
                utime = int(fields[13])
                stime = int(fields[14])
                cpu_core = fields[38]
                stats[pid] = (utime + stime, cpu_core)
        except IOError:
            continue  # Process might have exited
    return stats

# Main monitoring loop
while True:
    mem_info()
    
    # Take first snapshot
    start_stats = get_process_stats()
    
    time.sleep(wait_time)
    os.system('clear')  # Clear terminal output

    # Take second snapshot
    end_stats = get_process_stats()

    # Calculate deltas per core
    core_deltas = {core: 0 for core in core_keys}

    for pid in end_stats:
        if pid in start_stats:
            start_time, core = start_stats[pid]
            end_time, _ = end_stats[pid]
            delta = end_time - start_time
            if core in core_deltas:
                core_deltas[core] += delta

    # Convert ticks to seconds and normalize over the interval
    print("Per-core CPU usage (%):")
    total = 0
    for core in core_keys:
        ticks_used = core_deltas[core]
        seconds = ticks_used / HZ
        usage_percent = round(min((seconds / wait_time) * 100, 100))
        print(f"Core {core}: {usage_percent}%")
        total += usage_percent

    print(f"Total: {total}%\n")
