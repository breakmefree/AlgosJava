package leet.code.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Find the longest common prefix string amongst an array of strings.
 * 
 * @author knidhi
 *
 */
public class LongestCommonPrefix {
	
	public static String longestCommonPrefix(String[] strs) {
		String prefix = "";
		if(strs.length < 1)
		{
			return prefix;
		}
		prefix = strs[0];
		int preLen = prefix.length();
		for(String string : strs)
		{
			int strLen = string.length();
			if(!string.startsWith(prefix))
			{
				int size = (strLen > preLen) ? preLen : strLen;
				String temp = "";
				for(int i=0; i<size; i++)
				{
					if(prefix.charAt(i) == string.charAt(i))
					{
						temp += prefix.charAt(i);
					}
					else
					{
						break;
					}
				}
				prefix = temp;
				preLen = prefix.length();
			}
		}
		return prefix;
	}
	
	public static String longCommonPrefix(String[] strs) {
		if(strs == null || strs[0] == null)
			return null;
		if(strs.length == 0) {
			return "";
		}
		
		int i = 0;
		while(i < strs[0].length())
		{
			for(int j=1; j < strs.length; j++)
			{
				if(strs[j] == null) return null;
				if(strs[j].length() <= i || strs[j].charAt(i) != strs[0].charAt(i))
				{
					return strs[0].substring(0, i);
				}
			}
			i++;
		}
		return strs[0].substring(0, i);
	}

	public static void main(String[] args)
	{
		String[] strs = new String[] {"", "trise", "triangle", ""};
		System.out.println("---" + longCommonPrefix(strs));
		Set<Integer> set = new HashSet<>();
	}

}
