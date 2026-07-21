package com.greedy.ashhad;

import java.util.Arrays;

//https://www.youtube.com/watch?v=Ya-LfQ0OBkU&t=15s
public class Candy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int candy(int[] ratings) {
		int candies =0,n=ratings.length;
		int[] left=new int[n];
		int[] right=new int[n];
		
		Arrays.fill(left, 1);
		Arrays.fill(right, 1);
		
		for (int i = 1; i < n; i++) {
			if(ratings[i]>ratings[i-1])left[i]=left[i-1]+1;
		}
		for (int i = n-2; i >=0; i--) {
			if(ratings[i]>ratings[i+1])right[i]=right[i+1]+1;
		}
		for (int i = 0; i < n; i++) {
			candies=candies+Math.max(left[i], right[i]);
		}
		return candies;
	}
	public int candy2(int[] ratings) {
		if(ratings.length<=1) return ratings.length;
		
		int up=0,down=0;
		int prevSlope=0;
		int candies=0;

		
		for (int i = 1; i < ratings.length; i++) {
			
			int currSlope=ratings[i]>ratings[i-1]?1
					:(ratings[i]<ratings[i-1]?-1:0);
			
			if((prevSlope<0 && currSlope>=0) || (prevSlope>0 && currSlope==0) ) {
				candies=candies+sum(up)+sum(down)+Math.max(up, down);
				up=0;
				down=0;
			}
			
			if(currSlope>0)up++;
			else if(currSlope<0)down++;
			else candies++;
			
			prevSlope=currSlope;
		}
		candies=candies+sum(up)+sum(down)+Math.max(up, down)+1;
		return candies;
	}
	private int sum(int n) {
	
		return (n*(n+1))/2;
	}
}
