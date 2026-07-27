package com.graph.ashhad;


//understanding : https://www.youtube.com/watch?v=C-2_uSRli8o&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=10
//code : https://www.youtube.com/watch?v=aehEcTEPtCs
public class FloodFill {

	public static void main(String[] args) {
		FloodFill solution = new FloodFill();
	        int[][] image = {
	            {1, 1, 1},
	            {1, 1, 0},
	            {1, 0, 1}
	        };
	        int sr = 1, sc = 1, newColor = 2;

	        int[][] result = solution.floodFill(image, sr, sc, newColor);
	        
	        for (int[] row : result) {
	            for (int pixel : row) {
	                System.out.print(pixel + " ");
	            }
	            System.out.println();
	        }
	    }
	
	 public int[][] floodFill(int[][] image,int sr,int sc,int newColor){
		if(image[sr][sc] == newColor)return image;
	    filldfs(image, sr, sc,image[sr][sc], newColor);
		return image;
	 }
	private void filldfs(int[][] image, int sr, int sc, int prevColor, int newColor) {
//		System.out.println(" prevColor: "+prevColor);
		if(sr<0 ||sc<0|| sr>=image.length || sc>=image[0].length || image[sr][sc] != prevColor) {
		return;	 
		}
		image[sr][sc] = newColor;
		filldfs(image, sr-1, sc,prevColor, newColor);
		filldfs(image, sr+1, sc,prevColor, newColor);
		filldfs(image, sr, sc-1,prevColor, newColor);
		filldfs(image, sr, sc,prevColor, newColor);
	}
}
