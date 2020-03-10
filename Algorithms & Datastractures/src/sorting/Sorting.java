package sorting;

public class Sorting {
	public static void swapKeys(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

}
