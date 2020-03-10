package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.Test;

import graphs.*;

class GraphsTest {

	@Test
	void BellmannFordTest() {
		int nodes = 8;
		Graph G = new Graph(nodes, true, true);

		Node A = new Node(0);
		Node B = new Node(1);
		Node C = new Node(2);
		Node D = new Node(3);
		Node E = new Node(4);
		Node F = new Node(5);
		Node H = new Node(6);
		Node S = new Node(7);
		
		G.addEdge(new Edge(S, A, 10));
		G.addEdge(new Edge(B, A, 1));
		G.addEdge(new Edge(B, C, 1));
		G.addEdge(new Edge(E, B, -2));
		G.addEdge(new Edge(A, E, 2));
		G.addEdge(new Edge(C, D, 3));
		G.addEdge(new Edge(D, E, -1));
		G.addEdge(new Edge(F, E, -1));
		G.addEdge(new Edge(F, A, -4));
		G.addEdge(new Edge(H, F, 1));
		G.addEdge(new Edge(S, H, 8));

		double[][] DP = BellmanFord.BF(G, S);
		double[] results = new double[nodes];
		double[] solution = {5.0, 5.0, 6.0, 9.0, 7.0, 9.0, 8.0, 0.0};
		for (int i = 0; i < nodes; i++) {
			results[i] = DP[i][nodes-1];
		}
		assertArrayEquals(solution, results);
	}

	@Test
	void FloydWarshallTest() {
		int n = 4;
		Graph G = new Graph(n, true, true);
		
		Node A = new Node(0);
		Node B = new Node(1);
		Node C = new Node(2);
		Node D = new Node(3);

		G.addEdge(new Edge(A, C, -2));
		G.addEdge(new Edge(B, A, 4));
		G.addEdge(new Edge(B, C, 3));
		G.addEdge(new Edge(C, D, 2));
		G.addEdge(new Edge(D, B, -1));
		
		double[][] resFW = FloydWarshall.FW(G);
		double[][] resJ = Johnson.johnson(G);
		double[][] solution = {{0.0, -1.0, -2.0, 0.0},
								{4.0, 0.0, 2.0,4.0},
								{5.0, 1.0, 0.0, 2.0},
								{3.0, -1.0, 1.0, 0.0}};
		assertArrayEquals(solution, resFW);
		assertArrayEquals(solution, resJ);

	}
	
	@Test
	void PrimTest() {
		int n = 7;
		Graph G = new Graph(n, false, true);
		
		Node A = new Node(0);
		Node B = new Node(1);
		Node C = new Node(2);
		Node D = new Node(3);
		Node E = new Node(4);
		Node F = new Node(5);
		Node H = new Node(6);
		
		G.addEdge(new Edge(A, B, 9));
		G.addEdge(new Edge(A, E, 10));
		G.addEdge(new Edge(B, C, 7));
		G.addEdge(new Edge(B, H, 8));
		G.addEdge(new Edge(C, D, 3));
		G.addEdge(new Edge(C, F, 1));
		G.addEdge(new Edge(D, F, 2));
		G.addEdge(new Edge(F, E, 5));
		G.addEdge(new Edge(F, H, 6));
		G.addEdge(new Edge(E, H, 4));
		
		Set<Edge> MST = Prim.prim(G);
		Set<Edge> solution = new HashSet<Edge>();
		solution.add(G.getEdge(C, F));
		solution.add(G.getEdge(D, F));
		solution.add(G.getEdge(F, E));
		solution.add(G.getEdge(E, H));
		solution.add(G.getEdge(B, C));
		solution.add(G.getEdge(A, B));
		
		assertEquals(solution, MST);
	}
	
	@Test
	public void KruskalTest1() {
		int n = 7;
		Graph G = new Graph(n, false, true);
		
		Node A = new Node(0);
		Node B = new Node(1);
		Node C = new Node(2);
		Node D = new Node(3);
		Node E = new Node(4);
		Node F = new Node(5);
		Node H = new Node(6);
		
		G.addEdge(new Edge(A, B, 9));
		G.addEdge(new Edge(A, E, 10));
		G.addEdge(new Edge(B, C, 7));
		G.addEdge(new Edge(B, H, 8));
		G.addEdge(new Edge(C, D, 3));
		G.addEdge(new Edge(C, F, 1));
		G.addEdge(new Edge(D, F, 2));
		G.addEdge(new Edge(F, E, 5));
		G.addEdge(new Edge(F, H, 6));
		G.addEdge(new Edge(E, H, 4));
		
		Set<Edge> result = Kruskal.kruskal(G);
		Set<Edge> solution = new HashSet<Edge>();
		solution.add(G.getEdge(C, F));
		solution.add(G.getEdge(D, F));
		solution.add(G.getEdge(F, E));
		solution.add(G.getEdge(E, H));
		solution.add(G.getEdge(B, C));
		solution.add(G.getEdge(A, B));
		
		assertEquals(result, solution);

	}
	
	@Test
	public void KruskalTest2() {
		int n = 7;
		Graph G = new Graph(n, false, true);
		
		Node A = new Node(0);
		Node B = new Node(1);
		Node C = new Node(2);
		Node D = new Node(3);
		Node E = new Node(4);
		Node F = new Node(5);
		Node H = new Node(6);
		
		G.addEdge(new Edge(A, B, 7));
		G.addEdge(new Edge(A, D, 5));
		G.addEdge(new Edge(B, C, 8));
		G.addEdge(new Edge(B, E, 7));
		G.addEdge(new Edge(B, D, 9));
		G.addEdge(new Edge(C, E, 5));
		G.addEdge(new Edge(D, E, 15));
		G.addEdge(new Edge(E, H, 5));
		G.addEdge(new Edge(F, H, 11));
		G.addEdge(new Edge(E, F, 8));
		G.addEdge(new Edge(D, F, 6));
		
		Set<Edge> result = Kruskal.kruskal(G);
		Set<Edge> solution = new HashSet<Edge>();
		solution.add(G.getEdge(A, D));
		solution.add(G.getEdge(A, B));
		solution.add(G.getEdge(B, E));
		solution.add(G.getEdge(E, C));
		solution.add(G.getEdge(E, H));
		solution.add(G.getEdge(D, F));
		
		assertEquals(result, solution);
	}
	
	@Test
	void FloydWarshallTest2() {
		Graph G = new Graph(6, true, true);
		Node A = new Node(0);
		Node B = new Node(1);
		Node C = new Node(2);
		Node D = new Node(3);
		Node E = new Node(4);
		Node F = new Node(5);
		
		G.addEdge(new Edge(A, C, 5));
		G.addEdge(new Edge(A, B, 3));
		G.addEdge(new Edge(B, C, 4));
		G.addEdge(new Edge(B, A, 1));
		G.addEdge(new Edge(E, B, 1));
		G.addEdge(new Edge(B, E, 4));
		G.addEdge(new Edge(B, F, 1));
		G.addEdge(new Edge(F, E, 2));
		G.addEdge(new Edge(C, E, -4));
		G.addEdge(new Edge(C, D, 1));
		G.addEdge(new Edge(D, E, 5));
		G.addEdge(new Edge(E, D, 2));

		
		double[][] resFW = FloydWarshall.FW(G);
		double[][] resJ = Johnson.johnson(G);

		int tempI = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6 ; j++) {
				if (tempI != i) {
					System.out.println();
					tempI = i;
				}
				System.out.print(resFW[i][j] + " ");

			}
		}
		System.out.println();
		System.out.println();

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6 ; j++) {
				if (tempI != i) {
					System.out.println();
					tempI = i;
				}
				System.out.print(resJ[i][j] + " ");

			}
		}
		System.out.println();
		System.out.println();
	}
	
	@Test
	void DijkstraTest() {
		Graph G = new Graph(6, false, true);
		
		Node A = new Node(0);
		Node B = new Node(1);
		Node C = new Node(2);
		Node D = new Node(3);
		Node E = new Node(4);
		Node F = new Node(5);

		G.addEdge(new Edge(A, C, 2));
		G.addEdge(new Edge(A, B, 4));
		G.addEdge(new Edge(A, D, 5));
		G.addEdge(new Edge(C, D, 2));
		G.addEdge(new Edge(C, E, 5));
		G.addEdge(new Edge(C, F, 7));
		G.addEdge(new Edge(B, F, 6));
		G.addEdge(new Edge(E, F, 3));
		G.addEdge(new Edge(D, E, 1));
		
		double[] result = Dijkstra.dijkstra(G, A); 
		double[] solution = {0, 4, 2, 4, 5, 8};
		
		assertArrayEquals(solution, result);
	}
	
	@Test
	void TSTest() {
		Graph G = new Graph(7, true, false);
		Node A = new Node(0);
		Node B = new Node(1);
		Node C = new Node(2);
		Node D = new Node(3);
		Node E = new Node(4);
		Node F = new Node(5);
		Node H = new Node(6);
		
		G.addEdge(new Edge(A, C));
		G.addEdge(new Edge(A, D));
		G.addEdge(new Edge(H, D));
		G.addEdge(new Edge(C, F));
		G.addEdge(new Edge(F, B));
		G.addEdge(new Edge(B, H));
		G.addEdge(new Edge(D, E));

		
		int[] sol = {0, 2, 5, 1, 6, 3, 4};
		int[] res = TopologicalSorting.sort(G);
		assertArrayEquals(sol, res);
	}
	
	@Test
	void ETTest() {
		Graph G = new Graph(6, false, false);
		Node A = new Node(0);
		Node B = new Node(1);
		Node C = new Node(2);
		Node D = new Node(3);
		Node E = new Node(4);
		Node F = new Node(5);
		
		G.addEdge(new Edge(A, B));
		G.addEdge(new Edge(A, C));
		G.addEdge(new Edge(A, D));
		G.addEdge(new Edge(A, E));
		G.addEdge(new Edge(B, C));
		G.addEdge(new Edge(B, D));
		G.addEdge(new Edge(B, E));
		G.addEdge(new Edge(C, E));
		G.addEdge(new Edge(C, F));
		G.addEdge(new Edge(D, E));
		G.addEdge(new Edge(D, F));
		
		LinkedList<Node> tour = EulerTour.findTour(G, A);
		assertTrue(true);
		
		for(Node n : tour) {
			System.out.print(n.number + ", ");
		}
		
	}
}
