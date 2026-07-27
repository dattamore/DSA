package com.graph.ashhad;

import java.util.*;

//https://www.youtube.com/watch?v=PULSUj4gBBc
//time complexity: O(n*m)  space complexity :  O(n*m)
public class RottingOranges {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int orangesRotting(int[][] grid) {
	  int n=grid.length;
	  int m=grid[0].length;
	  int freshCount=0;
	  LinkedList<int[]> queue=new LinkedList<>();
	  
	  for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if(grid[i][j]==1) {
				freshCount++;
			}else if(grid[i][j]==2) {
				queue.add(new int[] {i,j});
			}
			
		}
	}
	  if(freshCount==0) {
		 return 0; 
	  }
	  int time=0;
	  while(!queue.isEmpty()) {
		  int size = queue.size();
		  
		  for (int i = 0; i < size; i++) {  
			  int rottenLoc[]=queue.poll();
			  int r=rottenLoc[0];
			  int c=rottenLoc[1];
			  int neighbours[][] = {{r-1,c},{r,c+1},{r+1,c},{r,c-1}};
			
			  for (int[] neighbour : neighbours) {
				int nr=neighbour[0];
				int nc=neighbour[1];
				
				if(nr<0 || nr>=n || nc<0|| nc>=m || grid[nr][nc] ==2) {
					continue;
				}
				queue.offer(new int[] {nr,nc});
				grid[nr][nc]=2; //visited
				freshCount--;
				if(freshCount==0) {
					return time +1;
				}
			}
		}
		  time++;
	  }
		
		return -1;
	}

}
