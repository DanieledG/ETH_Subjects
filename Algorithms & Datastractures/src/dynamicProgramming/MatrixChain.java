package dynamicProgramming;

public class MatrixChain {
	public static int multiplication(int[][] Matrices) {
		//The Matrices array should be a two dimensional array, representing n matrices
		//In the [0] entry of each matrix, the amount of rows is saves
		//In the [1] entry the amount of columns
		int n = Matrices[0].length; //amount of matrices
		int[][] DP = new int[n][n];
		//Initialization
		for (int i = 0; i < n; i++) {
			assert i < n;
			DP[i][i] = 0;
		}
		//----------------------------------------------------
		//Recurrence
		int p;
		for (int counter = 0; counter < n; counter++) {
			p = 0;
			for (int q = counter+1; q < n; q++) {
				DP[p][q] = Integer.MAX_VALUE;
				for(int i = p; i < q; i++) {
					int multCost = Matrices[0][p] * Matrices[1][i] * Matrices[1][q];
					DP[p][q] = Math.min(DP[p][q], 
								DP[p][i] + DP[i+1][q] + multCost);
				}
				p++;
			}
			
		}
		return DP[0][n-1];
	}
}
