package com.meeran.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class SubArrayExceedsSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int subArrayExceedsSum(int arr[], int target) {
		int minLength = arr.length+1;
		
		for(int i=0; i<arr.length;i++) {
			int currSum = arr[i];
			if(currSum>target) return 1;
			for(int j=i+1; j<arr.length;j++) {
				currSum += arr[j];
				if(currSum > target && (j-i+1)<minLength) minLength = (j-i+1);
			}
		}
		return minLength;
	}
	
	@Test
	public void testSubArrayExceedsSum() {
		assertEquals(2, subArrayExceedsSum(new int[] {1,2,3,4}, 6));
	}

}
