package graphs;

import java.util.*;

public class EulerTour {
	
	public static LinkedList<Node> findTour(Graph G, Node start) {
		int n = G.nodes;
		Iterator<Node>[] iterators = new Iterator[n];
		for (int i = 0; i < n; i++) {
			iterators[i] = G.adjList[i].iterator();
		}
		HashSet<Edge> usedEdges = new HashSet<Edge>();
		LinkedList<Node> ET = recurs(G, iterators, start, usedEdges);
		return ET;
	}
	
	private static LinkedList<Node> recurs(Graph G, Iterator<Node>[] iterators, Node start, HashSet<Edge> usedEdges){
		LinkedList<Node> ET = new LinkedList<Node>();
		Iterator<Node> itr = iterators[start.number];
		while(itr.hasNext()) {
			Node next = itr.next();
			Edge edge = G.getEdge(start, next);
			if (!usedEdges.contains(edge)) {
				usedEdges.add(edge);
				LinkedList<Node> list = recurs(G, iterators, next , usedEdges);
				list.addAll(ET);
				ET = list;
			}
		}
		ET.addFirst(start);
		return ET;
	}
}
