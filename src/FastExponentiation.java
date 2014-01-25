import java.util.Arrays;


public class FastExponentiation {
	public static void main(String[] args) {

		int a = 3;
		int n = 100;
		System.out.println("a = " + a + " n = " + n);
		double exp = fast_exponentiation(a, n);
		
		System.out.println("result is " + exp);
	}

	private static double fast_exponentiation(int a, int n) {
		if (n == 0) return 1;
		double x = fast_exponentiation(a, n / 2);
		if (n % 2 == 0) {
			return x * x;
		} else {
			return a * x * x;
		}
	}
}
