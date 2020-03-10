package dynamicProgramming;
//The knapsack problem consist on finding the combination of n items with largest value
//such that the weight of those items doesn't exceed a given limit W.
//It can be solved in O(n*W)
public class Knapsack {
	public static boolean[] knapsack(int[][] items, int weight) {
		assert weight > 0;
		assert items != null;
		int n = items[0].length;
		int[][] DP = new int[n+1][weight+1];
		//DP[i][j] := maximal value reachable with the first i objects, s.t the total weight <=j
		//Initialization
		for (int i = 0; i <= weight; i++) {
			DP[0][i] = 0;
			}
		for (int i = 1; i <= n; i++) {
			DP[i][0] = 0;
		}
		//---------------------------------------------------------------
		//Recurrence
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= weight; j++) {
				int currentW = items[0][i-1];
				int currentV = items[1][i-1];
				if (currentW <= j) {
					DP[i][j] = Math.max(DP[i-1][j], DP[i-1][j-currentW] + currentV);
				}
				else {
					DP[i][j] = DP[i-1][j];
				}
			}
		}
		//------------------------
		//Backtracking
		int k = n;
		int w = weight;
		boolean[] sol = new boolean[n];
		while (k > 0) {
			if (DP[k][w] == DP[k-1][w]) { //the solution doesn't contain item k
				k--;
				sol[k] = false;
			}
			else {
				k--;
				w -= items[0][k];
				sol[k] = true;
			}
		}
		//--------------------------------
		return sol;
	}
}
