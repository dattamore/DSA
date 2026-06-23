package com.heap.anuj;

import java.util.PriorityQueue;

public class LargestInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int kthLargest(int a[],int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(); //((a,b)->a-b)
		for (int i = 0; i < k; i++) {
			minHeap.add(a[i]);
		}
		for (int i = k; i < a.length; i++) {
			if (a[i]>minHeap.peek()) {
				minHeap.poll();
				minHeap.add(a[i]);
			}
		}
		return minHeap.peek();
	}
}
