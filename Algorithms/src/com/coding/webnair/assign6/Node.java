package com.coding.webnair.assign6;

public class Node implements Comparable<Node>
{
	int data;
	Node left;
	Node right;
	
	public Node(int data)
	{
		this.data = data;
		left = right = null;
	}
	
	@Override
	public int compareTo(Node node)
	{
		return this.data - node.data;
		
	}
}
