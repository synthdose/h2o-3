#!/bin/bash -xe

export DEBIAN_FRONTEND=noninteractive

echo "deb http://cloud.r-project.org/bin/linux/ubuntu xenial/" >> /etc/apt/sources.list.d/cran.list
apt-key adv --keyserver keyserver.ubuntu.com --recv-keys 51716619E084DAB9
sed -Ei 's/^# deb-src /deb-src /' /etc/apt/sources.list
apt-get update
apt-get -y build-dep r-base
apt-get -y install \
            build-essential \
            libffi-dev \
            libxml2-dev \
            libssl-dev \
            libcurl4-openssl-dev \
            libxft-dev \
            curl
