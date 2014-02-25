package tree;

import java.util.Stack;

class TreeTraversal {

	private static class BinaryTree {
		int value;
		BinaryTree left;
		BinaryTree right;

		public BinaryTree(int k) {
			value = k;
		}

		// now start defining the key post-order traversal method using Stack!
		// firstly we need using stack so better import stack!
		public void postOrderWithoutRecursive() {
			// as we discussed in slides, we need two support data
			// structure/varialbes
			// 1. a stack to store the pointers of each traversed tree node
			// 2. a previous tree node pointer to know where we were
			Stack<BinaryTree> treeNodes = new Stack<BinaryTree>();

			// Set as an arbitrary dummy tree node other than null, so it won't
			// be stuck with the problem that if root
			// has no right child, the code stops immediately
			BinaryTree previous = new BinaryTree(1000);

			// firstly, we add the current root to stack for processing
			treeNodes.push(this);
			// now define the key loop
			while (!treeNodes.isEmpty()) {
				BinaryTree current = treeNodes.peek();
				// firstly make sure it is not a null
				if (current == null)
					treeNodes.pop();
				// now check if it is leaf node to be printed
				else if (current.left == null && current.right == null) {
					// always check the current's left/child not the class scope
					// ones!
					System.out.print(current.value);
					treeNodes.pop();// need to pop it whenever we print it out
				}
				// it is always associated to the pointer not the value in the
				// class scope
				// 3rd, check if previous pointer is our left child, if so, we
				// need push right child for processing
				else if (current.left == previous)
					treeNodes.push(current.right);
				// 4th, if previous pointer is current pointer's right child,
				// print itself!
				else if (current.right == previous) {
					System.out.print(current.value);
					treeNodes.pop();
				}
				// otherwise, push the left child for processing!
				else
					treeNodes.push(current.left);

				// almost forgot to update the previous pointer
				previous = current;
			}
		}

		// firstly, write a normal post-order traversal for verification
		public void postOrderRecursive() {
			if (left != null)
				left.postOrderRecursive();
			if (right != null)
				right.postOrderRecursive();
			if (this != null)
				System.out.print(value);
		}

		public boolean isLeaf() {
			return this.left == null && this.right == null;
		}

		public void preOrderImplementation() {
			Stack<BinaryTree> treeNodes = new Stack<BinaryTree>();
			BinaryTree previous = null;
			treeNodes.add(this);

			while (!treeNodes.isEmpty()) {
				BinaryTree current = treeNodes.peek();

				
				if (current == null) {
					current = treeNodes.pop();
				} else if (current.isLeaf()) {
					System.out.println(current.value + " ");
					treeNodes.pop();
				} else if (previous == current.left) {
					treeNodes.push(current.right);
				} else if (previous == current.right) {
					System.out.println(current.value + " ");
					treeNodes.pop();
				} else {
					treeNodes.push(current.left);
				}

				previous = current;
			}
		}
	}

	public static void main(String[] args) {
		// now create a test case
		// 1
		// 2 3
		// 4 5 6 7
		BinaryTree myTree = new BinaryTree(1);
		myTree.left = new BinaryTree(2);
		myTree.right = new BinaryTree(3);
		myTree.left.left = new BinaryTree(4);
		myTree.left.right = new BinaryTree(5);
		myTree.right.left = new BinaryTree(6);
		 myTree.right.right = new BinaryTree(7);//now post-order expects:
		// 452631
		System.out.println("Post order using recursion: ");
		myTree.postOrderRecursive();

		System.out.println("\nPost order WIHTOUT recursion: ");
		myTree.postOrderWithoutRecursive();
	}
}

/**
 * Please watch at http://www.youtube.com/user/ProgrammingInterview Contact:
 * haimenboy@gmail.com
 * 
 * Step by step to crack programming interview questions. 1. All questions were
 * searched publicly from Google, Glassdoor, Careercup and StackOverflow. 2. All
 * codes were written from scratch and links to download the source files are
 * provided in each video's description. All examples were written in java, and
 * tools I have used include Editplus, Eclipse and IntelliJ. 3. All videos were
 * made without using any non-authorized material. All videos are silent sorry.
 * Text comment is provided during coding as additional explanations. Thank you
 * very much.
 */
