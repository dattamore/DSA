package com.stack.general;

import java.util.*;
//https://www.youtube.com/watch?v=0fRmVjxopiE
public class MaximumFrequencyStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	Map<Integer,Integer> freqMap;
	Map<Integer,Stack<Integer>> freqStack;
	int maxFreq;
	public MaximumFrequencyStack() {
		freqMap =new HashMap<>();
		freqStack =new HashMap<>();
		maxFreq=0;
	}
	
	public void push(int x) {
		int freq=freqMap.getOrDefault(x, 0)+1;
		freqMap.put(x, freq);
		if(freq>maxFreq) maxFreq=freq;
		freqStack.computeIfAbsent(freq, f->new Stack()).push(x);
	}
	public int pop() {
		Stack<Integer> s=freqStack.get(maxFreq);
		int top =s.pop();
		if(s.isEmpty())maxFreq--;
		freqMap.put(top, freqMap.get(top)-1);
		return top;
	}
}
