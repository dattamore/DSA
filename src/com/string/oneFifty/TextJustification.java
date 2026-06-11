package com.string.oneFifty;

import java.util.*;

//https://www.youtube.com/watch?v=jpU2LVaDa4g
public class TextJustification {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
//https://github.com/MAZHARMIK/Interview_DS_Algo/blob/master/strings/Text%20Justification.cpp
	 int MAX_WIDTH;
	public List<String> fullJustify(String[] words,int maxWidth){
		List<String> result=new ArrayList<>();
		int n=words.length;
		MAX_WIDTH =maxWidth;
		int i=0;
		while (i<n) {
			int lettersCount=words[i].length();
			int j=i+1;
			int spaceSlots=0;
			while (j<n && spaceSlots+lettersCount+words[i].length()+1<=maxWidth) {
				lettersCount+=words[j].length();
				spaceSlots+=1;
				j++;
			}
			int remainingSlots=maxWidth-lettersCount;
			
			int eachWordSpace=spaceSlots==0?0:remainingSlots/spaceSlots;
			int extraSpace=spaceSlots==0?0:remainingSlots%spaceSlots;
			while (j==n) {
				 eachWordSpace=1;
				 extraSpace=0;
			}
			result.add(getFinalWord(i,j,eachWordSpace,extraSpace,words));//every line
			i=j;
		}
		return result;
	}
	private String getFinalWord(int i, int j, int eachWordSpace, int extraSpace, String[] words) {
		StringBuilder s=new StringBuilder();
		for (int k = i; k < j; k++) {
			s.append(words[k]);
			if (k==j-1) {break;}//no space after last word of line
			
			for (int space = 1; space <=eachWordSpace; space++) {
				s.append(" ");
			}
			if(extraSpace>0) {
				s.append(" ");
				extraSpace--;
			}
		}
		while (s.length()<MAX_WIDTH) {//if no word left
			s.append(" ");
		}
		return s.toString();
	}
	
}
