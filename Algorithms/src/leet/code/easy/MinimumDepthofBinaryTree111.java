package leet.code.easy;

import java.util.ArrayList;
import java.util.List;

public class MinimumDepthofBinaryTree111 {
	
	public static int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        if(root.left == null) 
            return minDepth(root.right) + 1;
        if(root.right == null) 
            return minDepth(root.left) + 1;
        
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
	
	public static List<List<Integer>> generate(int numRows)
	{
		List<List<Integer>> allrows = new ArrayList<List<Integer>>();
		ArrayList<Integer> row = new ArrayList<Integer>();
		for(int i=0;i<numRows;i++)
		{
			row.add(0, 1);
			for(int j=1;j<row.size()-1;j++)
				row.set(j, row.get(j)+row.get(j+1));
			allrows.add(new ArrayList<Integer>(row));
		}
		return allrows;
		
	}

	public static void main(String[] args) {
		System.out.println(generate(0));
		System.out.println(generate(1));
		System.out.println(generate(2));
		System.out.println(generate(3));
		System.out.println(generate(4));
		System.out.println(generate(5));
		System.out.println(generate(6));

		
		//TreeNode node = new TreeNode(1);
		//node.left = new TreeNode(2);
		//System.out.println(minDepth(node));
	}

}
