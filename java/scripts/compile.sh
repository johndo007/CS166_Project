#!/bin/bash
#DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
#PORT= "12801"
# Indicate the path of the java compiler to use
export JAVA_HOME=/usr/csshare/pkgs/jdk1.7.0_17
export PATH=$JAVA_HOME/bin:$PATH

# compile the java program
javac -d ../classes ../src/ProfNetwork.java

#run the java program
#Use your database name, port number and login
java -cp ../classes:../lib/pg73jdbc3.jar ProfNetwork $DB_NAME 12801 $USER

