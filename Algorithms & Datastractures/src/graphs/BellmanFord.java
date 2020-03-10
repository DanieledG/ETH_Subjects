package graphs;


/*
 * Runs the Bellman-Ford Algorithm on a given Graph G. 
 * G can be both directed or undirected. The algorithm doesn't 
 * provide the correct solution if there are negative cycles in G.
 * The Bellman-Ford Algorithm provides the shortest path from one Node to another
 * in asymptotic runtime of O(n*m).
 */
public class BellmanFord {

	public static double[][] BF(Graph G, Node start){
		
		int n = G.nodes;
		
		//distances[j][l] := min. weight of a path from start to j, with at most l edges
		double[][] distances = new double[n][n];
		
		//Initialization: l=0
		for (int i = 0; i < n; i++) {
			if (i == start.number) {
				distances[i][0] = 0;
			}
			else {
				distances[i][0] = Double.MAX_VALUE;
			}
		}
		//end of Initialization
		
		//Actual iterations of the DP
		for (int l = 1; l < n; l++) {
			for (int i = 0; i < n; i++) {
				double minDistance = distances[i][l-1];
				for (Edge e : G.getNode(i).inEdges) {
					minDistance = Math.min(minDistance, distances[e.start.number][l-1] + e.weight);	
				}
				distances[i][l] = minDistance;
			}
		}
		return distances;	
	}
}
