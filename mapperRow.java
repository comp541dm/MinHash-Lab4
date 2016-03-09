import java.lang.*;
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class mapperRow {

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
      for (int j = 0; j < numColumns; j++) {
        signatureMatrix[i][j] = Integer.MAX_VALUE;
      }
    }

    // mapper(signatureMatrix);
    // Read matrix and pass it into appropriate functions
    int[] row = new int[numColumns];
    for (int i = 0; i < numRows; i++) {
      for (int j = 0; j < numColumns; j++) {
        row[j] = in.nextInt();
      }
      mapperRow(row, i);
    }
  }

  public static int hash (int a, int b, int x) {
    // Uses this formula: h(x, a, b) = ((ax + b) mod p) mod m
    // x = key a = (1, p-1) b = (0,p-1)
    // p = prime > max of x = # of rows
    // m = max possible value + 1 = numHashes
    int p = numRows + 1;
    int m = numHashes;
    a = (a % p-1) + 1;
    b = (b % p);
    return ((a * x + b) % p) % m;
  }
  public static void mapperRow (int[] row, int rowIndex) {
    for (int i = 0; i < numHashes; i++) {
      System.out.print(i + ", ");
      for (int j = 0; j < row.length; j++) {
        if (row[j] == 1) {
          System.out.print(hash(a[i], b[i], rowIndex) + " ");
        } else {
          System.out.print(Integer.MAX_VALUE + " ");
        }
      }
      System.out.println();
    }
  }

} 
