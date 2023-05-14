#!/bin/env bash

echo "sudo perf mem record -a &"
sudo perf mem record -a -o $1 &
echo "Perf start: DONE!"
