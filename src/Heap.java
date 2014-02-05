import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.sun.org.apache.xpath.internal.operations.Mult;

public class Heap {

	private List<Integer> mQueue;

	public int parent(int n) {
		if (n == 0)
			return -1;
		else
			return (n - 1) / 2;
	}

	public int leftChild(int n) {
		if (n == 0) {
			return 1;
		}
		return n * 2 + 1;
	}

	public int rightChild(int n) {
		if (n == 0) {
			return 2;
		}
		return n * 2 + 2;
	}

	public void insert(Integer x)
    {
		mQueue.add(x);		
		bubbleUp(mQueue.size() - 1);
    }
	
	private void bubbleUp(int position) {
		if (parent(position) == -1) return;
		if (mQueue.get(parent(position)) > mQueue.get(position)) {
			int temp = mQueue.get(position);
			mQueue.set(position, mQueue.get(parent(position)));
			mQueue.set(parent(position), temp);
			bubbleUp(parent(position));
		}
	}
	
	public int extractMin() {
		int min = -1;
		if (mQueue.size() == 0) {
			return min;
		}
		int temp = mQueue.get(0);
		mQueue.set(0, mQueue.get(mQueue.size() - 1));
		mQueue.set(mQueue.size() - 1, temp);
		mQueue.remove(mQueue.size() - 1);
		bubbleDown(0);
		return temp;
	}
	
	private void bubbleDown(int position) {
		int minIndex = position;
		int child = leftChild(position);
		for (int i = 0; i < 2; i++) {
			if ((child + i) < mQueue.size()) {
				if (mQueue.get(child+i) <= mQueue.get(minIndex)) {
					minIndex = child + i;
				}
			}
		}
		if (minIndex != position) {
			int temp = mQueue.get(position);
			mQueue.set(position, mQueue.get(minIndex));
			mQueue.set(minIndex, temp);
			bubbleDown(minIndex);
		}
	}
	
	public Heap(List<Integer> array, boolean bubbleDown) {
		if (bubbleDown) {
			mQueue = new ArrayList<Integer>(array);
			int start = mQueue.size() / 2;
			for (int i = start; i >= 0; i--) {
				bubbleDown(i);
			}
		} else {
			mQueue = new ArrayList<Integer>();
			for (Integer value : array) {
				insert(value);
			}
		}
	}
	
	public boolean isKthSmallestValueBiggerThanX(int k, int x) {
		int count = heapCompare(0, k, x);
		return count <= 0;
	}
	
	private int heapCompare(int position, int count, int x) {
		if ((count <= 0) || (position > mQueue.size() - 1)) {
			return count;
		}
		if (mQueue.get(position) < x) {
			count = heapCompare(leftChild(position), count - 1, x);
			count = heapCompare(rightChild(position), count, x); 
		}
		return count;
	}
	
	public void sortAndPrint() {
		while (mQueue.size() != 0) {
			System.out.println(extractMin());
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Integer value : mQueue) {
			sb.append(", " + value);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		List<Integer> a = Arrays.asList(2,6,324,23,43,4234,324,324,326,436,243);
		Heap heap = new Heap(a, true);
		System.out.println("heap is " + heap);
		
		int k = 5;
		int value = 243;
		System.out.println("Is " + k + "th" + " elements smaller than " + value + " " + heap.isKthSmallestValueBiggerThanX(k, value));
		
		heap.sortAndPrint();
	}

}
