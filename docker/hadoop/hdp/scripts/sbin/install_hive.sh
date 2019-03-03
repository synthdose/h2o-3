#! /bin/bash

set -x -e


apt-get install -y hive hive-server2

find /usr/hdp/current/hive-client/lib | grep '.jar' | \
    grep -E 'hive-jdbc|hive-common|hive-exec|hive-service|libfb303|libthrift' | \
    tr '\n' ':' > /opt/hive-jdbc-cp
