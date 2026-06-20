package com.linkedList.anuj;

//Clone(copy) a Linked List with Next and Random Pointer 
public class CloneLinkedList {

	public static void main(String[] args) {
	

	}	
	
	//insert new elements
	public static Node createDuplicate(Node head) {
		Node curr=head;
		while(curr!=null ) {
			Node temp=curr.next;
			Node n=new Node();
			n.data=curr.data;
			curr.next=n;
			curr.next.next=temp;
			curr=temp;
		}
		curr=head;
		
		//setting random nodes to new nodes
		
		while(curr!=null ) {
			if(curr.next!=null)
				curr.next.random=(curr.random!=null)?curr.random.next:null;
			
			curr=curr.next.next;
		}
		
		
		//Separating both linked lists
		Node orig=head;
		Node copy=head.next;
		Node temp=copy;
		while(orig!=null ) {
			orig.next=orig.next.next;
			copy.next=copy.next.next;
			orig=orig.next;
			copy=copy.next;
		}
		return temp;
	}
}
