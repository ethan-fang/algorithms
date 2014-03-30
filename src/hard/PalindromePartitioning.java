package hard;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

	public int minCut(String s) {
		int length = s.length();
		if (s == null || length == 1)
			return 0;

		boolean[][] matrix = new boolean[length][length];
		generatePalindromeMatrix(matrix, s);
		return getCutCount(matrix);
	}
	
	private int getCutCount(boolean[][] matrix) {
	    int[] minCut = new int[matrix.length];
	    
	    minCut[0] = 0;
	    for (int i = 1; i < minCut.length; i++) {
	        if (matrix[0][i]) {
	            minCut[i] = 0;
	            continue;
	        }
	        for (int j = 1; j <= i; j++) {
	            if (matrix[j][i]) {
	                int count = minCut[j - 1] + 1;
	                if (minCut[i] == 0 || count < minCut[i]) minCut[i] = count;
	            }
	        }
	    }
	    return minCut[matrix.length - 1];
	}

	private void print(String s) {
		boolean isDebug = false;
		if (isDebug)
			System.out.println(s);
	}

	private void generatePalindromeMatrix(boolean[][] matrix, String s) {
	    int length = s.length();
	    for (int i = 0; i <length; i++) {
	        for (int j = 0; j < length - i; j++) {
	            setSubStringPalindrome(matrix, s, j, j + i);
	        }
	    }
	}
	
	private void setSubStringPalindrome(boolean[][] matrix, String s, int start, int end) {
	    if (start < 0 || end >= matrix.length) return;
	    if (start == end) matrix[start][end] = true;
	    else if (start == end - 1) matrix[start][end] = (s.charAt(start) == s.charAt(end));
	    else matrix[start][end] = (s.charAt(start) == s.charAt(end)) && (matrix[start+1][end-1]);
	}

	public static void main(String[] args) {
		PalindromePartitioning s = new PalindromePartitioning();
		String string = "ab";

		System.out.println("cut " + s.minCut(string));

	}

}
