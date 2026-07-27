package com.graph.ashhad;

import java.util.*;

//chatgpt
public class IsPossibleBipartition {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        // Create an adjacency list for the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // Build the graph from dislikes
        for (int[] dislike : dislikes) {
            graph.get(dislike[0]).add(dislike[1]);
            graph.get(dislike[1]).add(dislike[0]);
        }

        // Array to store the color of each node; 0: uncolored, 1 and -1: two different colors
        int[] color = new int[n + 1];
        Arrays.fill(color, -1);
        // Perform BFS on each component
        for (int i = 0; i < n; i++) {
        	 if (color[i] == -1) { // If not colored, start BFS
		   		 LinkedList<Integer> queue=new LinkedList<>();
		   		 queue.add(i);
		   		 color[i]=0;
		   		 while(!queue.isEmpty()) {
		   			 int node = queue.poll();
		   			 for (int neighbour : graph.get(node)) {
		   				if(color[neighbour]==-1) {
		   					color[neighbour]=1 - color[node];
		   					queue.offer(neighbour);
		   				}else if(color[neighbour]==color[node]) {
		   					return false;
		   				}
		   			}
		   		 }
        	 }
        }

        return true;
    }

    public static void main(String[] args) {
    	IsPossibleBipartition solution = new IsPossibleBipartition();

        int[][] dislikes1 = {{1, 2}, {1, 3}, {2, 4}};
        System.out.println(solution.possibleBipartition(4, dislikes1)); // Output: true
//
//        int[][] dislikes2 = {{1, 2}, {1, 3}, {2, 3}};
//        System.out.println(solution.possibleBipartition(3, dislikes2)); // Output: false
//
//        int[][] dislikes3 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}};
//        System.out.println(solution.possibleBipartition(5, dislikes3)); // Output: false
    }
}
