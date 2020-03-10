package graphs;

import java.util.*;
/*
 * Dijkstra's Algorithm provides the shortest path from a given
 * start node to all other vertices in a weighted Graph with non-negative edge weights.
 * The idea is to always add the node with minimal distance, since there are no negative edges.
 * If implemented correctly (with a MinHeap), it takes O(m + n*log(n))
 */
public class Dijkstra {
	public static double[] dijkstra(Graph G, Node start) {
		double[] result = new double[G.nodes];
		//It would be way more efficient if I used a MinHeap to save the nodes
		HashMap<Node, Double> possNodes = new HashMap<Node, Double>();
		//PriorityQueue<Node> Queue = new PriorityQueue<Node>();
		Set<Node> found = new HashSet<Node>(); 	//Saves all Nodes that have already been found
		
		found.add(start);
		result[start.number] = 0;

		Node lastAdded = start;
		Node minNode = null;	//this is initialized just to make eclipse happy
		double minDist = 0;		//this is initialized just to make eclipse happy
		double currentDist = 0;

		while (found.size() < G.nodes) {
			for (Edge e : lastAdded.outEdges) {
				//refresh all upper bounds of the distances
				if (possNodes.get(e.end) != null) {
					if (possNodes.get(e.end) > currentDist + e.weight) {
						possNodes.put(e.end, currentDist+e.weight);
					}
				}
				else if (!found.contains(e.end)){
					possNodes.put(e.end, currentDist + e.weight);
				}
			}
			//----------------------------------------------------------
				
			//Now take out the "closest" Node (would take O(logN) with MinHeap)
			int i = 0;
			for(Node n : possNodes.keySet()) {
				if (i==0) {
					minNode = n;
					minDist = possNodes.get(n);
					i++;
				}
				else {
					if(possNodes.get(n) < minDist) {
						minNode = n;
						minDist = possNodes.get(n);
						//i++;
					}
				}
			}
			//------------------------------------------------------------
				
			//Then, save all the results
			result[minNode.number] = minDist;
			possNodes.remove(minNode);
			currentDist = minDist;
			lastAdded = minNode;
			found.add(minNode);
		}
		return result;
	}
}
