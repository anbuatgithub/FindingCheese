package com.meeran.important;


//Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

/*
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
In this case, 6 units of rain water (blue section) are being trapped.
 * */
public class TrippingRainWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1})+("   >>>>Expected<<<<  6"));
		System.out.println(trap(new int[]{4,2,0,3,2,5})+("   >>>>Expected<<<<  9"));
		System.out.println(trap(new int[]{})+("   >>>>Expected<<<<  0"));
	}
	
	
	/*
	 * 
	 * 
	 * 
	 *                     __
	 * 			___        | |__  __
	 *    ___   |  |x_ x x_|   |x_| |__
	 * ___|  |x_|	  |x_|             |
	 * */
	public static int trap(int[] height) {
		int left=0,right=height.length-1;
		int leftMax=0,rightMax=0;
		int ans=0;
		while(left<right) {
			if(leftMax<height[left])  leftMax=height[left];
			if(rightMax<height[right]) rightMax = height[right];
			if(leftMax<rightMax) {
				ans+=Math.max(0, leftMax-height[left]);
				left++;
			}else {
				ans+=Math.max(0, rightMax-height[right]);
				right--;
			}
		}
		return ans;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static int trap1(int[] height) {
		if(height.length==0) return 0;
		int left=0, right=height.length-1;
		int leftMax=0, rightMax=0, ans=0;
		while(left<right) {
			if(height[left]>leftMax) leftMax = height[left];
			if(height[right]>rightMax) rightMax=height[right];
			
			if(leftMax<rightMax) {
				ans+= Math.max(0, leftMax-height[left]);
				left++;
			}else {
				ans+=Math.max(0, rightMax-height[right]);
				right--;
			}
		}
		return ans;
	}

}
