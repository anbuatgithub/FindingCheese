package com.meeran.maths;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SquareRoot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	double squareRoot( double x ){
		return Math.sqrt(x);
	}
	
	@Test
	public void testSquareRoot() {
		assertEquals(2.0, squareRoot(4), 0.001);
		assertEquals(1.41421, squareRoot(2), 0.001);
	}

}
