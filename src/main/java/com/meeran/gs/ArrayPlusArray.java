package com.meeran.gs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

public class ArrayPlusArray {
	
	public static int arrayPlusArray(int[] arr1, int[] arr2) {
	    // arr1 + arr2 is not working...
		return Arrays.stream(arr1).sum()+ Arrays.stream(arr2).sum();
	   //return IntStream.of(arr1).sum()+IntStream.of(arr2).sum();
	  }
	
	@Test
	public void testArrayPlusArray() {
		assertEquals(21, arrayPlusArray(new int[]{1,2,3}, new int[]{4,5,6}));
		assertEquals(-21, arrayPlusArray(new int[]{-1,-2,-3}, new int[]{-4,-5,-6}));
		assertEquals(15, arrayPlusArray(new int[]{0,0,0}, new int[]{4,5,6}));
		assertEquals(0, arrayPlusArray(new int[]{}, new int[]{}));
		assertEquals(2100, arrayPlusArray(new int[]{100,200,300}, new int[]{400,500,600}));
	}

}
