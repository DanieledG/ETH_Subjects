package dynamicProgramming;

import java.util.HashMap;
import sorting.SmallerEqualCounter;

public class LAT {
	public static int[] lat(int[] A) {
		int n = A.length;
		HashMap<Integer, Integer> indices = new HashMap<Integer, Integer>();
		
		int[] DP = new int[n];
		int[] backtrack = new int[n];
		int lengthLAT = 0;
		
		//initialization
		for (int i = 0; i < n; i++) {
			DP[i] = Integer.MAX_VALUE;
		}
		//--------------------
		
		for (int i = 0; i < n; i++) {
			int current = A[i];
			indices.put(current, i);
			int index = SmallerEqualCounter.smallerEqualThan(current, DP);
			DP[index] = current;
			//saves the predecessor at that moment
			if (index != 0) {
				backtrack[i] = DP[index-1];
			}
			//saves the length of the LAT
			if (index+1 > lengthLAT) {
				lengthLAT = index+1;
			}
		}
		//backtracking
		int[] LAT = new int[lengthLAT];
		LAT[lengthLAT-1] = DP[lengthLAT-1];
		int ind = indices.get(DP[lengthLAT-1]);
		for (int i = lengthLAT-2; i >= 0; i--) {
			LAT[i] = backtrack[ind];
			ind = indices.get(LAT[i]);
		}
		//-------------------
		return LAT;
	}
}
