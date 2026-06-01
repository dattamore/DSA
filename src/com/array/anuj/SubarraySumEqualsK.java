package com.array.anuj;

import java.util.HashMap;
import java.util.Map;
//https://www.youtube.com/watch?v=XzwUBIkR9pA&t=320s
public class SubarraySumEqualsK {

	public static void main(String[] args) {
		//int[] nums = {1,1,1}; //2
		//int[] nums = {10,15,-5,15,-10,5};//5
		int[] nums = {3,4,7,2,-3,1,4,2};
		int k = 7;
		System.out.println(subarraySum(nums,k));
	}

	 public static int subarraySum(int[] nums, int k) {
	     int count=0;
	     int target=k;
	     int currSum=0;
	     int start=0;
	     int end=0;
	     Map<Integer,Integer> map=new HashMap<>();
	     
	     for (int i = 0; i < nums.length; i++) {
	    	 currSum=currSum+nums[i];
	    	 System.out.println(" currSum-sum : "+(currSum-target));
	    	 if(currSum-target==0) {
	    		 start=0;end=i;count++;
	    		 System.out.println("1start : "+nums[start]+" end :"+ nums[i]);
	    	 }	    	 
	    	 
	    	 if(map.containsKey(currSum-target)) {
	    		start= map.get(currSum-target)+1;
	    		end=i;count++;
	    		 System.out.println("2start : "+nums[start]+" end :"+ nums[i]);
	    	 }	    	 
	    	 map.put(currSum, i);	
	    	 System.out.println(" map : "+map.toString());
		}	     
	     return count;
	    }
}
