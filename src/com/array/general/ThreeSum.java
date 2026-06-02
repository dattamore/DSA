package com.array.general;

import java.util.Arrays;

public class ThreeSum {

	public static void main(String[] args) {
		int arr[]= {-1,0,1,2,-1,-4};
		//int targetSum=0;
		int n=arr.length;
		Arrays.sort(arr);
		System.out.println(" : "+Arrays.toString(arr));
		
		for (int i = 0; i < n-1; i++) {
			int first=arr[i];
			int start=arr[i+1];
			int end=arr[n-1];
			int targetSum=-first;
		
			while(start<end) {
				if((start+end)==targetSum) {
					System.out.println(" "+first+" "+start+" "+end+" ");
					start++;
					end--;
				}else if((start+end)>targetSum) {
					end--;
				}else if((start+end)<targetSum) {
					start++;
				}
			}
		}

	}
//	System.out.println(" first: "+first+" start: "+start+" end: "+end);
}
