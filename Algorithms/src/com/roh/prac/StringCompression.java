package com.roh.prac;

import java.util.ArrayList;
import java.util.List;

public class StringCompression {

	// aaaabbccccccccccd
	// a4b2c11d

	public static List<Character> strCompress(String str) {
		List<Character> compressed = new ArrayList<>();
		if(str == null || str.isEmpty()) return compressed;
		int j = 1;
		char curr = str.charAt(0);
		int count = 1;
		while (j < str.length()) {
			while (j < str.length() && curr == str.charAt(j)) {
				j++;
				count++;
			}
			compressed.add(curr);
			if (j < str.length()) {
				curr = str.charAt(j);
				if (count > 1) {
					addChar(compressed, count);
				}
				count = 1;
			}
			j++;
		}

		if (count > 1) {
			addChar(compressed, count);
		} else {
			compressed.add(curr);
		}

		return compressed;
	}
	
	private static void addChar(List<Character> compressed, int count) {
		if (count > 1) {
			String numStr = "" + count;
			for (int x = 0; x < numStr.length(); x++) {
				compressed.add(numStr.charAt(x));
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(strCompress(null));
		System.out.println(strCompress(""));
		System.out.println(strCompress("a"));
		System.out.println(strCompress("ab"));
		System.out.println(strCompress("abc"));
		System.out.println(strCompress("aaaabbc"));
		System.out.println(strCompress("aaaabbccccccccccd"));
		System.out.println(strCompress("aaaabbcccccccccc"));
		System.out.println(strCompress("aaaabbcc"));

	}

}
