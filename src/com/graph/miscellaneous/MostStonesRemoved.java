package com.graph.miscellaneous;

import com.graph.anuj.DisJointUnionSets;
import java.util.*;
//chatgpt
//https://www.youtube.com/watch?v=OwMNX8SPavM&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=54
public class MostStonesRemoved {

	public static void main(String[] args) {
		MostStonesRemoved sol = new MostStonesRemoved();
	        //int[][] stones = {{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}};
	        int[][] stones = {{0, 0}, {0, 2}, {1, 1}, {2, 0}, {2, 2}};
	        System.out.println(sol.removeStones(stones)); // Output: 5

	}
	 public int removeStones(int[][] stones) {
		int n = stones.length;  
		DisJointUnionSets dsu =new DisJointUnionSets(n);  

        Map<Integer, List<Integer>> rowMap = new HashMap<>();
        Map<Integer, List<Integer>> colMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int row = stones[i][0];
            int col = stones[i][1];

            rowMap.computeIfAbsent(row, k -> new ArrayList<>()).add(i);
            colMap.computeIfAbsent(col, k -> new ArrayList<>()).add(i);
            System.out.println("rowMap : "+rowMap);
            System.out.println("colMap : "+colMap);
        }
        int wires=0;
        for (List<Integer> indices : rowMap.values()) {
            for (int i = 1; i < indices.size(); i++) {
            	if(dsu.unionBySize(indices.get(0), indices.get(i))) {
            		System.out.println("row : "+ indices.get(0)+" : "+indices.get(i));
            		 wires++;
            	}
            }
        }

        for (List<Integer> indices : colMap.values()) {
            for (int i = 1; i < indices.size(); i++) {
            	if(dsu.unionBySize(indices.get(0), indices.get(i))) {
            		System.out.println("col : "+ indices.get(0)+" : "+indices.get(i));
            		 wires++;
            	}
            }
        }


        return wires;
	 }

}
