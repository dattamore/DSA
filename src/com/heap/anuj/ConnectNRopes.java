package com.heap.anuj;

import java.util.PriorityQueue;

public class ConnectNRopes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	int minCost(int a[]) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(); //((a,b)->a-b)
		for (int i = 0; i < a.length; i++) {
			minHeap.add(a[i]);
		}
		int ans=0;
		while(minHeap.size()>1) {
			int first =minHeap.poll();
			int second =minHeap.poll();
			int sum=first+second;
			ans+=sum;
			minHeap.add(sum);
		}
		return ans;
	}
}
