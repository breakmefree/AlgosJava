package com.coding.webnair.assign8;

import java.util.Iterator;
 
/**
 * Detects cycle in an undirected graph
 * 
 * @author Kshama Nidhi
 *
 */
class GraphLoop extends Graph
{
    GraphLoop(int numNodes) {
		super(numNodes);
	}

	// A recursive function that uses visited[] and parent to detect
    // cycle in subgraph reachable from vertex v.
    Boolean isCyclicUtil(int v, Boolean visited[], int parent)
    {
        // Mark the current node as visited
        visited[v] = true;
        Integer i;
 
        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> it = adj[v].iterator();
        while (it.hasNext())
        {
            i = it.next();
 
            // If an adjacent is not visited, then recur for that
            // adjacent
            if (!visited[i])
            {
                if (isCyclicUtil(i, visited, v))
                    return true;
            }
 
            // If an adjacent is visited and not parent of current
            // vertex, then there is a cycle.
            else if (i != parent)
                return true;
        }
        return false;
    }
 
    // Returns true if the graph contains a cycle, else false.
    Boolean isCyclic()
    {
        // Mark all the vertices as not visited and not part of
        // recursion stack
        Boolean visited[] = new Boolean[numNodes];
        for (int i = 0; i < numNodes; i++)
            visited[i] = false;
 
        // Call the recursive helper function to detect cycle in
        // different DFS trees
        for (int u = 0; u < numNodes; u++)
            if (!visited[u]) // Don't recur for u if already visited
                if (isCyclicUtil(u, visited, -1))
                    return true;
 
        return false;
    }
 
 
    // Driver method to test above methods
    public static void main(String args[])
    {
        // Create a graph given in the above diagram
        GraphLoop g1 = new GraphLoop(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        if (g1.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contains cycle");
 
        GraphLoop g2 = new GraphLoop(3);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        if (g2.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contains cycle");
        
        GraphLoop g = new GraphLoop(5);
        g.addEdge(0, 1);  // 0 ---------- 1
		g.addEdge(0, 2);  //   .   .   . 
		g.addEdge(0, 4);  //     .   . 4
		g.addEdge(1, 2);  //        2  . 
		g.addEdge(2, 3);	  //          .  	
		g.addEdge(2, 4);  //             3
		g.addEdge(3, 4);
		if (g.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contains cycle");
    }
}