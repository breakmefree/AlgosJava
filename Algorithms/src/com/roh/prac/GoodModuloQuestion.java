package com.roh.prac;

/**
 * Find a smallest number such that N %10 = 9, N%9=8, ... N%2 = 1.
 * 
 * @author knidhi
 *
 */
public class GoodModuloQuestion {

	public static boolean isThisTheNumber(int num)
	{
		for(int i = 10; i > 1; i--)
		{
			if(num % i != i-1)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		for (int a =1000; a <10000; a++)
		{
			boolean found = isThisTheNumber(a);
			if(found)
			{
				System.out.println(a + " : " + found);
			}
		}

	}

}
