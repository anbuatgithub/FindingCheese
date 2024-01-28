package com.meeran.numeric;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;

import org.junit.Test;

public class TheMillionthFibonacci {
	public static BigInteger fib(BigInteger n) {
	    // ...
		BigInteger a = BigInteger.valueOf(0);
		int limit=n.intValue();
		BigInteger fact = BigInteger.valueOf(1);
		BigInteger minus = BigInteger.valueOf(-1);
		if(n.intValue()==0) return a;
		else if(n.intValue()<0) {
			limit = -1 * n.intValue();
			if(n.intValue()%2==0) {
				fact = fact.multiply(minus);
			}
		}
        BigInteger b = BigInteger.valueOf(1);
        BigInteger c = BigInteger.valueOf(1);
        for (int j=2 ; j<=limit ; j++)
        {
            c =  a.add(b);
            a = b;
            b = c;
        }
  
        return b.multiply(fact);
	  }
	
	public static BigInteger fib1(BigInteger n) {
	    // ...
		BigInteger a = BigInteger.valueOf(0);
		BigInteger b = BigInteger.valueOf(1);
        BigInteger c = BigInteger.valueOf(1);
		BigInteger fact = BigInteger.valueOf(1);
		BigInteger minus = BigInteger.valueOf(-1);
		BigInteger two = BigInteger.valueOf(2);
		
		if(n.intValue()<0) {
			n = minus.multiply(n);
			if(n.intValue()%2==0) {
				fact = fact.multiply(minus);
			}
		}
		if(n.intValue()==0) return a;
		else if(n.intValue()==1) return b;
		else {
			return (fib(n.subtract(c)).add(fib(n.subtract(two)))).multiply(fact);
		}
	  }



	@Test
	  public void testFib0() {
	    testFib(0, 0);
	  }
	  
	  @Test
	  public void testFib1() {
	    testFib(1, 1);
	  }
	  
	  @Test
	  public void testFib2() {
	    testFib(1, 2);
	  }
	  
	  @Test
	  public void testFib3() {
	    testFib(2, 3);
	  }
	  
	  @Test
	  public void testFib4() {
	    testFib(3, 4);
	  }
	  
	  @Test
	  public void testFib5() {
	    testFib(5, 5);
	  }
	  
	  private static void testFib(long expected, long input) {
	    BigInteger found;
	    try {
	      found = fib(BigInteger.valueOf(input));
	    }
	    catch (Throwable e) {
	      // see https://github.com/Codewars/codewars.com/issues/21
	      throw new AssertionError("exception during test: "+e, e);
	    }
	    assertEquals(BigInteger.valueOf(expected), found);
	  }
}
