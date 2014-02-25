package Interviews;

public class InsertValueintoSortedCircularLinkedList {
	
	public static void main(String[] args) {
		List list = new List(100);
		list.next = new List(99);
		list.next.next = new List(98);
		list.next.next.next = new List(97);
		list.next.next.next.next = list;
		
		System.out.println("List is " + list);
		list = InsertValueIntoList(101, list);
		System.out.println("after insert 101, list is " + list);
		list = InsertValueIntoList(90, list);
		System.out.println("after insert 90, list is " + list);
		
		list = null;
		System.out.println("List is " + list);
		list = InsertValueIntoList(101, list);
		System.out.println("after insert 101, list is " + list);
		
		list = new List(100);
		System.out.println("List is " + list);
		list = InsertValueIntoList(101, list);
		System.out.println("after insert 101, list is " + list);
		
		list = new List(100);
		System.out.println("List is " + list);
		list = InsertValueIntoList(99, list);
		System.out.println("after insert 99, list is " + list);
	}

	public static List InsertValueIntoList(int value, List list) {
		List newNode = new List(value);
		if (list == null)
			return newNode;
		if (list.next == list) {
			newNode.next = list;
			newNode.next.next = newNode;
			return list.value > value ? list : newNode;
		}
		if (value > list.value) {
			List lastNode = list;
			while (lastNode.next != list) {
				lastNode = lastNode.next;
			}
			lastNode.next = newNode;
			lastNode.next.next = list;
			return newNode;
		}
		
		List current = list;
		while(current.next != list && current.next.value >= value) {
			current = current.next;
		}
		List currentNext = current.next;
		current.next = newNode;
		current.next.next = currentNext; 
		return list;
	}
	
	private static class List {
		public int value;
		public List next;
		public List(int k) {
			value = k;
			next = this;
		}
		
		@Override
		public String toString() {
			String s = "";
			List node = this;
			do {
				s += (node.value + "->");
				node = node.next;
			} while (node != this);
			return s;
		}
	}
}
