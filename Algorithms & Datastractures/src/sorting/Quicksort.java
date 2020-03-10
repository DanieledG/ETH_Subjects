package sorting;

public class Quicksort extends Sorting{
	
	public static int[] quicksort(int[] A, int left, int right) {
		if (left < right){
			int k = partition(A, left, right);
			quicksort(A, left, k-1);
			quicksort(A, k+1, right);
		}
		return A;
	}
	public static int partition(int[] A, int left, int right) {
		int i = left;
		int j = right-1;
		int pivot = A[right];
		do {
			while (i < right && A[i] <= pivot) {
				i++;
			}
			while (j > left && A[j] >= pivot) {
				j--;
			}
			if(i < j) {
				swapKeys(A,i,j);
			}
		} while (i < j);
		
		swapKeys(A, i, right);
		return i;
	}
}
