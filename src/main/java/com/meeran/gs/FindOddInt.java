package com.meeran.gs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class FindOddInt {

	public static int findIt(int[] a) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0; i<a.length; i++) {
			map.put(a[i], map.getOrDefault(a[i], 0)+1);
		}

		//System.out.println(map);
		return map.values().stream().filter(e->e.intValue()%2!=0).findFirst().get();
		//return map.entrySet().stream().filter(e->e.getValue()%2!=0).findFirst().get().getKey();
	  }
	
	@Test
	public void testFindOddInt() {
		assertEquals(5, findIt(new int[]{20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5})); 
		assertEquals(-1, findIt(new int[]{1,1,2,-2,5,2,4,4,-1,-2,5})); 
		assertEquals(5, findIt(new int[]{20,1,1,2,2,3,3,5,5,4,20,4,5})); 
		assertEquals(10, findIt(new int[]{10})); 
		assertEquals(10, findIt(new int[]{1,1,1,1,1,1,10,1,1,1,1})); 
		assertEquals(1, findIt(new int[]{5,4,3,2,1,5,4,3,2,10,10})); 
	}
}
