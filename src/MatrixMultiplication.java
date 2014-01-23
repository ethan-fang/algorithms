import java.util.Arrays;


public class MatrixMultiplication {

	
	public static void main(String[] args) {

		int A[][] = {{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
		int B[][] = {{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};

		multiply(A, B);
	}
	
	static void printArray(int a[][]) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println("");
		}
	}

	//xyz, cubic system
	static void multiply(int A[][], int B[][]) {
		System.out.println("A ");
		printArray(A);
		System.out.println("B ");
		printArray(B);
		
		int C[][] = new int[3][3];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length; j++) {
				for (int k = 0; k<B[j].length; k++)
			        C[i][j] += A[i][j] * B[j][k];
			}
		}
		System.out.println("c is ");
		printArray(C);
	}
}
