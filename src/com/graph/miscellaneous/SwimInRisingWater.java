package com.graph.miscellaneous;
import java.util.*;

//https://www.youtube.com/watch?v=Wq1NibUMrNU
//TC: O(N^2 log N) SC : O(N^2)
public class SwimInRisingWater {

	public static void main(String[] args) {
		
        SwimInRisingWater solution = new SwimInRisingWater();
        int[][] grid = {
            {0, 2},
            {1, 3}
        };
        System.out.println(solution.swimInWater(grid)); // Output: 3
	}

	 public int swimInWater(int[][] grid) {
	     int n= grid.length;
	     boolean[][] vis=new boolean[n][n];
		 PriorityQueue<Pair> pq= new PriorityQueue<>();
		
		 int[][] dir= {{1,0},{0,1},{-1,0},{0,-1}};
		 
		 
		 pq.add(new Pair(0,0,grid[0][0])); 
	
		 while(pq.size()!=0) {
			 Pair rem= pq.remove();
			 if(rem.row ==n-1 && rem.col == n-1) {
				 return rem.msf;
			 }
			 if(vis[rem.row][rem.col]==true ) {
				 continue;
			 }
			 vis[rem.row][rem.col]=true;
			 for (int i = 0; i < 4; i++) {
				int rowdash=rem.row+dir[i][0];
				int coldash=rem.col+dir[i][1];
				if(rowdash<0||coldash<0||rowdash>=n||coldash>=n ||
						vis[rowdash][coldash]==true	) {
					continue;
				}
				 pq.add(new Pair(rowdash,coldash,Math.max(rem.msf,grid[rowdash][coldash]))); 
			}
		 }
		 return 0;
	 }
}

class Pair implements Comparable<Pair> {

	int row;
    int col;
    int msf;
    

    public Pair(int row, int col, int msf) {
		super();
		this.row = row;
		this.col = col;
		this.msf = msf;
	}


	@Override
	public int compareTo(Pair that) {
		// TODO Auto-generated method stub
		return this.msf-that.msf;
	}
}
