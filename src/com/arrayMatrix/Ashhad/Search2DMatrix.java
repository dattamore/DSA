package com.arrayMatrix.Ashhad;

//https://www.youtube.com/watch?v=8JI46p5Jv7Q
//https://www.youtube.com/watch?v=JXU4Akft7yk
public class Search2DMatrix {

	public static void main(String[] args) {
		int[][] arr= {{1,3,5,7},{10,11,16,20},{23,30,34,60}};	
		int target = 23;
		int n=arr.length;
		int m=arr[0].length;
		System.out.println(n+" "+m);
		int l=0;
		int h=n*m-1;
		
		while(l<=h) {
			int mid=(l+h)/2;
			if(arr[mid/m][mid%m]==target) {
				System.out.println("ELEMENT FOUND : ");
			}
			if(arr[mid/m][mid%m]>target) {
				h=mid-1;
			}else {
				l=mid+1;
			}
		}
	}
}
//https://www.youtube.com/watch?v=dcTJRw1704w&t=7s
 class Search2DMatrix2 {

	public static void main(String[] args) {
	}
	public boolean searchMatrix(int[][] matrix,int target) {
		int row=0,col=matrix[0].length-1;
		while (row<matrix.length && col>=0) {
			if(matrix[row][col]==target) return true;
			else if(matrix[row][col]<target)row++;
			else col--;
		}
		return false;
	}

}
