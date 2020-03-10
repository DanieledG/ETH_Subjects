package sorting;

public class Bubblesort extends Sorting{
	public static int[] bubblesort(int[] A) {
		for (int i = 0; i < A.length-1; i++) {
			for (int j = 1; j < A.length-i; j++) {
				if (A[j-1] > A[j]) {
					swapKeys(A, j-1, j);
				}
			}
		}
		return A;
	}
}
