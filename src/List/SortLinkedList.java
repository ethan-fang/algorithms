package List;

public class SortLinkedList {

	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode oneStepNode = head;
		ListNode twoStepNode = head;
		while (twoStepNode != null && twoStepNode.next != null && twoStepNode.next.next != null) {
			oneStepNode = oneStepNode.next;
			twoStepNode = twoStepNode.next.next;
		}

		ListNode secondListHead = oneStepNode.next;
		oneStepNode.next = null;
		
		ListNode node = mergeSortedList(sortList(head), sortList(secondListHead));
		return node;
	}

	private ListNode mergeSortedList(ListNode node1, ListNode node2) {
		if (node1 == null && node2 == null)
			return null;
		if (node1 == null)
			return node2;
		if (node2 == null)
			return node1;
		ListNode head = null;
		if (node1.val >= node2.val) {
			head = node1;
			node1 = node1.next;
		} else {
			head = node2;
			node2 = node2.next;
		}
		ListNode tail = head;
		while (node1 != null && node2 != null) {
			if (node1.val >= node2.val) {
				tail.next = node1;
				tail = tail.next;
				node1 = node1.next;
			} else {
				tail.next = node2;
				tail = tail.next;
				node2 = node2.next;
			}
		}
		ListNode remainNode = (node1 != null) ? node1 : node2;
		tail.next = remainNode;
		return head;
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
		
		public void print() {
			ListNode cNode = this;
			while (cNode != null) {
				System.out.print(cNode.val + ",");
				cNode = cNode.next;
			}
		}
	}
	
	public static void main(String[] args) {
		SortLinkedList linkedList = new SortLinkedList();
		ListNode n1 = new ListNode(4);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(1);
		ListNode n4 = new ListNode(3);
//		ListNode n5 = new ListNode(4);
//		ListNode n6 = new ListNode(7);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
//		n4.next = n5;
//		n5.next = n6;
		System.out.println("Before sort ");
		n1.print();
		System.out.println("");
		
		System.out.println("After sort ");
		linkedList.sortList(n1).print();
		System.out.println("");
		
		
	}
}
