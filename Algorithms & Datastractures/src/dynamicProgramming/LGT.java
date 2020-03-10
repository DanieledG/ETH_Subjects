package dynamicProgramming;

public class LGT {
	public static int[] lgt(int[] A, int[] B) {
		int[][] DP = new int[A.length+1][B.length+1];
		//Initialization
		for(int i = 0; i < A.length+1; i++) {
			DP[i][0] = 0;
		}
		for(int i = 0; i < B.length+1; i++) {
			DP[0][i] = 0;
		}
		//-----------------------
		//Recurrence
		for(int i = 1; i < A.length+1; i++) {
			for(int j = 1; j < B.length+1; j++) {
				int equal = 0;
				if (A[i-1] == B[j-1]) {
					equal = 1;
				}
				int max = Math.max(DP[i-1][j], DP[i][j-1]);
				DP[i][j] = Math.max(DP[i-1][j-1] + equal, max);
			}
		}
		//-------------------------
		//Backtracking
		int[] sol = new int[DP[A.length][B.length]];
		int j = A.length;
		int k = B.length;
		for (int i = sol.length-1; i >= 0; i--) {
			while(k > 0 && DP[j][k] == DP[j][k-1]) {
				k--;
			}
			while(j > 0 && DP[j][k] == DP[j-1][k]) {
				j--;
			}

			sol[i] = A[j-1];
			j--;
			k--;
		}
		//--------
		return sol;
	}
}
