package com.facebook.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AddBinary {
	public static String addBinary(String a, String b) {

		int len = Math.abs(a.length() - b.length());
		String large = (a.length() >= b.length()) ? a : b;
		String small = (a.length() < b.length()) ? a : b;

		for (int i = 0; i < len; i++) {
			small = '0' + small;
		}
		String carry = "";
		StringBuilder res = new StringBuilder();
		String sum = "";
		for (int i = large.length() - 1; i >= 0; i--) {
			sum = addition(carry, "" + large.charAt(i), "" + small.charAt(i));
			if (sum.length() == 2) {
				carry = "" + sum.charAt(0);
				res.insert(0, "" + sum.charAt(1));
			} else {
				res.insert(0, "" + sum.charAt(0));
				carry = "";
			}

		}
		if (sum.length() == 2) {
			res.insert(0, carry);
		}
		return res.toString();
	}

	public static String addition(String carry, String s1, String s2) {
		if (s1.equals("0") && s2.equals("0")) {
			return carry.isEmpty() ? "0" : carry;
		} else if (s1.equals("1") && s2.equals("1")) {
			if (carry.isEmpty() || carry.equals("0")) {
				return "10";
			} else {
				return "11";
			}

		} else if ((s1.equals("0") && s2.equals("1")) || (s1.equals("1") && s2.equals("0"))) {
			if (carry.isEmpty() || carry.equals("0")) {
				return "1";
			} else {
				return "10";
			}
		}
		return "";
	}
	
	// Good Solution from net
	public static String addBinary2(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';
            sb.append(sum%2);
            carry = sum/2;
        }
        
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
	
	public static String addBinary3(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        StringBuilder sb = new StringBuilder();
        
        while(i >= 0 || j >= 0)
        {
            int sum = carry;
            if(i >= 0) sum += a.charAt(i--) - '0';
            if(j >= 0) sum += b.charAt(j--) - '0';
            sb.append(sum%2);
            carry = sum/2;
        }
        
        if(carry != 0) sb.append(carry);
        
        return sb.reverse().toString();
    }
	
	public List<List<Integer>> threeSum(int[] nums) {
	    Arrays.sort(nums);
	    List<List<Integer>> list = new ArrayList<>();
	    for(int i = 0; i < nums.length; i++) {
	        if(i > 0 && (nums[i] == nums[i-1])) continue; // avoid duplicates
	        for(int j = i+1, k = nums.length-1; j<k;) {
	            if(nums[i] + nums[j] + nums[k] == 0) {
	                list.add(Arrays.asList(nums[i],nums[j],nums[k]));
	                j++;k--;
	                while((j < k) && (nums[j] == nums[j-1]))j++;// avoid duplicates
	                while((j < k) && (nums[k] == nums[k+1]))k--;// avoid duplicates
	            }else if(nums[i] + nums[j] + nums[k] > 0) k--;
	            else j++;
	        }
	    }
	    return list;
	}

	public static void main(String[] args) {
		System.out.println("Add " + addBinary3("0", "0"));
		System.out.println("Add " + addBinary3("1", "111"));
		System.out.println("Add " + addBinary3("0", "101"));
		System.out.println("Add " + addBinary3("0", "1"));
		
		
		System.out.println("Add " + addBinary2("0", "0"));
		System.out.println("Add " + addBinary2("1", "111"));
		System.out.println("Add " + addBinary2("0", "101"));
		System.out.println("Add " + addBinary2("0", "1"));
        //Set<List<Integer>> arr = new HashSet<>();
        

	}

}
