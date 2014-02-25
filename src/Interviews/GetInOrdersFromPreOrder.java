package Interviews;

import java.util.ArrayList;
import java.util.List;

public class GetInOrdersFromPreOrder {
	
	public static void main(String[] args) {
		//now we test our code, we know from our slides that {1,2,3} preset
		//has in total 5 different BTs thus have 5 different in-order ways!
		int[] testPreOrder = {1,2,3};
		List<BinaryTree> testResults =
				inOrderFromPreOrder(testPreOrder, 0, testPreOrder.length - 1);
		for(BinaryTree eachFormedBt: testResults)
			eachFormedBt.PrintInOrder();
	}

	public static List<BinaryTree> inOrderFromPreOrder(int[] preorder,
			int start, int end) {
		List<BinaryTree> returnTrees = new ArrayList<BinaryTree>();
		if (start > end) {
			returnTrees.add(null);
			return returnTrees;
		}
		if (start == end) {
			returnTrees.add(new BinaryTree(preorder[start]));
			return returnTrees;
		}

		for (int i = start; i <= end; i++) {
			List<BinaryTree> left = inOrderFromPreOrder(preorder,
					start + 1, i);
			List<BinaryTree> right = inOrderFromPreOrder(preorder,
					i + 1, end);
			
			for (BinaryTree eachLeft : left) {
				for (BinaryTree eachRight : right) {
					BinaryTree tempRoot = new BinaryTree(preorder[start]);//everytime we make a copy of root
					tempRoot.left = eachLeft;
					tempRoot.right = eachRight;
					returnTrees.add(tempRoot);
				}
			}
		}
		return returnTrees;
	}

	private static class BinaryTree {
		int value;
		BinaryTree left;
		BinaryTree right;

		public BinaryTree(int k) {
			value = k;
		}
		
		public void PrintInOrder() {
			inOrderTraversal(this);
			System.out.println();//add a new line for formatting
		}
		private void inOrderTraversal(BinaryTree root) {
			if(root==null) return;
			inOrderTraversal(root.left);
			System.out.print(root.value);
			inOrderTraversal(root.right);
		}
	}
}
