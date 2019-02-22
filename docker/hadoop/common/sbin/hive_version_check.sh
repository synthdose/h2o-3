#!/bin/bash -ex

if [ "$HIVE_HOME" = "" ]
then
    HIVE=hive
else
    HIVE="$HIVE_HOME/bin/hive"
fi
HIVE_VERSION_MAJOR=$($HIVE --version | grep -E '^Hive' | sed -E 's/Hive ([0-9])\..*/\1/')
if [ "$HIVE_VERSION_MAJOR" = "2" ]
then
    exit 0
else
    # no hive or hive 1.x or hive 0.x
    exit 1
fi
