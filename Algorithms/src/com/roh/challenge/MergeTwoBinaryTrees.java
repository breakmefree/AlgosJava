package com.roh.challenge;

/**
 * Given two binary trees and imagine that when you put one of them to cover the other, 
 * some nodes of the two trees are overlapped while the others are not.
 * 
 * You need to merge them into a new binary tree. 
 * The merge rule is that if two nodes overlap, 
 * then sum node values up as the new value of the merged node. 
 * Otherwise, the NOT null node will be used as the node of new tree.
 * 
 * @author knidhi
 *
 */
public class MergeTwoBinaryTrees {
	
	public static Node mergeTrees(Node t1, Node t2)	{
		if(t1 == null && t2 == null)
            return null;

        if(t1 == null) {
            return t2;
        } else if(t2 == null) {
           return t1;
        } else {
        		Node root = new Node(t1.val + t2.val);
            root.left = mergeTrees(t1.left, t2.left);
            root.right = mergeTrees(t1.right, t2.right);
            return root;
		}
		
	}

	public static void main(String[] args) {
		Node tree = new Node();
		Node t1 = new Node();
		Node t2 = new Node();
		Node root = mergeTrees(t1, t2);

	}

}

class Node
{
	Node left;
	Node right;
	int val;
	public Node()
	{
		
	}
	
	public Node(int n)
	{
		this.val = n;
	}
}
