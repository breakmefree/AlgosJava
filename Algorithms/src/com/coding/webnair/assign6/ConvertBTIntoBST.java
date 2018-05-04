package com.coding.webnair.assign6;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Convert binary tree into BST
 * 
 * @author Kshama Nidhi
 *
 */
public class ConvertBTIntoBST {
	static Integer index = 0;

	public static void main(String[] args) {
		Node root = new Node(12);           //        12
        root.left = new Node(1);            //     1       2
        root.right = new Node(2);           //  6    7
        root.left.left = new Node(6);       //     8  9
        root.left.right = new Node(7);      //          10
        root.left.right.left = new Node(8);
        root.left.right.right = new Node(9);
        root.left.right.right.right = new Node(10);
        
        ArrayList<Integer> listOfValues = new ArrayList<>();
        inorder(root, listOfValues);
        for(Integer value : listOfValues)
        System.out.print(value + " ");
        System.out.println("---- Original values in BT.");

        Collections.sort(listOfValues);
        for (int i = 0; i <listOfValues.size(); i++)
            System.out.print(listOfValues.get(i) + " ");
        System.out.println("---- Inorder values saved and sorted in list.");
            
        converToBST(listOfValues, root);
		System.out.println("---- Sorted values updated in the original BT, hence BST now.");
        printInOrder(root);
		System.out.println("---- Printing the values inorder in BST.");
	}
	
	public static void printInOrder(Node root)
	{
		if(root == null)
			return;
		printInOrder(root.left);
		System.out.print(root.data + " ");
		printInOrder(root.right);
	}
	
	public static void converToBST(ArrayList<Integer> listOfValues, Node root)
	{
		if(root == null)
			return;
		converToBST(listOfValues, root.left);
		root.data = listOfValues.get(index++);
		System.out.print(root.data + " " + "("+index+")" + " ");
		converToBST(listOfValues, root.right);
	}
	
	public static void inorder(Node root, ArrayList<Integer> listOfValues)
	{
		if(root == null)
			return;
		inorder(root.left, listOfValues);
		listOfValues.add(root.data);
		inorder(root.right, listOfValues);
	}

}
