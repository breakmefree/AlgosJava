package com.coding.webnair.assign5;

/**
 * Print all nodes in a binary tree who don’t have siblings
 * 
 * @author Kshama Nidhi
 *
 */
public class BinaryTreeNodes
{

	public static void main(String[] args)
	{
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		
		head.left.right = new Node(4);
		head.right.left = new Node(5);
		
		head.left.right.left = new Node(6);
		head.left.right.right = new Node(7);
		head.right.left.left = new Node(8);
		printNoSiblingsNode(head);

	}
	
	public static void printNoSiblingsNode(Node head)
	{
		if(head == null)
		{
			return;
		}
		if(head.left != null && head.right !=  null)
		{
			printNoSiblingsNode(head.left);
			printNoSiblingsNode(head.right);
		}
		else if(head.left != null)
		{
			System.out.println("print :" + head.left.data);
			printNoSiblingsNode(head.left);
		}
		else if(head.right != null)
		{
			System.out.println("print :" + head.right.data);
			printNoSiblingsNode(head.right);
		}
	}

}