package com.array.general;

import java.util.HashMap;
import java.util.Map;

//Subarray with Given Sum
//https://www.youtube.com/watch?v=Ofl4KgFhLsM
public class SubarrayGivenSum {

	public static void main(String[] args) {

		int nums[]= {1,4,20,3,10,5};
	//	int[] nums = {3,4,7,2,-3,1,4,2};
		int target=33;
		int CurrSum=0;
		int left=0;int right=0;
		int count=0;
		while(left<=right) {
		
		if(CurrSum<target) {
			CurrSum=CurrSum+nums[right];
		//	System.out.println(" r:"+CurrSum);
			right++;
		}else {
			CurrSum=CurrSum-nums[left];
		//	System.out.println(" l:"+CurrSum);
			left++;
		}			
		if(CurrSum==target) {
			while(left<right) {
				System.out.print(" "+nums[left]);
				left++;
			}
			break;
			//continue;
		}			
	}	
 
}
}

//	
//	Map<Integer,Integer> map=new HashMap<>();
//    
//    for (int i = 0; i < nums.length; i++) {
//   	 CurrSum=CurrSum+nums[i];
//   	 if(CurrSum-target==0) {
//   		 left=0;right=i;count++;
//   		 System.out.println("1left : "+nums[left]+" right :"+ nums[i]);
//   	 }	    	 
//   	 System.out.println(" currSum-sum : "+(CurrSum-target));
//   	 if(map.containsKey(CurrSum-target)) {
//   		left= map.get(CurrSum-target)+1;
//   		right=i;count++;
//   		 System.out.println("2left : "+nums[left]+" right :"+ nums[i]);
//   	 }	    	 
//   	 map.put(CurrSum, i);	
//   	 System.out.println(" map : "+map.toString());
//	}	     
   
