import java.lang.*;
import java.util.Scanner;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.Arrays;

public class reducerRow {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int numHashes = Integer.parseInt(args[0]);
    int numColumns = Integer.parseInt(args[1]);
    int set1 = Integer.parseInt(args[2]);
    int set2 = Integer.parseInt(args[3]);
    int[][] signatureMatrix = new int[numHashes][numColumns];

    // Fill matrix with MAX_VALUE
    // Algorithmically equivalent to infinity
    for (int i = 0; i < numHashes; i++) {
      Arrays.fill(signatureMatrix[i], Integer.MAX_VALUE);
    }

    // gets HashIndex, and if any hashes are less than current hashes replace them
    // Example of input: 
    // 3, 2 3 3 0 0 0 21411342 1
    while (in.hasNextLine()) {
      String[] line = in.nextLine().split(","); 
      int hashRow = Integer.parseInt(line[0]);
      StringTokenizer st = new StringTokenizer(line[1]);
      for (int column = 0; st.hasMoreTokens(); column++) {
        int currentHashValue = Integer.parseInt(st.nextToken());
        if (currentHashValue < signatureMatrix[hashRow][column]) {
          signatureMatrix[hashRow][column] = currentHashValue;
        }
      }
    } 

    // Checks similarity between 2 sets and outputs it.
    System.out.println("Similarity: between " + set1 + " and set " + set2 + ": " + similarity(
      getColumn(signatureMatrix, set1, numHashes),
      getColumn(signatureMatrix, set2, numHashes)));
  }
 
  // Returns column of 2-dim array
  public static int[] getColumn (int[][] matrix, int index, int columnLength) {
    int[] col = new int[columnLength];
    for (int i = 0; i < columnLength; i++) {
      col[i] = matrix[i][index];
    }
    return col;
  }

  // Calculates similarity of 2 sets
  public static double similarity(int[] s1, int[] s2) {
    double sim = 0;
    for (int i = 0; i < s1.length; i++) {
      if (s1[i] == s2[i]) {
        sim++;
      }
    }
    return sim/(double)s1.length;
  }

} 
