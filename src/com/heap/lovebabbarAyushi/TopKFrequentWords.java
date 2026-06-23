package com.heap.lovebabbarAyushi;
import java.util.*;

//https://www.youtube.com/watch?v=4dPoGA4WfL4
//code chattgpt
public class TopKFrequentWords {

	    public List<String> topKFrequent(String[] words, int k) {

	        Map<String, Integer> map = new HashMap<>();
	        // Step 1: Count frequency
	        for(String word : words){
	            map.put(word, map.getOrDefault(word, 0) + 1);
	        }
	        // Step 2: Min Heap
	        PriorityQueue<String> pq = new PriorityQueue<>(
	            (a, b) -> {
	                int freqCompare = map.get(a) - map.get(b);

	                if(freqCompare == 0){
	                    return b.compareTo(a);   // reverse lexicographic
	                }

	                return freqCompare;
	            }
	        );
	        // Step 3: Maintain heap size k
	        for(String word : map.keySet()){

	            pq.offer(word);

	            if(pq.size() > k){
	                pq.poll();
	            }
	        }
	        // Step 4: Build result
	        List<String> result = new ArrayList<>();

	        while(!pq.isEmpty()){
	            result.add(pq.poll());
	        }
	        Collections.reverse(result);
	        return result;
	    }
	
}
