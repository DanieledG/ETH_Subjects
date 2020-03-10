package graphs;

import java.util.*;
/*
 * Prim's algorithm provides a MST of a given graph G
 * The idea is to always add the edge with minimum weight that adds 
 * a new vertex to the component we are working with, until it contains
 * all nodes in G.
 * It runs in O(m*log(n))
 */
public class Prim {
	
	public static Set<Edge> prim(Graph G) {
		Set<Node> usedNodes = new HashSet<Node>();
		ArrayList<Edge> possibleEdges = new ArrayList<Edge>();
		Set<Edge> MSTEdges = new HashSet<Edge>();
		
		//initialization
		possibleEdges.add(G.EDGES.get(0));
		Node firstNode = possibleEdges.get(0).start;
		usedNodes.add(firstNode);
		for (Node n : G.adjList[firstNode.number]) {
			if (!possibleEdges.contains(G.getEdge(firstNode, n))){
				possibleEdges.add(G.getEdge(firstNode, n));
			}
		}
		//end initialization

		for (int j = 1; j < G.nodes; j++) {
			int i = 0;
			Edge e = possibleEdges.get(0);
			while (usedNodes.contains(e.end) &&  usedNodes.contains(e.start)) {
				i++;
				e = possibleEdges.get(i);
			}
			MSTEdges.add(e);
			
			Node toAdd = null;
			if (usedNodes.contains(e.start)) {
				toAdd = e.end;
			}
			else {
				toAdd = e.start;
			}
			usedNodes.add(toAdd);
			
			for (Node n : G.adjList[toAdd.number]) {
				if (!possibleEdges.contains(G.getEdge(toAdd, n))){
					possibleEdges.add(G.getEdge(toAdd, n));
				}
			}
			possibleEdges.remove(i);
			possibleEdges.sort(null);
		}
		return MSTEdges;
	}
}
