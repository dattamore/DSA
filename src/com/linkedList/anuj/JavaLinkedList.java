package com.linkedList.anuj;
//reverse is also present:Vimeo
public class JavaLinkedList {

	public JavaLinkedList() {
		// TODO Auto-generated constructor stub
	}
 Node head;
 
 public void insert(int data) { 
	 Node newone =new Node();
	 newone.data=data;
	 newone.next=null;
	 
	 if(head==null) {
		 head=newone;
	 }else{
		 Node n=head;
		 while(n.next!=null) {
			 n=n.next;
		 }
		 n.next=newone;
	 }
	 //System.out.println("valiues : inserted " +data);
 }
 
 public void insertAtStart(int data) {
	 Node newone =new Node();
	 newone.data=data;
	// newone.next=null;
	 newone.next=head;
	 head=newone;
	 
 }
 public void insertAt(int index,int data) {
	 Node newone =new Node();
	 newone.data=data;
	 newone.next=null;
	 Node n  =head;
	 for(int i=0;i<index-1;i++) {
		 n=n.next;
	 }
	 newone.next=n.next;
	 n.next=newone;

 }
 
 public void deleteAt(int index) {

	if(index==0) {
	 head=head.next;
	}else {
	 Node n=head;
	 Node n1=null;
	 for(int i=0;i<index-1;i++) {
		 n=n.next;
	 }
	// n1=n.next;
	// n.next=n1.next;
	 n.next=n.next.next;
	}

 }
 public void show() {
	 Node n=head;
	 
	 while(n.next!=null) {

		 System.out.print(" : "+n.data);
		 n=n.next;
	 }
	 System.out.print(" : "+n.data);
	 System.out.println(" :::: ");
 }
 public void getListShow(Node nn) {
     Node n=nn;
	 
	 while(n.next!=null) {
		 System.out.print(" : "+n.data);
		 n=n.next;
	 }
	 System.out.print("  "+n.data);
	 
}
 public Node getList() {
	 Node n=head;
	 
	return n;
}
}
