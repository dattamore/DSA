package com.greedy.ashhad;
//https://www.youtube.com/watch?v=Gtugy3mRV-A
public class JumpGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	boolean canJump(int[] nums) {
		
		int finalPosition =nums.length -1;
		
		for (int i = nums.length-2; i >=0; i--) {
			
			if(i+nums[i]>=finalPosition) {
				finalPosition=i;
			}
		}
		
		return finalPosition==0;
	}
		int Jump2(int[] nums) {
				
			int totalJumps =0;
			int destination =nums.length -1;
			int coverage =0, lastJumpidx=0;
			
			if(nums.length==1)return 0;
			
			for (int i = 0; i <nums.length; i++) {
				
				coverage=Math.max(coverage, i+nums[i]);
				if(i==lastJumpidx) {
					lastJumpidx=coverage;
					lastJumpidx++;
				}		
				if (coverage>=destination) {
					return totalJumps;
				}
			}	
			return totalJumps;
		}
	
}
