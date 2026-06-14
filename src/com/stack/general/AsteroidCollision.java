package com.stack.general;

import java.util.Stack;
//code https://www.youtube.com/watch?v=rHoErvk5ch8
//understanding https://www.youtube.com/watch?v=OtddlksWtS4
public class AsteroidCollision {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] asteroidCollision(int[] asteroids) {
		Stack<Integer> stack=new Stack<>();
		
		for (Integer ast : asteroids) {
			boolean flag=true;
			while(!stack.isEmpty() && ast<0 && stack.peek()>0) {
				if(-ast>stack.peek()) {
					stack.pop();
				}
				else if(-ast<stack.peek()) {
					flag=false;
					break;
				}else {
					flag=false;
					stack.pop();
					break;
				}
			}
			if(flag) {
				stack.push(ast);
			}
		}
		int[] arr=new int[stack.size()];
		for (int i = arr.length-1; i >=0 ; i--) {
			arr[i]=stack.pop();
		}
		return arr;
	}
}
