package com.meeran.maths;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

public class Powerof10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static boolean isPowerOf10(int x){
		/*if(x==0) return false;
		if(x==1 || x%10==0) return true;
		else return false;*/
		while(x>1) {
			if(x%10==0) return true;
			x/=10;
		}
		return x==1;
	}
	
	@Test
	public void testPowerOfTen() {
	    assertTrue(isPowerOf10(1)); 
	    assertTrue(isPowerOf10(1000));
	    assertFalse(isPowerOf10(4));
	    assertFalse(isPowerOf10(0));
	    assertTrue(isPowerOf10(10));
	    assertTrue(isPowerOf10(100));
	}
}
