#!/usr/bin/env python

from operator import itemgetter
import sys

current_letter = None
current_count = 0
letter = None

# input comes from STDIN
for line in sys.stdin:
    # remove leading and trailing whitespace
    line = line.strip()

    # parse the input we got from mapper.py
    letter, count = line.split('\t', 1)

    # convert count (currently a string) to int
    try:
        count = int(count)
    except ValueError:
        # count was not a number, so silently
        # ignore/discard this line
        continue

    # this IF-switch only works because Hadoop sorts map output
    # by key (here: letter) before it is passed to the reducer
    if current_letter == letter:
        current_count += count
    else:
        if current_letter:
            # write result to STDOUT
            print '%s\t%s' % (current_letter, current_count)
        current_count = count
        current_letter = letter

# do not forget to output the last letter if needed!
if current_letter == letter:
    print '%s\t%s' % (current_letter, current_count)

