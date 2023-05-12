#!/usr/bin/env bash

# Find the perf pids
perf_pid_list=$(ps aux | grep -i 'perf record' | grep -v grep | awk '{print $2}')

for perf_pid in ${perf_pid_list}
do
    # kill the perf processes by sending SIGINT signal
    kill -2 $perf_pid
done
