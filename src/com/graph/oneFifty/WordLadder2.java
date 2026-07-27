package com.graph.oneFifty;
import java.util.*;
//TC : O(N*M2*26)
public class WordLadder2 {

	public static void main(String[] args) {
		 WordLadder2 wl = new WordLadder2();
	        String beginWord = "hit";
	        String endWord = "cog";
	        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

	        System.out.println(wl.ladderLength(beginWord, endWord, wordList)); // Output: 5

	}
	
	public List<List<String>> ladderLength(String beginWord,String endWord,List<String> wordList) {
		
		HashSet<String> set=new HashSet<>(wordList);
		List<List<String>> res = new ArrayList<>();
		if(!set.contains(endWord)) {
			return res;
		}
		List<String> dummy = new ArrayList<>();
		dummy.add(beginWord);
		
		Queue<List<String>> queue = new LinkedList<>();
		queue.offer(dummy);
		if(set.contains(beginWord)) {
			set.remove(beginWord);
		}
		int level=0;
		int resLevel=-1;
		while(!queue.isEmpty()) {
			HashSet<String> useWords=new HashSet<>();
			int curLevelSize=queue.size();
			
			for (int i = 0; i < curLevelSize; i++) {
				List<String> nodeList =queue.poll();
				String node = nodeList.get(nodeList.size()-1);
				if(node.contentEquals(endWord)) {
					resLevel= level;
					res.add(nodeList);
				//	break;
				}
				
				List<String> neighbours=getNeighbours(node,set);
				for (String word : neighbours) {
					if(set.contains(word)) {
						nodeList.add(word);
						queue.offer(new ArrayList<>(nodeList));
						nodeList.remove(word);
						useWords.add(word);
						
					
					}
				}
			}
//			for (String visited : useWords) {
//				set.remove(visited);
//			}
//			if(level==resLevel) {break;}  //it is not needed in this example,needed when: endword is not in the last
			                                 // added break on line no 43 ,it works
			level++;
		}
		return res;
	}
	
	public List<String> getNeighbours(String word, HashSet<String> set){
		List<String> neighbours=new ArrayList<>();
		for (int i = 0; i < word.length(); i++) {
			for (char ch = 'a'; ch <= 'z'; ch++) {
				if(ch==word.charAt(i)) {
					continue;
				}
				String newWord = word.substring(0,i)+ch+word.substring(i+1,word.length());
				
			    if(set.contains(newWord)) {
			    	neighbours.add(newWord);
			    }
			}
		}
		return neighbours;
	}
}
