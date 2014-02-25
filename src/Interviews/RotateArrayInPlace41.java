package Interviews;

public class RotateArrayInPlace41 {

	public static void main(String[] args)
	{
		int[] nums = {1,2,3,4,5,6};
		int k = 3;//so after rotation, we expect {4,5,6,1,2,3}
		System.out.println("Original: "+java.util.Arrays.toString(nums));
		rotate(nums, k);
		System.out.println("After rotation: "+java.util.Arrays.toString(nums));
	}
	
	public static void rotate(int[] a, int k) {
		reverse(a, 0, k - 1);
		reverse(a, k, a.length - 1);
		reverse(a, 0, a.length - 1);
	}
	
	public static void reverse(int[] a, int start, int end) {
		int cStart = start;
		int cEnd = end;
		while (cStart < cEnd) {
			int swap = a[cStart];
			a[cStart] = a[cEnd];
			a[cEnd] = swap;
			cStart++;
			cEnd--;
		}
	}
}
