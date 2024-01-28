package com.meeran.numeric;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.Test;

public class ProductFib {
	public static long[] productFib(long prod) {
	    // your code
		long n1 = 0, n2=1;
		long[] output = new long[3];
		while(n1*n2 <= prod) {
			if(n1*n2==prod) {
				output[0]=n1;
				output[1]=n2;
				output[2]=1;
				return output;
			}
			n2+=n1;   
			n1=n2-n1;
		}
		output[0]=n1;
		output[1]=n2;
		output[2]=0;
		return output;
   }
	
	@Test
	public void test1() {
		long[] r = new long[] {55, 89, 1};
		assertArrayEquals(r, productFib(4895));
	}
	@Test
	public void test2() {
		long[] r = new long[] {89, 144, 0};
		assertArrayEquals(r, productFib(5895));
	}
}
