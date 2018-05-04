package com.coding.webnair.assign7;

/**
 * Find a median of the combined sorted array obtained from two same sized sorted arrays
 * 
 * arr1 = {1,3, 4, 5, 7}
 * arr2 = {2, 4, 6, 8, 10}
 * combinedArr = {1, 2, 3, 4, 4, 5, 6, 7, 8, 10} -> median =4.5
 * 
 * @author knidhi
 *
 */
public class FindMedianOfArrays {

	public static void main(String[] args) {
		int[] arr1 = {1, 3, 4, 5, 7};
		int[] arr2 = {2, 4, 6, 8, 10};
		int[] mergedArr = mergeList(arr1, arr2);
		int lenth = arr1.length + arr2.length;
		if(lenth%2 == 1)
		{
			System.out.println("median :" + mergedArr[(lenth + 1)/2]);
		}
		else
		{
			double median = (mergedArr[(lenth)/2] + mergedArr[(lenth)/2 + 1])/2.0;
			System.out.println("median :" + median);
		}
	}
	
	public static int[] mergeList(int[] list1, int[] list2)
	{
		int[] merged = new int[list1.length + list2.length];
		int j = 0;
		int k = 0;
		int i = 0;
		while(j<list1.length && k <list2.length)
		{
			if(list1[j]< list2[k])
			{
				merged[i++] = list1[j++];
			}
			else
			{
				merged[i++] = list2[k++];
			}
		}
		
		while(j < list1.length)
		{
			merged[i++] = list1[j++];
		}
		
		while(k < list2.length)
		{
			merged[i++] = list2[k++];
		}
		
		return merged;
	}
}
