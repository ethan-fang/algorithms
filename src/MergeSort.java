import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

import com.sun.jmx.remote.internal.ArrayQueue;


public class MergeSort {

	private List<Integer> s;
	
	public static void main(String[] args) {
		Integer[] sArray = { 4, 2, 5, 6, 1, 23, 123, 12, 12, 213, 123, 21, 321, 312, 1,
				1 };
		
		MergeSort mergeSort = new MergeSort();
		mergeSort.s = Arrays.asList(sArray);
		System.out.println("before" + mergeSort);
		
		mergeSort.sort();
		System.out.println("after " + mergeSort);
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
		merge_sort(0, s.size() - 1);
	}
	
	//O(n2)
	private void merge_sort(int start, int end) {
		if (start == end) {
			return;
		}
		int middle = (start+end) / 2;
		this.merge_sort(start, middle);
		this.merge_sort(middle + 1, end);
		merge(start, middle, end);
	}
	
	private void merge(int start, int middle, int end) {
		List<Integer> bufferList = new ArrayList<Integer>();
		
		int i = start, j = middle + 1;
		while(i <= middle && j <= end) {
			if (s.get(i) <= s.get(j)) {
				bufferList.add(s.get(i));
				i++;
			} else {
				bufferList.add(s.get(j));
				j++;
			}
		}
		for (int i1 = i; i1 <= middle; i1++) {
			bufferList.add(s.get(i1));
		}
		for (int i1 = j; i1 <= end; i1++) {
			bufferList.add(s.get(i1));
		}
		for (int i1 = start; i1 <= end; i1++) {
			s.set(i1, bufferList.get(i1 - start));
		}
	}
}
