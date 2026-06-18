package com.stack.anuj;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Stack;

///Largest Rectangular in Histogram | Maximum Rectangular Area in a Histogram
public class LargestRectangularHistogram {

	public static void main(String[] args) {
		// int a[]= {3,10,5,1,15,10,7,6};
		// int a[]= {4,2,1,5,6,3,2,4,2}; 
		int a[]= {2,1,5,6,2,3}; //10  ////-1 -1 1 2 1 4
	//	int a[]= {2,4};//4
		System.out.println("MAXX : "+ maxElement(a));
	//	System.out.println("MAXX : "+ largestRectangleArea(a));
	}

	public static int largestRectangleArea(int[] a) {
        int n = a.length;

      //  ArrayDeque<Integer> st1 = new ArrayDeque<>();
      //  ArrayDeque<Integer> st2 = new ArrayDeque<>();
        
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();

        int left[] = new int[n];
        int right[] = new int[n];

        //previous smaller element
        for(int i = 0; i < n; i++){
            while(!st1.isEmpty() && a[st1.peek()] >  a[i])
                st1.pop();

            if(st1.isEmpty())
                left[i] = -1;
            else 
                left[i] = st1.peek();

            st1.push(i);            
        }
        System.out.println(" "+Arrays.toString(left));
        //next greater element
        for(int i = n-1; i >= 0; i--){
            while(!st2.isEmpty() && a[st2.peek()] >= a[i])
                st2.pop();
            if(st2.isEmpty())
                right[i] = n;
            else 
                right[i] = st2.peek();

            st2.push(i);            
        }
        System.out.println(" "+Arrays.toString(right));
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            int sum = (right[i] - left[i] - 1) * a[i];
            max = Math.max(max, sum); 
        }
        return max;          
    }
	
	public static int maxElement(int[] a) {
		
		 int p[]= previousSmallerElement(a);
		 int n[]= nextSmallerElement(a);
		 int maxArea=1;
		 
		 for (int i = 0; i < a.length; i++) {	
			int curr=( n[i]-p[i] -1)*a[i];
			System.out.println(" curr : "+curr);
			maxArea=Math.max(maxArea, curr);
		 }
		 return maxArea;
	}
	
	
	private static int[] previousSmallerElement(int[] a) {
		Stack<Integer> stack=new Stack<>();
		int newArray[]=new int[a.length];
		
		 for (int i = 0; i < a.length; i++) {		 
			 while(!(stack.isEmpty()) && a[stack.peek()]>a[i]) {				 
				 stack.pop();			 				 
			 }
			 if(stack.isEmpty()) {
				 System.out.print(" -1");
				 newArray[i]=-1;
			//	 stack.push(-1); 
			//	 continue;
			 }else {
			 System.out.print(" "+stack.peek());
			 newArray[i]=stack.peek();}
			 stack.push(i); 			 
			}	
		 return newArray;
	}
	
	private static int[] nextSmallerElement(int[] a) {
		Stack<Integer> stack=new Stack<>();
	
		int newArray[]=new int[a.length];
		
		 for (int i = a.length-1; i >=0 ; i--) {		 
			 while(!(stack.isEmpty()) && a[stack.peek()]>=a[i]) {				 
				 stack.pop();			 				 
			 }
			 if(stack.isEmpty()) {
				// System.out.print(" -1");
				 newArray[i]=a.length;
				// stack.push(-1); 
				 
				// continue;
			 }else {
			// System.out.print(" "+stack.peek());
			 newArray[i]=stack.peek();}
			 stack.push(i); 			 
			}		
		 System.out.println(" ");
		 System.out.println(" "+Arrays.toString(newArray));
		 return newArray;
	}
}
