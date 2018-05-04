package com.somya.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given two unsorted sets of integers, find the complement of the intersection of the two
 * sets. What is the best-case runtime complexity of solving this problem?
 * @author knidhi
 *
 */
public class UnsortedSets {
	

	public static void main(String[] args) {
		// Solution 1: using java methods.
		List<Integer> listA  = new ArrayList<Integer>(Arrays.asList(49, 2, 3, 8,  9, 48, 1, 67, 70));
		List<Integer> listB  = new ArrayList<Integer>(Arrays.asList(67, 4, 5, 7,  8, 49, 66, 3, 70));
		List<Integer> temp = new ArrayList<>(listA);
		listA.removeAll(listB);
		listB.removeAll(temp);
		listA.addAll(listB);
		System.out.println(listA);
		
		// Solution 2:
		int[] arrA = {49, 2, 3, 8,  9, 48, 1, 67, 70};
		int[] arrB = {67, 4, 5, 7,  8, 49, 66, 3, 70};
		
		Map<Integer, Integer> map = new HashMap<>();
		for(int i : arrA)
		{
			map.put(i, i);
		}
		for(int i : arrB) {
			if(map.get(i) == null)
			{
				map.put(i, i);
			}
			else
			{
				map.remove(i);
			}
		}
		System.out.println(map);

		int[] result = new int[map.size()];
		int i=0;
		for(Integer key : map.keySet()) {
			result[i++] = key;
		}
		System.out.println(Arrays.asList(result));

	}

}
