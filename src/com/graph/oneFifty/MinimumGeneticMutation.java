package com.graph.oneFifty;

import java.util.*;

public class MinimumGeneticMutation {
    public static void main(String[] args) {
        MinimumGeneticMutation mgm = new MinimumGeneticMutation();
//        String start = "AACCGGTT";
//        String end = "AACCGGTA";
//        String[] bank = {"AACCGGTA"}; // Output: 1
        

        String start = "AACCGGTT";
        String end = "AAACGGTA";
        String[] bank = {"AACCGGTA","AACCGCTA","AAACGGTA"}; // Output: 2
                
        System.out.println(mgm.minMutation(start, end, bank)); 
    }
    
    public int minMutation(String start, String end, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(end)) return -1;

        char[] genes = {'A', 'C', 'G', 'T'};
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(end)) return level;

                char[] currentArray = current.toCharArray();
                for (int j = 0; j < currentArray.length; j++) {
                    char oldChar = currentArray[j];
                    for (char gene : genes) {
                        if (gene == oldChar) continue;

                        currentArray[j] = gene;
                        String next = new String(currentArray);

                        if (bankSet.contains(next)) {
                            queue.add(next);
                            bankSet.remove(next);
                        }
                    }
                    currentArray[j] = oldChar;
                }
            }
            level++;
        }

        return -1;
    }


}
