package com.graph.miscellaneous;

import com.graph.anuj.DisJointUnionSets;
import java.util.*;

public class RedundantConnection {

	public static void main(String[] args) {
		 RedundantConnection solution = new RedundantConnection();
	        int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
	        int[] result = solution.findRedundantConnection(edges);
	        System.out.println("Redundant Edge: " + result[0] + ", " + result[1]); // Output: [2, 3]
	   	

	}

	 public int[] findRedundantConnection(int[][] edges) {
		int totalNodes = edges.length;
		int res[]=new int[2];
		DisJointUnionSets dsu =new DisJointUnionSets(totalNodes);
		
		for (int[] edge : edges) {
			if(!dsu.unionBySize(edge[0]-1,edge[1]-1)) {
				res = edge;
			}
		}
		return res;
	 }
}
