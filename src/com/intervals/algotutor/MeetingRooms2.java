package com.intervals.algotutor;
import java.util.*;

//understanding : https://www.youtube.com/watch?v=zKSDKQ-ifmI
//code chatgpt both approach
public class MeetingRooms2 {


public int minMeetingRooms(int[][] intervals) {
    int n = intervals.length;
    // Step 1: Create separate start and end arrays
    int[] start = new int[n];
    int[] end = new int[n];

    for (int i = 0; i < n; i++) {
        start[i] = intervals[i][0];
        end[i] = intervals[i][1];
    }
    // Step 2: Sort both arrays
    Arrays.sort(start);
    Arrays.sort(end);
    // Step 3: Sweep line
    int i = 0, j = 0;
    int rooms = 0;
    int maxRooms = 0;

    while (i < n) {
        if (start[i] < end[j]) {  // New meeting starts before previous ends → need room	              
            rooms++;
            i++;
        } else {// A meeting ended → free room	                
            rooms--;
            j++;
        }
        maxRooms = Math.max(maxRooms, rooms);
    }
    return maxRooms;
}				

// Driver
public static void main(String[] args) {
    MeetingRooms2 obj = new MeetingRooms2();

    int[][] intervals = {
        {0, 30},
        {5, 10},
        {15, 20}
    };

   // System.out.println(obj.minMeetingRooms(intervals)); // Output: 2
    System.out.println(obj.minMeetingRooms22(intervals));
}
	    
public int minMeetingRooms22(int[][] intervals) {
    List<int[]> events = new ArrayList<>();

    for (int[] interval : intervals) {
        events.add(new int[]{interval[0], 1});  // start
        events.add(new int[]{interval[1], -1}); // end
    }
    // Sort by time, if same time → end first
	    Collections.sort(events, (a, b) -> {
	        if (a[0] == b[0]) return a[1] - b[1];
	        return a[0] - b[0];
	    }); 
	    int rooms = 0, maxRooms = 0;
	    for (int[] event : events) {
	    	System.out.println("0 : "+event[0]+ " 1 : "+event[1]);
	        rooms += event[1];
	        maxRooms = Math.max(maxRooms, rooms);
	    }
    return maxRooms;
   }
	
}
