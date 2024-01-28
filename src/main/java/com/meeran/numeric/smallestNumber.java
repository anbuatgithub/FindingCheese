package com.meeran.numeric;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.stream.IntStream;

import org.junit.Test;

public class smallestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int FindMin(int a[]){
		Arrays.sort(a);
		return IntStream.of(a).findFirst().getAsInt();
	}
	
	@Test
	public void testFindMin() {
		assertEquals(1, FindMin(new int[] {3, 4, 5, 6, 1, 2}));
		assertEquals(1, FindMin(new int[] {2,1}));
		assertEquals(1, FindMin(new int[] {1}));
	}

}
