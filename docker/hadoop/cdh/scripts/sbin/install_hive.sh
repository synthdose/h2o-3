#! /bin/bash

set -x -e

apt-get install -y hive hive-server2

find /usr/lib/hive/lib | grep 'jdbc-standalone' | tr '\n' ':' > /opt/hive-jdbc-cp
