package Interviews;

public class Print2DArrayinSpiralOrder22 {
	//let's create a test case
		public static void main(String[] args)
		{
			int[][] sorted = {	{1,4,5}, 
								{2,6,7},
								{3,8,9}};
			Search(sorted, 3);//expect to be found at location (2,0)
			Search(sorted, 4);//expect to be found at location (0,1)
			Search(sorted, 10);//expected to be not found
		}

		private static void Search(int[][] sorted, int value) {
			int i = sorted.length - 1;
			int j = 0;
			
			while (i >=0 && j <= sorted[0].length - 1) {
				if (sorted[i][j] == value) {
					System.out.println(i + " " + j);
					return;
				}
				if (sorted[i][j] > value) {
					i--;
				}
				if (sorted[i][j] < value) {
					j++;
				}
			}
		}
		
		
}
