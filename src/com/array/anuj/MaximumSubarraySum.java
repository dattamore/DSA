  package com.array.anuj;
//Kadane's Algorithm | Largest Sum Contiguous Subarray |
  //https://www.youtube.com/watch?v=HCL4_bOd3-4
public class MaximumSubarraySum {

	public static void main(String[] args) {
		//int arr[]= {5,-4,-2,6,-1};
		int arr[]= {-2,1,-3,4,-1,2,1,-5,4};
		//int arr[]= {1};

		int currSum=0;
		int maxSum=0;
		
		for (int i = 0; i < arr.length; i++) {
			
			currSum=currSum+arr[i];
			if(currSum>maxSum) {
				maxSum=currSum;
			}
			if(currSum<0) {
			 currSum=0;
			}
		}
		
		System.out.println(" maxSum: "+maxSum);
	}

}
