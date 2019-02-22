#! /bin/bash

set -x -e

if [ -z ${HIVE_VERSION} ]; then
    echo "HIVE_VERSION must be set"
    exit 1
fi

# Download and initialize HIVE
cd /home/hive
wget http://archive.apache.org/dist/hive/hive-${HIVE_VERSION}/apache-hive-${HIVE_VERSION}-bin.tar.gz
tar -xzf apache-hive-${HIVE_VERSION}-bin.tar.gz
rm apache-hive-${HIVE_VERSION}-bin.tar.gz
chown -R hive:hive apache-hive-*/

find $HIVE_HOME/lib | grep '.jar' | \
    grep -E 'hive-jdbc|hive-common|hive-exec|hive-service|libfb303|libthrift' | \
    tr '\n' ':' > /opt/hive-jdbc-cp
