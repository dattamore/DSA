package com.heap.lovebabbarAyushi;

import java.util.PriorityQueue;

import com.linkedList.lovebabbarAyushi.Node;

public class MergeKSortedLists {

	public Node mergeKLists(Node[] lists) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>((a,b) -> a.data - b.data);
        // only head pointer of all lists are added
        for(Node l : lists){
        	getListShowMerge(l);
            if(l!=null){
                pq.add(l);
            }        
        }
        Node head = new Node(); 
       
        Node point = head;
       
        while(!pq.isEmpty()){ 
            point.next = pq.poll();
            System.out.println("****");
            getListShowMerge(point);
            point = point.next; 
            if(point.next!=null){
                pq.add(point.next); // add next of current smallest  
            }
        }
        return head.next;
    }
	
	public static void getListShowMerge(Node nn) {
	     Node n=nn;
		 
		 while(n.next!=null) {
			 System.out.print(" : "+n.data);
			 n=n.next;
		 }
		 System.out.print("  "+n.data);
		 System.out.println("  ");
		 
	}
}
