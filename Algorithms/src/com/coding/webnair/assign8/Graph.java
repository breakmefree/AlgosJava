package com.coding.webnair.assign8;

import java.util.LinkedList;
import java.util.Iterator;

class Graph {
	public int numNodes;
	public LinkedList<Integer> adj[];

	@SuppressWarnings({ "unchecked", "rawtypes" })
	// Constructor
	Graph(int numNodes) {
		this.numNodes = numNodes;
		adj = new LinkedList[numNodes];
		for (int i = 0; i < numNodes; ++i)
			adj[i] = new LinkedList();
	}

	// Function to add an edge into the graph
	protected void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
	}

	// BFS traversal from a given source s
	protected void doBFS(int s) {
		boolean visited[] = new boolean[numNodes];

		// Create a queue for BFS
		LinkedList<Integer> queue = new LinkedList<Integer>();

		// Mark the current node as visited and enqueue it
		visited[s] = true;
		queue.add(s);

		while (queue.size() != 0) {
			// Dequeue a vertex from queue and print it
			s = queue.poll();
			// Printing is really visiting
			System.out.print(s + " ");

			Iterator<Integer> i = adj[s].listIterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}

	// recursive helper method
	protected void dfsHelper(int v, boolean visited[]) {
		// Mark the current node as visited and print it
		visited[v] = true;
		System.out.print(v + " ");

		// Recurse for all the vertices adjacent to this vertex
		Iterator<Integer> i = adj[v].listIterator();
		while (i.hasNext()) {
			int n = i.next();
			if (!visited[n])
				dfsHelper(n, visited);
		}
	}

	// The function to do DFS traversal. It uses recursive DFSHelper()
	protected void doDFS(int v) {
		boolean visited[] = new boolean[numNodes];
		// Call the recursive helper function to print DFS traversal
		dfsHelper(v, visited);
	}

	public static void main(String args[]) {
		Graph g = new Graph(5);

		g.addEdge(0, 1);  // 0 ---------- 1
		g.addEdge(0, 2);  //   .   .   . 
		g.addEdge(0, 4);  //     .   . 4
		g.addEdge(1, 2);  //        2  . 
		g.addEdge(2, 0);  //         . .
		g.addEdge(2, 3);	  //          .  	
		g.addEdge(2, 4);  //             3
		g.addEdge(3, 4);

		System.out.println("BFS from 2");
		g.doBFS(2);
		System.out.println("\nDFS from 2");
		g.doDFS(2);
	}
}
