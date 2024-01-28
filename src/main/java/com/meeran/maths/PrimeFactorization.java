package com.meeran.maths;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class PrimeFactorization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static ArrayList<Integer>primeFactorization(int x) {
		ArrayList<Integer> result = new ArrayList<>();
		
		while(x%2==0) {
			if(x%2==0) result.add(2);
			x/=2;
		}
		for(int i=3; i<Math.sqrt(x); i+=2) {
			while(x%i==0) {
				if(x%i==0) result.add(i);
				x/=i;
			}
		}
		if(x>2)result.add(x);
		return result;
	}
	
	@Test
	public void testPrimeFactorization() {
		assertEquals(Arrays.asList(2,3), primeFactorization(6));
		assertEquals(Arrays.asList(5), primeFactorization(5));
		assertEquals(Arrays.asList(2,2,3), primeFactorization(12));
		assertEquals(Arrays.asList(3,3,5,7), primeFactorization(315));
	}

}
