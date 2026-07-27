package com.graph.anuj;

import java.util.ArrayList;

//Adjacency Matrix and Adjacency List Graph
public class GraphDataStructure {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int v=5;
		int e=10;
		
		int a[][] = new int[v+1][v+1];
		
		ArrayList<ArrayList<Integer>> adj =new ArrayList<>();
		
		for (int i = 0; i <= v; i++) {
			adj.add(new ArrayList<Integer>());
		}
	}

	static void addEdge(int a[][],int source,int dest) {
		a[source][dest]=1;
		a[dest][source]=1;
	}
	
	static void addEdge(ArrayList<ArrayList<Integer>> adj,int source,int dest) {
		adj.get(source).add(dest);
		adj.get(dest).add(source);
	}
}
