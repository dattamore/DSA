package com.arrayMatrix.oneFifty;

//https://www.youtube.com/watch?v=aqVW8IuXUF0
//2
//https://www.youtube.com/watch?v=AXfCV7z7pb4
public class SpiralMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void makeSpiral(int[][] matrix) {
		int rowBegin=0;
		int rowEnd=0;
		int colBegin=0;
		int colEnd=0;
		while (rowBegin<=rowEnd && colBegin<=colEnd) {
			
			//Traverse Right
			for (int i = colBegin; i <= colEnd; i++) {
				System.out.println(matrix[rowBegin][i]);//matrix[rowBegin][i]=count++; //spiral 2
			}
			rowBegin++;
			
			//Traverse Down
			for (int i = rowBegin; i <= rowEnd; i++) {
				System.out.println(matrix[i][colEnd]);
			}
			colEnd--;
			//Traverse left
			if(rowBegin<=rowEnd) {
				for (int i = colEnd; i >= colBegin; i--) {
					System.out.println(matrix[i][i]);
					}
				}
			rowEnd--;
			//Traverse up
			if(colBegin<=colEnd) {
			for (int i = rowEnd; i >= rowBegin; i--) {
				System.out.println(matrix[i][colBegin]);
			}
			colBegin++;
		}
	}
	}
}
