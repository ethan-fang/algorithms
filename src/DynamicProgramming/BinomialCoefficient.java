package DynamicProgramming;

public class BinomialCoefficient {

	public static final int MAXN = 10;

	long binomial_coefficient(int n, int m)

	{
		int i, j;
		long[][] bc = new long[MAXN][MAXN];
		for (i = 0; i <= n; i++)
			bc[i][0] = 1;
		for (j = 0; j <= n; j++)
			bc[j][j] = 1;
		for (i = 1; i <= n; i++)
			for (j = 1; j < i; j++)
				bc[i][j] = bc[i - 1][j - 1] + bc[i - 1][j];
		return (bc[n][m]);
	}
	
	public static void main(String[] args) {
		int n = 5;
		int m = 1;
		System.out.println("Binomial " + n + "/" + m);
		BinomialCoefficient b = new BinomialCoefficient();
		System.out.println(b.binomial_coefficient(n, m));
	}

}
