package com.coding.interview;

public class CompareSortedArrays {
	
	
	public static void findCommonElementsInSortedArrays(int[] arrA, int[] arrB, int[] match, int j)
	{
		int k = 0; int i=0;
		while(i < arrA.length && k < arrB.length)
		{
			if(arrA[i] == arrB[k])
			{
				match[j++] = arrA[i];
				k++;
				i++;
			}
			else if(arrA[i] < arrB[k])
			{
				i++;
			}
			else 
			{
				k++;
			}
		}
	}

	public static void main(String[] args)
	{
		int[] match = new int[10];
		int[] arrA = {1, 2, 3, 8,  9, 48, 49, 67, 70};
		int[] arrB = {3, 4, 5, 7,  8, 49, 66, 67, 70};
		int j =0;
		findCommonElementsInSortedArrays(arrA, arrB, match, j);
		
		for(int i=0; i < match.length && match[i] != 0; i++)
		{
			System.out.println(match[i]);
			
		}

	}

}
