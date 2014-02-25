package tree;

public class VerifyBST {
	//now we create a test case
	public static void main(String[] args)
	{
		//let's construct a simple tree
		//   4
		// 2   6
		//1 3 5 7
		Tree myTree = new Tree(4);
		myTree.left = new Tree(2);
		myTree.right = new Tree(6);
		myTree.left.left = new Tree(1);
		myTree.left.right = new Tree(3);
		myTree.right.left = new Tree(7);//now we test a false case
		myTree.right.right = new Tree(7);//made a typo sorry
		
		//so this should be a binary search tree!
		//please notice when we call the method from main block, we define the range as all possible integer values!
		System.out.println("My tree is BST? "+IfBST(myTree, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}
	
	
	
	//now we start implement the BST verify method
	//define method header
	//Notice, the key of our algorithm is to keep track of the reasonable range for current focus node and its sub-trees
	//So we need small and large as two range index values
	public static boolean IfBST(Tree a, int small, int large)
	{
		//firstly, check if Tree is a valid tree node or null
		if(a==null)
			return true;//if no elements we return true
		//now check if the current tree node is within (small, large
		if(a.value>small && a.value<large)
		{
			//The following code could be simplified!
			return IfBST(a.left, small, a.value)&&IfBST(a.right, a.value, large);
		}
		else
			return false;//as the current node finds inappropriate node, return false immediately
	}
}

//firstly. we create a tree class for testing
class Tree {
	public int value;
	public Tree left;
	public Tree right;
	public Tree(int a)
	{
		value = a;
		left=right=null;
	}
}
