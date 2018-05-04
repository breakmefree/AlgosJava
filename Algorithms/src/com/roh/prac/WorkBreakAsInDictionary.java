package com.roh.prac;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a string
 * 
 * @author knidhi
 *
 */
public class WorkBreakAsInDictionary {
	
	private static Set<String> dictionary = new HashSet<>();
	
	public static void wordSplit(String str, List<String> wordList)
	{
		if(str == null || str.length() == 0)
			return;
		
		for(int i=0; i<str.length(); i++)
		{
			String prefix = str.substring(0, i+1);
			if(dictionary.contains(prefix))
			{
				wordList.add(str.substring(0, i+1));
				wordSplit(str.substring(i+1),  wordList);
			}
		}
	}

	public static void main(String[] args) {
		// "mobile","samsung","sam","sung",
        // "man","mango", "icecream","and",
        // "go","i","love","ice","cream"
		dictionary.add("mobile");
		dictionary.add("samsung");
		dictionary.add("sam");
		dictionary.add("sung");
		dictionary.add("man");
		dictionary.add("mango");
		dictionary.add("icecream");
		dictionary.add("and");
		dictionary.add("go");
		dictionary.add("i");
		dictionary.add("love");
		dictionary.add("ice");
		dictionary.add("cream");
		dictionary.add("am");
		dictionary.add("wonder");
		dictionary.add("ful");
		dictionary.add("wonderful");

		List<String> wordList = new ArrayList<>();
		String str = "iamwonderful";
		wordSplit(str, wordList);
		System.out.println(wordList);

	}

}
