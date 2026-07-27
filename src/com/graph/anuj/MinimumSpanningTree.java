package com.graph.anuj;

import java.util.PriorityQueue;
import java.util.ArrayList;
//Prims Algorithm
public class MinimumSpanningTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
 
	class Pair implements Comparable<Pair>{
		int wt;
		int v;	
		public Pair(int wt, int v) {
			super();
			this.wt = wt;
			this.v = v;
		}
		@Override
		public int compareTo(Pair that) {
			// TODO Auto-generated method stub
			return this.wt-that.wt;
		}	
	}
	
	class Solution{
		
	 int spanningTree(int v,ArrayList<ArrayList<ArrayList<Integer>>> adj) {
		 boolean[] vis=new boolean[v];
		 PriorityQueue<Pair> q= new PriorityQueue<>();
		 int ans=0;
		 
		 q.add(new Pair(0,0)); 
		 
		 while(q.size()!=0) {
			 Pair cur=q.remove();
			 int v1=cur.v;
			 if(vis[v1]) {continue;}
			 
			 ans+=cur.wt;
			 vis[v1]=true;
			 
			 ArrayList<ArrayList<Integer>> neighbors=  adj.get(v1);
			 for (ArrayList<Integer> list : neighbors) {
				 int vertex=list.get(0);
				 int wt=list.get(1);
				 if(vis[vertex]==false) {
					 q.add(new Pair(vertex,wt)); 
				 } 			
			}
		 }
         return ans;
		}
	}
}
 