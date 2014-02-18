package DynamicProgramming;

public class Fibonacci {
	public static final int MAX = 20;

	long fib_r(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		return fib_r(n - 1) + fib_r(n - 2);
	}

	long fib_dp(int n) {
		int i;
		long[] f = new long[MAX];
		/* counter */
		/* array to cache computed fib values */
		f[0] = 0;
		f[1] = 1;
		for (i = 2; i <= n; i++)
			f[i] = f[i - 1] + f[i - 2];
		return (f[n]);
	}

	long fib_ultimate(int n) {
		int i; /* counter */
		long back2 = 0, back1 = 1; /* last two values of f[n] */
		long next; /* placeholder for sum */
		if (n == 0)
			return (0);
		for (i = 2; i < n; i++) {
			next = back1 + back2;
			back2 = back1;
			back1 = next;
		}
		return (back1 + back2);
	}

	public static void main(String[] args) {
		int n = 10;
		System.out.println("Fibonacci " + 10 + " is ");
		System.out.println();
		Fibonacci fi = new Fibonacci();
		System.out.println(fi.fib_r(10));
		System.out.println(fi.fib_dp(10));
		System.out.println(fi.fib_ultimate(10));
	}

}
