package com.graph.algotutor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

//https://www.youtube.com/watch?v=0m_eIw_XW9c&list=PLJtzaiEpVo2yylm7sGxX8GItvhB2oklg-&index=2
//Time complexity : O(V+E)
public class CloneGraph {

	public static void main(String[] args) {

	        // Example to create a sample graph
	        Node node1 = new Node(1);
	        Node node2 = new Node(2);
	        Node node3 = new Node(3);
	        Node node4 = new Node(4);

	        node1.neighbors.add(node2);
	        node1.neighbors.add(node4);

	        node2.neighbors.add(node1);
	        node2.neighbors.add(node3);

	        node3.neighbors.add(node2);
	        node3.neighbors.add(node4);

	        node4.neighbors.add(node1);
	        node4.neighbors.add(node3);

	        Node clonedGraph = clone(node1);

	        // Print the cloned graph (to verify correctness)
	        printGraph(clonedGraph);


	}
	static HashMap<Node,Node> map=new HashMap<>();
	   
	public static Node clone(Node node) {
		
		if(node==null)return  null;
		Node newNode=new Node(node.val);
		
		
		map.put(node, newNode);
		for (Node n : node.neighbors) {
			if(map.containsKey(n)){
				newNode.neighbors.add(map.get(n));
			}else {
				newNode.neighbors.add(clone(n));
			}
		}
		
		return newNode;
	}
	
	 public static void printGraph(Node node) {///chatgpt 
		    if (node == null) {
		        System.out.println("Graph is empty.");
		        return;
		    }

		    // Use a set to avoid re-visiting nodes
		    Set<Integer> visited = new HashSet<>();
		    Queue<Node> queue = new LinkedList<>();
		    queue.add(node);

		    System.out.println("Graph:");
		    while (!queue.isEmpty()) {
		        Node current = queue.poll();

		        // Skip nodes that have already been printed
		        if (visited.contains(current.val)) {
		            continue;
		        }

		        // Mark the current node as visited
		        visited.add(current.val);

		        // Print the current node and its neighbors
		        System.out.print("Node " + current.val + " neighbors: ");
		        for (Node neighbor : current.neighbors) {
		            System.out.print(neighbor.val + " ");
		            queue.add(neighbor); // Add neighbors to the queue for processing
		        }
		        System.out.println();
		    }
		}
}

//Definition for a Node.
class Node {
 public int val;
 public List<Node> neighbors;

 public Node() {
     val = 0;
     neighbors = new ArrayList<Node>();
 }

 public Node(int _val) {
     val = _val;
     neighbors = new ArrayList<Node>();
 }

 public Node(int _val, ArrayList<Node> _neighbors) {
     val = _val;
     neighbors = _neighbors;
 }

}
