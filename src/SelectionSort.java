import java.util.Arrays;


public class SelectionSort {
	public static void main(String[] args) {

		int s[] = { 4, 2, 5, 6, 1, 23, 123, 12, 12, 213, 123, 21, 321, 312, 1,
				1 };

		selection_sort(s);
	}

	//S(n) ≈ n(n − 1)/2
	static void selection_sort(int s[]) {
		System.out.println("before selection sort" + Arrays.toString(s));
		int n = s.length;
		//First finger
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (s[i] < s[j]) {
					int temp = s[i];
					s[i] = s[j];
					s[j] = temp;
				}
			}
		}
		System.out.println("after " + Arrays.toString(s));
	}
}
