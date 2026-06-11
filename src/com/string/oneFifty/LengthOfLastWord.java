package com.string.oneFifty;
//https://www.youtube.com/watch?v=0vlc5ttPftY
public class LengthOfLastWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int lenthofLastWord(String s) {
		int count=0;
		for (int i = s.length()-1; i >=0; i--) {
			if (s.charAt(i)!=' ') {
				count++;
			}else {
				
				if(count>0) {
					return count;
				}
			}
		}
		return count;
	}
}
