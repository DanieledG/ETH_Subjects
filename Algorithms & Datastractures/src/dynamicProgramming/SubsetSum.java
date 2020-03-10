package dynamicProgramming;

public class SubsetSum {
	public static boolean[] subset(int[] ints, int sum) {
		boolean[][] DP = new boolean[ints.length + 1][sum + 1];
		//Initialization
		for (int i = 1; i <= sum; i++) {
			DP[0][i] = false;
		}
		for (int i = 0; i <= ints.length; i++) {
			DP[i][0] = true;
		}
		//------------------------
		
		//Recurrence
		for (int i = 1; i <= ints.length; i++) {
			for (int j = 1; j <= sum; j++) {
				if (ints[i-1] > j) {
					DP[i][j] = DP[i-1][j];
				}
				else {
					DP[i][j] = DP[i-1][j] || DP[i-1][j-ints[i-1]];
				}
			}
		}
		
		//backtracking
		boolean[] result = new boolean[ints.length];
		if (DP[ints.length][sum]) {
			int k = ints.length;
			int s = sum;
			while (k>0) {
				if (DP[k][s] == DP[k-1][s]) {
					k--;
				}
				else {
					result[k-1] = true;
					s = s - ints[k-1];
					k--;

				}
			}
		}
		else {
			System.out.println("no solution found");
			return null;
		}
		return result;
	}
}
