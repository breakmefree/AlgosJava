package com.roh.prac;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*def bft(root):
if !root:
	retun
arr = [root]
while len(arr) != 0:
	n = arr.pop()
	print n
	if arr.left:
		arr.append(n.left)
	if arr.right:
		arr.append(n.right)
 return
	
(t1, t2 ) (t3, t4) -----		
(1, 4) (3, 6 ) (7, 9) (8, 10) (12, 14)
(1, 6) (7, 10) (12,14)*/
public class MergeOverlappingTuple 
{

	public static void main(String[] args) 
	{
		List<Tuple> tuples = new ArrayList<Tuple>();
		tuples.add(new Tuple(1, 4));
		tuples.add(new Tuple(1, 2));
		tuples.add(new Tuple(5, 6));
		tuples.add(new Tuple(8, 10));
		tuples.add(new Tuple(12, 14));
		tuples.add(new Tuple(13, 16));
		
		Collections.sort(tuples);
		System.out.println(tuples);
		List<Tuple> result = mergeOverlappingTuple(tuples);
		System.out.println("result: " + result.size());
		for(Tuple tuple : result)
		{
			System.out.println("( " + tuple.start + ", " + tuple.end +  " )");
		}
	}
	
	public static List<Tuple> mergeOverlappingTuple(List<Tuple> sortedTuples)
	{
		int start = sortedTuples.get(0).start;
		int end = sortedTuples.get(0).end;
		
		List<Tuple> result = new ArrayList<>();

		for(int i=1; i < sortedTuples.size(); i++)
		{
			Tuple current = sortedTuples.get(i);
			if(current.start <= end)
			{
				end = Math.max(end, current.end);
			}
			else
			{
				result.add(new Tuple(start, end));
				start = current.start;
				end = current.end;
				
			}
		}
		result.add(new Tuple(start, end));
		return result;
	}

}

class Tuple implements Comparable<Tuple>
{
	int start;
	int end;
	
	public Tuple(int start, int end)
	{
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Tuple t2)
	{
		return this.start - t2.start;
	}
	
	
}
