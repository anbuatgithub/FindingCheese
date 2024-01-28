package com.meeran.gs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class NonConsecutiveNum {

	private Integer find(int[] arr) {
		int firstNum = arr[0];
		
		for(int i=1; i<arr.length; i++) {
			if(arr[i]!=++firstNum) {
				return arr[i];
			}
		}
		return null;
	}
	
	@Test
	public void testNonConsecutiveNum() {
		assertEquals(Integer.valueOf(6),find(new int[]{1, 2, 3, 4, 6, 7, 8}));
        assertEquals(null,find(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
        assertEquals(Integer.valueOf(6),find(new int[]{4, 6, 7, 8, 9, 11}));
        assertEquals(Integer.valueOf(11),find(new int[]{4, 5, 6, 7, 8, 9, 11}));
        assertEquals(null,find(new int[]{31, 32}));
        assertEquals(Integer.valueOf(0),find(new int[]{-3, -2, 0, 1}));
        assertEquals(Integer.valueOf(-1),find(new int[]{-5, -4, -3, -1}));
	}

}
