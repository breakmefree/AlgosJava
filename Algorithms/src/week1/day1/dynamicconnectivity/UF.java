package week1.day1.dynamicconnectivity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UF 
{
	private int[] nodes;
	// initialize union-find data structure with N objects
	// 0 - N-1
	public UF(int N)
	{
		nodes = new int[N];
		for(int i =0; i<N; i++)
		{
			nodes[N] = i;
		}
	}
	
	public int root(int i)
	{
		while(i != nodes[i])
			i = nodes[i];
		
		return i;
	}
	
	public void union(int p, int q)
	{
		int i = root(p);
		int j = root(q);
		nodes[i] = j;
		
	}
	
	public boolean connected(int p, int q)
	{
	
		return root(p) == root(q);
		
	}
	
	public int find(int p)
	{
		return p;
		
	}
	
	public int count()
	{
		return 0;
		
	}
	
	public static void main(String[] args) throws IOException {
		int N = System.in.read();
		UF uf = new UF(N);
		
	}

}
