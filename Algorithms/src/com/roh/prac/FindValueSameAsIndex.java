package com.roh.prac;

/**
 * Given an array with increasing sequence of number.
 * Find if the there is index whose value is same as the index 
 * 
 * @author knidhi
 */
public class FindValueSameAsIndex {
	
	public static int findIndex(int[] arr)
	{
		if(arr.length == 0)
			return -1;
		int start = 0;
		int end = arr.length -1;
		
		while(start <= end)
		{
			int mid = start + (end - start)/2;
			if(arr[mid] == mid)
				return mid;
			else if(arr[mid] > mid)
				start = mid + 1;
			else
				end = mid - 1;
		}
		
		return -1;
	}
	

	public static void main(String[] args)
	{
		int[] arr = {1};
		System.out.println(findIndex(arr));
	}

}
