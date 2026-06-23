package com.heap.lovebabbarAyushi;
//Sort a nearly sorted or K sorted array
import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;

public class KnearlySorted {

	public static void main(String[] args) {
     int arr[]= {6,5,3,2,8,10,9};
     int k=3;
		System.out.println(Arrays.toString(arr));
	 sort(arr,arr.length,k);
		//System.out.println(Arrays.toString(arr)); 
	}

	private static void sort(int[] arr, int length,int k) {
     PriorityQueue<Integer> pq = new PriorityQueue<Integer>(); //minheap
     int arrNew[]= new int[length];
     int newArrayCount=0;
		for (int i = 0; i <= k; i++) {
			pq.add(arr[i]);
		}
		for (int i = k+1; i < length; i++) {
			//if(pq.peek()<arr[i]) {	
				arrNew[newArrayCount]=pq.poll();
				pq.add(arr[i]);			
			newArrayCount++;			
		}		

		for (int i = 0; i < length-k; i++) {
			arrNew[newArrayCount]=pq.poll();
			newArrayCount++;
		}
		System.out.println(" sorted: "+Arrays.toString(arrNew));
	}

}
