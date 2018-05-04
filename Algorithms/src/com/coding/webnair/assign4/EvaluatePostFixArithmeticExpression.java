package com.coding.webnair.assign4;

import java.util.Stack;

/**
 * Evaluate post-fix arithmetic expression: 
 * Assume, for example this is the input array 
 * {"5", "1", "2", "+", "4", "*", "+", "3", "-"}, 
 * the output should be an integer which is evaluating the expression.
 * 
 * @author Kshama Nidhi
 */
public class EvaluatePostFixArithmeticExpression {

	public static void main(String[] args) {
		String[] aExpr = {"5", "1", "2", "+", "4", "*", "+", "3", "-"};
		System.out.println("evaluatePostFixAE: " + evaluatePostFixAE(aExpr));
		String[] aExpr1 = {"5", "1", "2", "+", "4", "*", "+", "3", "-", "2", "+"};
		System.out.println("evaluatePostFixAE: " + evaluatePostFixAE(aExpr1));
	}
	
	public static int evaluatePostFixAE(String[] aExpr)
	{
		if(aExpr == null)
		{
			return -1;
		}
		Stack<String> elements = new Stack<>();
		for(String str : aExpr)
		{
			if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/") || str.equals("^"))
			{
				int a = Integer.parseInt(elements.pop());
				int b = Integer.parseInt(elements.pop());
				
				if(str.equals("+"))
				{
					elements.push((b + a) + "");
				}
				else if(str.equals("-"))
				{
					elements.push((b - a) + "");
				}
				else if(str.equals("*"))
				{
					elements.push((b * a) + "");
				}
				else if(str.equals("/"))
				{
					elements.push((b / a) + "");
				}
			}
			else
			{
				elements.push(str);
			}
		}
		return Integer.parseInt(elements.pop());
	}

}
