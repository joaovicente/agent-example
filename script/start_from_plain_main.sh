#!/bin/bash
BASE_DIR="$(dirname $(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd))"
AGENT_JAR=agent/target/agent-1.0-SNAPSHOT-jar-with-dependencies.jar
AGENT_FULL_PATH=$BASE_DIR/$AGENT_JAR
TEST_APP_DIR=$BASE_DIR/testapp
TEST_APP_JAR=$BASE_DIR/testapp/target/testapp-1.0-SNAPSHOT.jar
LIB_DIR=$TEST_APP_DIR/lib

mvn -f $BASE_DIR clean package

pushd $LIB_DIR
CLASSPATH=$(for file in `ls .`; do echo `pwd`/$file; done) 
CLASSPATH=`echo $CLASSPATH | sed 's/ /:/g'`
echo $CLASSPATH
popd
CLASSPATH=$CLASSPATH:$TEST_APP_DIR/target/classes
echo $CLASSPATH
pushd $TEST_APP_DIR

export JAVA_OPTS=" -javaagent:$AGENT_FULL_PATH -classpath $CLASSPATH"
java $JAVA_OPTS com.segeon.testapp.Main
popd
