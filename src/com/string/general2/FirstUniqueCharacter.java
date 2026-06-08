package com.string.general2;

//https://youtube.com/watch?v=_fFOfmJn298
public class FirstUniqueCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static int firstUniqueCharacter(String s) {
		int[] freq =new int[26];
		char[] chars=s.toCharArray();
		for (char c : chars) {
			freq[c-'a']++;
		}
		int i=0;
		for (; i < chars.length; i++) {
			if(freq[chars[i]-'a']==1) {
				return i;
			}
		}
		return i;
	}
}
