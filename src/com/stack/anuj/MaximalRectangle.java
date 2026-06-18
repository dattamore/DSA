package com.stack.anuj;
//Max rectangle | Maximal Rectangle | Maximum Size Rectangle in Binary Matrix |
public class MaximalRectangle {

	static LargestRectangularHistogram histogram=new LargestRectangularHistogram();
	public static void main(String[] args) {
		
		int[][] a= {{1,0,1,0,0},{1,0,1,1,1},{1,1,1,1,1},{1,0,0,1,0}};
		//int[][] a= {{1}};
		int area=largestArea(a);
		System.out.println(" "+area);
	}
	private static int largestArea(int[][] a) {
		int[] currRow=a[0];
		int maxAns=histogram.maxElement(currRow);	
		for (int i = 1; i < a.length; i++) {
			
			for (int j = 0; j < a[0].length; j++) {
				if(a[i][j]==1) {
					currRow[j]+=1;
				}else {
					currRow[j]=0;
				}
				
			}
			int currAns=histogram.maxElement(currRow);		
			maxAns=Math.max(maxAns, currAns);
		}
		
		return maxAns;
	}

}
