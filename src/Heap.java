import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	
	public Heap(List<Integer> array) {
		mQueue = new ArrayList<Integer>();
		for (Integer value : array) {
			insert(value);
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
	}

}
