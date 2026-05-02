package com.array.anuj;
//Leetcode - 122
public class BuySellStock2 {

	public static void main(String[] args) {
        int arr[]= {5,2,6,1,4,7,3,6};      
		
		int Profit=0;
				
		for (int i = 1; i < arr.length; i++) {
			
			if(arr[i] >arr[i-1]) {
				Profit=Profit+(arr[i] -arr[i-1]);
			}
		}
		System.out.println("Profit : "+Profit);
	}
}
