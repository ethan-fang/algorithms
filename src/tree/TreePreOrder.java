package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreePreOrder {

	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (root == null)
			return list;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode topNode = stack.pop();
			if (topNode != null) {
				list.add(topNode.val);
				stack.push(topNode.right);
				stack.push(topNode.left);
			}
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
