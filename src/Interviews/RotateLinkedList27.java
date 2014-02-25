package Interviews;

public class RotateLinkedList27 {
	//let's create a test case
	public static void main(String[] args)
	{
		List myList = new List(1);
		myList.next = new List(2);
		myList.next.next = new List(3);
		myList.next.next.next = new List(4);
		myList.next.next.next.next = new List(5);//so the list is 1,2,3,4,5
		myList.Print();//print out the list should be in order
		myList = RotateN(myList, 2);//let's rotate by 2, thus we expect 3,4,5,1,2
		myList.Print();//let's verify it!
		myList = RotateN(myList, 2);//let's rotate by 2, thus we expect 5,1,2,3,4
		myList.Print();//let's verify it!
	}
	
	private static List RotateN(List myList, int i) {
		// TODO Auto-generated method stub
		return null;
	}

	//we firstly define our simple List class
	private static class List
	{
		List next;
		int value;
		public List(int k)
		{
			value = k;
		}
		//we also define a print method to print List in order
		public void Print()
		{
			List current = this;
			while(current!=null)
			{
				System.out.print(current.value+"->");
				//gosh I forget to update current index
				current = current.next;
			}
			System.out.print("NULL\n");
		}
	}

}
