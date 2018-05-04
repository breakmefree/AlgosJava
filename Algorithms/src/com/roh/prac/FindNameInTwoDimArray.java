package com.roh.prac;

/**
 * Find the name of the array in the two dimensional array.
 * 
 * @author knidhi
 *
 */
public class FindNameInTwoDimArray {
	public static boolean findNameInTwoDArray(char[][] arr, String name)
	{
		if(name == null || name.isEmpty())
			return true;
		
		if(arr == null || arr.length==0)
			return false;
		int k = 0;
		for(int i=0; i < arr.length; i++) {
			for(int j=0; j < arr[i].length; j++) {
				if(name.charAt(k) == arr[i][j]) {
					
					k++;
					if(k == name.length())
						return true;
				}
				
			}
		}
			
		return false;
	}

	public static void main(String[] args) {
		
		char[][] names = {
				{'A', 'N', 'E', 'A', 'S', 'T'},
				{'S', 'A', 'L', 'E', 'S', 'F', 'O', 'R', 'C', 'E'},
				{'N', 'T', 'S', 'T'},
				{'N', 'O', 'S', 'T'},
				{'N', 'N', 'S', 'T'}
		};
		System.out.println(findNameInTwoDArray(names, "NEST"));
		
	}

}
