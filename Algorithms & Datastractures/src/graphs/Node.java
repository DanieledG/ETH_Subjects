package graphs;

import java.util.*;

public class Node {
	public int number;
	Set<Edge> inEdges;
	Set<Edge> outEdges;
	
	public Node(int n) {
		number = n;
		inEdges = new HashSet<Edge>();
		outEdges = new HashSet<Edge>();
	}
}
