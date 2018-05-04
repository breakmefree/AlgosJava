package com.coding.webnair.assign8;

import java.util.HashMap;

/**
 * This class will be used as nodes for Trie data structure.
 * Trie is a n-ary Tree.
 * 
 * @author Kshama Nidhi
 *
 */
public class TreeNode 
{
	private char data;
    private HashMap<Character,TreeNode> children;
    private boolean isEnd;
    
    public TreeNode(Character data) 
    {
    		this.data = data;
        this.children = new HashMap<>();
        this.isEnd = false;
    }

	public boolean isEnd()
	{
		return isEnd;
	}

	public void setEnd(boolean isEnd)
	{
		this.isEnd = isEnd;
	}

	public char getData()
	{
		return data;
	}

	public HashMap<Character, TreeNode> getChildren()
	{
		return children;
	}
    
}
