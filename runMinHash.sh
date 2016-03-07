#!/usr/bin/env bash

setMatrix="testMatrix.txt"
numHash=$1
numElements=$2
numSets=$3

cat $setMatrix | \
java mapperColumn $numHash $numSets $numElements | \
java reducerColumn $numHash $numSets 
