package com.coding.interview;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> n1 = new HashMap<>();
        for(int i=0; i<nums1.length; i++) {
            if(n1.get(nums1[i]) == null) 
            {
                n1.put(nums1[i], 1);
            } else {
                n1.put(nums1[i], n1.get(nums1[i]) + 1);
            }
        }
        
        Map<Integer, Integer> n2 = new HashMap<>();
        for(int i=0; i<nums2.length; i++) {
            if(n2.get(nums2[i]) == null) 
            {
                n2.put(nums2[i], 1);
            } else {
                n2.put(nums2[i], n2.get(nums2[i]) + 1);
            }
        }
        
        Map<Integer, Integer> smaller = n1.size() < n2.size() ? n1 : n2;
        List<Integer> list = new ArrayList<>();
        for(Integer key : smaller.keySet()) {
            if(n1.get(key) != null && n2.get(key) != null) {
                int times = n1.get(key) < n2.get(key) ? n1.get(key) : n2.get(key);
                for(int j = 0; j < times; j++) {
                    list.add(key);
                }
            }
        }
        int[] arr = new int[list.size()];
        for(int i=0; i< list.size(); i++)
        {
            arr[i] = list.get(i);
        }
        
        return arr;
	}

	public static void main(String[] args) {
		int a1 = Integer.parseInt("2e11");
		int[] a = {1,2};
		//int[] b = {1,1};
		//StringBuilder b = new StringBuilder((""+'c').toLowerCase());
        
		//System.out.println(intersect(a, b));
		//System.out.println(intersect(b, a));

	}

}
