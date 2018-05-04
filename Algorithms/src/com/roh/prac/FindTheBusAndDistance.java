package com.roh.prac;

import java.util.Random;

public class FindTheBusAndDistance {
	// 1, 3, 6, 12, 24
	
	public static boolean isBusFound(int location) {
		return new Random().nextBoolean();
	}
	public static void main(String[] args) {
		int distance = 1;
		int distFromBegin = 1;
		int nextDistance = 3 * distFromBegin;
		int counter = 1;
		while(!isBusFound(distFromBegin)) 
		{
			distance += nextDistance;
			counter++;
			nextDistance *= 2;
			distFromBegin = nextDistance/3;
		}
		
		System.out.println("Lap : " + counter + "  == Total dist: " + distance + "  distFromBegin: "  + distFromBegin);

	}

}
