package com.meeran.numeric;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class SecondSmallest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int secondSmallest(int a[]){
		Arrays.sort(a);
		for(int i=0;i+1<a.length;i++) if(a[i]!=a[i+1]) return a[i+1];
		return 0;
	}
	
	@Test
	public void testSecondSmallest() {
		assertEquals(2, secondSmallest(new int[] {3, 4, 5, 6, 1, 2}));
		assertEquals(2, secondSmallest(new int[] {2,1}));
		assertEquals(0, secondSmallest(new int[] {1}));
	}

}
