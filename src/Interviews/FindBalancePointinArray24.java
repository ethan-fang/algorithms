package Interviews;

public class FindBalancePointinArray24 {

	public static void main(String[] args)
	{
		int[] a = {1,2,3,7,6,5,9,5,6,7,5,2,-1};//expected 6th position
		System.out.println("(Best) Balance point for a is index "+BalanceBest(a));
	}

	private static int BalanceBest(int[] a) {
		if (a.length < 2) {
			return -1;
		}
		int rightSum = 0;
		for (int i = 1; i < a.length; i++) {
			rightSum += a[i];
		}
		
		int leftSum = 0;
		for (int i = 1; i < a.length; i++) {
			leftSum += a[i-1];
			rightSum -= a[i];
			if (leftSum == rightSum)
				return i;
		}
		return -1;
	}
	
	
}
