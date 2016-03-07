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
    int[][] signatureMatrix = new int[numHashes][numColumns];

    for (int i = 0; i < numHashes; i++) {
      Arrays.fill(signatureMatrix[i], Integer.MAX_VALUE);
    }

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

    System.out.println("Similarity: " +  similarity(
      getColumn(signatureMatrix, 1, numHashes),
      getColumn(signatureMatrix, 2, numHashes)));
  }
 
  public static int[] getColumn (int[][] matrix, int index, int columnLength) {
    int[] col = new int[columnLength];
    for (int i = 0; i < columnLength; i++) {
      col[i] = matrix[i][index];
    }
    return col;
  }

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
