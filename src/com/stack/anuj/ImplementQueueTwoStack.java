package com.stack.anuj;

import java.util.Stack;

public class ImplementQueueTwoStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	Stack s1;
	Stack s2;
	
	void push(int data) {
		s1.push(data);
	}
	
	int pop() {
		while(!s1.empty()) {
			s2.push(s1.pop());
		}
		int ans =(int)s2.pop(); //s2.peek();
		
		while(!s2.isEmpty()) {
			s1.push(s2.pop());
		}
		return ans;
	}
}
