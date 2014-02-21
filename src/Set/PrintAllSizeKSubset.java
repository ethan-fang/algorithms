package Set;

public class PrintAllSizeKSubset {
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5};
		boolean[] used = new boolean[5];
		PrintAllSizeKSubset(array, used, 0, 0, 2);
	}
	
	
	static void PrintAllSizeKSubset(int[] array, boolean[] used, int startIndex, int currentSize, int k) {
		if (currentSize == k) {
			for (int i = 0; i < array.length; i++) {
				if (used[i]) {
					System.out.println(array[i] + " ");
				}
			}
			System.out.println();
			return;
		}
		
		if (startIndex == array.length) {
			return;
		}
		
		used[startIndex] = true;
		PrintAllSizeKSubset(array, used, startIndex + 1, currentSize + 1, k);
		used[startIndex] = false;
		PrintAllSizeKSubset(array, used, startIndex + 1, currentSize, k);
	}
}
