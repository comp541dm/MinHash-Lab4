#!/usr/bin/env python

import sys
import random

random.seed()
for i in range(0, int(sys.argv[1])):
  for i in range(0, int(sys.argv[2])):
    print random.randint(0,1),
  print 
