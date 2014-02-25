package Interviews;

import java.util.Stack;

public class PostorderTraversalwithoutrecursion47 {
	
	public static void main(String[] args) {
		Tree myTree = new Tree(1);
		myTree.left = new Tree(2);
		myTree.right = new Tree(3);
		myTree.left.left = new Tree(4);
		myTree.left.right = new Tree(5);
		myTree.right.left = new Tree(6);
		//myTree.right.right = new BinaryTree(7);//now post-order expects: 452631
		System.out.println("\nPost order WIHTOUT recursion: ");
		Traversal(myTree);
	}
	
	public static void Traversal(Tree t) {
		if (t == null) {
			return;
		}
		Stack<Tree> nodes = new Stack<Tree>();
		
		Tree previous = new Tree(1);
		nodes.push(t);
		while (!nodes.isEmpty()) {
			Tree current = nodes.peek();
			if (current == null) {
				nodes.pop();
			} else if (current.left == null && current.right == null) {
				System.out.println(current.value + " ");
				nodes.pop();
			} else if (previous == current.left) {
				nodes.push(current.right);
			} else if (previous == current.right) {
				System.out.println(current.value + " ");
				nodes.pop();
			} else {
				nodes.push(current.left);
			}
			previous = current;
		}
	}

	private static class Tree {
		int value;
		Tree left;
		Tree right;
		public Tree(int k) {
			value = k;
		}
	}
}
