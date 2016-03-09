#!/usr/bin/env bash

setMatrix="testMatrix.txt"
numHash=1000
numElements=$1
numSets=$2
set1=$3
set2=$4

cat $setMatrix | \
java mapperRow $numHash $numSets $numElements | \
java reducerRow $numHash $numSets $set1 $set2 
