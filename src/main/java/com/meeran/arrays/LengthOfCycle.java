package com.meeran.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class LengthOfCycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	//floyd's algorithm
	private static int lengthOfCycle(int[] nums, int start) {
		if(start<0 || start>=nums.length) return -1;
		int slow = nums[start];
		int fast=nums[nums[start]];
		if(slow==fast) return -1;
		int count=1;
		while(slow!=fast) {
			count++;
			slow=nums[slow];
			if(fast<nums.length) fast=nums[nums[fast]];
			else return -1;
		}
		return count;
	}
	
	@Test
	public void testlengthOfCycle() {
		assertEquals(2, lengthOfCycle(new int[]{1, 0}, 0));
		assertEquals(3, lengthOfCycle(new int[]{1,2, 0}, 0));
		assertEquals(3, lengthOfCycle(new int[]{1, 2, 3, 1}, 0));
		assertEquals(-1, lengthOfCycle(new int[]{1, 2, 3, 4}, 0));
		assertEquals(-1, lengthOfCycle(new int[]{1, 2, 3, 4}, -1));
		assertEquals(-1, lengthOfCycle(new int[]{1, 2, 3, 4}, 4));
		assertEquals(-1, lengthOfCycle(new int[]{2, 3, 4, 0}, 0));
		assertEquals(2, lengthOfCycle(new int[]{2, 3, 0}, 0));
	}
}
