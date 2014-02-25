package Interviews;

public class Longest_Increasing_Subsequence_49 {

	public static void main(String[] args) {
		// let's use the example discussed in slides
		int[] nums = { 2, 6, 4, 5, 1, 3 };

		LIS(nums);
	}

	public static void LIS(int[] a) {

		if (a == null) {
			System.out.println("");
		}
		if (a.length == 1) {
			System.out.println(a[0]);
		}

		String[] paths = new String[a.length];
		int[] values = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			paths[i] = a[i] + " ";
			values[i] = 1;
		}

		LIS(a, values, paths);
	}

	public static void LIS(int[] a, int[] values, String[] paths) {
		for (int cIndex = 1; cIndex < a.length; cIndex++)
			for (int i = 0; i < cIndex; i++) {
				if (values[cIndex] <= values[i] && a[cIndex] > a[i]) {
					paths[cIndex] = paths[i] + a[cIndex] + " ";
					values[cIndex] = values[i] + 1;
				}
			}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < values.length; i++) {
			if (max < values[i]) {
				max = values[i];
			}
		}
		for (int i = 0; i < values.length; i++) {
			if (values[i] == max) {
				System.out.println("LIS: " + paths[i]);
			}
		}
	}

}
