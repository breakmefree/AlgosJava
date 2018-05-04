package leet.code.medium;

import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubarraySumEqualsk {
	
	public static int maxSubArrayLen(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		int max = 0, sum = 0;
		for(int i=0; i < nums.length; i++) {
			sum += nums[i];
			
			if(sum == k) {
				max = Math.max(max, i+1);
			}
			
			int diff = sum -k;
			if(map.containsKey(diff)) {
				max = Math.max(max, i - map.get(diff));
			}
			
			if(!map.containsKey(sum)) {
				map.put(sum, i);
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int[] nums = {1, -1, 5, -2, 3};
		int k = 3;
		
		System.out.println(maxSubArrayLen(nums, k));
		
		int[] nums1 = {1, -1, 5, -2, 3};
		k = 1;

		System.out.println(maxSubArrayLen(nums1, k));
	}

}
