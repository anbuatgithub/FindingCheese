package com.meeran.gs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class EnglishBeggers {

	public static int[] beggars(int[] values, int n) {
	    // show me the code!
		int[] output = new int[n];
		
		for(int i=0; i<n; i++) {
			for(int j=i; j<values.length; j+=n) {
				output[i]+=values[j];
			}
		}
		return output;
	  }
	
	@Test
	public void testEnglishBeggers() {
		int[] test = {1, 2, 3, 4, 5};
        int[] a1 = {15}, a2 = {9, 6}, a3 = {5, 7, 3}, a4 = {1, 2, 3, 4, 5, 0}, a5 = {};
        assertEquals(Arrays.toString(a1), Arrays.toString(beggars(test, 1)));
        assertEquals(Arrays.toString(a2), Arrays.toString(beggars(test, 2)));
        assertEquals(Arrays.toString(a3), Arrays.toString(beggars(test, 3)));
        assertEquals(Arrays.toString(a4), Arrays.toString(beggars(test, 6)));
        assertEquals(Arrays.toString(a5), Arrays.toString(beggars(test, 0)));
	}
}
