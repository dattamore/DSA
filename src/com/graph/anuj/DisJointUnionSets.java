package com.graph.anuj;

public class DisJointUnionSets {

int[] rank,parent;
int n;

public DisJointUnionSets( int n) {
	this.rank = new int[n];
	this.parent = new int[n];
	this.n = n;
	for (int i = 0; i < n; i++) {
		parent[i]=i;
	}
}

public int find(int x) {
	if(parent[x]==x) {return x;}
	//if(parent[x]==x) {return find(parent[x]);} //pathcompression
	return find(parent[x]);
	//return parent[x]; //pathcompression
}

public void union (int x,int y) {
	int xRoot=find(x);
	int yRoot=find(y);
	
	if(xRoot==yRoot)return; 
	
	if(rank[xRoot] < rank[yRoot]) {
		parent[xRoot]= yRoot;
		
	}else if(rank[yRoot] < rank[xRoot]) {
		parent[yRoot]= xRoot;
		
	}else {
		parent[yRoot]= xRoot;
		rank[yRoot] = rank[yRoot]+1;
	}
	
}

//for MakeNetworkConnected class
public boolean unionBySize (int x,int y) {
	int xRoot=find(x);
	int yRoot=find(y);
	
	if(xRoot==yRoot)return false; 
	
	if(rank[xRoot] < rank[yRoot]) {
		parent[xRoot]= yRoot;
		
	}else if(rank[yRoot] < rank[xRoot]) {
		parent[yRoot]= xRoot;
		
	}else {
		parent[yRoot]= xRoot;
		rank[yRoot] = rank[yRoot]+1;
	}
	return true; 
}

}
