package sorting;

public class Heapsort {
	static void restoreMaxHeapCondition(int[] A, int i) {
		while (2 * i + 2 < A.length ) {
			int largestSon = Math.max(A[2*i+1], A[2*i + 2]);
			int index = 0;
			if (largestSon == A[2*i+1]) {
				index = 2 * i + 1;
			}
			else {
				index = 2 * i + 2;
			}
			if (A[i] < largestSon) {
				Sorting.swapKeys(A, i, index);
			}
			i = index;
		}
		if (2 * i + 1 < A.length) {
			if (A[i] < A[2*i+1]) {
				Sorting.swapKeys(A, i, 2*i+1);
			}
		}
	}

	public static int[] sort(int[] A) {
		int middle = A.length/2;
		for (int i = middle; i >= 0; i--) {
			restoreMaxHeapCondition(A, i);
		}
		int [] res = new int[A.length];
		for (int i = A.length-1; i >= 0; i--) {
			res[i] = A[0];
			A[0] = Integer.MIN_VALUE;
			restoreMaxHeapCondition(A, 0);
		}
		return res;
	}
}
