package com.intervals.algotutor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.*;

//undersatnding : https://www.youtube.com/watch?v=dzNIPX7HY6A
public class MergeIntervals {

	public static void main(String[] args) {
		int[][] intervals= {{1,3},{2,6},{8,10},{15,18}};	
		//int[][] intervals= {{1,4},{4,6}};
		int n=intervals.length;
		ArrayList<int[]> result=new ArrayList<>();

		if(n==0 || intervals== null ) {
			System.out.println(result.toArray(new int[0][]));
		}
		Arrays.sort(intervals,(a,b)->a[0]-b[0]);
		int start=intervals[0][0];
		int end=intervals[0][1];
		
		for (int i = 1; i < intervals.length; i++) {
			
			if(end>=intervals[i][0]) {
				end=Math.max(end, intervals[i][1]);			
				result.add(new int[] {start,end});//not sure of this line
				
			}else {
				result.add(new int[] {intervals[i][0],intervals[i][1]});
			}
			start=intervals[i][0];
			end=intervals[i][1];
		}
		
		for (int[] js : result) {
			System.out.println(js[0]+","+js[01]);
		}
	}
	
//chatgpt easier
	    public int[][] merge(int[][] intervals) {
	        if (intervals == null || intervals.length <= 1) {
	            return intervals;
	        }
	        // Step 1: Sort by start time
	        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);//ascending order
	        List<int[]> result = new ArrayList<>();

	        // Step 2: Initialize with first interval
	        int[] current = intervals[0];
	        result.add(current);

	        // Step 3: Traverse remaining intervals
	        for (int i = 1; i < intervals.length; i++) {
	            int[] next = intervals[i];
	            // Overlap condition
	            if (next[0] <= current[1]) {
	                // Merge intervals
	                current[1] = Math.max(current[1], next[1]);
	            } else {
	                // No overlap → move to next interval
	                current = next;
	                result.add(current);
	            }
	        }
	        return result.toArray(new int[result.size()][]);
	    }

	    // Driver code for testing
	    public static void test(String[] args) {
	        MergeIntervals obj = new MergeIntervals();

	        int[][] intervals = {
	            {1, 3},
	            {2, 6},
	            {8, 10},
	            {15, 18}
	        };

	        int[][] merged = obj.merge(intervals);

	        for (int[] interval : merged) {
	            System.out.println(Arrays.toString(interval));
	        }
	    }
	

}

//for (int[] i : intervals) {
//	System.out.println(i[0]+" :"+i[1]);
//	if(i[0]<=end) {
//		end=Math.max(end, i[1]);
//	}else {
//		result.add(new int[] {start,end});
//		start=i[0];
//		end=i[1];
//	}
//}
