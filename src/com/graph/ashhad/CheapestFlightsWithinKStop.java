package com.graph.ashhad;

import java.util.Arrays;

//https://www.youtube.com/watch?v=NIrYezLg_6Q
//TC : (k+1)E
public class CheapestFlightsWithinKStop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//BellmanFord
	public int finCheapestPrice(int n,int[][] flights,int src,int dst,int k) {
		 int price[]=new int[n];
		 Arrays.fill(price, Integer.MAX_VALUE);
		 price[src]=0;
		 
		 
		 for (int i = 0; i < k+1; i++) {
			 int temp[]=Arrays.copyOf(price, n); //values
			 for (int flight[] : flights) {
				int u = flight[0];
				int v = flight[1];
				int w = flight[2];
				if(price[u] != Integer.MAX_VALUE && price[u]+w < temp[v]) {
					temp[v]=price[u]+w;
				}
			}
			 price =temp;
		}
		 
		 return price[dst] == Integer.MAX_VALUE?-1:price[dst];
		}
}
