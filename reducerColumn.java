import java.lang.*;
import java.util.Scanner;
import java.util.Random;
import java.util.StringTokenizer;

public class reducerColumn {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int numHashes = Integer.parseInt(args[0]);
    int numColumns = Integer.parseInt(args[1]);
    int set1 = Integer.parseInt(args[2]);
    int set2 = Integer.parseInt(args[3]);
    int[][] signatureMatrix = new int[numHashes][numColumns];

    while (in.hasNextLine()) {
      String[] line = in.nextLine().split(","); 
      int column = Integer.parseInt(line[0]);
      StringTokenizer st = new StringTokenizer(line[1]);
      for (int row = 0; st.hasMoreTokens(); row++) {
        signatureMatrix[row][column] = Integer.parseInt(st.nextToken());
      }
    } 

    System.out.println("Similarity: between " + set1 + " and set " + set2 + ": " + similarity(
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
} 
