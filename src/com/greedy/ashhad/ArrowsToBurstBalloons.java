package com.greedy.ashhad;

import java.util.Arrays;
//https://www.youtube.com/watch?v=6jAor6mUbdI
//https://www.youtube.com/watch?v=zBCglI35CSQ
public class ArrowsToBurstBalloons {
//both are working
	public static void main(String[] args) {
		ArrowsToBurstBalloons obj = new ArrowsToBurstBalloons();

	        int[][] points1 = {
	            {10,16},
	            {2,8},
	            {1,6},
	            {7,12}
	        };
	        int[][] points = {{1,2},{3,4},{5,6},{7,8}};//4
	        System.out.println(obj.findArrow(points));
	        System.out.println(obj.findMinArrowShots(points)); // Output: 2

	}

	public int findArrow(int[][] points) {
		Arrays.sort(points,(a,b)->Integer.compare(a[0], b[0]));
		int arrows=1;
		int prevStart=points[0][0];
		int prevEnd=points[0][1];
		for (int i = 0; i < points.length; i++) {
			int currStart=points[i][0];
			int currEnd=points[i][1];
			if (currStart>prevEnd) {
				 arrows++;
				 prevStart=currStart;
				 prevEnd=currEnd;
			} else {
				 prevStart=Math.max(prevStart, currStart);
				 prevEnd=Math.min(prevEnd, currEnd);
			}
		}
		return arrows;
	}
	
	//Sort by End chatgpt
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) return 0;

        // Step 1: Sort by end coordinate
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;
        int end = points[0][1];

        // Step 2: Traverse balloons
        for (int i = 1; i < points.length; i++) {
            // If no overlap → need new arrow
            if (points[i][0] > end) {
                arrows++;
                end = points[i][1];
            }
            // Else overlap → do nothing (same arrow bursts it)
        }

        return arrows;
    }
}
