package Interviews;

public class StairClimbing29 {

	//now we create a test case
		public static void main(String[] args)
		{
			//now let's see the performance difference using larger case and count time used
			long startTime = System.currentTimeMillis();
			System.out.println("Ways of 35-steps: (recursive) "+ways(35));
			System.out.println("Time used (recursive)"+(System.currentTimeMillis()-startTime));

			startTime = System.currentTimeMillis();//update time for start of iterative method
			System.out.println("Ways of 35-steps: (interation) "+waysInteration(35));
			System.out.println("Time used (iterative)"+(System.currentTimeMillis()-startTime));

			//same result, but the optimized method has much better performance
			//this is one of the simplest example to show the power of dynamic programming (DP)
		}

	private static int waysInteration(int n) {
			if (n == 1)
				return 1;
			if (n == 2)
				return 2;
			if (n == 3)
				return 4;
			return waysInteration(n-3) + waysInteration(n-2) + waysInteration(n-1);
		}

	private static int ways(int n) {
		
		//similary we check if it meets basic cases
				if(n==1) return 1;//climb 1 step
				if(n==2) return 2;//(1+1) or (2)
				if(n==3) return 4;//1+1+1, 1+2, 2+1, 3
				//now we process the problem by using additional memory to remember the steps for stairs less than n
				//we only need to remember the most recent 3 cases for most space efficiency
				int[] prev = {1,2,4};//these are the basic cases
				int current = 3;//we only come here when n>3
				while(current<n)
				{
					//we need update the previous three steps!
					int preTotal = prev[0] + prev[1] + prev[2];
					//and we update prev[0] with original prev[1] and further
					prev[0] = prev[1];
					prev[1] = prev[2];
					prev[2] = preTotal;//we need update the most recent with the total sum of previous three
					//we forgot the update current
					++current;
				}
				//after the loop, current equal n and the last value in the memory array is what we want!
				return prev[2];
	}
		
		
}
