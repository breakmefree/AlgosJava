package com.roh.prac;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TreeTraversalzigzag {
	
	public List<TreeNode> zigzagTreetraversal(TreeNode head) {
		if(head == null) return null;
		boolean left = true;
		Queue<TreeNode> lefty = new LinkedList<>();
		Stack<TreeNode> righty = new Stack<>();
		righty.add(head);
		List<TreeNode> nodes = new ArrayList<>();
		while (lefty.size() >0 || righty.size() > 0) {
			left = readChildNodes(left, lefty, righty, nodes);
		}
		
		return nodes;
	}
	
	public boolean readChildNodes(boolean left, Queue<TreeNode> lefty, Stack<TreeNode> righty, List<TreeNode> nodes)
	{
		Queue<TreeNode> leftChilds = new LinkedList<>();
		Stack<TreeNode> rightChilds = new Stack<>();
		if(left) {
			while(righty != null && !righty.empty()) {
				TreeNode tn = righty.pop();
				nodes.add(tn);
				if(tn.left != null) leftChilds.offer(tn.left);
				if(tn.right != null) leftChilds.offer(tn.right);
			}
			lefty = leftChilds;
			left = false;
		} else {
			while(lefty != null && lefty.peek() != null) {
				TreeNode tn = lefty.poll();
				nodes.add(tn);
				if(tn.left != null) rightChilds.push(tn.left);
				if(tn.right != null) rightChilds.push(tn.right);
			}
			righty = rightChilds;
			left = true;
		}
		return left;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
