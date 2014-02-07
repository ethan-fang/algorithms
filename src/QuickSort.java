import java.util.Arrays;
import java.util.List;


public class QuickSort {

	private List<Integer> s;
	
	public static void main(String[] args) {
		Integer[] sArray = { 4, 2, 5, 6, 1, 23, 123, 12, 12, 213, 123, 21, 321, 312, 1,
				1 };
		
		QuickSort quickSort = new QuickSort();
		quickSort.s = Arrays.asList(sArray);
		System.out.println("before" + quickSort);
		
		quickSort.sort();
		System.out.println("after " + quickSort);
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (Integer value : s) {
			sb.append(value + ",");
		}
		return sb.toString();
	}

	public void sort() {
		quick_sort(0, s.size() - 1);
	}
	
	//O(n2)
	private void quick_sort(int start, int end) {
		if (start >= end) {
			return;
		}
		int p = partition(start, end);
		quick_sort(start, p - 1);
		quick_sort(p + 1, end);
	}
	
	private int partition(int start, int end) {
		int pivotFinalPosition = start;
		int position = end;
		
		for (int i = start; i < end; i++) {
			if (s.get(i) < s.get(position)) {
				int temp = s.get(i);
				s.set(i, s.get(pivotFinalPosition));
				s.set(pivotFinalPosition, temp);
				pivotFinalPosition++;
			}
		}
		int temp = s.get(end);
		s.set(end, s.get(pivotFinalPosition));
		s.set(pivotFinalPosition, temp);
		return pivotFinalPosition;
	}
}
