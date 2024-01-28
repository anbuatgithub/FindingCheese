package com.meeran.numeric;

import static org.junit.Assert.assertArrayEquals;
import static java.util.Arrays.copyOf;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

public class Tribonacci {
	public static double[] tribonacci(double[] s, int n) {
	      // hackonacci me
		if(n == 0) return new double[0];
		int i=0;
		double[] result = new double[n];
		if(n<s.length) {
			for(; i<n; i++) result[i]=s[i];
			return result;
		}
		for(; i < s.length; i++){
			result[i] = s[i];
		}
		for(; i <= n - 1; i++){
			result[i] = result[i - 1] + result[i - 2] + result[i - 3];
		}
		return result;
	  }
	
	  
	  private double precision = 1e-10;
	  
	  @Test
	  public void sampleTests() {
	    assertArrayEquals(new double []{1,1,1,3,5,9,17,31,57,105}, Tribonacci.tribonacci(new double []{1,1,1},10), precision);
	    assertArrayEquals(new double []{0,0,1,1,2,4,7,13,24,44}, Tribonacci.tribonacci(new double []{0,0,1},10), precision);
	    assertArrayEquals(new double []{0,1,1,2,4,7,13,24,44,81}, Tribonacci.tribonacci(new double []{0,1,1},10), precision);
	  }
	  
	  @Test
	  public void basicTests() {
	    assertArrayEquals(new double []{1,1,1,3,5,9,17,31,57,105}, Tribonacci.tribonacci(new double []{1,1,1},10), precision);
	    assertArrayEquals(new double []{0,0,1,1,2,4,7,13,24,44}, Tribonacci.tribonacci(new double []{0,0,1},10), precision);
	    assertArrayEquals(new double []{0,1,1,2,4,7,13,24,44,81}, Tribonacci.tribonacci(new double []{0,1,1},10), precision);    
	    assertArrayEquals(new double []{1,0,0,1,1,2,4,7,13,24}, Tribonacci.tribonacci(new double []{1,0,0},10), precision);
	    assertArrayEquals(new double []{0,0,0,0,0,0,0,0,0,0}, Tribonacci.tribonacci(new double []{0,0,0},10), precision);
	    assertArrayEquals(new double []{1,2,3,6,11,20,37,68,125,230}, Tribonacci.tribonacci(new double []{1,2,3},10), precision);
	    assertArrayEquals(new double []{3,2,1,6,9,16,31,56,103,190}, Tribonacci.tribonacci(new double []{3,2,1},10), precision);
	    assertArrayEquals(new double []{1}, Tribonacci.tribonacci(new double []{1,1,1},1), precision);
	    assertArrayEquals(new double []{}, Tribonacci.tribonacci(new double []{300,200,100},0), precision);
	    assertArrayEquals(new double []{0.5,0.5,0.5,1.5,2.5,4.5,8.5,15.5,28.5,52.5,96.5,177.5,326.5,600.5,1104.5,2031.5,3736.5,6872.5,12640.5,23249.5,42762.5,78652.5,144664.5,266079.5,489396.5,900140.5,1655616.5,3045153.5,5600910.5,10301680.5}, Tribonacci.tribonacci(new double []{0.5,0.5,0.5},30), precision);

	  }
	  
	  @Test
	  public void randomTests() {
	    double[] sign;
	    int n;
	    for(int i = 0; i < 40; i++) {
	        sign = new double[]{randInt(0, 20), randInt(0, 20), randInt(0, 20)};
	        n = randInt(0, 50);

	        System.out.println("Testing for signature: " + Arrays.toString(sign) + " and n: " + n);
	        assertArrayEquals("It should work with random inputs too", soluzionacci(sign, n), Tribonacci.tribonacci(sign, n), precision);
	        
	    }
	  }

	  private double[] soluzionacci(double[] s, int n) {
	    double[] res = new double[n];
	    res = copyOf(s, n);
	    
	    for(int i = 3; i < n; i++)
	      res[i] = res[i - 3] + res[i - 2] + res[i - 1];
	    
	    return res;
	  }

	  private int randInt(int aStart, int aEnd) {
	    Random random = new Random();
	    long range = (long)aEnd - (long)aStart + 1;
	    long fraction = (long)(range * random.nextDouble());
	    
	    return (int)(fraction + aStart);    
	  }    
}
