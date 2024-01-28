package com.meeran.gs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.TreeSet;

import org.junit.Test;

public class UglyNumber {

	static int nthUglyNumber(int n) {
		
		TreeSet<Integer> set = new TreeSet<>();
		set.add(1);
		int count =1;
		while(count<n) {
			int temp = set.pollFirst();
			set.add(temp*2);
			set.add(temp*3);
			set.add(temp*5);
			count++;
			
		}
		return set.pollFirst();
	}
	
	@Test
	public void testUglyNumber() {
		int n = 150;
        assertEquals(5832,nthUglyNumber(n));
	}

	public static void main(String[] args) {


		System.out.println(UglyNumber.nthUglyNumber(4));



	}

}
