package com.string.general2;

import java.util.Arrays;
//understanding : https://www.youtube.com/watch?v=wtOQaovlvhY&t=197s
public class LongestCommonPrefix {

	public static void main(String[] args) {
		String[] strs = {"flower","flow","flight"};
		
	String s=	longestPrefix(strs);
	System.out.println(" : "+s);
	}

	private static String longestPrefix(String[] strs) {
		
		System.out.println(" : "+Arrays.deepToString(strs));
		Arrays.sort(strs);
		System.out.println(" : "+Arrays.deepToString(strs));
		String str1=strs[0];
		String str2=strs[strs.length-1];
		System.out.println("str1 : "+str1+" str2 : "+str2);
		int index=0;
		while(index <str1.length() && index <str2.length()) {
			
			if(str1.charAt(index)==str2.charAt(index)) {
				index++;
			}else {break;}
		}
		return str2.substring(0,index);
	}

}
