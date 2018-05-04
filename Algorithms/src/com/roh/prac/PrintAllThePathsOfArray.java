package com.roh.prac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import leet.code.easy.TreeNode;

public class PrintAllThePathsOfArray {
	
	public static List<List<Integer>> printAllPathsOfaTree(TreeNode head)
	{
		List<List<Integer>> paths = new ArrayList<>();
		if(head == null) return paths;
		if(head.left == null && head.right == null) {
			List<Integer> num = new ArrayList<>();
			num.add(head.val);
			paths.add(num);
			return paths;
		}
		List<List<Integer>> left = printAllPathsOfaTree(head.left);
		List<List<Integer>> right = printAllPathsOfaTree(head.right);
		
		for(int i = 0; i < left.size(); i++) {
			if(left.get(i).size() >0) {
				left.get(i).add(0, head.val);
			}
		}
		
		for(int i = 0; i < right.size(); i++) {
			if(right.get(i).size() >0) {
				right.get(i).add(0, head.val);
			}
		}
		paths.addAll(left);
		paths.addAll(right);
		return paths;
	}
	

	public static void main(String[] args) {
		
		int[][] arr = new int[][] {{1,2,3}, {1,2}};
		List<Integer> a = new ArrayList<>();
		for(int i =0; i<arr.length; i++) {
			for(int j =0; j < arr[i].length; j++) {
				a.add(arr[i][j]);
			}
		}
		System.out.println(a);
		
		//TreeNode tree = new TreeNode(0);
		//tree.left = new TreeNode(1);
		//System.out.println(printAllPathsOfaTree(tree));
	}

}
