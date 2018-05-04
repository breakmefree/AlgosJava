package com.roh.prac;

public class InorderTraversal {
	public void inorderTraversal(Node1 node)
	{
		if(node.left == null)
			return;
		inorderTraversal(node.left);
		System.out.println(node.i);
		inorderTraversal(node.right);
		
	}
	
	public boolean mirrorImage(Node1 root1, Node1 root2)
	{
		if(root1.left == null ^ root2.right == null)
			return false;
		
		if(root1.left == null)
			return true;
		
		if(mirrorImage(root1.left, root2.right))
			return mirrorImage(root1.right, root2.left);
		
		return true;

	}
	

	public static void main(String[] args) {

	}

}

class Node1
{
	int i;
	Node1 left;
	Node1 right;
}
