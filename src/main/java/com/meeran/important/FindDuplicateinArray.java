package com.meeran.important;

import java.util.HashMap;
import java.util.Map;

/*
 * 
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.
 * */
public class FindDuplicateinArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findDuplicate(new int[]{1,3,4,2,2})+("   >>>>Expected<<<<  2"));
		System.out.println(findDuplicate(new int[]{3,1,3,4,2})+("   >>>>Expected<<<<  3"));
		System.out.println(findDuplicate(new int[]{})+("   >>>>Expected<<<<  0"));
	}
	
	public static int findDuplicate(int[] nums) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(Integer num :nums) {
			map.merge(num, 1, (a,b) -> a+b);
		}
		return map.isEmpty() ? 0 : map.entrySet().stream().filter(e->e.getValue()>1).findFirst().get().getKey();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static int findDuplicatec2(int[] nums) {
		if(nums.length==0) return 0;
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<nums.length;i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
		}
		return map.entrySet().stream().filter(e->e.getValue()>1).findFirst().get().getKey();
	}
	
	
	public static int findDuplicate1(int[] nums) {
		if(nums.length==0) return 0;
		int slow=0, fast=0;
		while(true) {
			slow=nums[slow];
			fast=nums[nums[fast]];
			if(slow==fast) break;
		}
		
		int slow2=0;
		while(true) {
			slow=nums[slow];
			slow2=nums[slow2];
			if(slow==slow2) return slow;
		}
	}

}
