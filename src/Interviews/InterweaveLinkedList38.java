package Interviews;

public class InterweaveLinkedList38 {
	private static class MyList {
		int value;
		MyList next;

		public MyList(int k) {
			value = k;
		}

		public void Print() {
			MyList tmp = this;
			while (tmp != null) {
				System.out.print(tmp.value + "->");
				tmp = tmp.next;
			}
			System.out.println("NULL");
		}
	}

	// create a test case
	public static void main(String[] args) {
		MyList L = new MyList(1);
		L.next = new MyList(2);
		L.next.next = new MyList(3);
		L.next.next.next = new MyList(4);
		L.next.next.next.next = new MyList(5);
		L.next.next.next.next.next = new MyList(6);
		L.next.next.next.next.next.next = new MyList(7);
		L.Print();// expect 1,2,3,4,5,6,7
		Interweave(L);
		L.Print();// expect 1,7,2,6,3,5,4

		// notice this problem we used constant space and linear running time!
	}

	private static void Interweave(MyList L) {
		MyList mid = GetMiddle(L);
		//now reverse 2nd half
		MyList secondhalf = Reverse(mid.next);
		MyList firsthalf = L;
		//do not forget to update mid.next==null
		mid.next = null;//otherwise we are duplicating L1 and L2
		L = Merge(firsthalf, secondhalf);
	}
	
	//so the 3rd method is to merge two lists into one, by picking one from each other
	private static MyList Merge(MyList L1, MyList L2)
	{
		//however, one assumption is that the length of L1>L2, because of our mid algorithm
		MyList merged = new MyList(0);//its next is the resulting merged list
		MyList current = merged;//current points where we are at the time of merging
		int turn = 1;//we define a turn to know which list element to be merged per loop cycle
		while(L1!=null && L2!=null)
		{
			if(turn==1)//pick from L1
			{
				current.next = L1;
				L1 = L1.next;//update L1's index to right
				turn = 2;//next loop we pick from L2
			}
			else//pick from L2
			{
				current.next = L2;
				L2 = L2.next;//update L1's index to right
				turn = 1;//back to L1 next cycle
			}
			current = current.next;//update the current pointer
		}
		//as we said L1's length may be longer than L2 considering size of array
		if(L1!=null)//we merge the remaining L1 to our current.next
			current.next = L1;

		return merged.next;
	}
	
	private static MyList GetMiddle(MyList l) {
		MyList slow = l;
		MyList fast = l;
		while(fast!=null && fast.next!=null && slow!=null)
		{
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
	
	private static MyList Reverse(MyList l) {
		if (l == null || l.next == null) {
			return l;
		}
		MyList myNext = l.next;
		MyList newList = Reverse(myNext);
		myNext.next = l;
		l.next = null;
		return newList;
	}
}
