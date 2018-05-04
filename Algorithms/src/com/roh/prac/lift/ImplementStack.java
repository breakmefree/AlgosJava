package com.roh.prac.lift;

import java.util.ArrayList;
import java.util.List;

public class ImplementStack {
	
	private static List<Integer> stack = new ArrayList<>();
	private static List<Integer> maxStack = new ArrayList<>();
	private static int max = Integer.MIN_VALUE;
	
	private static void push(int num)
	{
		stack.add(num);
		if(num > max) max = num;
		maxStack.add(max);
	}
	
	private static int pop() throws Exception
	{
		try {
			int num = stack.remove(stack.size() -1);
			maxStack.remove(maxStack.size() -1);
			if(maxStack.size() != 0) {
				max = maxStack.get(maxStack.size() -1);
			} else {
				max = Integer.MAX_VALUE;
			}
			return num;
		} catch(NullPointerException e) {
			throw new Exception("Empty Stack");
		}
	}
	
	private static int max()
	{
		return max;
	}
	
	private static int peek() throws Exception
	{
		try {
			return stack.get(stack.size() -1);
		} catch(NullPointerException e) {
			throw new Exception("Empty Stack");
		}
	}

	public static void main(String[] args) throws Exception {
		ImplementStack.push(2);
		System.out.println("max(): " + ImplementStack.max());
		ImplementStack.push(3);
		System.out.println("max(): " + ImplementStack.max());
		ImplementStack.push(1);
		System.out.println("max(): " + ImplementStack.max());
		ImplementStack.push(5);
		System.out.println("max(): " + ImplementStack.max());
		ImplementStack.push(6);
		System.out.println("max(): " + ImplementStack.max());
		ImplementStack.pop();
		System.out.println("max(): " + ImplementStack.max());
		ImplementStack.pop();
		System.out.println("max(): " + ImplementStack.max());
		ImplementStack.peek();
		System.out.println("max(): " + ImplementStack.max());
		ImplementStack.push(4);
		System.out.println("max(): " + ImplementStack.max());
	}

}
