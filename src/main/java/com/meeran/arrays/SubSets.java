package com.meeran.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;

import org.junit.Test;

public class SubSets {
	public static BigInteger F(int n) {
		/*for (BigInteger bi = BigInteger.valueOf(1);
	            bi.compareTo(maxLimit)>=0;
	            bi = bi.subtract(BigInteger.ONE)) {
	    }*/
	    BigInteger count = BigInteger.ZERO;
		double maxLimit = Math.pow(2, n);
	    for (int i = 1; i < maxLimit; i++) {
	        int counter = i;
	        if ((counter & (counter >> 1)) > 0)
	            continue;
	        count = count.add(new BigInteger("1"));
	    }
	    return count;
	  }
	
	@Test
    public void SampleTests() {
		 assertEquals(new BigInteger("2"), F(2), "F(2)");
	      assertEquals(new BigInteger("4"), F(3), "F(3)");
	      assertEquals(new BigInteger("12"), F(5), "F(5)");
	      assertEquals(new BigInteger("17710"), F(20), "F(20)");
	      assertEquals(new BigInteger("591286729878"), F(56), "F(56)");
    }
}
