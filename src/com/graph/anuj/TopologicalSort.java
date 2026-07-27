package com.graph.anuj;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Boolean topoSort(int V, ArrayList<ArrayList<Integer>> adj) {

		boolean vis[] = new boolean[V];
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < V; i++) {
			if (!vis[i]) {
				dfs(i, adj, vis, stack); return true;
			}
		}
		int ans[] = new int[V];
		int i=0;
		while (!stack.isEmpty()) {
			ans[i++] = stack.pop();
		}
		return false;
	}

	private void dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean[] vis, Stack<Integer> stack) {
		vis[v] = true;
		 
		for (Integer neighbor : adj.get(v)) {
			if(!vis[neighbor]) {
				dfs(neighbor, adj, vis, stack);
			}
		}
		stack.push(v);
	}
}
