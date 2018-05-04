package com.roh.prac;

import java.util.Arrays;

/**
 * There are 3 types of colored balloons in an array(Red, Green and Blue).
 * Sort the same colored balloons together.
 * @author knidhi
 *
 */
public class ColoredBallonsInArraySort {
	
	public static void sortBalloons(String[] balloons)
	{
		if(balloons == null || balloons.length < 3)
			return;
		int red = -1, blue = balloons.length;
		
		int a = 0;
		while(balloons[a++].equals("R"))
		{
			red++;
		}
		
		a = balloons.length -1;
		while(balloons[a--].equals("B"))
		{
			blue--;
		}
		
		for(a = red+1; a < blue; a++)
		{
			if(balloons[a].equals("R"))
			{
				if(a - red > 1)
				{
					String temp = balloons[a];
					balloons[a] = balloons[red+1];
					balloons[red+1] = temp;
				}
				red ++;
			}
			else if(balloons[a].equals("B"))
			{
				if(blue - a > 1)
				{
					String temp = balloons[a];
					balloons[a] = balloons[blue - 1];
					balloons[blue - 1] = temp;
				}
				blue--;
			}
		}
		
	}

	public static void main(String[] args) {
		String[] balloons = new String[] {"R","B","R","B","G","G","R","B","B"};
		sortBalloons(balloons);
		System.out.println(Arrays.asList(balloons));
		balloons = new String[] {"G", "B", "R", "B", "G"};
		sortBalloons(balloons);
		System.out.println(Arrays.asList(balloons));
	}

}
