package com.coding.webnair.assign4;

import java.util.Arrays;

/**
 * Interleave the first half of the queue with second half.
 * input: [1,2,3,4,5,6,7,8,9,10]
 * output: [1,6,2,7,3,8,4,9,5,10]
 * 
 * @author Kshama Nidhi
 */
public class InterleaveQueue {

	public static void main(String[] args) {
		int[] input0 = {1,2};
		System.out.println(Arrays.toString(interleaveHalfOfQueue(input0)).toString());
		int[] input1 = {};
		System.out.println(Arrays.toString(interleaveHalfOfQueue(input1)).toString());
		int[] input2 = {1,2,3,4,5,6,7,8,9,10};
		System.out.println(Arrays.toString(interleaveHalfOfQueue(input2)).toString());
		int[] input3 = {10,8,6,4,3,2,1,0,-1,11,6};
		System.out.println(Arrays.toString(interleaveHalfOfQueue(input3)).toString());
		int[] input4 = {1};
		System.out.println(Arrays.toString(interleaveHalfOfQueue(input4)).toString());
	}

	public static int[] interleaveHalfOfQueue(int[] input)
	{
		if(input == null || input.length < 3) return input;
		int[] output = new int[input.length];
		int half = input.length/2;
		
		for(int i=0, j=0; i < input.length; i++)
		{
			output[i++] = input[j++];
			if(i < input.length)
			{
				output[i] = input[half++];
			}
		}
		
		return output;
	}
}
