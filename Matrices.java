import java.util.Arrays;

public class Matrices {
	public static void main(String args[]) {

		int[][] matrixOne = new int[2][2];
		for (int row = 0; row < 2; row++) {
			for (int col = 0; col < 2; col++) {
				matrixOne[row][col] = 1;
			}
		}//matrixOne[1][0]=0;matrixOne[0][1]= 0
		

		int[][] matrixTwo = new int[2][2];
		for (int row = 0; row < 2; row++) {
			for (int col = 0; col < 2; col++) {
				matrixTwo[row][col] = (int) (Math.random()*5);
			}
		}

		PrintMatrix(matrixOne);
		PrintMatrix(matrixTwo);
		PrintMatrix(MatrixMultiplication(matrixOne, matrixTwo));

	}

	private static int[][] MatrixAddition(int[][] matrix1, int[][] matrix2) {
		if (!CompareSize(matrix1, matrix2))
			throw new UnsupportedOperationException("Dimension Mismatch");

		int[][] resultMatrix = new int[matrix1.length][matrix1[1].length];
		for (int row = 0; row < resultMatrix.length; row++) {
			for (int col = 0; col < resultMatrix[1].length; col++) {
				resultMatrix[row][col] = matrix1[row][col] + matrix2[row][col];
			}
		}
		return resultMatrix;
	}
	
	private static int[][] MatrixMultiplication(int[][] matrix1, int[][] matrix2) {
		if (!MultiplyAllow(matrix1, matrix2))
			throw new UnsupportedOperationException("Dimension Mismatch");
		
		int[][] resultMatrix = new int[matrix1.length][matrix2[1].length];
		for (int row = 0; row < resultMatrix.length; row++) {
			for (int col = 0; col < resultMatrix[1].length; col++) {// while loop
				
				int counter = 0; int totalAdd = 0; int innerAdd = 0; int tempRow = row; int tempCol = col;
				while(counter < matrix1[1].length){// run it only number of additions, 
					innerAdd = matrix1[tempRow][counter]* matrix2[counter][tempCol];
					totalAdd = totalAdd + innerAdd;
					counter++;
				}
				resultMatrix[row][col] = totalAdd;	
			}
		}
		return resultMatrix;
	}
	

	private static boolean CompareSize(int[][] matrix1, int[][] matrix2) {
		return (matrix1.length == matrix2.length && matrix1[1].length == matrix2[1].length);
	}
	
	private static boolean MultiplyAllow(int[][] matrix1, int[][] matrix2){
		return (matrix1[1].length == matrix2.length);
	}

	private static void PrintMatrix(int[][] someMatrix) {
		for (int[] rows : someMatrix) {
			for (int columns : rows) {
				System.out.print("| " + columns + " ");
			}
			System.out.println("| ");
		}
		System.out.println();
	}


}
