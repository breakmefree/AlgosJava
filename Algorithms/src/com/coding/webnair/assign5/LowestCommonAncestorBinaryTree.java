package com.coding.webnair.assign5;

/**
 * Lowest common ancestor(LCA) in a binary tree
 * 
 * @author Kshama Nidhi
 *
 */
public class LowestCommonAncestorBinaryTree {

	public static void main(String[] args) {
		Node root = new Node(20);          //        20
        root.left = new Node(8);           //     8       22
        root.right = new Node(22);         //  4    12
        root.left.left = new Node(4);      //     10  14
        root.left.right = new Node(12);    //            15
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        root.left.right.right.right = new Node(15);
        System.out.println("Expected - 20 : " + findLowestCommonAncestor(root, 10, 22).data);
        System.out.println("Expected - 20 : " + findLowestCommonAncestor(root, 8, 14).data);
        System.out.println("Expected - 12 : " + findLowestCommonAncestor(root, 10, 14).data);
        System.out.println("Expected - null : " + findLowestCommonAncestor(root, 4, 20));
        System.out.println("Expected - 12 : " + findLowestCommonAncestor(root, 14, 15).data);

	}
	
	public static Node findLowestCommonAncestor(Node root, int n1, int n2)
	{
		if(root == null)
		{
			return null;
		}
		
		if(n1 < root.data && n2 < root.data)
		{
			root.left.parent = root;
			return findLowestCommonAncestor(root.left, n1, n2);
		}
		
		if(n1 > root.data && n2 > root.data)
		{	root.right.parent = root;
			return findLowestCommonAncestor(root.right, n1, n2);
		}
		if(n1 == root.data || n2 == root.data)
		{
			return root.parent;
		}
		return root;
	}

}
