package com.graph.anuj;

import java.util.ArrayList;

public class DetectCycleDirected {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public Boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {

		boolean vis[] = new boolean[V];
		boolean recS[] = new boolean[V];
		for (int i = 0; i < V; i++) {
			if (!vis[i]) {
				dfs(i, adj, vis, recS); return true;
			}
		}
		return false;
	}
	private boolean dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] recS) {
		vis[v] = true;
		recS[v] = true;
		 
		for (Integer neighbor : adj.get(v)) {
			if(!vis[neighbor]) {
				if(dfs(neighbor, adj, vis, recS))return true;
			}
			else if(recS[neighbor])return true; 
		}
		recS[v] = false;
		return false;
	}

}
