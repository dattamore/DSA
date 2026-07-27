package com.graph.ashhad;

import java.util.*;

public class WaterAndJug {

	public static void main(String[] args) {
		WaterAndJug wjp = new WaterAndJug();
	        System.out.println(wjp.canMeasureWater(3, 5, 4)); // Output: true
	      //  System.out.println(wjp.canMeasureWater(2, 6, 5)); // Output: false

	}

	 public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int target) {
	     if(jug1Capacity+jug2Capacity<target) {return false;} 
		 
	     int[] directions = {jug1Capacity,-jug1Capacity,jug2Capacity,-jug2Capacity};
	     Queue<Integer> q =new LinkedList<>();
	     Set<Integer> visited =new HashSet<>();
	     q.offer(0);
	     visited.add(0);
	     while(!q.isEmpty()) {
	    	 System.out.println("---------------------------Queue  : ");
	    	int curr = q.poll(); 
	    	if(curr == target) {
	    		return true;
	    	}
	    	for (Integer direction : directions) {
	    		int total = curr+direction; 
	    		System.out.println("---------------------------start : ");
	    		System.out.println("totaol : "+total +"= curr: "+curr+ " direction "+direction);
	    		if(total == target) {
	    			System.out.println("total == target : ");
	    			return true;
		    	}
	    		if(total <0 || total>jug1Capacity+jug2Capacity) {
	    			System.out.println("total <0 || total>jug1Capacity+jug2Capacity : ");
		    		continue;
		    	}
	    		if(!visited.contains(total)) {
	    			System.out.println("visited : ");
	    			visited.add(total);
	    			q.offer(total);
		    	}
			}
	     }
		 return false;
	    }
}
