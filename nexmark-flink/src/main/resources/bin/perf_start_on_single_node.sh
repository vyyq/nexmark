#!/usr/bin/env bash

# bin=`dirname "$0"`
# bin=`cd "$bin"; pwd`
# 
# . "$bin"/config.sh

jvm_pid_list=$(jps | grep -i 'TaskManagerRunner' | awk '{print $1}')

echo "jvm_pid_list: ${jvm_pid_list}"

events="-e LLC-load-misses -e LLC-loads -e LLC-store-misses -e LLC-stores"

for jvm_pid in ${jvm_pid_list}
do
    # perf on these JVM processes
    echo "perf record $events -p $jvm_pid -o perf_${jvm_pid}.data -F 99 -m 2048 &"
    perf record $events -p $jvm_pid -o perf_${jvm_pid}.data -F 99 -m 2048 &
    sleep 0.5
done

echo "Perf start: DONE!"
