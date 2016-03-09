import java.lang.*;
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class mapperColumn {

  public static int numColumns;
  public static int numRows;
  public static int numHashes; 
  public static int a[];
  public static int b[];

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    numHashes = Integer.parseInt(args[0]);
    numRows = Integer.parseInt(args[1]);
    numColumns = Integer.parseInt(args[2]);
    a = new int[numHashes];
    b = new int[numHashes];
    int[][] signatureMatrix = new int[numHashes][numColumns];
    // Need some way to generate an array of hashes
    // hash hashes = new hash[numHashes];
    // Uses these combined with hash function for multiple random hashes
    Random rand = new Random();

    // Initialize values in signatureMatrix to MAX
    // and random numbers to a & b
    for (int i = 0; i < numHashes; i++) {
      a[i] = Math.abs(rand.nextInt());
      b[i] = Math.abs(rand.nextInt());
      // System.err.println("a[" + i + "]: " + a[i] + " b[" + i + "]: " + b[i]);
      for (int j = 0; j < numColumns; j++) {
        signatureMatrix[i][j] = Integer.MAX_VALUE;
      }
    }

    // mapper(signatureMatrix);
    // Read matrix and pass it into appropriate functions
    int[] column = new int[numRows];
    for (int i = 0; i < numColumns; i++) {
      for (int j = 0; j < numRows; j++) {
        column[j] = in.nextInt();
      }
      mapperColumn(column, i);
    }
  }

  public static int hash (int a, int b, int x) {
    // Uses this formula: h(x, a, b) = ((ax + b) mod p) mod m
    // x = key a = (1, p-1) b = (0,p-1)
    // p = prime > max of x = # of rows
    // m = max possible value + 1 = numHashes
    int p = 11;
    int m = 100;
    a = (a % p-1) + 1;
    b = (b % p);
    return ((a * x + b) % p) % m;
  }

  public static void mapperColumn (int[] column, int columnIndex) {
    int[] sigColumn = new int[numHashes];
    Arrays.fill(sigColumn, Integer.MAX_VALUE);
    for (int i = 0; i < column.length; i++) {
      if (column[i] == 1) {
        for (int j = 0; j < numHashes; j++) {
          if (hash(a[j], b[j], i) < sigColumn[j]) {
            sigColumn[j] = hash(a[j], b[j], i);
          }       
        }
      }
    }
    System.out.print(columnIndex + ", ");
    printIntArray(sigColumn);
  }

  public static void printIntArray (int[] arr) {
    for (int i = 0; i < arr.length - 1; i++)
      System.out.print(arr[i] + " ");
    System.out.println(arr[arr.length-1]);
  }
} 
