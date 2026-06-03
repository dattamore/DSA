package com.arrayMatrix.Ashhad;

import java.util.Arrays;
//understanding : https://www.youtube.com/watch?v=Z0R2u6gd3GU
public class RotateImage {
	static int[][] arr= {{1,2,3},{4,5,6},{7,8,9}};
	//static int[][] arr= {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
	public static void main(String[] args) {
		
		System.out.println(Arrays.deepToString(arr));
		for (int i = 0; i < arr.length; i++) {			
			for (int j = i; j < arr.length; j++) {		
				//swap(arr[i][j],arr[j][i]);
				swap(i,j);
		}			
	}
		System.out.println("-------------");
		System.out.println(Arrays.deepToString(arr));
		for (int i = 0; i < arr.length; i++) {				
			reverse(arr[i]);
		}	
		System.out.println(Arrays.deepToString(arr));
}

	private static void reverse(int[] is) {
		
		//System.out.print(Arrays.toString(is)+ " ");
		int l=0;
		int e=is.length-1;
		while(l<=e) {
			int temp=is[l];
			is[l]=is[e];
			is[e]=temp;
			l++;e--;
		}
		//System.out.println(Arrays.toString(is));
	}

	private static void swap(int i, int j) {
		// TODO Auto-generated method stub
		int temp=arr[i][j];
		arr[i][j]=arr[j][i];
		arr[j][i]=temp;
	}
	
}

//Rotate matrix by 180 degrees
//revrse row and then reverse columns

//Rotate matrix by 270 degrees
//3 times 90 solution
//transpose and reverse columns
