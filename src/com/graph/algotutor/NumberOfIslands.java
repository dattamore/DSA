package com.graph.algotutor;

//understanding
//https://www.youtube.com/watch?v=__98uL6wst8
public class NumberOfIslands {
//main class chatgpt
	public static void main(String[] args) {
		  NumberOfIslands solution = new NumberOfIslands();

	        // Test Case 1
	        char[][] grid1 = {
	            {'1', '1', '0', '0', '0'},
	            {'1', '1', '0', '0', '0'},
	            {'0', '0', '1', '0', '0'},
	            {'0', '0', '0', '1', '1'}
	        };
	        System.out.println(solution.numIslands(grid1)); // Output: 3

	        // Test Case 2
	        char[][] grid2 = {
	            {'1', '1', '1'},
	            {'0', '1', '0'},
	            {'1', '1', '1'}
	        };
	        System.out.println(solution.numIslands(grid2)); // Output: 1

	        // Test Case 3
	        char[][] grid3 = {
	            {'1', '0', '0', '1'},
	            {'0', '0', '0', '0'},
	            {'1', '0', '1', '1'}
	        };
	        System.out.println(solution.numIslands(grid3)); // Output: 4

	}
	
	public int numIslands(char[][] grid) {
		int num=0;
		int row=grid.length;
		int col=grid[0].length;
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				
				if(grid[i][j] == '1') {
					num++;
					dfs(grid,i,j);
				}
				
			}
		}
		return num;
	}

	private void dfs(char[][] grid, int i, int j) {
		
		if(i<0||j<0 || i>=grid.length||j>=grid[0].length || grid[i][j]=='0')
			return;
		
		grid[i][j]='0';
		
		   dfs(grid, i - 1, j); // Up
	        dfs(grid, i + 1, j); // Down
	        dfs(grid, i, j - 1); // Left
	        dfs(grid, i, j + 1); // Right
	}

}
