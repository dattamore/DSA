package com.string.oneFifty;

import java.util.*;

//https://www.youtube.com/watch?v=EVHQ48RM5tw
public class SubstringWithConcatenationOfAllWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> findSubstring(String s,String[] words){
		List<Integer> ans= new ArrayList<Integer>();
		int len =words[0].length();
		Map<String,Integer> map=new HashMap<>();
		for (String word : words) {
			map.put(word, map.getOrDefault(word, 0)+1);
		}
		
		for (int i = 0; i <=s.length()-len* words.length; i++) {//len* words.length =3*2=6
			Map<String,Integer> copyMap=new HashMap<>(map);
			
			for (int j = 0; j < words.length; j++) {
				String str=s.substring(i+j*len,i+j*len+len); //check this again
				
				if (copyMap.containsKey(str)) {
					int count=	copyMap.get(str);
					if(count==1)copyMap.remove(str);
					else copyMap.put(str, count-1);
					if(copyMap.isEmpty()) {
						ans.add(i);
						break;
					}
					else {break;}
				}
			}
		}
		return ans;
	}
}
