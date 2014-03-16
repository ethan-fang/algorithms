package tree;

import java.util.ArrayList;
import java.util.Stack;

public class TreePostOrder {

	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		if (root == null)
			return null;
		ArrayList<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();

		TreeNode current = null;
		TreeNode previous = null;
		stack.push(root);
		while (!stack.isEmpty()) {
			current = stack.peek();
			if (current == null) {
				stack.pop();
			} else if (current.left == null && current.right == null) {
				list.add(current.val);
				stack.pop();
			} else if (current.left == previous) {
				stack.push(current.right);
			} else if (current.right == previous) {
				list.add(current.val);
				stack.pop();
			} else {
				stack.push(current.left);
			}
			previous = current;
		}
		return list;
	}

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
