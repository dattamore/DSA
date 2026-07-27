package com.graph.anuj;

import java.util.ArrayList;
import java.util.LinkedList;

public class DFS {

	public static void main(String[] args) {

	}

	public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {

		boolean vis[] = new boolean[V];
		ArrayList<Integer> ans = new ArrayList<Integer>();

		for (int i = 0; i < V; i++) {
			if (!vis[i]) {
				dfs(i, adj, vis, ans);
			}
		}
		return ans;
	}

	private void dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean[] vis, ArrayList<Integer> ans) {
		vis[v] = true;
		ans.add(v);
		
		for (Integer neighbor : adj.get(v)) {
			if(!vis[neighbor]) {
				dfs(neighbor, adj, vis, ans);
			}
		}
		
	}
}
