package graphs;
/* Johnson's algorithm computes the shortest path between any 2 nodes 
 * in a given Graph G. To achieve this, it firstly modifies all the edge 
 * weights in order for them to be all >= 0 and then runs Dijkstras algorithm
 * on the new graph for each Node.
 */
public class Johnson {
	public static double[][] johnson(Graph G){
		int n = G.nodes;
		//create new Graph john with one more node as G
		Graph john = new Graph(n+1, G.directed, G.weighted);
		//add all the Edges of G to john
		for (Edge e : G.EDGES) {
			john.addEdge(e);
		}
		//create new Node to use in John
		Node q = new Node(n);
		for (int i = 0; i < n; i++) {
			//create a new Edge between q and each node in G with weight 0
			Edge e = new Edge(q, G.getNode(i), 0);
			//add said edge to john
			john.addEdge(e);
		}
		//compute the table of BF with q as starting Node
		double[][] temp = BellmanFord.BF(john, q);
		//create array of heights
		double[] heights = new double[G.nodes];
		for (int i = 0; i < n; i++) {
			//insert for each node the min distance from q;
			heights[i] = temp[i][G.nodes];
		}
		for (Edge e : G.EDGES) {
			//change the weight of each edge in G with the height of the nodes
			e.weight += heights[e.start.number] - heights[e.end.number];
		}
		//now we have to run Dijkstra on the modified Graph G
		double[][] res = new double[n][];
		for (int i = 0; i < n; i++) {
			res[i] = Dijkstra.dijkstra(G, G.getNode(i));
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				res[i][j] += heights[j] - heights[i];
			}
		}
		return res;
	}
}
