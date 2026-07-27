package com.graph.anuj;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleUndirected {

	public static void main(String[] args) {
	       int V = 5;
	       ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
	        for (int i = 0; i < V; i++) {
	            adj.add(new ArrayList<>());
	        }
	        
	        // Example graph edges
	        addEdge(adj, 0, 1);
	        addEdge(adj, 1, 2);
	        addEdge(adj, 2, 3);
	        addEdge(adj, 3, 4);
	        addEdge(adj, 4, 1); // This edge creates a cycle

	        DetectCycleUndirected solution = new DetectCycleUndirected();
	        System.out.println(solution.isCyclic(V, adj)); // Output: true

		}
	    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
	        adj.get(u).add(v);
	        adj.get(v).add(u);
	    }
	public Boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {

		boolean vis[] = new boolean[V];
		ArrayList<Integer> ans = new ArrayList<Integer>();

		for (int i = 0; i < V; i++) {
			if (!vis[i]) {
				dfs(i, adj, vis, -1); return true;
			}
		}
		return false;
	}

	private boolean dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean[] vis, int parent) {
		vis[v] = true;
		 
		for (Integer neighbor : adj.get(v)) {
			if(!vis[neighbor]) {
				if(dfs(neighbor, adj, vis, v))return true;
			}
			else if(neighbor != parent)return true; 
		}
		return false;
	}
// Time Complexity : O(V+E)
}
