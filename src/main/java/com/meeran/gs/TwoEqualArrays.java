package com.meeran.gs;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class TwoEqualArrays {

	public static boolean areEqual(int arr1[], int arr2[]) {

		if(arr1.length != arr2.length)
			return false;

		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		for(int i=0;i<arr1.length;i++) {
			if(arr1[i]!=arr2[i]) return false;
		}
		return true;
	}

	@Test
	public void testTwoEqualArrays() {
		int arr1[] = { 3, 5, 2, 5, 2 };
        int arr2[] = { 2, 3, 5, 5, 2 };
        int arr3[] = { 2, 3, 3, 5, 2 };
        
        assertTrue(areEqual(arr1, arr2));
        assertFalse(areEqual(arr1, arr3));
	}
}
