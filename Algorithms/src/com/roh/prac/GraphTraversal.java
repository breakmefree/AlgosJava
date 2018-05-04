package com.roh.prac;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class GraphTraversal {
	
	public void bfs(int x, List<Node> nodes) {
		Node node = nodes.get(x);
		Queue<Node> queue = new LinkedList<Node>();
		Set<Node> visitedNodes = new HashSet<>();
		visitedNodes.add(node);
		queue.add(node);
		while(queue.size() != 0) {
			node = queue.poll();
			for(int i=0; i< node.childs.size(); i++) {
				node = node.childs.get(i);
				if(!visitedNodes.contains(node)) {
					visitedNodes.add(node);
					queue.add(node);
				}
			}
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
