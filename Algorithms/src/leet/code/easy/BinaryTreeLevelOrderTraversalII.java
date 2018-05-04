package leet.code.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeLevelOrderTraversalII {
    public static List<List<Integer>> levelOrderBottom(TreeNode root)
    {
    		if(root == null)
    			return null;
        Stack<List<Integer>> st = new Stack<List<Integer>>();
        Stack<List<TreeNode>> stTN = new Stack<List<TreeNode>>();
        List<Integer> list = new ArrayList<Integer>();
        list.add(root.val);
        st.push(list);
        
        List<TreeNode> listTN = new ArrayList<TreeNode>();
        listTN.add(root);
        stTN.push(listTN);
        
        levelOrderBottom(st, stTN);
        List<List<Integer>> res = new ArrayList<List<Integer>>(); 
        while(!st.isEmpty())
        {
            res.add(st.pop());
        }
        return res;
    }
    
    public static void levelOrderBottom(Stack<List<Integer>> st, Stack<List<TreeNode>> stTN)
    {
        if(stTN.empty() || stTN.peek() == null)
            return;
        List<TreeNode> listTN = stTN.pop();
        List<Integer> list = new ArrayList<Integer>();
        List<TreeNode> listChildNodes = new ArrayList<TreeNode>();
        for(int i=0; i < listTN.size(); i++)
        {
            if(listTN.get(i).left != null)
            {
                list.add(listTN.get(i).left.val);
                listChildNodes.add(listTN.get(i).left);
            }
            
            if(listTN.get(i).right != null)
            {
                list.add(listTN.get(i).right.val);
                listChildNodes.add(listTN.get(i).right);
            }
        }
        if(list.size() > 0 && listChildNodes.size() > 0) {
        		st.push(list);
        		stTN.push(listChildNodes);
        }
        
        levelOrderBottom(st, stTN);
    }
	public static void main(String[] args) {
		TreeNode head = new TreeNode(3);
		head.left = new TreeNode(9);
		head.right = new TreeNode(20);
		
		head.right.left = new TreeNode(15);
		head.right.right = new TreeNode(7);
		
		levelOrderBottom(head);
		
	}

}
