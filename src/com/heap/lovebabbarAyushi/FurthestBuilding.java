package com.heap.lovebabbarAyushi;

import java.util.PriorityQueue;

//https://www.youtube.com/watch?v=wAxhnUhXvHE
//chatgpt easier

//This problem teaches the “resource replacement greedy pattern”:
//Use expensive resource first (ladder)
//Replace smallest usage with cheaper resource (bricks)
public class FurthestBuilding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	public int furthestBuilding2(int[] heights,int bricks,int ladders) {
		int n=heights.length;
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(); //((a,b)->a-b)
		int brickUsed=0;
		for (int i = 1; i < n; i++) {
			int diff =heights[i] -heights[i-1];
			if (diff >0) {
				minHeap.add(diff);
				if (minHeap.size()>ladders) {
					 brickUsed +=minHeap.remove();
				}
				if (brickUsed>bricks) {
					return i-1;
				}
			}
			
		}
		return n-1;
	}
	
	//chatgpt

	    public int furthestBuilding(int[] heights, int bricks, int ladders) {

	        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	        for(int i = 0; i < heights.length - 1; i++) {

	            int climb = heights[i + 1] - heights[i];

	            if(climb > 0) {
	                minHeap.offer(climb);
	                // if ladders exceeded, use bricks for smallest climb
	                if(minHeap.size() > ladders) {
	                    bricks = bricks-minHeap.poll();
	                    if(bricks < 0) {
	                        return i;
	                    }
	                }
	            }
	        }
	        return heights.length - 1;
	    }
	
}
