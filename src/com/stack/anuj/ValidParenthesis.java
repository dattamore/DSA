package com.stack.anuj;
import java.util.Stack;
import java.util.Vector;

//code online : https://www.geeksforgeeks.org/dsa/check-for-balanced-parentheses-in-an-expression/
public class ValidParenthesis {

	    public static boolean isBalanced(String s) {	       
	        Stack<Character> st = new Stack<>();      
	        for (char c : s.toCharArray()) {
	            if (c == '(' || c == '{' || c == '[') {//open
	                st.push(c);
	            }
	            else if (c == ')' || c == '}' || c == ']') {//close	                
	                // No opening bracket
	                if (st.isEmpty()) return false; 
	                char top = st.peek();
	                if ((c == ')' && top != '(') ||
	                    (c == '}' && top != '{') ||
	                    (c == ']' && top != '[')) {
	                    return false;
	                }                
	                // Pop matching opening bracket
	                st.pop(); 
	            }
	        }
	        // Balanced if stack is empty
	        return st.isEmpty(); 
	    }

	
}
