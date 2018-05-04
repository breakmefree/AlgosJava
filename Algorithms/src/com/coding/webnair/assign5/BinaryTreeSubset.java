package com.coding.webnair.assign5;

/**
 * Find if a binary tree is a subset of another
 * 
 * @author Kshama Nidhi
 *
 */
public class BinaryTreeSubset {

	public static void main(String[] args) {
		Node root = new Node(20);          //        20
        root.left = new Node(8);           //     8       22
        root.right = new Node(22);         //  4    12
        root.left.left = new Node(4);      //     10  14
        root.left.right = new Node(12);    //            15
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        root.left.right.right.right = new Node(15);
        
        Node subset = new Node(20);
        subset.left = new Node(8);
        subset.left = new Node(21);
        System.out.println("Expected - true : " + isBSTSubset(root, root.left.left));
        System.out.println();
        System.out.println("Expected - false : " + isBSTSubset(root, subset));
        System.out.println();
        System.out.println("Expected - true : " + isBSTSubset(root, root.left.right));
}
	
	public static boolean isBSTSubset(Node root, Node subset)
	{
		if(root == null) return false;
		if(subset == null) return true;
		
		if(subset.data > root.data)
		{
			return isBSTSubset(root.right, subset);
		}
		else if(subset.data < root.data)
		{
			return isBSTSubset(root.left, subset);
		}
		if(root.data == subset.data)
		{
			return isBSTIdential(root, subset);
		}
		
		return false;
	}
	
	public static boolean isBSTIdential(Node tree1, Node tree2)
	{
		if(tree1 == null && tree2 == null)
			return true;
		
		if(tree1 == null || tree2 == null)
			return false;
		
		return (tree1.data == tree2.data
				&& isBSTIdential(tree1.left, tree2.left)
				&& isBSTIdential(tree1.right, tree2.right));
	}

}
