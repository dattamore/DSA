package com.graph.anuj;

import java.util.Arrays;

import com.graph.anuj.MinimumSpanningTree2.Pair;

//Bellman Ford Algorithm | Negative Weight Cycle Detection | Shortest Path
//O(VE)
public class NegativeWeightCycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	} 

	public int isNegativeWeightCycle(int n,int[][] edges) {
		int[] dist =new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[0]=0;
		
		for (int count = 0; count < dist.length; count++) {
			for (int j = 0; j < edges.length; j++) {
				int src = edges[j][0];
				int dest = edges[j][1];
				int weight = edges[j][2];
				if(dist[src]!=Integer.MAX_VALUE &&
						dist[src]+weight<dist[dest]	) {
					dist[dest]	= dist[src]+weight;
				 } 
			}
		}
		
		for (int j = 0; j < edges.length; j++) {
			int src = edges[j][0];
			int dest = edges[j][1];
			int weight = edges[j][2];
			if(dist[src]!=Integer.MAX_VALUE &&
					dist[src]+weight<dist[dest]	) {
				dist[dest]	= dist[src]+weight;
				return 1;//negative cycle is prsent
			 } 
		}
		
		return 0;
	}
}
