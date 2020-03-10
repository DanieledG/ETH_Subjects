package graphs;

public class TopologicalSorting {
	public static int[] sort(Graph G) {
		Stack S = new Stack();
		int[] inDeg = new int[G.nodes];
		for (int i = 0; i < G.nodes; i++) {
			Node current = G.getNode(i);
			inDeg[i] = current.inEdges.size();
			if (inDeg[i] == 0) {
				S.push(new StackNode(G.getNode(i)));
			}
		}

		int[] topSort = new int[G.nodes];
		int counter = 0;
		while (S.size > 0) {
			StackNode current = S.pop();
			topSort[counter] = current.key;
			counter++;
			for (Edge e : current.twin.outEdges) {
				inDeg[e.end.number]--;
				if (inDeg[e.end.number] == 0) {
					S.push(new StackNode(e.end));
				}
			}
		}
		if ( counter < G.nodes) {
			return null;
		}
		
		return topSort;
	}
}
