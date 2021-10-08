package math.matrix;

import java.util.Scanner;

public class Matrix {
	private int[][] matrix;
	private boolean square;

	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}

	public boolean isSquare() {
		return square;
	}

	public void setSquare(boolean square) {
		this.square = square;
	}

	public void ToString() {
		printMatrix(this.matrix);
	}

	public void printMatrix(int[][] A) {
		for (int[] ints : A) {
			System.out.print("| ");
			for (int j = 0; j < A[0].length; j++) {
				System.out.printf("%3d ", ints[j]);
			}
			System.out.println("|");
		}
	}

	public Matrix() { // Sets matrix as the 2x2 Zero matrix
		new Matrix(new int[2][2]);
	}

	public Matrix(int n, Scanner in) { // creates a new 2D array of nxn size and prompts the user to fill it with integers
		int[][] A = new int[n][n];
		this.square = true;

		System.out.println("Enter Integer Elements Separated by Spaces (ex. \" 1 -3 4 \")");

		for (int i = 0; i < n; i++) {

			String row;
			String[] rowStrings;
			int[] rowInts = new int[n];

			System.out.print("Row " + (i + 1) + ":\t");

			row = in.nextLine();
			rowStrings = row.split(" ");

			for (int j = 0; j < n; j++) {
				rowInts[j] = Integer.parseInt(rowStrings[j]);
			}

			A[i] = rowInts;
		}
		this.matrix = A;
	}

	public Matrix(int[][] matrix) {
		this.matrix = matrix;
		if(matrix.length == matrix[0].length) this.square = true;
	}

	public int calculateDeterminant() {
		if(!this.square) return Integer.MIN_VALUE;

		return recursiveDeterminant(this.matrix);
	}
	
	private int recursiveDeterminant(int[][] A) {

		int determinant = 0;

		if(A.length == 2) {
			determinant = ( (A[0][0]) * (A[1][1]) - (A[0][1]) * (A[1][0]) );
			System.out.println(determinant);
		}
		else {
			int[][] B = new int[(A.length)-1][(A.length)-1];

			for (int i = 0; i < A.length; i++) {

				for (int j = 0; j < B.length; j++) {
					int count = 0;
					for (int k = 0; k < A.length; k++) {

						if(i != k) {

							B[j][count] = A[j+1][k];
							count++;
						}
					}
				}

				printMatrix(B);
				System.out.println();
				determinant += ((i%2 == 1)? -1 : 1) * (recursiveDeterminant(B) * (A[0][i]));


			}
		}
		return determinant;
	}
}
