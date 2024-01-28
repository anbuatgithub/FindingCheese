package com.meeran.dynamicprogramming;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class Staircase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	//the child wants to have fun, too, so instead
	//of taking 1 step at a time, it will vary between taking
	//either 1, 2 or 3 steps at a time.
	public static Integer countSteps(Integer n) {
		if(n<0) return 0;
		return count_Steps(0,n);
	}
	
	public static Integer count_Steps(Integer i, Integer n) {
		if(i>n) return 0;
		if(i==n) return 1;
		return count_Steps(i+1,n)+count_Steps(i+2, n)+count_Steps(i+3, n);
	}
	
	public static Integer climbStairs (Integer n) {
		if(n<0) return 0;
		if(n==1) return 1;
		if(n==2) return 2;
		int[] steps = new int[n+1];
		steps[1]=1;
		steps[2]=2;
		steps[3]=4;
		for(int i=4;i<=n;i++) steps[i]=steps[i-1]+steps[i-2]+steps[i-3];
		return steps[n];
	}
	
	
	@Test
	public void testCountSteps() {
		assertEquals(4, countSteps(3));
		assertEquals(1, countSteps(1));
		assertEquals(2, countSteps(2));
		assertEquals(274, countSteps(10));
		assertEquals(0, countSteps(-5));
	}
	
	@Test
	public void testClimbStairs() {
		assertEquals(4, climbStairs(3));
		assertEquals(1, climbStairs(1));
		assertEquals(2, climbStairs(2));
		assertEquals(274, climbStairs(10));
		assertEquals(0, climbStairs(-5));
	}

}
