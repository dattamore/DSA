package com.heap.miscellaneous;
import java.util.*;

//https://www.youtube.com/watch?v=NT5Lp5vaMm0
//code chatgpt
public class SlidingWindowMedian {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public double[] medianSlidingWindow(int[] nums, int k) {

        DualHeap dh = new DualHeap(k);

        double[] result = new double[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {

            dh.insert(nums[i]);

            if (i >= k) {
                dh.erase(nums[i - k]); // remove element leaving window
            }

            if (i >= k - 1) {
                result[i - k + 1] = dh.getMedian();
            }
        }

        return result;
    }


	class DualHeap {

	    PriorityQueue<Integer> maxHeap; // max heap
	    PriorityQueue<Integer> minHeap; // min heap

	    Map<Integer, Integer> delayed;

	    int maxHeapSize;
	    int minHeapSize;
	    int k;

	    public DualHeap(int k) {

	        this.k = k;

	        maxHeap = new PriorityQueue<>((a, b) -> b - a);
	        minHeap = new PriorityQueue<>();

	        delayed = new HashMap<>();
	    }

	    public double getMedian() {

	        if (k % 2 == 1) {
	            return maxHeap.peek();
	        }

	        return ((long) maxHeap.peek() + minHeap.peek()) / 2.0;
	    }

	    public void insert(int num) {

	        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
	            maxHeap.offer(num);
	            maxHeapSize++;
	        } else {
	            minHeap.offer(num);
	            minHeapSize++;
	        }

	        makeBalance();
	    }

	    public void erase(int num) {

	        delayed.put(num, delayed.getOrDefault(num, 0) + 1);

	        if (num <= maxHeap.peek()) {
	            maxHeapSize--;

	            if (num == maxHeap.peek()) {
	                prune(maxHeap);
	            }
	        } else {
	            minHeapSize--;

	            if (num == minHeap.peek()) {
	                prune(minHeap);
	            }
	        }

	        makeBalance();
	    }

	    private void prune(PriorityQueue<Integer> heap) {

	        while (!heap.isEmpty()) {

	            int num = heap.peek();

	            if (delayed.containsKey(num)) {

	                delayed.put(num, delayed.get(num) - 1);

	                if (delayed.get(num) == 0) {
	                    delayed.remove(num);
	                }

	                heap.poll();

	            } else {
	                break;
	            }
	        }
	    }

	    private void makeBalance() {

	        if (maxHeapSize > minHeapSize + 1) {

	            minHeap.offer(maxHeap.poll());
	            maxHeapSize--;
	            minHeapSize++;

	            prune(maxHeap);

	        } else if (maxHeapSize < minHeapSize) {

	            maxHeap.offer(minHeap.poll());
	            maxHeapSize++;
	            minHeapSize--;

	            prune(minHeap);
	        }
	    }
	}
}
