package Interviews;

public class PrintFullBinaryTreeBoundary45 {
	
	//    1
	//  2   3
	//4  5 6  7
	
	public static void main(String[] args) {
		Tree myTree = new Tree(1);
		myTree.left = new Tree(2);
		myTree.right = new Tree(3);
		myTree.left.left = new Tree(4);
		myTree.left.right = new Tree(5);
		myTree.right.left = new Tree(6);
		myTree.right.right = new Tree(7);
		PrintEdge(myTree);
	}
	
	public static void PrintEdge(Tree t) {
		if (t == null) return;
		System.out.println(t.value + " ");
		PrintLeftEdgeExceptLeaf(t);
		PrintBottomEdge(t);
		PrintRightEdgeExceptLeaf(t);
	}
	
	public static void PrintRightEdgeExceptLeaf(Tree t) {
		Tree current = t.right;
		while (current.right != null) {
			System.out.println(current.value + " ");
			current = current.right;
		}
	}
	
	public static void PrintBottomEdge(Tree t) {
		if (t == null) return;
		if (t.left == null && t.right == null) {
			System.out.println(t.value + " ");
		}
		PrintBottomEdge(t.left);
		PrintBottomEdge(t.right);
	}
	
	public static void PrintLeftEdgeExceptLeaf(Tree t) {
		Tree current = t.left;
		while (current.left != null) {
			System.out.println(current.value + " ");
			current = current.left;
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
