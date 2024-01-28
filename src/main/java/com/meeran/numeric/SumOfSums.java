package com.meeran.numeric;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;

import org.junit.Test;

public class SumOfSums {
	public static BigInteger sumOfSums(int n)
	  {
	    //Enter your code here
		BigInteger num = new BigInteger(String.valueOf(n)).multiply(new BigInteger(String.valueOf(n + 1))).multiply(new BigInteger(String.valueOf(n + 2))).divide(BigInteger.valueOf(6));
        return num.multiply(num.add(BigInteger.valueOf(1))).divide(BigInteger.valueOf(2));
	  }
	
	public static BigInteger sumOfSums2(int n)
	  {
	    //Enter your code here
		BigInteger sum = BigInteger.ZERO;
		while(n>0) {
			sum = sum.add(getSum(BigInteger.valueOf(n)));
			n--;
		}
		return getSum(sum);
	  }
	
	private static BigInteger getSum(BigInteger n) {
		if(n.equals(new BigInteger("1"))) return n;
		BigInteger sum = BigInteger.ZERO;
		while (!n.equals(new BigInteger("0"))) {
			sum = sum.add(n);
			n=n.subtract(new BigInteger("1"));
		}
		return sum;
	}
	
	public static BigInteger sumOfSums1(int n)
	  {
	    //Enter your code here
		int sum = 0;
		while(n>0) {
			sum +=getSum(n);
			n--;
		}
		return getSum(BigInteger.valueOf(sum));
	  }
	
	private static int getSum(int n) {
		if(n==1) return n;
		int sum = 0;
		while (n>0) {
			sum += n;
			n--;
		}
		return sum;
	}
	
	
	@Test
    public void exampleTests() {
        // assertEquals("expected", "actual");
      assertEquals(new BigInteger("55"),sumOfSums(3));
      assertEquals(new BigInteger("630"),sumOfSums(5));
      assertEquals(new BigInteger("14740530850"),sumOfSums(100));
    }
    @Test
    public void fixedTests(){
      assertEquals(new BigInteger("335221223415"),sumOfSums(169));
      assertEquals(new BigInteger("1"),sumOfSums(1));
      assertEquals(new BigInteger("1000985861505"),sumOfSums(203));
    }
    @Test
    public void randomTest1(){
      for(int i = 0 ; i < 10; ++i)
      {
        int n = (int)(Math.random()*5000)+5000;
        assertEquals(solver(n),sumOfSums(n));
      }
    }
    @Test
    public void randomTest2(){
      for(int i = 0 ; i < 24; ++i)
      {
        int n = (int)(Math.random()*500000)+500000;
        assertEquals(solver(n),sumOfSums(n));
      }
    }
    @Test
    public void randomTest3(){
      for(int i = 0 ; i < 10; ++i)
      {
        int n = (int)(Math.random()*50000)+50000;
        assertEquals(solver(n),sumOfSums(n));
      }
    }
    @Test
    public void randomTest4(){
      for(int i = 0 ; i < 30; ++i)
      {
        int n = (int)(Math.random()*100000000)+900000000;
        assertEquals(solver(n),sumOfSums(n));
      }
    }
  BigInteger solver(int n)
  {
       BigInteger n1 = new BigInteger(""+(n+1));
    final BigInteger SIX = new BigInteger("6");
   return n1.multiply(n1.multiply(n1.multiply(n1.multiply(n1.multiply(n1).subtract(BigInteger.TWO)).add(SIX)).add(BigInteger.ONE)).subtract(SIX)).divide(new BigInteger("72"));
  }
}
