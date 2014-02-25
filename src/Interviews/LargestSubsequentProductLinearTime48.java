package Interviews;

public class LargestSubsequentProductLinearTime48 {
	public static void main(String[] args) {
		//write a test case, use the example we discussed in slides.
		double[] nums = {1.63, 0.68, -3.00, -2.21, -0.72}; //expect LSP=7.35
		System.out.println("Max sum: "+largestSP(nums));
	}
	
	public static double largestSP(double[] nums) {
		
		double maxPos = 0;
		double maxNeg = 0;
		double curPos = 1;
		double curNeg = 1;
		
		for (int i = 0; i < nums.length; i++) {
			
			double value = nums[i];
			if (value > 0) {
				curPos = curPos * value;
				if (curNeg != 1) {
					curNeg *= value;
				}
			} else if (value < 0) {
				if (curNeg == 1) {
					curNeg = curPos * value;
					curPos = 1;
				} else {
					double tempNeg = curNeg;
					curNeg = curPos * value;
					curPos = tempNeg * value;
				}
			} else {
				curNeg = 1;
				curPos = 1;
			}
			if (curPos < 1) {
				curPos = 1;
			}
			if (maxPos < curPos) {
				maxPos = curPos;
			}
			if (maxNeg > curNeg) {
				maxNeg = curNeg;
			}
			System.out.println("After " + i + " iterations maxPos is " + maxPos + " and maxNeg is " + maxNeg);
		}
		return maxPos;
	}
	
}
