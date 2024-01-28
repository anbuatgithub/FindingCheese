package com.meeran.maths;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class PowerOfExpo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static double power(double base, int exp) {
		return Math.pow(base, exp);
	}
	
	@Test
	public void testPower() {
		assertEquals(16.0, power(2.0,4));
	}

}
