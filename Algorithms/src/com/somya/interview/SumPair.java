package com.somya.interview;

import java.util.HashMap;
import java.util.Map;

/**
 * You have an array with elements 23, 12, 27, 15, 18, 7, 9, 10. Write a program to check
 * which two elements’ addition would fetch you 32.
 * 
 * @author knidhi
 *
 */
public class SumPair {

	public static void main(String[] args) {
		int sum = 32;
		int[] arr = {23, 12, 27, 15, 18, 7, 9, 10};
		Map<Integer, Integer> map = new HashMap<>();
		for(int i : arr) {
			map.put(i, 32 -i);
		}
		for(int i : arr) {
			if(map.get(32 - i) != null)
			{
				System.out.println(i + " " + map.get(i));
				map.remove(i);
			}
		}
		
	}

}
