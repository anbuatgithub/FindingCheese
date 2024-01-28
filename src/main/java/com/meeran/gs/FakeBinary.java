package com.meeran.gs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

// Given a string of digits, you should replace any digit below 5 with '0' and any digit 5 and 
// above with '1'. Return the resulting string.
public class FakeBinary {
	
	public static String fakeBin1(String numberString) {
		
		String output="";
		for(Character ch : numberString.toCharArray()) {
			if(ch <'5') {
				output+=0;
			}else {
				output+=1;
			}
		}
        return output;
    }
	
	public static String fakeBin(String numberString) {
        return numberString.replaceAll("[0-4]", "0").replaceAll("[5-9]", "1");
    }
	
	@Test
	public void testFakeBin() {
		assertEquals("01011110001100111", fakeBin("45385593107843568"));
		assertEquals("101000111101101", fakeBin("509321967506747"));
		assertEquals("011011110000101010000011011", fakeBin("366058562030849490134388085"));
	}
	
	@Test
	public void testFakeBin1() {
		assertEquals("01011110001100111", fakeBin1("45385593107843568"));
		assertEquals("101000111101101", fakeBin1("509321967506747"));
		assertEquals("011011110000101010000011011", fakeBin1("366058562030849490134388085"));
	}
	
}
