import java.util.ArrayList;
import java.util.List;

public class DeleteFromTree {


	
	public static void main(String[] args) {
		Node a = new Node(2, new Node(1, null, null), new Node(7,
				new Node(4, new Node(3, null, null), new Node(6, new Node(5, null,
						null), null)), new Node(8, null, null)));
		
		System.out.println("a is " + a);
		
		newRoot = a;
		boolean success = deleteNode(a, 2);
		
		if (success) {
			System.out.println("new node " + newRoot);
		} else {
			System.out.println("Can not delete");
		}
	}
	
	public static Node parent = null;
	public static Node newRoot = null;
	public static List<Node> bag = new ArrayList<Node>();
	
	public static boolean deleteNode(Node node, int value) {
		if (node == null) return false;
		if (node.value == value) {
			if (node.left == null && node.right == null) {
				if (parent != null) {
					if (parent.left == node) {
						parent.left = null;
					} else {
						parent.right = null;
					}
				}
			} else if (node.left == null) {
				if (parent != null) {
					if (parent.left == node) {
						parent.left = node.right;
					} else {
						parent.right = node.right;
					}
				}
			} else if (node.right == null) {
				if (parent != null) {
					if (parent.left == node) {
						parent.left = node.left;
					} else {
						parent.right = node.left;
					}
				}
			} else {
				Node smallestNodeParent = node;
				Node smallestNode = node.right;
				while (smallestNode.left != null) {
					smallestNodeParent = smallestNode;
					smallestNode = smallestNode.left;
				}
				if (smallestNodeParent.left == smallestNode) {
					smallestNodeParent.left = smallestNode.right;
				} else {
					smallestNodeParent.right = smallestNode.right;
				}
				
				if (parent != null) {
					if (parent.left == node) {
						parent.left = smallestNode;
					} else {
						parent.right = smallestNode;
					}
				}
				smallestNode.left = node.left;
				smallestNode.right = node.right;
				if (node == newRoot) {
					newRoot = smallestNode;
				}
			}
			return true;
		} else if (value < node.value) {
			parent = node;
			return deleteNode(node.left, value);
		} else {
			parent = node;
			return deleteNode(node.right, value);
		}
	}
}

class Node {
	public int value;
	public Node left;
	public Node right;
	
	public Node(int value, Node left, Node right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		return "(" + (this.left != null ? this.left.toString() : "*") + " "
				+ this.value + " " + (this.right != null ? this.right.toString()
				: "*") + ")";
	}
}
