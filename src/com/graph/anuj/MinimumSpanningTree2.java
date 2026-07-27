package com.graph.anuj;

import java.util.*;

import com.graph.anuj.MinimumSpanningTree2.Solution;
//import com.graph.miscellaneous.NetworkDelayTime.Pair;

//IMP
//Dijkstra's Algorithm | Single Source Shortest Path Algorithm
//O(ElogV)
public class MinimumSpanningTree2 {
    static MinimumSpanningTree2 tree = new MinimumSpanningTree2();
    static MinimumSpanningTree2.Solution sol = tree.new Solution();
	public static void main(String[] args) {

	        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
	        int v = 5; // number of vertices

	        for (int i = 0; i < v; i++) {
	            adj.add(new ArrayList<>());
	        }

	        adj.get(0).add(new ArrayList<>(Arrays.asList(1, 2)));
	        adj.get(0).add(new ArrayList<>(Arrays.asList(3, 6)));
	        adj.get(1).add(new ArrayList<>(Arrays.asList(2, 3)));
	        adj.get(2).add(new ArrayList<>(Arrays.asList(3, 8)));
	        adj.get(2).add(new ArrayList<>(Arrays.asList(4, 5)));
	        adj.get(3).add(new ArrayList<>(Arrays.asList(4, 9)));

	        int[] result = sol.spanningTree(v, 0, adj);
	        System.out.println(Arrays.toString(result));

	}
 
	class Pair implements Comparable<Pair>{
		int wt;
		int v;	
		public Pair(int wt, int v) {
			super();
			this.wt = wt;
			this.v = v;
		}
//		@Override
//		public int compareTo(Pair that) {
//			// TODO Auto-generated method stub
//			return this.wt-that.wt;
//		}	
		 @Override
	        public int compareTo(Pair other) {
	            return Integer.compare(this.wt, other.wt);
	        }
	}
	
	public class Solution{
		
	 public int[] spanningTree(int v,int S,ArrayList<ArrayList<ArrayList<Integer>>> adj) {
		 boolean[] vis=new boolean[v];
		 PriorityQueue<Pair> q= new PriorityQueue<>();
		 //int ans=0;
		 int[] ans=new int[v];
		 Arrays.fill(ans, Integer.MAX_VALUE);
		 
		 
		 q.add(new Pair(S,0)); 
		 ans[S]=0;
		 while(q.size()!=0) {
			 Pair cur=q.poll();
			 int v1=cur.v;
			// if(vis[v1]) {continue;}
			 
			// ans+=cur.wt;
			// vis[v1]=true;
			 
			 ArrayList<ArrayList<Integer>> neighbors=  adj.get(v1);
			 for (ArrayList<Integer> list : neighbors) {
				 int vertex=list.get(0);
				 int wt=list.get(1);
				 if(ans[vertex]>ans[v1]+wt) {
					 ans[vertex]=ans[v1]+wt;
					 q.add(new Pair(vertex,ans[vertex])); 
				 } 
//				 if(vis[vertex]==false) {
//					 q.add(new Pair(vertex,wt)); 
//				 } 			
			}
		 }
         return ans;
		}
	 
	 public  ArrayList<ArrayList<ArrayList<Integer>>> convert(int n, int[][] times) {
	        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

	        // Initialize the adjacency list with empty lists for each vertex
	        for (int i = 0; i < n; i++) {
	            adj.add(new ArrayList<>());
	        }

	        // Add edges to the adjacency list
	        for (int[] time : times) {
	            int u = time[0]-1; // source vertex
	            int v = time[1]-1; // destination vertex
	            int weight = time[2]; // weight of the edge

	            ArrayList<Integer> edge = new ArrayList<>(Arrays.asList(v, weight));
	            adj.get(u).add(edge);
	        }

	        return adj;
	    }
	}
}
 