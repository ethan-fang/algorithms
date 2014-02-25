package Interviews;

public class SubTreeBinaryTreeJudging33 {

	//create a test case
		public static void main(String[] args)
		{
			//let's create a parent tree of 
			//   1
			// 2  3
			//   4 5
			BinaryTree t1 = new BinaryTree(1);
			t1.left =  new BinaryTree(2); t1.right =  new BinaryTree(3);
			t1.right.left =  new BinaryTree(4);t1.right.right =  new BinaryTree(5);

			//we create a subtree
			// 3
			//4 6
			BinaryTree t2 = new BinaryTree(3);
			t2.left =  new BinaryTree(4); t2.right =  new BinaryTree(6);

			//test for equal from reference view
			if(ifSubTreeRef(t1, t1.left.right))//this time should be sub-tree
				System.out.println("T2 is a sub-tree of t1 (Reference)");
			else
				System.out.println("T2 is NOT a sub-tree of t1 (Reference)");

			//test for equal from value view
			if(ifSubTreeValue(t1, t2))//expect false now
				System.out.println("T2 is a sub-tree of t1 (Value)");
			else
				System.out.println("T2 is NOT a sub-tree of t1 (Value)");
		}
		
		private static boolean ifSubTreeValue(BinaryTree t1, BinaryTree t2) {
			if (t2 == null)
				return true;
			if (t1 == null)
				return false;
			if(t1.value==t2.value)
			{
				//then we need check if both t1 and t2's subtree are same
				if(ifSubTreeValue(t1.left, t2.left) && ifSubTreeValue(t1.right, t2.right))
					return true;//we found one if roots are same are all children trees are same
			}
			//other wise, we need go to the t1's left or right sub-tree to continue the equality finding
			return ifSubTreeValue(t1.left, t2) || ifSubTreeValue(t1.right, t2);//notice it is OR not AND
	}

		private static boolean ifSubTreeRef(BinaryTree t1, BinaryTree t2) {
			if (t2 == null)
				return true;
			if (t1 == null)
				return false;
			return t1 == t2 || ifSubTreeRef(t1.left, t2) || ifSubTreeRef(t1.right, t2);
		}

		//we firstly define a binary tree class
		private static class BinaryTree
		{
			int value;
			BinaryTree left;
			BinaryTree right;
			public BinaryTree(int k)
			{
				value = k;
			}
		}
}
