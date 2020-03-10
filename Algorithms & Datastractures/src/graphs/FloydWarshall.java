package graphs;

/*
 * The Floyd-Warshall algorithm is used to find the shortest path between all pair of nodes.
 * In theory, it works with a 3 dimensional table, as specified in the comments below. 
 * The general idea is that a shortest path from u to v is composed of a shortest path from
 * u to w + a shortest path from w to v, for some node w in G. 
 * It runs in a complexity of O(n^3). The same result can be achieved with Johnsons algorithm in
 * O(m*n + n^2*log(n))
 */

public class FloydWarshall {
	public static double[][] FW(Graph G){
		int n = G.nodes;
		//DP[k][i][j] := minimal distance of a path from i 
		//				to j with all nodes in [0;k]
		//for simplicity of programming this algorithm, it is easier to use a 2D array
		//and then going over it k times, overwriting some solutions if necessary
		double[][] DP = new double[n][n];
		//Initialization
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <n ; j++) {
				if (i==j) {
					DP[i][j] = 0;
				}
				else {
					DP[i][j] = Math.min(Double.MAX_VALUE, G.adjMatrix[i][j]);
				}
			}
		}
		//end of initialization
		//recurrence
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n ; j++) {
					DP[i][j] = Math.min(DP[i][j], 
									DP[i][k] + DP[k][j]);
				}
			}
		}	
		//end of iterations
		return DP;
	}
}
