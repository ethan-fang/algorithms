package Interviews;

public class PassingExamRatioByGuessing {
	//let's test
	public static void main(String[] args)
	{
		System.out.println("Ratio of guessing 5 out of 10 is " +passingRatio1(10, 5));
		System.out.println("Ratio of guessing 2 out of 4 is " +passingRatio1(4, 2));
	}

	private static float passingRatio(int i, int j) {
		if (j == 0) {
			float allWrong = 1;
			for (int k = 0; k < i; k++) {
				allWrong *= 3.0/4;
			}
			return allWrong;
		} else if (i == j) {
			float allRight = 1;
			for (int k = 0; k < i; k++) {
				allRight *= 1.0/4;
			}
			return allRight;
		}
		
		return passingRatio(i - 1, j - 1) * 1.0f/4 + passingRatio(i - 1, j) * 3.0f/4;
	}
	
	private static double passingRatio1(int N, int k) {
		double[][] ratios = new double[N + 1][k + 1];
		double singleRight = 1.0 / 4;
		double singleWrong = 3.0 / 4;
		ratios[1][0] = singleWrong;
		ratios[1][1] = singleRight;
		
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j <= k; j++) {
				if (j == 0) {
					ratios[i][j] = ratios[i-1][j]*singleWrong;
				} else {
					ratios[i][j] = ratios[i-1][j-1]*singleRight +  ratios[i-1][j]*singleWrong;
				}
			}
		}
		return ratios[N][k];
	}
		
}
