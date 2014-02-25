package Interviews;

import java.util.Stack;

public class BinaryTreeTraversalWithoutRecursion {
	public static void main(String[] args)
	{
		//let's create a binary tree
		//    1
		//  2   3
		// 4 5 6 7
		BinaryTree t = new BinaryTree(1);
		t.left = new BinaryTree(2);			t.right = new BinaryTree(3);
		t.left.left = new BinaryTree(4);		t.left.right = new BinaryTree(5);
		t.right.left = new BinaryTree(6);		t.right.right = new BinaryTree(7);
		System.out.println("In order using recursion: ");
		t.InOrder();
		System.out.println("\nIn order without recursion: ");
		inOrderWithoutRecursion(t);
		System.out.println("\nPreorder using recursion: ");
		t.Preorder();
		System.out.println("\nPreorder without recursion: ");
		preOrderWithoutRecursion(t);
	}
	
	public static void preOrderWithoutRecursion(BinaryTree t) {

		if (t == null)
			return;
		BinaryTree current = t;
		Stack<BinaryTree> stack = new Stack<BinaryTree>();
		while (current != null || !stack.isEmpty()) {
			if (current != null) {
				System.out.print(current.value + "");
				stack.push(current.right);
				current = current.left;
			} else {
				current = stack.pop();
			}
		}
	}

	public static void inOrderWithoutRecursion(BinaryTree t) {

		if (t == null)
			return;
		BinaryTree current = t;
		Stack<BinaryTree> stack = new Stack<BinaryTree>();
		while (current != null || !stack.isEmpty()) {
			if (current != null) {
				stack.push(current);
				current = current.left;
			} else {
				current = stack.pop();
				System.out.print(current.value + "");
				current = current.right;
			}
		}
	}

	private static class BinaryTree {
		int value;
		BinaryTree left;
		BinaryTree right;

		public BinaryTree(int k) {
			value = k;
		}

		//we firstly implement an inorder using recursion
		public void InOrder()
		{
			if(left!=null)
				left.InOrder();
			System.out.print(value+", ");//print out as visiting it
			if(right!=null)
				right.InOrder();
		}

		//now we process with pre-order
		//firstly implement a recursive preorder method
		public void Preorder()
		{
			System.out.print(value+", ");
			if(left!=null)
				left.Preorder();
			if(right!=null)
				right.Preorder();
		}
	}
}
