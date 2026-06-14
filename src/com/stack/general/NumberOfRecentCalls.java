package com.stack.general;

import java.util.LinkedList;
import java.util.Queue;

//https://www.youtube.com/watch?v=CRQXGjzGYWI
public class NumberOfRecentCalls {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	Queue<Integer> queue;
	public NumberOfRecentCalls() {
		queue=new LinkedList<>();
	}
	public int ping(int t) {
		if (queue.size()==0) {
			queue.add(t);
			return 1;
		}else {
			if(t<=3000) {
				queue.add(t);
			}else {
				int margin = t-3000;
				while(queue.size()!=0 && queue.peek()<margin) {
					queue.poll();
				}
				queue.add(t);
			}
			return queue.size();
		}
	}
}
