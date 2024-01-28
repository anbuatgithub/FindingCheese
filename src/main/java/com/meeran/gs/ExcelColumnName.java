package com.meeran.gs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class ExcelColumnName {

	static int titleToNumber(String s) {
		int result=0;
		for(int i=0; i<s.length();i++) {
			result = result*26;
			result+= s.charAt(i)-'A'+1;
		}
		return result;
	}
	
	static String numberToTitle(int num) {
		String result="";
		
		while(num>0) {
			num--;
			num=num/26;
			result = (char) ('A'+ num%26) +result;
			
		}
		return result;
	}
	
	@Test
	public void testTitleToNumber() {
		assertEquals(1, titleToNumber("A"));
		assertEquals(28, titleToNumber("AB"));
	}
	
	@Test
	public void testNumberToTitle() {
		assertEquals("AB", numberToTitle(28));
	}

}
