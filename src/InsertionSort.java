import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {

		int s[] = { 4, 2, 5, 6, 1, 23, 123, 12, 12, 213, 123, 21, 321, 312, 1,
				1 };

		insertion_sort(s);
	}

	//O(n2)
	static void insertion_sort(int s[]) {
		System.out.println("before " + Arrays.toString(s));
		int n = s.length;
		//First finger
		for (int i = 1; i < n; i++) {
			int j = i;
			//Second finger
			while (j > 0 && (s[j] > s[j - 1])) {
				int temp = s[j - 1];
				s[j - 1] = s[j];
				s[j] = temp;
				j--;
			}
		}
		System.out.println("after " + Arrays.toString(s));
	}
}
