package sorting;

public class Mergesort extends Sorting{
	
	public static int[] merge(int[] A, int left, int middle, int right) {
		int[] Temp = new int[right - left + 1];
		int i = left;
		int j = middle + 1;
		int k = 0;
		 while(i <= middle && j <= right) {
			 if (A[i] <= A[j]) {
				 Temp[k] = A[i];
				 i++;
			 }
			 else {
				 Temp[k] = A[j];
				 j++;
			 }
			 k++;
		 }
		 
		 while(i <= middle) {
			 Temp[k] = A[i];
			 i++;
			 k++;
		 }
		 
		 while(j <=  right) {
			 Temp[k] = A[j];
			 j++;
			 k++;
		 }
		 for (k=left; k<=right; k++) {
			 A[k] = Temp[k-left];
		 }
		 return A;
}
	
	public static int[] mergesort(int [] A, int left, int right) {
		if (left < right) {
			int middle = (left+right) / 2;
			mergesort(A,left, middle);
			mergesort(A, middle+1, right);
			A = merge(A, left, middle, right);
		}
		return A;
	}
}
 