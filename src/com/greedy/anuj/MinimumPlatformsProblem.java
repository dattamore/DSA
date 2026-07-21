package com.greedy.anuj;

import java.util.Arrays;

public class MinimumPlatformsProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static	int findPlatform(int a[],int d[],int n) {
		Arrays.sort(a);
		Arrays.sort(d);
		int count =0;
		int ans =0;
		int i=0,j=0;
		while(i<n) {
			if (a[i]<=d[j]) {
				count++;
				ans=Math.max(ans, count);
				i++;
			} else if(a[i]>d[j]){
				count--;
				j--;
			}
		}
		return ans;
	}
	
}
