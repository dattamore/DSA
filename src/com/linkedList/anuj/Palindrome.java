package com.linkedList.anuj;

public class Palindrome {

	public static void main(String[] args) {

		 JavaLinkedList j1=new JavaLinkedList(); 
		 j1.insert(11);j1.insert(12); j1.insert(13);j1.insert(13);j1.insert(12);j1.insert(16);//j1.insert(32); 
		 j1.show();		  
		 Node head= j1.getList();
		 System.out.println(isPalindrome(head));		 
	}
	 public static boolean isPalindrome(Node head) {		
		 Node mid=findMiddle(head);
		 Node last=reverse(mid.next);
		 //j1.getListShow();
		 while(last!=null) {			 
			 if(head.data!=last.data) {
				 return false;
			 }
			 head=head.next;
			 last=last.next;
		 }		 
		 return true;
	 }

    public static Node reverse(Node head) {		
		Node curr=head;
		Node prev=null;
		while(curr!=null) {
			Node temp=curr.next;
			curr.next=prev;
			prev=curr;
			curr=temp;
		}		
		return prev;
	}
	public static Node findMiddle(Node head) {	
		Node slow=head;
		Node fast=head;
		while(fast!=null && fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}
		
		return slow;
	}
}
