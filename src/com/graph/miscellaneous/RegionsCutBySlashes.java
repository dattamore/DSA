package com.graph.miscellaneous;

//https://www.youtube.com/watch?v=LBwIhde7pvc&t=1394s
public class RegionsCutBySlashes {

	int rows;
	int cols;
	int[][] dir= {{1,0},{0,1},{-1,0},{0,-1}};
	
	public static void main(String[] args) {
		RegionsCutBySlashes solution = new RegionsCutBySlashes();
//        String[] grid = {
//            " /",
//            "/ "
//        };

        String[] grid = {
                "/\\",
                "\\/"
            };
        System.out.println(solution.regionsBySlashes(grid)); // Output: 2 && 5

	}

	public int regionsBySlashes(String[] grid) {
		int size = grid.length;
		int matrix[][] = new int[size * 3][size * 3];
		 rows = size * 3;
		 cols = size* 3;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				int row = i * 3;
				int col = j * 3;
				if (grid[i].charAt(j) == '/') {
					matrix[row][col + 2] = 1;
					matrix[row + 1][col + 1] = 1;
					matrix[row + 2][col] = 1;
				} else if (grid[i].charAt(j) == '\\') {
					matrix[row][col] = 1;
					matrix[row + 1][col + 1] = 1;
					matrix[row + 2][col + 2] = 1;
				}
			}
		}
		int count = 0;
		for (int i = 0; i < size * 3; i++) {
			for (int j = 0; j < size * 3; j++) {
				if (matrix[i][j] == 0) {
					dfs(i, j, matrix);
					count++;
				}
			}
		}

		return count;
	}

	 public void dfs(int row,int col,int matrix[][]) {
		 
		 if(row<0 || col<0 || row>=rows|| col>=cols || matrix[row][col]==1 ) {
			 return;
		 }
		 matrix[row][col]=1;
		 for (int i = 0; i < 4; i++) {
			 dfs(row+dir[i][0], col+dir[i][1], matrix);
		}
		
	 }
}
