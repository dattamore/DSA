package com.heap.anuj;

import java.util.Collections;
import java.util.PriorityQueue;

//understanding : https://www.youtube.com/watch?v=756_8C9YBZQ n
public class FindMedian {

	PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());//((a,b)->b-a)
	PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(); //((a,b)->a-b)
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindMedian f=new FindMedian();
		f.inserSum(3);f.inserSum(1);
		System.out.println("  : "+f.medain());
		f.inserSum(5); System.out.println("  : "+f.medain());
		f.inserSum(4); System.out.println("  : "+f.medain());
	}

	public void inserSum(int num) {
		
		//if(maxHeap.isEmpty() || maxHeap.peek()>=num) {
		if(maxHeap.isEmpty() || num<= maxHeap.peek()) {
			maxHeap.add(num);
		}else{
			minHeap.add(num);
		}
		
		if(maxHeap.size() > minHeap.size()+1) {
			minHeap.add(maxHeap.poll());
		}else if(maxHeap.size() < minHeap.size()){
			maxHeap.add(minHeap.poll());
		}
	}
	
	public double medain() {
		if(maxHeap.size() == minHeap.size()) {
			return (maxHeap.peek() + minHeap.peek())/2.0;
		}
		
		return maxHeap.peek();
	}
}
