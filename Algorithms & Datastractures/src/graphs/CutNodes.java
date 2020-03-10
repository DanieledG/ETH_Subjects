package graphs;
import java.util.*;
public class CutNodes {

	public static void main(String[] args) {
		Scanner In = new Scanner(System.in);
		int t = In.nextInt();
		for (int i = 0; i < t; i++) {
			testCase(In);
		}
	}

	public static void testCase(Scanner In) {	
		// Input using In.java class
		int n = In.nextInt();
		int m = In.nextInt();
		LinkedList<Integer>[] adjacencyM = new LinkedList[n];
		LinkedList<Integer>[] DFSTree = new LinkedList[n];

		for (int i= 0; i < n; i++) {
			adjacencyM[i] = new LinkedList<Integer>();
		}
		
		for (int i = 0; i < m; i++) {
			int from = In.nextInt();
			int to = In.nextInt();
			adjacencyM[from].add(to);
			adjacencyM[to].add(from);
		}
		int[] dfsN = new int[n];
		int[] lowN = new int[n];
		boolean[] cutNode = new boolean[n];
		DFSVisit(adjacencyM, DFSTree, dfsN, lowN, cutNode, 0, 0);

		cutNode[0] = false;
		if (DFSTree[0].size() > 1) {
			cutNode[0] = true;

		}
		boolean existCutNode = false;
		for (int i = 0; i < n; i++) {
			if (cutNode[i]) {
				existCutNode = true;
				System.out.print(i + " ");
			}
		}
		if (!existCutNode) {
			System.out.print("-1");
		}
	}

	public static int DFSVisit(LinkedList<Integer>[] adj, LinkedList<Integer>[] T, int[] dfs, int[] low, boolean[] cutNode, int start, int num) {
		dfs[start] = ++num;
		low[start] = num;
		for (int neighbour : adj[start]) {
			if (dfs[neighbour] == 0) {
				if (T[start] == null) {
					T[start] = new LinkedList<Integer>();
				}
				T[start].add(neighbour);
				int val = DFSVisit(adj, T, dfs, low, cutNode, neighbour, num);
				if (val >= dfs[start]) {
					cutNode[start] = true;
				}
				low[start] = Math.min(low[start], val);
			} else if (T[start] == null || !T[start].contains(neighbour)) {
				low[start] = Math.min(low[start], dfs[neighbour]);
			}
		}
		return low[start];
	}
}
