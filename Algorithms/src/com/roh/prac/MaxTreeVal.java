package com.roh.prac;

import java.util.HashMap;
import java.util.Map;

public class MaxTreeVal {
	static int count = 0;
	public static int maxTree(Treee root, Map<Treee, Integer> cache) {
		count++;
		if (root == null) {
			return 0;
		}
		
		if (cache.get(root) != null) {
			return cache.get(root);
		}
		
		// Case root not chosen.
		int l1 = maxTree(root.left, cache) + maxTree(root.right, cache);
		
		//Case root is chosen.
		int l2 = root.data + (root.left == null ? 0 : maxTree(root.left.left, cache) + 
					maxTree(root.left.right, cache)) +
				(root.right == null ? 0 : maxTree(root.right.left, cache) + 
						maxTree(root.right.right, cache));
		
		cache.put(root, (l1 > l2 ? l1 : l2));
		return (l1 > l2 ? l1 : l2);
	}
	
	public static int maxTree1(Treee root) {
		count++;
		if (root == null) {
			return 0;
		}

		
		// Case root not chosen.
		int l1 = maxTree1(root.left) + maxTree1(root.right);
		
		//Case root is chosen.
		int l2 = root.data + (root.left == null ? 0 : maxTree1(root.left.left) + 
					maxTree1(root.left.right)) +
				(root.right == null ? 0 : maxTree1(root.right.left) + 
						maxTree1(root.right.right));
		
		return (l1 > l2 ? l1 : l2);
	}
	
	
	public static void main(String[] args) {
		Treee root1 = new Treee(5);
		long startTime = System.nanoTime();
		 
		System.out.println("Value: " + maxTree(root1, new HashMap<Treee, Integer>()));
		
		Treee root = new Treee(20);          //        20
        root.left = new Treee(8);           //     8       22
        root.right = new Treee(22);         //  4    12
        root.left.left = new Treee(4);      //     10  14
        root.left.right = new Treee(12);    //            15
        root.left.right.left = new Treee(10);
        root.left.right.right = new Treee(14);
        root.left.right.right.right = new Treee(15);
        System.out.println("Value: " + maxTree(root, new HashMap<Treee, Integer>()));
      //code
      		long endTime = System.nanoTime();
      		System.out.println("Count " + count );

      		count=0;

            System.out.println("Value: " + maxTree1(root));

      		System.out.println("Count1 " + count );

	}

}

class Treee {
	int data;
	Treee left;
	Treee right;
	
	public Treee(int data) {
		this.data = data;
		this.left = this.right = null;
	}
}