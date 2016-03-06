import java.lang.*;
import java.util.Scanner;
import java.util.Random;

public class reducerColumn {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int numColumns = 10;
    int numHashes = 100;
    int[][] signatureMatrix = new int[numHashes][numColumns];

    for (int i = 0; i < numHashes; i++) {
      for (int j = 0; j < numColumns; j++) {
        signatureMatrix[i][j] = in.nextInt();
      }
    }
    System.out.println("Similarity: " +  similarity(
      getColumn(signatureMatrix, 1, numHashes),
      getColumn(signatureMatrix, 2, numHashes)));
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

  public static int[] getColumn (int[][] matrix, int index, int columnLength) {
    int[] col = new int[columnLength];
    for (int i = 0; i < columnLength; i++) {
      col[i] = matrix[i][index];
    }
    return col;
  }
} 
