package com.intervals.algotutor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
//https://www.youtube.com/watch?v=BTObFnHbD4U&t=419s
public class NonOverlappingIntervals {

	public static void main(String[] args) {
		int[][] intervals= {{1,2},{2,3},{3,4},{1,3}};	
		int n=intervals.length;
        int count=0;
		Arrays.sort(intervals,(a,b)->a[0]-b[0]);
		for (int[] js : intervals) {
			System.out.print(js[0]+","+js[01]+" // ");
		}
		System.out.println(" ");
		int left=0;
		int right=1;
		
		while(right<n) {
			System.out.println(" DATA: "+intervals[left][0]+""+intervals[left][1]+ " // "+intervals[right][0]+ ""+intervals[right][1]);
			if(intervals[left][1]<=intervals[right][0]) {//Non-overlappin
				System.out.println(" Non: "+intervals[left][1]+ " "+intervals[right][0]);
				left=right;
				right+=1;
			}
			else if(intervals[left][1]<=intervals[right][1]) {//overlapping remove right
				System.out.println(" remove right : "+intervals[left][1]+ " "+intervals[right][1]);
				count++;
				right+=1;
			}
			else if(intervals[left][1]>intervals[right][1]) {//overlapping remove left
				System.out.println(" remove left : "+intervals[left][1]+ " "+intervals[right][1]);
				count++;
				left=right;
				right+=1;
			}
			
		}
		System.out.println("count : "+count);

	}
	//easier
	//https://www.youtube.com/watch?v=XsrJgwGlRoc
	 int eraseOverlapInterval(int[][] intervals) {
		 if (intervals.length==0) {
			return 0;
		}
		 Arrays.sort(intervals, Comparator.comparingInt(a->a[1]));
		 
		 int count=1;
		 int previous_intervals=0;
		 
		 for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0]>=intervals[previous_intervals][1]) {
				previous_intervals=i;
				count++;
			}
		}
		 return intervals.length-count;
	 }

}
