#!/usr/bin/env bash

# bin=`dirname "$0"`
# bin=`cd "$bin"; pwd`
# 
# . "$bin"/config.sh

jvm_pid_list=$(jps | grep -i 'TaskManager' | awk '{print $1}')

events="-e cpu/core/LLC-load-misses -e cpu_core/LLC-loads -e cpu_core/LLC-store-misses -e cpu_core/LLC-stores"

for jvm_pid in ${jvm_pid_list}
do
    # perf on these JVM processes
    perf record $events -p $jvm_pid -o $perf_${jvm_pid}.data &
done