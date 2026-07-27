package com.graph.miscellaneous;
import java.util.*;

import com.graph.anuj.MinimumSpanningTree2;
public class NetworkDelayTime {

	MinimumSpanningTree2 tree = new MinimumSpanningTree2();
	MinimumSpanningTree2.Solution sol = tree.new Solution();

	public static void main(String[] args) {
		NetworkDelayTime sol = new NetworkDelayTime();
        int[][] times = {
            {2, 1, 1},
            {2, 3, 1},
            {3, 4, 1}
        };
        int n = 4;
        int k = 2;
        System.out.println(sol.networkDelayTime(times, n, k)); // Output: 2

	}

	 public int networkDelayTime(int[][] times, int n, int k) {
	    ArrayList<ArrayList<int[]>>   adj=new ArrayList<>(); 
	    for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<>());
		}
	    
	    for (int[] time : times) {
			int u=time[0]-1;
			int s=time[1]-1;
			int w=time[2];
			adj.get(u).add(new int[] {s,w});
		}
	    int minTime[] =dijkstra(n,k-1,adj);

	    int res = Integer.MIN_VALUE;
	    for (int time : minTime) {
			res=Math.max(res, time);
		}
	    return res==Integer.MIN_VALUE?-1:res;
	 }
	 
	   public int[] dijkstra(int n, int source, ArrayList<ArrayList<int[]>> adj) {
	        int[] dist = new int[n];
	        Arrays.fill(dist, Integer.MAX_VALUE);
	        dist[source] = 0;

	        PriorityQueue<Pair> pq = new PriorityQueue<>();
	        pq.add(new Pair(source, 0));

	        while (!pq.isEmpty()) { //same  : => !(pq.size() == 0)
	            Pair current = pq.poll();
	            int s1 = current.s;

	            for (int[] neighbor : adj.get(s1)) {
	                int nextNode = neighbor[0];
	                int wt = neighbor[1];

	                if (dist[s1] + wt < dist[nextNode]) {
	                    dist[nextNode] = dist[s1] + wt;
	                    pq.add(new Pair(nextNode, dist[nextNode]));
	                }
	            }
	        }
	        return dist;
	    }

	    class Pair implements Comparable<Pair> {
	        int s;
	        int wt;

	        Pair(int s, int wt) {
	            this.s = s;
	            this.wt = wt;
	        }

//	        @Override
//	        public int compareTo(Pair other) {
//	            return Integer.compare(this.wt, other.wt);
//	        }
			@Override
			public int compareTo(Pair that) {
				// TODO Auto-generated method stub
				return this.wt-that.wt;
			}
	    }
}



//MinimumSpanningTree2 tree = new MinimumSpanningTree2();
//MinimumSpanningTree2.Solution sol = tree.new Solution();

//ArrayList<ArrayList<ArrayList<Integer>>> adj2=sol.convert(n, times);
//int minTime[] =sol.spanningTree(n,k,adj2);
