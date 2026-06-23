package com.heap.lovebabbarAyushi;

import java.util.Comparator;
import java.util.PriorityQueue;

//https://www.youtube.com/watch?v=QFrefY2W1I8
//understanding chatgpt
public class IPO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Pair{
		int profit;
		int capital;
		public Pair(int profit, int capital) {
			super();
			this.profit = profit;
			this.capital = capital;
		}
	}
	public int findMaximizedCapital(int k,int w,int[] profits,int[] capital) {

        PriorityQueue<Pair> minHeap = new PriorityQueue<>(new Comparator<Pair>() {
					public int compare(Pair p1,Pair p2) {
						return Integer.compare(p1.capital, p2.capital);
					}   
            });
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(new Comparator<Pair>() {
					public int compare(Pair p1,Pair p2) {
						return Integer.compare(p1.profit, p2.profit);
					}   
            });
        for (int i = 0; i < profits.length; i++) {
			minHeap.add(new Pair(profits[i],capital[i]));
		}
        while(k>0) {
        	while(!minHeap.isEmpty() && minHeap.peek().capital<=w) {
        		maxHeap.add(minHeap.remove()); //peek
        	}
        	if(maxHeap.isEmpty())break;
        	w+=maxHeap.remove().profit;//poll
        	k--;
        }
        return w;
	}
}
