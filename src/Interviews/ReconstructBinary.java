package Interviews;

public class ReconstructBinary {

	// now create a test case
	public static void main(String[] args) {
		// assume we want to reconstruct the binary tree
		// 1
		// 2 3
		// 4 5
		// try a more complicated case for example
		int[] preOder = { 1, 2, 3, 4, 5 };
		int[] inOrder = { 2, 1, 4, 3, 5 };
		BinaryTree myTree = Construct(preOder, 0, preOder.length - 1, inOrder,
				0, inOrder.length - 1);
		// verify if it is the tree
		System.out.print("in-order: ");
		myTree.Traversal_InOrder();
		System.out.print("\npre-order: ");
		myTree.Traversal_PreOrder();
	}

	private static BinaryTree Construct(int[] preOder, int preStart,
			int preEnd, int[] inOrder, int inStart, int inEnd) {

		if (preStart == preEnd) {
			return new BinaryTree(preOder[preStart]);
		}
		if (preStart > preEnd) {
			return null;
		}
		
		int inPosition = 0;
		for (int i = inStart; i < inEnd; i++) {
			if (inOrder[i] == preOder[preStart]) {
				inPosition = i;
				break;
			}
		}

		BinaryTree node = new BinaryTree(preOder[preStart]);
		System.out.println("in position " + inPosition);
		node.left = Construct(preOder, preStart + 1, preStart + inPosition - inStart, inOrder, inStart, inPosition - 1);
		node.right = Construct(preOder, preStart + inPosition - inStart + 1, preEnd, inOrder, inPosition + 1, inEnd);
		// TODO Auto-generated method stub
		return node;
	}

	private static class BinaryTree {
		int value;
		BinaryTree left;
		BinaryTree right;

		public BinaryTree(int k) {
			value = k;
		}

		// we reused the binary tree class in our last example, we also added
		// two traversal method
		public void Traversal_InOrder() {
			if (this != null) {
				if (left != null)
					left.Traversal_InOrder();
				System.out.print(value + ",");
				if (right != null)
					right.Traversal_InOrder();
			}
		}

		public void Traversal_PreOrder() {
			if (this != null) {
				System.out.print(value + ",");
				if (left != null)
					left.Traversal_PreOrder();
				if (right != null)
					right.Traversal_PreOrder();
			}
		}
	}
}
