package Interviews;

public class PrintAllSizeKSubsets42 {
	public static void main(String[] args) {
		//now, let's create a test case
		int[] array = {1,2,3,4};
		int K = 2;
		boolean[] used = new boolean[array.length];
		PrintAllSizeKSubset(array, used, 0, 0, 2);
		//expect, 12,13,14,23,24,34!
	}
	
	public static void PrintAllSizeKSubset(int[] a, boolean[] used, int startIndex, int currentSize, int k) {
		if (currentSize == k) {
			for (int i = 0; i < used.length; i++) {
				if (used[i]) {
					System.out.print(a[i] + " ");
					
				}
			}
			System.out.println();
			return;
		}
		
		if (startIndex == a.length) {
			return;
		}
		used[startIndex] = true;
		PrintAllSizeKSubset(a, used, startIndex + 1, currentSize + 1, k);
		used[startIndex] = false;
		PrintAllSizeKSubset(a, used, startIndex + 1, currentSize, k);
	}
	
}
