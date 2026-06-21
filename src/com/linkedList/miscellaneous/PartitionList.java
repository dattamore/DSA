package com.linkedList.miscellaneous;

//https://www.youtube.com/watch?v=b4FeEwAGDtU
public class PartitionList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Node partition(Node head,int x) {
		Node small =new Node();
		Node higher =new Node();
		Node smallHead=small;
		Node higherHead=higher;
		
		while(head!=null) {
			if(head.data<x) {
				smallHead.next =head;
				smallHead=smallHead.next;
			}else {
				higherHead.next =head;
				higherHead=higherHead.next;
			}
			head=head.next;
		}
		higherHead.next=null;
		smallHead.next =higher.next;
		
		return small.next;
	}
}
