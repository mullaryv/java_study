//package Q1_08_Zero_Matrix;

import CtCILibrary.AssortedMethods;

public class MyTester {
	public static boolean matricesAreEqual(int[][] m1, int[][] m2) {
		if (m1.length != m2.length || m1[0].length != m2[0].length) {
			return false;
		}
		
		for (int k = 0; k < m1.length; k++) {
			for (int j = 0; j < m1[0].length; j++) {
				if (m1[k][j] != m2[k][j]) {
					return false;
				}
			}
		}	
		return true;
	}
	
	public static int[][] cloneMatrix(int[][] matrix) {
		int[][] c = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				c[i][j] = matrix[i][j];
			}
		}
		return c;
	}
	
	public static void main(String[] args) {

		int nrows = 10;
		int ncols = 15;
		int[][] matrix1 = AssortedMethods.randomMatrix(nrows, ncols, -10, 10);		
		int[][] matrix2 = cloneMatrix(matrix1);
		int[][] matrix3 = cloneMatrix(matrix1);
		int[][] matrix4 = cloneMatrix(matrix1);

		System.out.println("original:");
		AssortedMethods.printMatrix(matrix1);
		
		QuestionA.setZeros(matrix1);
		QuestionB.setZeros(matrix2);
		MyQuestion.setZerosA(matrix3);
		MyQuestion.setZerosB(matrix4);
		
		System.out.println("matrix-1:");
		AssortedMethods.printMatrix(matrix1);
		System.out.println("matrix-2:");
		AssortedMethods.printMatrix(matrix2);
		System.out.println("matrix-3 (A):");
		AssortedMethods.printMatrix(matrix3);
		System.out.println("matrix-4 (B):");
		AssortedMethods.printMatrix(matrix4);
		
		if (matricesAreEqual(matrix1, matrix2)) {
			System.out.println("1-2: Equal");
		} else {
			System.out.println("1-2: Not Equal");
		}

		if (matricesAreEqual(matrix1, matrix3)) {
			System.out.println("1-3: Equal");
		} else {
			System.out.println("1-3: Not Equal");
		}

		if (matricesAreEqual(matrix1, matrix4)) {
			System.out.println("1-4: Equal");
		} else {
			System.out.println("1-4: Not Equal");
		}

	}
}
