package com.linkedList.anuj;

//Detect & Remove Cycle in a Linked List | Floyd's Cycle Detection Algorithm 
public class DetectRemoveCycle {

	public static void main(String[] args) {
		 JavaLinkedList j1=new JavaLinkedList(); 
		 j1.insert(11);j1.insert(12); j1.insert(13);j1.insert(13);j1.insert(12);j1.insert(16);//j1.insert(32); 
		 j1.show();		  
		 Node head= j1.getList();
		 System.out.println("");

	}

	public static Node detectCycleNode(Node head) {	
		
		Node meet= detectCycle( head);
		Node start=head;
	//	Node prev=null;
		while(meet!=start) {
	//		prev=meet;
			meet=meet.next;
			start=start.next;
		}
	//	prev.next=null;
	//	head=prev;
		return start;
	}
	public static Node detectCycle(Node head) {	
		Node fast=head;
		Node slow=head;		
		while(fast!=null && fast.next!=null) {			
			slow=slow.next;
			fast=fast.next.next;
			
			if(slow==fast) {
				return slow;
			}
		}
	 return null;
	}
}
