package com.meeran.maths;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class AddFraction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] fraction1 = {2, 3};
		int[] fraction2 = {1, 2};
		int[] result1 = addFractions(fraction1, fraction2);
		System.out.println("result=7,6=>"+Arrays.toString(result1));
		
		int[] fraction3 = {1, 500};
		int[] fraction4 = {2, 1500};
		int[] result2 = addFractions(fraction3, fraction4);
		System.out.println("result=1,300=>"+Arrays.toString(result2));
		
		int[] fraction5 = {1, 2};
		int[] fraction6 = {3, 2};
		int[] result3 = addFractions(fraction5, fraction6);
		System.out.println("result=2,1=>"+Arrays.toString(result3));
		
		int[] fraction7 = {1, 3};
		int[] fraction8 = {3, 9};
		int[] result4 = addFractions(fraction7, fraction8);
		System.out.println("result=2,3=>"+Arrays.toString(result4));
		
	}
	static int[] addFractions ( int[] fraction1, int[] fraction2 ){
		//numerator
		int numerator = (fraction1[0] * fraction2[1]) + (fraction1[1] * fraction2[0]);
		int denominator = fraction1[1] * fraction2[1];
		
		//find gcd
		int gcd=1;
		for(int i=1; i<=numerator && i<=denominator; ++i) {
			if(numerator%i==0 && denominator%i==0) gcd=i;
		}
		
		return new int[] {numerator/gcd, denominator/gcd};
	}
	
	@Test
	public void testAddFractions() {
		int[] array1 = {2, 3};
		int[] array2 = {1, 2};
		int[] output= {7,6};
	    assertEquals(Arrays.toString(output),Arrays.toString(addFractions(array1,array2))); 
	}
}
