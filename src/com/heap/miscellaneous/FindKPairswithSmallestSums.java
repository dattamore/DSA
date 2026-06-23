package com.heap.miscellaneous;
import java.util.*;

import javax.swing.text.html.parser.Element;

//understanding https://www.youtube.com/watch?v=o_eBSdgYfbc
//chatgpt
public class FindKPairswithSmallestSums {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {1,7,11};
		int[] nums2 = {2,4,6}; 
		int k = 3;
		FindKPairswithSmallestSums find=new FindKPairswithSmallestSums();
		System.out.println(find.kSmallestPairs(nums1,nums2,k));
	}
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> result = new ArrayList<>();
        if(nums1.length == 0 || nums2.length == 0) {
            return result;
        }
        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a,b) ->
                (nums1[a[0]] + nums2[a[1]]) -
                (nums1[b[0]] + nums2[b[1]])
            );
        // push first column
        for(int i=0; i<nums1.length && i<k; i++){
            pq.offer(new int[]{i,0});
        }
        // for (int[] e : pq) {// System.out.println(e[0]+" --- "+e[1]);}
        while(k > 0 && !pq.isEmpty()){

            int[] pair = pq.poll();
            int i = pair[0];
            int j = pair[1];
            result.add(Arrays.asList(nums1[i], nums2[j]));

            if(j + 1 < nums2.length){
                pq.offer(new int[]{i, j+1});
            }
            k--;
        }
        return result;
    }
	
}
//line no :48
//Common Interview Follow-up
//Interviewer often asks:
//Why only push (i, j+1) and not (i+1, j)?
//Because (i+1,0) is already inserted initially.
//So we avoid duplicates.
