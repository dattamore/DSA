package com.string.general2;

import java.util.Arrays;
//https://www.youtube.com/watch?v=5QpMpO2CAb0
public class LongestSubstringKRepeatingCharacters {

	public static void main(String[] args) {
		String s = "aaabbebd"; int k = 3;

		System.out.println(longestSubstring(s,k));
	}
    public static int longestSubstring(String s, int k) {
     
    	return helper(s.toCharArray(),0,s.length(),k);
    }
	private static int helper(char[] ch, int start, int end, int k) {
		System.out.println("startc: "+start+" end: "+end);
		if(end-start <k)return 0;
		
		int[] count=new int[26];
		
		for (int i = start; i < end; i++) {
			int value=ch[i]-'a';
			//System.out.println(" value : "+value);
			count[value]++;
		}System.out.println(" : "+Arrays.toString(count));
		
		for (int i = start; i < end; i++) {
		//	System.out.print(" i : "+i);
			int values=ch[i]-'a';
			if(count[ch[i]-'a']<k) {
				int j=i+1;
				System.out.print(" j : "+j);System.out.println(" ");	
				while(j<end && count[ch[j]-'a']<k) {//there could be continuous invalid characters
					j++;
				}	
				System.out.print(" j2 : "+j);System.out.println(" ");
				return Math.max(helper(ch,start,i,k ),helper(ch,j,end,k ) );
			}			
		}				
		return end-start;
	}
}
