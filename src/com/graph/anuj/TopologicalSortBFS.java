package com.graph.anuj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSortBFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void topoSort(int V, ArrayList<ArrayList<Integer>> adj) {

		boolean vis[] = new boolean[V];
		ArrayList<Integer> ans = new ArrayList<Integer>();
		
		int inDeg[] = new int[V];
		
		for (ArrayList<Integer> list : adj) {
			for (Integer  e: list) {
				inDeg[e]++;
			}
		}
		bfs(adj,V,0, vis, ans,inDeg);
	}

	private void bfs(ArrayList<ArrayList<Integer>> adj, int V, int v, boolean[] vis, ArrayList<Integer> ans,
			int[] inDeg) {
		
		LinkedList<Integer> q=new LinkedList<Integer>();
		
		for (int i = 0; i < V; i++) {
			if(inDeg[i] ==0) {
				q.add(i);
			}
		}		 
		while(!q.isEmpty()) {
			int cur = q.poll();
			ans.add(cur);
			
			for (int neighbor : adj.get(cur)) {
				if(--inDeg[neighbor] ==0) {
					q.add(neighbor);
				}
			}
		}
	}
}
