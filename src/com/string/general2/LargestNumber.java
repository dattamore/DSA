  package com.string.general2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//https://www.youtube.com/watch?v=qEIGhVtZ-sg
public class LargestNumber {

	public static void main(String[] args) {
		//int[] nums = {10,2};
		int[] nums = {3,30,5,34,9};

	System.out.println(largestNumber(nums));
	}

	public static String largestNumber(int[] nums) {

	    List<String> list = new ArrayList<String>();
	    for(int i=0;i<nums.length;i++){  
	        list.add(String.valueOf(nums[i]));
	    }
	    System.out.println(" 1: "+list);
	    Collections.sort(list,new Comparator(){
	    	public int compare(Object A,Object B){	            	            
	            String AB = A.toString()+B.toString();
	            String BA = B.toString()+A.toString();	            
	            return -AB.compareTo(BA) ;
	           // return AB.compareTo(BA) > 0 ? -1 : 1;
	        }      
	    });	    
	    System.out.println(" 2: "+list);
	    String res = "";
	     for(int i=0;i<list.size();i++){
	    	 System.out.println(" :: "+list.get(i));
	         res += list.get(i);
	    }	    
	    if(res.charAt(0) == '0')
	        return "0";
	    
	    return res;
	}
}
