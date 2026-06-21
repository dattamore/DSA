package com.linkedList.miscellaneous;


//https://www.youtube.com/watch?v=oDL8vuu2Q0E
public class ReverseLL2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	    public Node reverseBetween(Node head, int left, int right) {
	        if (head == null || left == right)
	            return head;

	        Node dummy = new Node();
	        dummy.next = head;
	        //// make markers for currentnode and for the before reversing
	        Node leftPrev = dummy;
	        Node currNode = head; 
	        for (int i = 0; i < left-1; i++) {
	        	leftPrev = leftPrev.next;
	        	currNode = currNode.next;
	        }
	        //make a marker to node where we start reversing
	        Node subListHead = currNode;
	        Node preNode = null;
	        for (int i = 0; i <= right - left; i++) {
	            Node temp = currNode.next;
	            currNode.next =preNode;
	            preNode = currNode;
	            currNode = temp;
	        }
	        //Join the pieces
	        leftPrev.next= preNode;
	        subListHead.next = currNode;
	        return dummy.next;
	    }
	
}
