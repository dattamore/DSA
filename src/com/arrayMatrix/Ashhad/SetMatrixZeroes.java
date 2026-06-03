package com.arrayMatrix.Ashhad;
import java.util.*;

//https://www.youtube.com/watch?v=EBlr9Y4koFU
public class SetMatrixZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void setZeroes(int[][] matrix) {
		int rows=matrix.length;
		int cols=matrix[0].length;
		Set<Integer> rowSet=new HashSet<>();
		Set<Integer> colSet=new HashSet<>();
		for (int i = 0; i < rows; i++) {			
			for (int j = 0; j < cols; j++) {		
				if(matrix[i][j]==0) {
					rowSet.add(i);
					colSet.add(j);
					}
				}
		}	
		for (int i = 0; i < rows; i++) {			
			for (int j = 0; j < cols; j++) {		
				if(rowSet.contains(i)||colSet.contains(j)) {
					matrix[i][j]=0;
					}
				}
		}
	}
}
