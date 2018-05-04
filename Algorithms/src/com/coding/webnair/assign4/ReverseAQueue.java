package com.coding.webnair.assign4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Reverse a queue
 * input: [1,2,3,4,5]
 * output: [5,4,3,2,1]
 * 
 * @author Kshama Nidhi
 */
public class ReverseAQueue {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		for(int i=1; i<6; i++)
		{
			queue.add(i);
		}
		queue=null;
		reverseQueue(queue);
		System.out.println(queue);
		
	}

	public static void reverseQueue(Queue<Integer> queue)
	{
		if(queue == null || queue.size() < 2)
		{
			return;
		}
		Stack<Integer> stack = new Stack<>();
		while(queue.peek() != null)
		{
			stack.push(queue.poll());
		}
		while(!stack.isEmpty())
		{
			queue.add(stack.pop());
		}
	}
}
