package com.graph.algotutor;
import java.util.*;

//chatgpt
//Time Complexity: O(V+E) Space Complexity:O(V+E)

public class CourseSchedule {
    public static void main(String[] args) {
        CourseSchedule cs = new CourseSchedule();

        // Example 1 
        int numCourses1 = 2;
        int[][] prerequisites1 = {{1, 0}};
        System.out.println(cs.canFinish(numCourses1, prerequisites1)); // Output: true

        // Example 2
        int numCourses2 = 2;
        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        System.out.println(cs.canFinish(numCourses2, prerequisites2)); // Output: false
        
        // Test Case 3: Multiple dependencies (no cycle)
        int numCourses3 = 4;
        int[][] prerequisites3 = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println(cs.canFinish(numCourses3, prerequisites3)); // Output: true

        // Test Case 4: Multiple courses with a cycle
        int numCourses4 = 4;
        int[][] prerequisites4 = {{1, 0}, {2, 0}, {3, 1}, {3, 2}, {1, 3}};
        System.out.println(cs.canFinish(numCourses4, prerequisites4)); // Output: false
    }



	    public boolean canFinish(int numCourses, int[][] prerequisites) {
	        // Create adjacency list
	        List<List<Integer>> graph = new ArrayList<>();
	        for (int i = 0; i < numCourses; i++) {
	            graph.add(new ArrayList<>());
	        }

	        // Array to store in-degrees of nodes
	        int[] inDegree = new int[numCourses];

	        // Build the graph and compute in-degrees
	        for (int[] prerequisite : prerequisites) {
	            int course = prerequisite[0];
	            int pre = prerequisite[1];
	            graph.get(pre).add(course);
	            inDegree[course]++;
	        }

	        // Initialize queue for nodes with 0 in-degree
	        Queue<Integer> queue = new LinkedList<>();
	        for (int i = 0; i < numCourses; i++) {
	            if (inDegree[i] == 0) {
	                queue.add(i);
	            }
	        }

	        // Perform BFS and count visited nodes
	        int visitedCount = 0;
	        while (!queue.isEmpty()) {
	            int current = queue.poll();
	            visitedCount++;

	            // Reduce in-degree for neighbors
	            for (int neighbor : graph.get(current)) {
	                inDegree[neighbor]--;
	                if (inDegree[neighbor] == 0) {
	                    queue.add(neighbor);
	                }
	            }
	        }
	        System.out.println("visitedCount : "+visitedCount +" numCourses : "+numCourses );
	        // If all nodes are visited, we can finish all courses
	        return visitedCount == numCourses;
	    }



}
