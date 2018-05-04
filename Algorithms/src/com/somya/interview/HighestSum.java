package com.somya.interview;

/**
 * You have an array (2,3,10,0,-4,9,8,-5,6,7,0,8,0,5,-7,6,4,-7,8,3,2,0,5,8). Write a program
 * which sequence will give you the highest sum.
 * 
 * @author knidhi
 *
 */
public class HighestSum {

	public static void main(String[] args) {
		int[] arr = {2,3,10,0,-4,9,8,-5,6,7,0,8,0,5,-7,6,4,-7,8,3,2,0,5,8};
		int maxSum =0;
		int currSum=0;
		for(int i =0; i <arr.length; i++)
		{
			currSum += arr[i];
			if(currSum > maxSum)
			{
				maxSum = currSum;
			}
			System.out.println(maxSum);
			System.out.println(currSum + "\n");
		}
		
}

}
