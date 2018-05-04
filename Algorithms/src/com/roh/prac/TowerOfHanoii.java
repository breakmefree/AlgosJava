package com.roh.prac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TowerOfHanoii {
	
	public static void move( List<Integer> discs, String source,  String dest, String swap)
	{
		if(discs == null || discs.size() < 1)
			return;
		System.out.println(discs.size());
		if(discs.size() == 1)
		{
			System.out.println("moving " + discs.get(0) + " from " + source + " ->> " + dest);
			return;
		}
		else
		{
			List<Integer> slist = new ArrayList<Integer>(discs.subList(0, discs.size() -1));
			List<Integer> last = new ArrayList<Integer>(discs.subList(discs.size() -1,discs.size()));
			move(slist, source, swap, dest);
			move(last, source, dest, swap);
			move(slist, swap, source, dest);
		}
	}

	public static void main(String[] args) {
		List<Integer> args1 = Arrays.asList(1,2);
		move(args1, "A", "B", "C");	
	}

}
