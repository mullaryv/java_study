import java.util.Set;
import java.util.HashSet;

import MyLibrary.AssortedMethods;


public class ZeroMatrix {

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
        int[][] matrix1 = AssortedMethods.randomMatrix(nrows, ncols, -10, 10);        
        int[][] matrix2 = AssortedMethods.cloneMatrix(matrix1);

        System.out.println("original:");
        AssortedMethods.printMatrix(matrix1);
        
        setZerosA(matrix1);
        setZerosB(matrix2);
        
        System.out.println("matrix-1:");
        AssortedMethods.printMatrix(matrix1);
        System.out.println("matrix-2:");
        AssortedMethods.printMatrix(matrix2);
        
        if (AssortedMethods.matricesAreEqual(matrix1, matrix2)) {
            System.out.println("1-2: Equal");
        } else {
            System.out.println("1-2: Not Equal");
        }
    }
/*
    public static void main(String[] args) {
        int nrows = 10;
        int ncols = 15;
        int[][] matrix = AssortedMethods.randomMatrix(nrows, ncols, -10, 10);        

        AssortedMethods.printMatrix(matrix);
        
        setZerosA (matrix);
    
        System.out.println();
        AssortedMethods.printMatrix(matrix);
    }
*/
}