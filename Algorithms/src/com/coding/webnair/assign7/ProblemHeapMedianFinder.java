package com.coding.webnair.assign7;

/**
 * Created by dhirendrasinha on 3/19/17.
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class ProblemHeapMedianFinder {
    // Heap implemention is PriorityQueue
    private PriorityQueue<Integer> maxHeap, minHeap;
    private static final int CAPACITY = 10;

    public ProblemHeapMedianFinder() {
        minHeap = new PriorityQueue<Integer>(CAPACITY);
        maxHeap = new PriorityQueue<>(CAPACITY, new Comparator<Integer>() {
            @Override
            public int compare(Integer n1, Integer n2) {
                return (n1 > n2 ? -1 : (n1 == n2 ? 0 : 1));
            }
        });
    }

    // maxHeap holds all smaller elements with the largest among them at the top
    // minHeap holds all greater elements with the smallest among them at the top
    public void addNewNumber(int num) {
        if (maxHeap.size() == minHeap.size()) {
            if ((minHeap.peek() != null) && num > minHeap.peek()) {
                // move the top element from minHeap to maxHeap and add this new number to minHeap
                maxHeap.add(minHeap.poll());
                minHeap.add(num);
            } else {
                // add this new element in maxHeap because its smaller than/ = the smallest element in minHeap
                maxHeap.add(num);
            }
        } else {
            if (num < maxHeap.peek()) {
                minHeap.add(maxHeap.poll());
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }
        }
    }

    public double getMedian() {
        if (maxHeap.isEmpty())
            return minHeap.peek();
        else if (minHeap.isEmpty())
            return maxHeap.peek();

        if (maxHeap.size() == minHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else {
            return minHeap.peek();
        }
    }

    //Generate some random numbers between 0 to 100
    private int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100); // between 0 to 100
        }
        return array;
    }

    public static void main(String[] args) {
        ProblemHeapMedianFinder medianFinder = new ProblemHeapMedianFinder();

        //If the number(N) of elements is Odd then median = (N+1)/2 th element
        System.out.println("------N is ODD------");
        int[] arr1 = medianFinder.generateRandomArray(15);
        System.out.println("Array: " + Arrays.toString(arr1));
        for (int a : arr1) {
            medianFinder.addNewNumber(a);
        }

        System.out.println("Median is: " + medianFinder.getMedian());
        //Try to find median in sorted array
        Arrays.sort(arr1);
        System.out.println("Sorted Array: " + Arrays.toString(arr1));

        // If the number(N) of elements is Even then median = AVG(N/2th, N/2th) element
        System.out.println("------N is EVEN------");
        medianFinder = new ProblemHeapMedianFinder();
        int[] arr2 = medianFinder.generateRandomArray(16);
        System.out.println("Array: " + Arrays.toString(arr2));
        for (int a : arr2) {
            medianFinder.addNewNumber(a);
        }
        System.out.println("Median is: " + medianFinder.getMedian());
        // Try to find median in sorted array
        Arrays.sort(arr2);
        System.out.println("Sorted Array: " + Arrays.toString(arr2));
    }
}
