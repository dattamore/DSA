package com.heap.lovebabbarAyushi;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int lastStoneWeight(int[] stones) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		for (Integer stone : stones) {
			maxHeap.add(stone);
		}
		while(maxHeap.size()>1) {
			int y= maxHeap.poll();
			int x= maxHeap.poll();
			
			if(x!=y) {
				maxHeap.add(y-x);
			}
		}
		return maxHeap.isEmpty()?0:maxHeap.poll();
	}
}
