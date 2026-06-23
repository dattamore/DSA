package com.heap.lovebabbarAyushi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

	public static void main(String[] args) {
		int[] nums= {1,1,1,2,2,3,5,5,5};
		int k=2;
		
		Map<Integer,Integer> map=new HashMap<>();
		
		for (int i : nums) {
			map.put(i, map.getOrDefault(i,0)+1);
		}
		System.out.println(":"+map);
		
		PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(
				(x,y)->(y.getValue()-x.getValue())); //max heap(nlogn)..it can be solved with minheap (nlogk)
		
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.println("++ :"+entry.getKey());
			pq.add(entry);
		}
		
		int[] output=new int[k];
		for (int i = 0; i < k; i++) {
			output[i]=pq.poll().getKey();
		}		
		
		System.out.println(Arrays.toString(output));
	}

}
