package Interviews;

import java.util.Stack;

public class LargestRectangleInHistogram39 {

	// create a test case
	public static void main(String[] args) {
		// int[] histos = {2,4,2,1};//use demo example, expect 6
		// System.out.println("Largest rectangle size is "+LargestRectangle(histos));

		int[] histos2 = { 10, 6, 10 };// this time expect 18, with height 6 and
										// width spans last 3 nodes
		System.out.println("Largest rectangle size is "
				+ LargestRectangle(histos2));
	}

	private static int LargestRectangle(int[] histos) {

		// firstly define two stacks, one for heights the other for indexes
		Stack<Integer> heights = new Stack<Integer>();
		Stack<Integer> indexes = new Stack<Integer>();

		int maxSize = 0;
		for (int i = 0; i < histos.length; i++) {
			if (heights.isEmpty() || histos[i] > heights.peek()) {
				heights.push(histos[i]);
				indexes.push(i);
			} else if (heights.peek() > histos[i]) {
				int index = 0;
				while (!heights.isEmpty() && heights.peek() > histos[i]) {
					int height = heights.pop();
					index = indexes.pop();
					int size = (i - index) * height;
					if (maxSize < size) {
						maxSize = size;
					}
				}
				heights.push(histos[i]);
				indexes.push(index);
			}
		}

		// after the process, there may still be values in stacks, pop out each
		// and test size
		while (!heights.isEmpty()) {
			// we need compute the size
			int tempAreaSize = heights.pop() * (histos.length - indexes.pop());// the
																				// width=currentIndex(last
																				// one)
																				// -
																				// stored
																				// index
			if (maxSize < tempAreaSize)
				maxSize = tempAreaSize;// update largest area size if necessary
		}

		return maxSize;
	}

}
