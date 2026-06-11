package com.string.oneFifty;
//https://www.youtube.com/watch?v=5tkofg3RXOg
public class RansomNote {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	boolean canConstruct(String ransomNote,String magazine) {
		int[] charCount=new int[26];
		
		for (char c : magazine.toCharArray()) {
			charCount[c-'a']++;
		}
		
		for (char c  : ransomNote.toCharArray()) {
			if (charCount[c-'a']==0) {
				return false;
			}
			charCount[c-'a']--;
		}
		return true;      
	}
}
