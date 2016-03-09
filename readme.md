# Data Mining Lab 4
 - Suppose we want to use a MapReduce framework to compute minhash signatures.

 - If the matrix is stored in chunks that correspond to some columns, then it is quite easy to exploit parallelism. Each Map task gets some of the columns and all the hash functions, and computes the minhash signatures of its given columns. Design Map and Reduce functions to exploit MapReduce with data in this form.

 - However, suppose the matrix were chunked by rows, so that a Map task is given the hash functions and a set of rows to work on. Design Map and Reduce functions to exploit MapReduce with data in this form.

# Instructions
 1. Use generateMatrix.py to generate a signature matrix. Pipe it into a file.
 2. Run runMinHashColumn.sh or runMinHashRow.sh to do a minHash on the matrix.
   * By default the matrix file name is testMatrix.txt and # of hashes is 1000
   * You can change either of these by modifying the bash script.
 3. runMinHash* takes 4 commandline arguments:
   1. # of sets
   2. # of elements
   3. First set to compare
   4. Second set to compare

# Other Information
 - Does not currently support concurrency via hadoop/spark. To add concurreny need to
   1. Add commandline argument for index of signatureMatrix
   2. Add output and input for passing relevant parts of a[] and b[] to mappers.
   3. Add controller to setup mappers.
