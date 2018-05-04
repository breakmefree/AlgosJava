package com.roh.prac;

import java.util.LinkedList;
import java.util.Queue;

public class PrintTreeNodes
{
	public static void nodeTraversal(Tree head)
	{
		if(head == null) return;

		Tree curr = head;
		Queue<Tree> nodesQueue = new LinkedList<Tree>();
		nodesQueue.add(curr);
		while(nodesQueue != null)
		{
			curr = nodesQueue.poll();
			if(curr != null)
			{
				System.out.println(curr.data);
				if(curr.left != null)
					nodesQueue.add(curr.left);
				if(curr.right != null)
					nodesQueue.add(curr.right);
			}

		}
		
	}

	public static void main(String[] args)
	{ 
		//         0
		//       1    2
		//   3   4    5   6   
		Tree head = new Tree(0);
		head.left = new Tree(1);
		head.right = new Tree(2);
		
		head.left.left = new Tree(3);
		head.left.right = new Tree(4);
		head.right.left = new Tree(5);
		head.right.right = new Tree(6);
		
		nodeTraversal(head);
	}

}

class Tree
{
	int data;
	Tree left;
	Tree right;
	public Tree (int data)
	{
		this.data = data;
		this.left = null;
		this.right = null;
	}
}