package List;

import List.SortLinkedList.ListNode;

public class SortLinkedListInsertion {
	public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode newHead = oneMove(null, head);
        ListNode cNodeParent = newHead;
        ListNode cNode = cNodeParent.next;
        while (cNode != null) {
        	cNodeParent = oneMove(cNodeParent, cNode);
            cNode = cNodeParent.next;
        }
        return newHead;
    }
    
    public ListNode oneMove(ListNode parent, ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode minNode = head;
        int minValue = head.val;
        ListNode minNodeParent = null;
        ListNode cNode = head;
        while (cNode.next != null) {
            if (minValue > cNode.next.val) {
                minNodeParent = cNode;
                minNode = cNode.next;
                minValue = cNode.next.val;
            }
            cNode = cNode.next;
        }
        if (head != minNode) {
            if (parent != null) {
                parent.next = minNode;
            }
            if (minNodeParent != null) {
                minNodeParent.next = head;
            }
            ListNode headNext = head.next;
            head.next = minNode.next;
            minNode.next = headNext;
            return minNode;
        } else {
            return head;
        }
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
		SortLinkedListInsertion linkedList = new SortLinkedListInsertion();
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(1);
//		ListNode n3 = new ListNode(1);
//		ListNode n4 = new ListNode(3);
//		ListNode n5 = new ListNode(4);
//		ListNode n6 = new ListNode(7);
		n1.next = n2;
//		n2.next = n3;
//		n3.next = n4;
//		n4.next = n5;
//		n5.next = n6;
		System.out.println("Before sort ");
		n1.print();
		System.out.println("");
		
		System.out.println("After sort ");
		linkedList.insertionSortList(n1).print();
		System.out.println("");
		
		
	}
}
