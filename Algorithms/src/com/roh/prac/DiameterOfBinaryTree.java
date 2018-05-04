package com.roh.prac;

public class DiameterOfBinaryTree {
	public int height(TreeNode node)
	{
		if(node == null)
		{
			return 0;
		}
		
		return Math.max(height(node.left), height(node.right)) + 1;
	}
	
	public int diameter(TreeNode node) {
		if(node == null) {
			return 0;
		}
		
		int lefth = height(node.left);
		int righth = height(node.right);
		
		int ldia = diameter(node.left);
		int rdia = diameter(node.right);
		
		return Math.max(lefth + righth + 1, Math.max(ldia, rdia));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
