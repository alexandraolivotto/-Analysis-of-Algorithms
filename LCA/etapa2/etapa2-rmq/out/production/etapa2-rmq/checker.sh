#!/bin/bash

## CONSTANTS ##
CURRENT_DIRECTORY=`pwd`
RESOURCES_DIRECTORY="$CURRENT_DIRECTORY/tests"
GOOD_TESTS=0

## FUNCTIONS ##
function cleanHomework
{
	find . -name "*.class" -type f -delete
	rm -rf "$RESOURCES_DIRECTORY/out"
}

function compileHomework
{
	if [ -f "$CURRENT_DIRECTORY/FileIO.jar" ]
	then
		unzip FileIO.jar
	fi

	javac -g Main.java

	mkdir "$RESOURCES_DIRECTORY/out"
}

function checkTest
{
    echo -ne "$1\t.....................................\t"
    java Main "$RESOURCES_DIRECTORY/in/$1.in" "$RESOURCES_DIRECTORY/out/$1.out" > /dev/null

	if [ $? -eq 0 ]; then
        `diff -Bw -u --ignore-all-space $RESOURCES_DIRECTORY/out/$1.out $RESOURCES_DIRECTORY/ref/$1.ref &> /dev/null`
        DIFF_RESULT=$?

        if [ $DIFF_RESULT -eq 0 ]; then
        	echo -ne "OK\n"

			if [[ $1 == *x* ]]; then
            	GOOD_TESTS=$((GOOD_TESTS+5))
        	elif [[ $1 == *dense* ]]; then
            	GOOD_TESTS=$((GOOD_TESTS+21))
        	else
            	GOOD_TESTS=$((GOOD_TESTS+1))
        	fi
        else
           echo -ne "FAIL (files differ)\n"
        fi
    else
        echo -ne 'FAIL (program error)\n'
    fi
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

