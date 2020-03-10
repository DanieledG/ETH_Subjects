package sorting;

public class SmallerEqualCounter {
	public static int smallerEqualThan(int n, int[] A) {
		int left = 0; 
		int right = A.length-1;
		while (left <= right) {
			int m = (left+right) / 2;
			
			if (A[m] == n || (m == right && A[right] < n)){
				return m+1;
			}
			else if((m == 0 && A[0] > n) || 
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
