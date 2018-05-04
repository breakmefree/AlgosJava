package com.roh.prac;

import java.util.Arrays;

public class ToweOfHanoiiTwo {
	
	public static void toh(int[] items, char src, char temp, char dest) {
		if (items.length <= 0) {
			return; 
		}
		
		if (items.length == 1) {
			System.out.println("Moving " + items[0] + " from " + src + " to " + dest + "." );
			return;
		}
		
		int[] head = Arrays.copyOfRange(items, 0, items.length-1);
		int[] end = new int[] {items[items.length - 1]};
		
		toh(head, src, dest, temp);
		toh(end, src, temp, dest);
		toh(head, temp, src, dest);
	}

	public static void main(String[] args) {
		toh(new int[] {1}, 'A', 'B', 'C');
	}
}
