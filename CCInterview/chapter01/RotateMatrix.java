import MyLibrary.AssortedMethods;


public class RotateMatrix {

    public static int[][] copyMatrix (int[][] m) {
        int N = m[0].length;
        int[][] new_matrix = new int[N][N];

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                new_matrix[i][j] = m[i][j];
            }
        }
        return new_matrix;
    }


    public static boolean compareMatrix (int[][] a, int[][] b) {
        int N = a[0].length;
        int M = b[0].length;
        if (N != M) return false;

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (a[i][j] != b[i][j])
                    return false;
            }
        }
        return true;
    }


    public static void rotate (int[][] m) {
        int N = m[0].length;

        int[][] new_matrix = new int[N][N];

        for (int row=0; row<N; row++) {
            for (int col=0; col<N; col++) {
//              System.out.println ("i:" + i + ", j:" + j);
                new_matrix[row][col] = m[N-1-col][row];
            }
        }
//      System.out.println ("new matrix:");
//      AssortedMethods.printMatrix(new_matrix);

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                m[i][j] = new_matrix[i][j];
            }
        }
    }


    public static void rotateInPlace (int[][] m) {
        int N = m.length - 1;
        int K = N/2;

        for (int i=0; i<K; i++) {

            for (int j=0+i; j<N-i; j++) { //at the end of this loop last element is already has changed.
                int saved = m[i][j];

                //System.out.println ("  N=" + N + ", i:" + i + ", " + j);
                //System.out.println ("  saved = " + m[i][j]);
                //System.out.println ("  m[N-j][i] = " + m[N-j][i]);
                //System.out.println ("  m[N-i][N-j] = " + m[N-i][N-j]);
                //System.out.println ("  m[j][N-i] = " + m[j][N-i]); 
        
                m[i][j] = m[N-j][i];
                m[N-j][i] = m[N-i][N-j];
                m[N-i][N-j] = m[j][N-i]; 
                m[j][N-i] = saved;

            }
            //AssortedMethods.printMatrix(m);
        } 
    }


    public static void main(String[] args) {
        int[][] matrix = AssortedMethods.randomMatrix(5, 5, 0, 9);
        int[][] matrix2 = copyMatrix (matrix);

        System.out.println ("input:");
        AssortedMethods.printMatrix(matrix);

        rotate(matrix);
        System.out.println("\nrotated:");
        AssortedMethods.printMatrix(matrix);

        rotateInPlace (matrix2);
        System.out.println("\nrotate in place:");
        AssortedMethods.printMatrix(matrix2);
        if (!compareMatrix (matrix, matrix2))
            System.out.println ("in place: not the same!");

    }
}
