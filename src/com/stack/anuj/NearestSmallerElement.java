     package com.stack.anuj;

import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    // int a[]= {4,10,5,8,20,15,3,12};
    // int a[]= {3,10,5,1,15,10,7,6};
     int a[]= {2,1,5,6,2,3};  //-1 -1 1 2 1 4
    
     previousSmallerElement(a);//left
   //  previousGreaterElement(a);//left
     
    
  //   nextGreaterElement(a);//right
   //  nextSmallerElement(a);//right
	}

	private static void nextGreaterElement(int[] a) {
		Stack<Integer> stack=new Stack<>();
	
		int newArray[]=new int[a.length];
		
		 for (int i = a.length-1; i >=0 ; i--) {		 
			 while(!(stack.isEmpty()) && stack.peek()<a[i]) {				 
				 stack.pop();			 				 
			 }
			 if(stack.isEmpty()) {
			//	 System.out.print(" -1");
				 newArray[i]=-1;
				 stack.push(a[i]); 
				 
				 continue;
			 }
			// System.out.print(" "+stack.peek());
			 newArray[i]=stack.peek();
			 stack.push(a[i]); 			 
			}		
		 System.out.println(" ");
		 System.out.println(" "+Arrays.toString(newArray));
	}
	private static void nextSmallerElement(int[] a) {
		Stack<Integer> stack=new Stack<>();
	
		int newArray[]=new int[a.length];
		
		 for (int i = a.length-1; i >=0 ; i--) {		 
			 while(!(stack.isEmpty()) && stack.peek()>a[i]) {				 
				 stack.pop();			 				 
			 }
			 if(stack.isEmpty()) {
				// System.out.print(" -1");
				 newArray[i]=-1;
				 stack.push(a[i]); 
				 
				 continue;
			 }
			// System.out.print(" "+stack.peek());
			 newArray[i]=stack.peek();
			 stack.push(a[i]); 			 
			}		
		 System.out.println(" ");
		 System.out.println(" "+Arrays.toString(newArray));
	}
	private static void previousGreaterElement(int[] a) {
		Stack<Integer> stack=new Stack<>();
		for (int i = 0; i < a.length; i++) {		 
			 while(!(stack.isEmpty()) && stack.peek()<a[i]) {				 
				 stack.pop();				 				 
			 }
			 if(stack.isEmpty()) {
				 System.out.print(" -1");
				 stack.push(a[i]); 
				 continue;
			 }
			 System.out.print(" "+stack.peek());
			 stack.push(a[i]); 			 
			}		
	}

	private static void previousSmallerElement(int[] a) {
		Stack<Integer> stack=new Stack<>();
		
		 for (int i = 0; i < a.length; i++) {		 
			 while(!(stack.isEmpty()) && stack.peek()>a[i]) {	//a[i]	< stack.peek() ..curr elem is smaller 
				 stack.pop();			 				 
			 }
			 if(stack.isEmpty()) {
				 System.out.print(" -1");
				 stack.push(a[i]); 
				 continue;
			 }
			 System.out.print(" "+stack.peek());
			 stack.push(a[i]); 			 
			}		
	}

}
