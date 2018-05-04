package com.coding.webnair.assign6;
/**
 * Find kth largest element in a BST
 * 
 * @author Kshama Nidhi
 *
 */
public class ElementInBST {
	private static int i=0;

	public static void main(String[] args) {
		Node root = new Node(20);          //        20
        root.left = new Node(8);           //     8       22
        root.right = new Node(22);         //  4    12
        root.left.left = new Node(4);      //     10  14
        root.left.right = new Node(12);    //            15
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        root.left.right.right.right = new Node(15);

        inorder(root, 7);
	}
	
	private static void inorder(Node root, int k)
	{
		if(root == null)
			return;
		inorder(root.left, k);
		i++;
		if(i==k)
		{
			System.out.println(k + "th largest element is " + root.data);
			return;
		}
		inorder(root.right, k);
	}

}
