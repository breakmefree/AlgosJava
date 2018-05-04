package com.coding.webnair.assign8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given a dictionary of words, and a given prefix, 
 * return all matching words from the dictionary starting with the prefix:
 * For example the dictionary is:
 * Character, charter, chart, characteristics, chat, chatterbot, chow, cat, caterpillar, carrot
 * 
 * For example:
 * prefix is ch -> character, charter, chat, characteristics, chat, chatterbot, chow
 * prefix is char -> character, charter, chart, characteristics
 * 
 * Think about this problem. Atleast to pseudo code level send me a solution.
 * 
 * @author Kshama Nidhi
 *
 */
public class Dictionary {
	private TreeNode root = new TreeNode('0');
	
	public void insert(String str)
	{
		TreeNode current = root;
		int len = str.length();
		for(int i = 0; i < len; i++)
		{
			if(current.getChildren().containsKey(str.charAt(i)))
			{
				current = current.getChildren().get(str.charAt(i));
			}
			else
			{
				TreeNode tNode = new TreeNode(str.charAt(i));
				current.getChildren().put(str.charAt(i), tNode);
				current =  tNode;
			}
		}
		current.setEnd(true);
	}
	
	public List<String> autoComplete(String prefix)
	{
		List<String> autoCompWords = new ArrayList<>();
		TreeNode current = root;
		int len = prefix.length();
		for(int i = 0; i < len; i++)
		{
			if(current.getChildren().containsKey(prefix.charAt(i)))
			{
				current = current.getChildren().get(prefix.charAt(i));
				if(i == len -1 && current.isEnd())
				{
					autoCompWords.add(prefix);
				}
			}
			else
			{
				// What if prefix not match.
				return null;
			}
		}
		
		
		
		HashMap<Character, TreeNode> childrens = current.getChildren();
		
		for(TreeNode child : childrens.values())
		{
			fetchAllWords(child, autoCompWords, prefix);
		}
		
		return autoCompWords;
	}
	
	public void fetchAllWords(TreeNode root, List<String> autoCompWords, String prefix)
	{
		if(root == null)
		{
			return;
		}
		String word = prefix + root.getData();
		if(root.isEnd())
		{
			autoCompWords.add(word);
		}
		for(TreeNode child : root.getChildren().values())
		{
			fetchAllWords(child, autoCompWords, word);
		}
	}

	public static void main(String[] args) {
		Dictionary trie = new Dictionary();
		trie.insert("character");
		trie.insert("charter");
		trie.insert("chart");
		trie.insert("characteristics");
		trie.insert("chat");
		trie.insert("chatterbot");
		trie.insert("chow");
		trie.insert("cat");
		trie.insert("caterpillar");
		trie.insert("carrot");
				
		List<String> autoCompWords = trie.autoComplete("ca");
		System.out.println(autoCompWords);
		autoCompWords = trie.autoComplete("cha");
		System.out.println(autoCompWords);
		autoCompWords = trie.autoComplete("char");
		System.out.println(autoCompWords);
		autoCompWords = trie.autoComplete("a");
		System.out.println(autoCompWords);
		autoCompWords = trie.autoComplete("c");
		System.out.println(autoCompWords);
		
	}

}
