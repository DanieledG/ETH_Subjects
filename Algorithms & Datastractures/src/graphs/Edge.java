package graphs;

public class Edge implements Comparable<Edge>{
	Node start;
	Node end;
	double weight;
	
	public Edge(Node s, Node e) {
		start = s;
		end = e;
		weight = 1;
	}
	
	public Edge(Node s, Node e, double w) {
		start = s;
		end = e;
		weight = w;
	}
	
	@Override
	public int compareTo(Edge otherEdge) {
		if (this.weight < otherEdge.weight) {
			return -1;
		}
		else if (this.weight > otherEdge.weight) {
			return 1;
		}
		return 0;
	}


}

