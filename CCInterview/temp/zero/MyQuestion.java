import java.util.Set;
import java.util.HashSet;

import CtCILibrary.AssortedMethods;


public class MyQuestion {

  // using HashSet
  public static void setZerosA (int[][] matrix) {

    Set<Integer> columns = new HashSet<Integer>();

    int m = matrix.length;
    int n = matrix[0].length;

    for (int i=0; i<m; i++) {
      boolean hasZeros = false;

      for (int j=0; j<n; j++) {
        if (matrix[i][j] == 0) {
          hasZeros = true;
          columns.add(j); 
        }
      }
      if (hasZeros) {
        for (int j=0; j<n; j++)
          matrix[i][j] = 0;
      }
    }

    for (Integer c : columns) {

      for (int i=0; i<m; i++)
        matrix[i][c.intValue()] = 0;
    }
  } 


  // storing column info in array
  public static void setZerosB (int[][] matrix) {

    int m = matrix.length;
    int n = matrix[0].length;

    boolean[] columns = new boolean [n];

    for (int i=0; i<m; i++) {
      boolean hasZeros = false;

      for (int j=0; j<n; j++) {
        if (matrix[i][j] == 0) {
          hasZeros = true;
          columns[j] = true; 
        }
      }
      if (hasZeros) {
        for (int j=0; j<n; j++)
          matrix[i][j] = 0;
      }
    }

    for (int j=0; j<n; j++) {
      if (columns[j]) {
        for (int i=0; i<m; i++)
          matrix[i][j] = 0;
      }
    }
  } 


  public static void main(String[] args) {
    int nrows = 10;
    int ncols = 15;
    int[][] matrix = AssortedMethods.randomMatrix(nrows, ncols, -10, 10);		

    AssortedMethods.printMatrix(matrix);
		
    setZerosA (matrix);
    
    System.out.println();
    AssortedMethods.printMatrix(matrix);
  }

}