package com.roh.challenge;

public class ValidateBinarySearchTree {

	public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        return returnValues(root).isValid;
    }
    
    public Values returnValues(TreeNode root)
    {
        Values values = new Values();
        values.max = root.val;
        values.min = root.val;
        values.isValid = false;
            
            
        if(root.left != null)
        {
            Values _value = returnValues(root.left);
            if (_value.max >= values.min || !_value.isValid ){
                return values;
            } 
            values.min = _value.min;
        } 
        
        if(root.right != null)
        {
            Values _value = returnValues(root.right);
            if (_value.min <= values.max || !_value.isValid) {
                return values;
            }
            values.max = _value.max;
        }
        
        values.isValid = true;
        return values;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Values
{
    int max;
    int min;
    boolean isValid;
}

class TreeNode {
	 int val;
	 TreeNode left;
	 TreeNode right;
	 TreeNode(int x) { val = x; }
}
