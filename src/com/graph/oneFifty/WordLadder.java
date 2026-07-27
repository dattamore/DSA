package com.graph.oneFifty;
import java.util.*;

public class WordLadder {

	public static void main(String[] args) {
		 WordLadder wl = new WordLadder();
	        String beginWord = "hit";
	        String endWord = "cog";
	        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

	        System.out.println(wl.ladderLength(beginWord, endWord, wordList)); // Output: 5

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
	
	public int ladderLength(String beginWord,String endWord,List<String> wordList) {
		
		HashSet<String> set=new HashSet<>(wordList);
		if(!set.contains(endWord)) {
			return 0;
		}
		Queue<String> queue = new LinkedList<>();
		queue.offer(beginWord);
		if(set.contains(beginWord)) {
			set.remove(beginWord);
		}
		int level=0;
		while(!queue.isEmpty()) {
			int curLevelSize=queue.size();
			
			for (int i = 0; i < curLevelSize; i++) {
				String node =queue.poll();
				if(node.contentEquals(endWord)) {
					return level+1;
				}
				
				List<String> neighbours=getNeighbours(node,set);
				for (String word : neighbours) {
					if(set.contains(word)) {
						queue.offer(word);
						set.remove(word);
					}
				}
			}
			level++;
		}
		return 0;
	}
}
