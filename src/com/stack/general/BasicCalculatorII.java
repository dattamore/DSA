package com.stack.general;

import java.util.Stack;
//https://www.youtube.com/watch?v=GR8Z1zaQzz0
public class BasicCalculatorII {

	public static void main(String[] args) {
		String s = "3+2*2";
		// String s = " 3/2 ";
		//String s =" 3+5 / 2 ";
		System.out.println(calculate(s));
		

	}
   public static int calculate(String s) {
     
	   if(s==null || s.length()==0)return 0;
	   //Stack<Integer> st=new Stack<>();
	   int curr=0;
	   char op='+';
	   char[] ch=s.toCharArray();
	   int sum=0;
	   int last=0;
	   //"3-2*2"
	   for (int i = 0; i < ch.length; i++) {
		
		   if(Character.isDigit(ch[i])) {
			   curr=curr*10+ch[i]-'0';
		   }		   
		   if(!Character.isDigit(ch[i]) && ch[i]!=' ' || i==ch.length-1) {
			  if(op=='+') {
				  sum+=last;
				  last=curr;
			  }
			  else if(op=='-') {
				  sum+=last;
				  last=-curr;
			  }
			  else if(op=='*') {
				  //st.push(st.pop()*curr);
				  last=last*curr;
			  }
			  else if(op=='/') {
				  //st.push(st.pop()/curr);
				  last=last/curr;
			  }
			  op=ch[i];
			  curr=0;
		   }		   
	     }
	   sum+=last;
	   return sum;
    }
   // understanding : https://www.youtube.com/watch?v=sfM4DjMfhw4
       public int calculate2(String s) {//with stack ..code from chatgpt

           Stack<Integer> stack = new Stack<>();
           int curr = 0;
           char sign = '+'; // previous operator

           for (int i = 0; i < s.length(); i++) {
               char ch = s.charAt(i);
               // build currber
               if (Character.isDigit(ch)) {
                   curr = curr * 10 + (ch - '0');
               }
               // if operator OR end of string
               if ((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1) {
                   if (sign == '+') {
                       stack.push(curr);
                   }
                   else if (sign == '-') {
                       stack.push(-curr);
                   }
                   else if (sign == '*') {
                       stack.push(stack.pop() * curr);
                   }
                   else if (sign == '/') {
                       stack.push(stack.pop() / curr);
                   }
                   sign = ch;
                   curr = 0;
               }
           }
           // sum all values in stack
           int result = 0;
           for (int val : stack) {
               result += val;
           }
           return result;
       }
   
}
