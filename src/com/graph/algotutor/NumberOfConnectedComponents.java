package com.graph.algotutor;

//chatgpt
public class NumberOfConnectedComponents {
    
    public static void main(String[] args) {
        NumberOfConnectedComponents solution = new NumberOfConnectedComponents();
        int n = 5;
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
        
        System.out.println(solution.countComponents(n, edges)); // Output: 2
    }
    
    public int countComponents(int n, int[][] edges) {
        // Initialize parent and rank arrays
        int[] parent = new int[n];
        int[] rank = new int[n];
        
        // Initially, each node is its own parent
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1; // All nodes start with rank 1
        }
        
        // Perform union operations for each edge
        for (int[] edge : edges) {
        	System.out.println("edge[0] : "+edge[0]+ " edge[1] : "+edge[1]);
            union(parent, rank, edge[0], edge[1]);
        }
        
        // Count unique components by finding distinct roots
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (find(parent, i) == i) {
                components++;
            }
        }
        
        return components;
    }
    
    private int find(int[] parent, int node) {
        if (parent[node] != node) {
            // Path compression: make the parent of the node its root
            parent[node] = find(parent, parent[node]);
        }
        return parent[node];
    }
    
    private void union(int[] parent, int[] rank, int node1, int node2) {
        int root1 = find(parent, node1);
        int root2 = find(parent, node2);
        
        if (root1 != root2) {
            // Union by rank: attach smaller tree under larger tree
            if (rank[root1] > rank[root2]) {
                parent[root2] = root1;
            } else if (rank[root1] < rank[root2]) {
                parent[root1] = root2;
            } else {
                parent[root2] = root1;
                rank[root1]++;
            }
        }
    }

}

