package com.graph.miscellaneous;
import java.util.*;


//https://www.youtube.com/watch?v=2gtg3VsDGyc&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=26
//TC same as topo sort..plus sorting
public class EventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> reverseGraph = new ArrayList<>();
        int[] inDegree = new int[n];
        
        // Initialize reverseGraph and inDegree
        for (int i = 0; i < n; i++) {
            reverseGraph.add(new ArrayList<>());
        }
        
        // Build reverse graph and calculate in-degrees
        for (int i = 0; i < n; i++) {
            for (int neighbor : graph[i]) {
                reverseGraph.get(neighbor).add(i);
                inDegree[i]++;
            }
        }
        
//     // Iterate through the reverseGraph and print the nodes
//        for (int i = 0; i < reverseGraph.size(); i++) {
//            System.out.print("Node " + i + " has edges to: ");
//            for (int neighbor : reverseGraph.get(i)) {
//                System.out.print(neighbor + " ");
//            }
//            System.out.println();
//        }
        
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        
        // Start with nodes having in-degree 0 (safe nodes)
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        // Process nodes in topological order
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);
            
            for (int neighbor : reverseGraph.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        Collections.sort(result); // Sort result to match the problem's requirements
        return result;
    }

    public static void main(String[] args) {
    	EventualSafeStates sol = new EventualSafeStates();
        int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};
        System.out.println(sol.eventualSafeNodes(graph)); // Output: [2, 4, 5, 6]
    }
}

