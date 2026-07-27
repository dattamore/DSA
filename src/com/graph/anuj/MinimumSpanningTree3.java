package com.graph.anuj;

import java.util.ArrayList;
import java.util.Collections;
//Kruskal's Algorithm
//T : O(ElogE)  S :O(E+V)
public class MinimumSpanningTree3 {

	class Edge implements Comparable<Edge>{
		int src,dest,wt;

		public Edge(int src, int dest, int wt) {
			this.src = src;
			this.dest = dest;
			this.wt = wt;
		}

		@Override
		public int compareTo(Edge that) {
			// TODO Auto-generated method stub
			return this.wt-that.wt;
		}	
	}
	
	class Solution{
		int p[],rank[];

		int find(int x) {
			if(p[x]==x) {return x;}
			return find(p[x]);
		}
		
		void union (int x,int y) {
			int xRoot=find(x);
			int yRoot=find(y);
			
			if(xRoot==yRoot)return; 
			p[yRoot]=xRoot;
		}
		
		int spanningTree(int V,int S,ArrayList<ArrayList<ArrayList<Integer>>> adj) {
			 boolean[][] added=new boolean[V][V];
			 ArrayList<Edge> edges=new ArrayList<>();
			 
			 for (int i = 0; i < adj.size(); i++) {
				 for (int j = 0; j < adj.get(i).size(); j++) {
					 	ArrayList<Integer> cur=adj.get(i).get(j);
					 	
					 	if(!added[i][cur.get(0)]) {
					 		added[i][cur.get(0)] = true;
					 		added[cur.get(0)][i] = true;
					 		edges.add(new Edge(i,cur.get(0),cur.get(1)));
					 	}
						
					}
			}
			 
			p=new int[V];
			
			for (int i = 0; i < V; i++) {
				p[i]=i;			
			}
			
			Collections.sort(edges);
			int count=1;
			int ans=0;
			
			for (int i = 0; count < V; i++) {
				Edge edge=edges.get(i);	
				int rx=find(edge.src);
				int ry=find(edge.dest);
				
				if(rx!=ry) {
					union(rx,ry);
					count++;
					ans+=edge.wt;
				}
			}
		
			return ans; 
		}

	}
	

	
}
