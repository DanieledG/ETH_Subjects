package dynamicProgramming;

public class MinEditingDistance {
	public static int minED(String a, String b) {
		a = a.toLowerCase();
		b = b.toLowerCase();
		char[] A = new char[a.length()+1];
		char[] B = new char[b.length()+1];
		//Initialization
		for (int i = 1; i <= a.length(); i++) {
			A[i] = a.charAt(i-1);
		}
		for (int i = 1; i <= b.length(); i++) {
			B[i] = b.charAt(i-1);
		}
		int[][] DP = new int[a.length()+1][b.length()+1];
		for (int i = 0; i <= a.length(); i++) {
			DP[i][0] = i;
		}
		for (int i = 0; i <= b.length(); i++) {
			DP[0][i] = i;
		}
		//-----------------------------
		for (int i = 1; i <= a.length(); i++) {
			for (int j = 1; j <= b.length(); j++) {
				int equal = 1;
				if (A[i] == B[j]) {
					equal = 0;
				}
				int min = Math.min(DP[i-1][j] + 1, DP[i][j-1] + 1);
				DP[i][j] = Math.min(min, DP[i-1][j-1] + equal);
			}
		}
		
		return DP[a.length()][b.length()];
	}
}
