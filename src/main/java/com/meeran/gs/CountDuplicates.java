package com.meeran.gs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;

import org.junit.Test;

public class CountDuplicates {

	public static int duplicateCount(String text) {
	    // Write your code here
		String input = text.toLowerCase();
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		
		for(Character ch : input.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0)+1);
		}
		//return (int) map.entrySet().stream().filter(e->e.getValue()>1).count();
		return (int) map.values().stream().filter(e->e >1).count(); 
	  }
	
	@Test
	public void testCountDuplicates() {
		assertEquals(0,duplicateCount("abcde"));
		assertEquals(1,duplicateCount("abcdeaa"));
		assertEquals(1,duplicateCount("indivisibility"));
		 
		String testThousandA = new String(new char[1000]).replace('\0', 'a');
		String te = new String(new char[5]).replace('\0', 'a');
		System.out.println('\0');

		 String testHundredB = new String(new char[100]).replace('\0', 'b');
		 String testTenC = new String(new char[10]).replace('\0', 'c');
		 String test1CapitalA = new String(new char[1]).replace('\0', 'A'); 
		 String test1d = new String(new char[1]).replace('\0', 'd'); 
		 String test = test1d + test1CapitalA + testTenC +
            testHundredB + testThousandA;
		System.out.println(test);
        
		 assertEquals(3,duplicateCount(test));
	}

}
