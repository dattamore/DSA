package com.linkedList.miscellaneous;
import com.linkedList.miscellaneous.Node;

//https://www.youtube.com/watch?v=eFPFwwojxGU
public class RemoveDuplicatesSortedList2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public Node deleteDuplicates(Node head) {
		Node dummy =new Node();
		dummy.data=0;
		
		Node prev=dummy;
		Node curr=head;
		while (curr!=null) {
			if (curr.next!=null &&curr.data==curr.next.data) {
				while (curr.next!=null &&curr.data==curr.next.data) {
					curr=curr.next;
				}
				prev.next=curr.next;
			}else {
				prev=prev.next;
			}
			curr=curr.next;
		}
		return dummy.next;
	}
}
