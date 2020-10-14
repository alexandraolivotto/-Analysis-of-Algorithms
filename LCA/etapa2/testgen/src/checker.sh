#!/bin/bash

## CONSTANTS ##
CURRENT_DIRECTORY=`pwd`
RESOURCES_DIRECTORY="$CURRENT_DIRECTORY/gentest"
GOOD_TESTS=0

## FUNCTIONS ##
function cleanHomework
{
	find . -name "*.class" -type f -delete
}
function compileHomework
{
	if [ -f "$CURRENT_DIRECTORY/FileIO.jar" ]
	then
		unzip FileIO.jar
	fi

	javac -g Main.java

	mkdir "$RESOURCES_DIRECTORY/tests"
}

function checkTest
{
    echo -ne "$1\t.....................................\t"
    java Main "$RESOURCES_DIRECTORY/test/$1" "$RESOURCES_DIRECTORY/tests/$1.in" > /dev/null
	echo -ne "DONE\n"
}

## MAIN EXECUTION ##
cleanHomework
compileHomework

checkTest "test1"
checkTest "test2"
checkTest "test3"
checkTest "test4"
checkTest "test5"
checkTest "test6"
checkTest "test7"
checkTest "test8"
checkTest "test9"
checkTest "test10"
checkTest "test11"
checkTest "test12"
checkTest "test13"
checkTest "test14"
checkTest "test15"


