package com.greedy.anuj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ActivitySelectionProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static ArrayList<Integer> maxMeeting(int N,int[] S,int[] F){
		ArrayList<Integer> ans=new ArrayList<>();
		int a[][] = new int[N][3];
		for (int i = 0; i < N; i++) {
			a[i][0] = i+1;
			a[i][1] = S[i];
			a[i][2] = F[i];
		}
		Arrays.sort(a, Comparator.comparingInt(o->o[2]));
		int r=a[0][2];
		ans.add(a[0][0]);
		
		for (int i = 1; i < a.length; i++) {
			if (a[i][1]>r) {
				ans.add(a[i][0]);
				r=a[i][2];
			}
		}
		Collections.sort(ans);
		return ans;
	}
}
