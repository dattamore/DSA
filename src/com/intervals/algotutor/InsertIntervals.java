package com.intervals.algotutor;

import java.util.LinkedList;
// understanding : https://www.youtube.com/watch?v=wCBtjZxw1xY   
public class InsertIntervals {

	public static void main(String[] args) {
		//int[][] intervals= {{1,3},{6,9}};
		//int[] NewIntervals= {2,5};
		int[][] intervals= {{1,2},{3,5},{6,7},{8,10},{12,16}};	
		int[] NewIntervals= {4,8};
		int n=intervals.length;int i=0;		
		LinkedList<int[]> result=new LinkedList<>();
		
		while(i<n && (intervals[i][1]<NewIntervals[0])) {
			result.add(intervals[i]);
			i++;
		}
		while(i<n && (intervals[i][0]<=NewIntervals[1])   ) {
			System.out.println("intervals[i][0]: "+intervals[i][0]+" NewIntervals[1]: "+NewIntervals[1]);
			NewIntervals[0]=Math.min(intervals[i][0], NewIntervals[0]);
			NewIntervals[1]=Math.max(intervals[i][1], NewIntervals[1]);
			i++;
		}
		result.add(NewIntervals);
		
		while(i<n && (intervals[i][0]>NewIntervals[1])) {
			result.add(intervals[i]);
			i++;
		}
		for (int[] js : result) {
			System.out.println(js[0]+","+js[01]);
		}
	}

}
