package com.meeran.stringandpatterns;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class JadenCase {
	public String toJadenCase(String phrase) {
		// TODO put your code below this comment
		if(phrase==null || phrase.equals("")) return null;
		String result="";
		for(String str :  phrase.split(" ")) {
			result += str.substring(0,1).toUpperCase() + ""+str.substring(1,str.length()).toLowerCase()+" ";
		}
		return result.equals("") ? null : result.substring(0,result.length()-1);
	}
	
	@Test
	public void test() {
		assertEquals("Most Trees Are Blue", toJadenCase("most trees are blue"));
	}
	
	@Test
	public void testNullArg() {
		assertNull(toJadenCase(null));
	}
	
	@Test
	public void testEmptyArg() {
		assertNull(toJadenCase(""));
	}
}
