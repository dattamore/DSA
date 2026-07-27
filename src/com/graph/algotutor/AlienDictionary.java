 package com.graph.algotutor;
 import java.util.*;
 //https://www.youtube.com/watch?v=ef95J3BNbls
public class AlienDictionary {

	public static void main(String[] args) {
        AlienDictionary solution = new AlienDictionary();
        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
        System.out.println(solution.alienOrder(words)); // Output: "wertf"

	}

	public String alienOrder(String[] words) {
		Map<Character,Set<Character>> map=new HashMap<>();
		int[] inDegree =new int[26];
		buildMap(words,map,inDegree);
		return bfs(map,inDegree);
	}
	private void buildMap(String[] words, Map<Character, Set<Character>> map, int[] inDegree) {
		for (String s : words) {
			for (char c : s.toCharArray()) {
				map.putIfAbsent(c, new HashSet<>());
			}
		}
		
		for (int i = 1; i < words.length; i++) {
			String first=words[i-1];
			String second=words[i];
			
			if(first.length()>second.length() && first.startsWith(second)) {
				map.clear();
				return;
			}
			
			for (int j = 0; j < first.length(); j++) {
				char key=first.charAt(j);
				char value=second.charAt(j);
				if(key !=value) {
					if(!map.get(key).contains(value)) {
						inDegree[value - 'a']++ ;
						map.get(key).add(value);
					}
					break;
				}
			}
		}
		
	}

	private String bfs(Map<Character, Set<Character>> map, int[] inDegree) {
		StringBuilder sb =new StringBuilder();
		
		 Queue<Character> queue = new LinkedList<>();
	        for (char c:map.keySet()) {
	            if (inDegree[c-'a'] == 0) {
	                queue.add(c);
	            }
	        }
  
	        while (!queue.isEmpty()) {
	        	char c= queue.poll();
	        	 sb.append(c);
	            // Reduce in-degree for neighbors
	            for (char nextC:map.get(c)) {
	                inDegree[nextC-'a']--;
	                if (inDegree[nextC-'a'] == 0) {
	                    queue.add(nextC);
	                   
	                }
	            }
	        }
		return sb.length() == map.size()?sb.toString(): "";
	}


}
