package sorting;

public class Insertionsort {
	public static int[] insertionsort(int[] A) {
		for (int k = 1; k < A.length; k++) {
			int i = findIndex(A, k, A[k]);
			int temp = A[k];
			for (int j = k; j > i; j--) {
				A[j] = A[j-1];
			}
			A[i] = temp;
		}
		return A;
	}
	
	public static int findIndex (int[] A, int right, int n) {
		int left = 0; 
		while (left <= right) {
			int m = (left+right) / 2;
			
			if ((A[m] == n) ||
				(m == right && A[m] < n) ||
				(m == 0 && A[m] > n) || 
				(m > 0 && m <= right &&
				A[m-1] < n && A[m] > n)) {
				return m;
			}
			
			else if (A[m] > n) {
				right = m - 1;
			}
			
			else {
				left = m+1;
			}
		}
		return -1;
	}
}
