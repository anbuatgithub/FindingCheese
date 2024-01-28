package com.meeran.stringandpatterns;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class RunLengthEncoding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	String rle(String input) {
		String output="";
		int count=1;
		if(input.length()==1) return input.charAt(0)+""+count;
		
		for(int i=0; i+1<input.length();i++) {
			if(input.charAt(i)==input.charAt(i+1)) {
				count++;
			}else {
				output+=input.charAt(i)+""+count;
				count=1;
			}
			if(i==input.length()-2) output+=input.charAt(i+1)+""+count;
		}
		return output;
	}
	
	@Test
	public void testRle() {
		assertEquals("a3b3a2d1", rle("aaabbbaad"));
		assertEquals("a1", rle("a"));
		assertEquals("a2", rle("aa"));
		assertEquals("a2b3", rle("aabbb"));
		assertEquals("a5", rle("aaaaa"));
	}

}
