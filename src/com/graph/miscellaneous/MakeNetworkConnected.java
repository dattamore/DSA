package com.graph.miscellaneous;
import java.util.*;

import com.graph.anuj.DisJointUnionSets;

//https://www.youtube.com/watch?v=Gn6ZlaLIDjY&list=PLQ7ZAf76c0ZOGuMjg3qwNgILb_dKWTxyQ&index=34&t=1s
public class MakeNetworkConnected {
	
	public static void main(String[] args) {
		MakeNetworkConnected sol = new MakeNetworkConnected();
//	        int n = 6;
//	        int[][] connections = {{0,1},{0,2},{0,3},{1,2},{1,3}};  //2
	        
	        int n = 6;
	        int[][] connections = {{0,1},{0,2},{0,3},{1,2}};//-1
	        System.out.println(sol.makeConnected(n, connections)); 

	}
	
	public int makeConnected(int n, int[][] connections) {
		 System.out.println(" connections.length : "+connections.length);
	      if(connections.length < n-1) {
	    	  return -1;
	      }  
	      DisJointUnionSets dsu =new DisJointUnionSets(n);
	      int wires=0;
	      for (int[] connection : connections) {
	    	  int u=connection[0];
	    	  int v=connection[1];
	    	  if(dsu.unionBySize(u, v)) {
	    		  System.out.println(" u : "+u+" v : "+v);
	    		  wires++;
	    	  }
		}
	  
	   return n-1-wires;
	}

}
