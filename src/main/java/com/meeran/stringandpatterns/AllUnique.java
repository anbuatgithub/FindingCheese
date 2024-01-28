package com.meeran.stringandpatterns;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class AllUnique {
	public static boolean hasUniqueChars(String str) {
		return str.chars().distinct().count() == str.length();
    }
	
	public static boolean hasUniqueChars1(String str) {
	      Map<Character,Integer> map = new HashMap<Character,Integer>();
	      for(Character ch : str.toCharArray()) map.put(ch, map.getOrDefault(ch, 0)+1); 
	      return  map.values().stream().filter(e->e>1).count() >0 ? false : true;
  }
	
	@Test
    public void testBasicExamples() {
        assertFalse(hasUniqueChars1("  nAa"));
		assertTrue(hasUniqueChars1("abcde"));
		assertFalse(hasUniqueChars1("++-"));
		assertTrue(hasUniqueChars1("AaBbc"));
		 
    }
}
