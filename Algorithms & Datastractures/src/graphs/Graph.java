package graphs;

import java.util.*;

public class Graph {
	boolean directed;
	boolean weighted;
	
	int nodes;
	int edges;
	
	ArrayList<Edge> EDGES;
	List<Node>[] adjList;
	double[][] adjMatrix;
	
	public Graph(int N, boolean d, boolean w) {
		nodes = N;
		adjMatrix = new double[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				adjMatrix[i][j] = Double.MAX_VALUE;
			}
		}
		adjList = new LinkedList[N];
		for (int i = 0; i < N; i++) {
			adjList[i] = new LinkedList<Node>();
		}
		directed = d;
		weighted = w;
		edges = 0;
		EDGES = new ArrayList<Edge>();
	}
	
	public void addEdge(Edge e) {
		if (directed) {
			adjMatrix[e.start.number][e.end.number] = e.weight;
			adjList[e.start.number].add(e.end);
			e.start.outEdges.add(e);
			e.end.inEdges.add(e);
			edges++;
			EDGES.add(e);
			EDGES.sort(null);
		}
		else {
			adjMatrix[e.start.number][e.end.number] = e.weight;
			adjMatrix[e.end.number][e.start.number] = e.weight;
			adjList[e.end.number].add(e.start);
			adjList[e.start.number].add(e.end);
			e.start.outEdges.add(e);
			e.end.inEdges.add(e);
			e.start.inEdges.add(e);
			e.end.outEdges.add(e);
			edges++;
			EDGES.add(e);
			EDGES.sort(null);
		}
	}
	
	public Edge getEdge(Node s, Node e) {
		if (adjMatrix[s.number][e.number] != Double.MAX_VALUE) {
			for (Edge edge : EDGES) {
				if(directed) {
					if (edge.start == s && edge.end == e) {
						return edge;
					}
				}
				else {
					if ((edge.start == s && edge.end == e) || (edge.end == s && edge.start == e)) {
						return edge;
					}
				}
			}
		}
		return null;
	}
	
	public Node getNode(int i) {
		for (Edge edge : EDGES) {
			if (edge.start.number == i) {
				return edge.start;
			}
			else if (edge.end.number == i) {
				return edge.end;
			}
		}
		return null;
	}
}
