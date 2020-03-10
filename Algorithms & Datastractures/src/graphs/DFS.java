package graphs;

public class DFS {
	public static void dfs(Graph G, Node start) {
		Stack S = new Stack();
		boolean[] visited = new boolean[G.nodes];
		
		S.push(new StackNode(start));
		
		while (S.size > 0) {
			StackNode current  = S.pop();
			int number = current.key;
			if (!visited[number]) {
				for (Edge e : current.twin.outEdges) {
					if(!visited[e.end.number]) {
						S.push(new StackNode(e.end));
					}
				}
				visited[number] = true;
			}
		}
		return;
	}
}
