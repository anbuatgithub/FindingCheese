package com.meeran.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class SortTwisted37 {
	public static Integer[] sortTwisted37(Integer[] array)
	  {
		return Arrays.stream(array)
		         .map(SortTwisted37::swap)
		          .sorted(Integer::compare)
		           .map(SortTwisted37::swap)
		            .toArray(Integer[]::new);
	  }
	
	private static Integer swap(Integer i) {
	    return Integer.valueOf(i.toString()
	        .replace("7", "*")
	         .replace("3", "7")
	          .replace("*", "3")
	            );
	  }
	
	@Test
    public void basicTests() {        
        assertEquals(Arrays.toString(new Integer[] {1,2,7,4,5,6,3,8,9}), Arrays.toString(sortTwisted37(new Integer[] {1,2,3,4,5,6,7,8,9})));
        assertEquals(Arrays.toString(new Integer[] {12,14,13}), Arrays.toString(sortTwisted37(new Integer[] {12,13,14})));
        assertEquals(Arrays.toString(new Integer[] {2,7,4,3,9}), Arrays.toString(sortTwisted37(new Integer[] {9,2,4,7,3})));    
    }
}
