package graphs;

import java.util.*;
/*
 * Kruskal's algorithm is a greedy-type algorithm which provides a MST of a given graph G
 * To create the MST, it always chooses the Edge with the smallest weight 
 * that does not create a cycle in the MST.
 * It runs in O(m*log(n)), which, for some reason, is equivalent to O(m*log(m))
 */
public class Kruskal {
	public static Set<Edge> kruskal(Graph G) {
		Set<Edge> MSTEdges = new HashSet<Edge>();	//creates the set of edges for the MST
		ArrayList<Edge> edges = (ArrayList<Edge>) G.EDGES.clone();	//makes a copy of all the edges in the graph
		Node[] rep = new Node[G.nodes];			//saves a representative for every CC in the graph
		for (int i = 0; i < G.nodes; i++) {
			rep[i] = G.getNode(i);		//at the beginning, each node is the representative of its ZHK
		}
		
		ArrayList<Node>[] members;		//saves all the members for each CC
		members = new ArrayList[G.nodes];
		for (int i = 0; i < G.nodes; i++) {
			members[i] = new ArrayList<Node>();
			members[i].add(G.getNode(i));	//initializes the array
		}
		
		Iterator<Edge> iterator = edges.iterator(); //goes through all the edges, in ascending weight order
		for (int i = 0; i < G.edges; i++) {
			Edge e = iterator.next();
			Node rep1 =rep[e.start.number];
			Node rep2 = rep[e.end.number];
			if (rep1 != rep2) {	//checks if the 2 nodes connected by the edge are in the same CC
				if (members[rep1.number].size() > members[rep2.number].size()) {	//checks which CC has more members
					for (Node n : members[rep2.number]) {
						rep[n.number] = rep1;			//and adds all the members of the smallest into the bigger
					}
					members[rep1.number].addAll(members[rep2.number]);
				}
				
				else {
					for (Node n : members[rep1.number]) {
						rep[n.number] = rep2;
					}
					members[rep2.number].addAll(members[rep1.number]);
				}
				
				MSTEdges.add(e); 		//adds the selected edge to the MST
			}
			iterator.remove();		//and removes it from the old edges

		}
		return MSTEdges;
	}
}
