package com.coding.webnair.assign5;

public class Node
{
	int data;
	Node left;
	Node right;
	Node parent;
	
	public Node(int data)
	{
		this.data = data;
		left = right = parent = null;
	}
}
