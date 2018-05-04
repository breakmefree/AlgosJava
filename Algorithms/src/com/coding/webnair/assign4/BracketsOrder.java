package com.coding.webnair.assign4;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given a string containing just the characters ‘(‘, ‘)’, ‘{‘, ‘}’, ‘[' and ']‘, 
 * determine if the input string is valid. The brackets must close in the correct 
 * order, “()” and “()[]{}” are all valid but “(]” and “([)]” are not.
 * 
 * @author Kshama Nidhi
 */
public class BracketsOrder
{

	public static void main(String[] args)
	{
		System.out.println("FALSE - " + checkValidBracketOrder("["));
		System.out.println("FALSE - " + checkValidBracketOrder("[["));
		System.out.println("FALSE - " + checkValidBracketOrder("[}"));
		System.out.println("FALSE - " + checkValidBracketOrder("([)]"));
		System.out.println("TRUE - " + checkValidBracketOrder("[([]){}]"));
		
		System.out.println("TRUE - " + checkValidBracketOrder(null));
		System.out.println("TRUE - " + checkValidBracketOrder(""));
		System.out.println("TRUE - " + checkValidBracketOrder("()"));
		System.out.println("TRUE - " + checkValidBracketOrder("()[]{}"));
		//System.out.println("TRUE - " + checkValidBracketOrder("(12[0]11) 11({5})]11"));
	}
	
	public static boolean checkValidBracketOrder(String brackets)
	{
		System.out.print("String: "+ brackets + " :-- ");
		if(brackets == null || brackets.isEmpty())
			return true;
		if(brackets.length() %2 !=0)
            return false;
		
		Stack<Character> stack = new Stack<>();
		int length = brackets.length();
		Map<Character, Character> pairs = new HashMap<>();
		pairs.put('}', '{');
		pairs.put(')', '(');
		pairs.put(']', '[');
		
		for(int i=0; i< length; i++)
		{
			if(brackets.charAt(i) == ']' || brackets.charAt(i) == ')' || brackets.charAt(i) == '}')
			{
				if(stack.isEmpty()) 
					return false;
				if(stack.pop() != pairs.get(brackets.charAt(i)))
				{
					return false;
				}
			}
			else
			{
				stack.push(brackets.charAt(i));
			}
		}
		if(!stack.isEmpty())
			return false;
		return true;
	}

}
