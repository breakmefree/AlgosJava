package com.roh.prac;

public class ValidPalindromeII {

	public static boolean validPalindrome(String s) {
		String str = s.substring(0);
        if(s == null || s.length() < 3) {
            return true;
        }
        boolean flag = true;   
        
        boolean strP1 = strProcessing1(s, flag);
        boolean strP2 = strProcessing2(str, flag);
        return strP1 || strP2;
    }
	
	public static boolean strProcessing1(String s, boolean flag) {
		for(int i =0 ; i< s.length()/2; i++) {
            if(s.charAt(i) == s.charAt(s.length() - 1 - i)) {
                continue;
            } else if(flag) {
            		if(s.charAt(i+1) == s.charAt(s.length() - 1 - i)) {
                    s = s.substring(0, i) + s.substring(i+1);
                    flag = false;
                } else if(s.charAt(i) == s.charAt(s.length() - 2 - i)) {
                    s = s.substring(0, s.length() - 2 - i + 1) + s.substring(s.length() - i);
                    flag = false;
                } else {
                		return false;
                }
            } else {
                return false;
            }
        }
        return true;
	}
	
	public static boolean strProcessing2(String s, boolean flag) {
		for(int i =0 ; i< s.length()/2; i++) {
            if(s.charAt(i) == s.charAt(s.length() - 1 - i)) {
                continue;
            } else if(flag) {
            		if(s.charAt(i) == s.charAt(s.length() - 2 - i)) {
                    s = s.substring(0, s.length() - 2 - i +1) + s.substring(s.length() - i);
                    flag = false;
                }else if(s.charAt(i+1) == s.charAt(s.length() - 1 - i)) {
                    s = s.substring(0, i) + s.substring(i+1);
                    flag = false;
                } else {
                		return false;
                }
            } else {
                return false;
            }
        }
        return true;
	}
	
	public static void main(String[] args) {
		System.out.println("true: " + validPalindrome("lcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupucul"));
		System.out.println("true: " + validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
		System.out.println("true: " + validPalindrome("ebcbbececabbacecbbcbe"));
		System.out.println("true: " + validPalindrome("abbecaacbba"));
		System.out.println("true: " + validPalindrome("cdbeeeabddddbaeedebdc"));
		System.out.println("false: " + validPalindrome("abc"));

	}

}
