package com.graph.algotutor;

import java.util.*;

//chatgpt BFS
//convert int[][] edges to  List<List<Integer>> graph 
public class GraphValidTree {

	    public static void main(String[] args) {
	    	GraphValidTree solution = new GraphValidTree();
	        int n = 5;
	        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
	
	        System.out.println(solution.validTree(n, edges)); // Output: true
	    	
	    }
    
	    public boolean validTree(int n, int[][] edges) {
	        // A valid tree must have exactly n-1 edges
	        if (edges.length != n - 1) return false;

	        // Build the graph as an adjacency list
	        List<List<Integer>> graph = new ArrayList<>();
	        for (int i = 0; i < n; i++) {
	            graph.add(new ArrayList<>());
	        }
	        for (int[] edge : edges) {
	            graph.get(edge[0]).add(edge[1]);
	            graph.get(edge[1]).add(edge[0]);
	        }

	        // Perform BFS
	        boolean[] visited = new boolean[n];
	        Queue<int[]> queue = new LinkedList<>();
	        queue.offer(new int[]{0, -1}); // Start from node 0 with no parent

	        while (!queue.isEmpty()) {
	            int[] current = queue.poll();
	            int node = current[0];
	            int parent = current[1];

	            // If the node is already visited, it's a cycle
	            if (visited[node]) return false;
	            visited[node] = true;
	            for (int neighbor : graph.get(node)) {
	                // Ignore the edge leading back to the parent
	            	 System.out.println("neighbor : "+neighbor+" parent: "+ parent);
	                if (neighbor == parent) continue;

	                queue.offer(new int[]{neighbor, node});
	            }
	        }
	        // Check if all nodes are visited (ensure connectivity)
	        for (boolean v : visited) {
	            if (!v) return false;
	        }
	        return true;
	    }
	
}
