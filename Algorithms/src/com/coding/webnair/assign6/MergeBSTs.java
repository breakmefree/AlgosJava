package com.coding.webnair.assign6;

import java.util.ArrayList;

/**
 * Merge two BSTs
 * 
 * @author Kshama Nidhi
 *
 */
public class MergeBSTs {

	public static void main(String[] args) {
		Node root1 = new Node(20);          //        20
        root1.left = new Node(8);           //     8       22
        root1.right = new Node(22);         //  4    12
        root1.left.left = new Node(4);      //     10  14
        root1.left.right = new Node(12);    //            15
        root1.left.right.left = new Node(10);
        root1.left.right.right = new Node(14);
        root1.left.right.right.right = new Node(15);
        
        Node root2 = new Node(5);          //        5
        root2.left = new Node(3);          //     3     6
        root2.right = new Node(6);         //  1    
        root2.left.left = new Node(1); 
        
        ArrayList<Integer> listOfValues1 = new ArrayList<>();
        inorder(root1, listOfValues1);
        for(Integer value : listOfValues1)
        		System.out.print(value + " ");
        System.out.println("--- BST-1 values in array.");
        
        ArrayList<Integer> listOfValues2 = new ArrayList<>();
        inorder(root2, listOfValues2);
        for(Integer value : listOfValues2)
        		System.out.print(value + " ");
        System.out.println("--- BST-2 values in array.");
        
        ArrayList<Integer> merged = mergeList(listOfValues1, listOfValues2);
        for(Integer value : merged)
            System.out.print(value + " ");
        System.out.println("--- Merged values from BST-1 + BST-2 in array.");
        
        printInOrder(convertListToBST(merged, 0, merged.size() - 1));
        System.out.println("--- Inorder traversal of Merged BST.");

	}
	
	public static ArrayList<Integer> mergeList(ArrayList<Integer> list1, ArrayList<Integer> list2)
	{
		ArrayList<Integer> merged = new ArrayList<>();
		int j=0;
		int k=0;
		while(j<list1.size() && k <list2.size())
		{
			if(list1.get(j) < list2.get(k))
			{
				merged.add(list1.get(j++));
			}
			else
			{
				merged.add(list2.get(k++));
			}
		}
		
		while(j<list1.size())
		{
			merged.add(list1.get(j++));
		}
		
		while(k <list2.size())
		{
			merged.add(list2.get(k++));
		}
		
		return merged;
	}
	
	public static void inorder(Node root, ArrayList<Integer> listOfValues)
	{
		if(root == null)
			return;
		inorder(root.left, listOfValues);
		listOfValues.add(root.data);
		inorder(root.right, listOfValues);
	}
	
	public static void printInOrder(Node root)
	{
		if(root == null)
			return;
		printInOrder(root.left);
		System.out.print(root.data + " ");
		printInOrder(root.right);
	}
	
	/**
	 * Converts list to BST
	 */
    public static Node convertListToBST(ArrayList<Integer> list, int start, int end)
    {
        if(start > end || list == null)
            return null;
     
        int mid = (start + end)/2;
        Node node = new Node(list.get(mid));

        node.left = convertListToBST(list, start, mid-1);
        node.right = convertListToBST(list, mid+1, end);
     
        return node;
    }

}
