package com.heap.lovebabbarAyushi;

import java.util.Arrays;
import java.util.PriorityQueue;

//understanding https://www.youtube.com/watch?v=z-NbVpzA_fs&list=PLPyD8bF-abzswXItsbav88ojXrzurguY3&index=8
//code https://www.youtube.com/watch?v=r7DwTstWSEI&t=334s
public class KClosestPointsToOrigin {

	public static void main(String[] args) {
		//int arr[]= {20,10,60,30,50,40};
		//int[][] points= {{1,3},{-2,2}};
		int[][] points= {{3,3},{5,-1},{-2,4}};
		int k=2;
		
		
		kClosest(points,k);

	}
	
	private static void kClosest(int[][] points, int k) {
		
		int [][] res=new int[k][2];
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
				(x,y)->(x[0]*x[0]+x[1]*x[1] - y[0]*y[0]+y[1]*y[1])); //min heap
		
		for(int [] p:points) {//it should be upto k..check code
			System.out.println("--add p: "+Arrays.toString(p));
			pq.add(p);     ///pq.offer(p);
		}
		for (int i = 0; i < k; i++) {
			System.out.println("--** ");
			res[i]=pq.poll();
		}		
		
				//System.out.println(" "+ res[0][0]);
				for (int i = 0; i < res.length; i++) {
					System.out.println("-- ");
		            System.out.println(Arrays.toString(res[i]));
		        }	
				// System.out.println(Arrays.toString(res[0]));
			
		}
		
		//System.out.println(" "+k+" "+ pq.peek());
	

}
