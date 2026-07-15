package com.intervals.general;
import java.util.*;
//undersatnding https://www.youtube.com/watch?v=dTVB1W7-BvY
//code chatgpt
public class MaximumNumberEventsAttended {

	static MaximumNumberEventsAttended obj =null;
    public MaximumNumberEventsAttended() {
		super();
		 obj = new MaximumNumberEventsAttended();
	}

	public static void main(String[] args) {
    	

        int[][] events1 = {// Output: 3
            {1, 2},
            {2, 3},
            {3, 4}
        };
        int[][] events ={{1,2},{2,3},{3,4},{1,2}}; // Output: 4
        System.out.println(obj.maxEvents(events));
    }
    
	    public static int maxEvents(int[][] events) {
	        // Step 1: Sort by start day
	        Arrays.sort(events, (a, b) -> a[0] - b[0]);
	       // obj.iterate(events);
	        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

	        int day = 0;
	        int i = 0;
	        int n = events.length;
	        int count = 0;

	        while (i < n || !minHeap.isEmpty()) {

	            // If no ongoing events, jump to first event's start day
	            if (minHeap.isEmpty()) {
	                day = events[i][0];
	            }
	            // Step 2: Add all events starting today
	            while (i < n && events[i][0] == day) {
	            	System.out.println(" i : "+i+" day : "+day);
	                minHeap.offer(events[i][1]); // store end day
	                i++;
	                System.out.println(" ------------------ : ");
	            }System.out.println("********************************** ");
	            // Step 3: Remove expired events
	            while (!minHeap.isEmpty() && minHeap.peek() < day) {
	                minHeap.poll();
	            }
	            // Step 4: Attend event with earliest end
	            if (!minHeap.isEmpty()) {
	                minHeap.poll();
	                count++;
	                //day++;
	            }
	            day++;
	        }
	        return count;
	    }



		public static void iterate(int[][] events) {
		
		 for(int i=0; i<events.length; i++) {
		     for(int j=0; j<events[i].length; j++) {
		         System.out.println("Values at arr["+i+"]["+j+"] is "+events[i][j]);
		     }
		 }
		}
}
//Approach
//Sort events by start day
//Use a min heap (priority queue) to store end days
//Iterate day by day:
//Add all events starting today
//Remove expired events (end
