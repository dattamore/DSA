package com.array.anuj;

public class BuySellStock {

	public static void main(String[] args) {
		int arr[]= {3,2,4,8,7,10,1,15};
		
		int maxProfit=Integer.MIN_VALUE;
		int minNumber=Integer.MAX_VALUE;
		
		for (int i = 0; i < arr.length; i++) {
			minNumber=Math.min(minNumber, arr[i]); System.out.print(" minNumber: "+minNumber);
			
			int profit =arr[i]-minNumber; System.out.print(" profit: "+profit);
			
			maxProfit=Math.max(maxProfit, profit); System.out.print(" maxProfit: "+maxProfit);
			
			System.out.println(" : ");
		}

		System.out.println("maxProfit : "+maxProfit);
	}

}
