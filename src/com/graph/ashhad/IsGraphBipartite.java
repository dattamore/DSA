package com.graph.ashhad;

import java.util.Arrays;
import java.util.LinkedList;

//https://www.youtube.com/watch?v=7nETmZcQRko&list=PLQ7ZAf76c0ZOGuMjg3qwNgILb_dKWTxyQ&index=35
public class IsGraphBipartite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isBipartite(int[][] graph) {
	
		int n=graph.length;
		int color[] = new int[n];
		Arrays.fill(color, -1);
		for (int i = 0; i < n; i++) {
			if(color[i] == -1) {
				if(!colorBFS(i,graph,color)) {
					return false;
				}
			}
		}
		
		return true;
	}

	private boolean colorBFS(int src, int[][] graph, int[] color) {
		 LinkedList<Integer> queue=new LinkedList<>();
		 queue.add(src);
		 color[src]=0;
		 while(!queue.isEmpty()) {
			 int node = queue.poll();
			 for (int neighbour : graph[node]) {
				if(color[neighbour]==-1) {
					color[neighbour]=1 - color[node];
					queue.offer(neighbour);
				}else if(color[neighbour]==color[node]) {
					return false;
				}
			}
		 }
		return true;
	}
}
