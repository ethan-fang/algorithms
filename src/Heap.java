import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.sun.org.apache.xpath.internal.operations.Mult;

public class Heap {

	private List<Integer> mQueue;

	public int parent(int n) {
		if (n == 1)
			return -1;
		else
			return n / 2;
	}

	public int leftChild(int n) {
		return n * 2;
	}

	public int rightChild(int n) {
		return n * 2 + 1;
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
		int child = position * 2;
		if (child == 0) {
			child++;
		}
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
	
	public Heap(List<Integer> array) {
		mQueue = new ArrayList<Integer>();
		for (Integer value : array) {
			insert(value);
		}
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
		Heap heap = new Heap(a);
		System.out.println("heap is " + heap);
		heap.sortAndPrint();
	}

}
