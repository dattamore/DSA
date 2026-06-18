package com.stack.anuj;

import java.util.Queue;

public class ImplementStackTwoQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	Queue q1;
	Queue q2;
	
	void push(int data) {
		while(!q1.isEmpty()) {
			q2.add(q1.poll());
		}
		q1.add(data);
		
		while(!q2.isEmpty()) {
			q1.add(q2.poll());
		}
	}
	
	int pop() {
		return (int)q1.poll();
	}
}
