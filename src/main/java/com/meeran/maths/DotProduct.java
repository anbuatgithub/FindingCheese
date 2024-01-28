package com.meeran.maths;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.IntStream;

import org.junit.Test;

public class DotProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array1 = {2, 3};
		int[] array2 = {1, 2};
		long result1 = dotProduct(array1, array2);
		System.out.println("result=8=>"+result1);
	}
	
	static long dotProduct( int[] array1, int array2[] ){
		return (long)IntStream.of(array1).reduce(1,(a,b)->a*b) + 
				(long)IntStream.of(array2).reduce(1,(a,b)->a*b);
	}
	
	@Test
	public void testDoctProduct() {
		int[] array1 = {2, 3};
		int[] array2 = {1, 2};
	    assertEquals(8,dotProduct(array1,array2)); 
	}

}
