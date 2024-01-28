package com.meeran.stringandpatterns;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class MagicPortion {
	public static void main(String Args[]) {
		
	}
	
	static String getDistinctIngredients(String str) {
		StringBuilder output = new StringBuilder();
		output.append(str.charAt(0)+",");
		int i=1;
		while(i<str.length()) {
			if(str.charAt(0)==str.charAt(i)) {
				if(2*i<=str.length() &&  str.substring(0, i).equals(str.substring(i, 2*i))) {
					output.append("*,");
					i+=i;
				}else {
					output.append(str.charAt(i)+",");
					i++;
				}
			}else {
				output.append(str.charAt(i)+",");
				i++;
			}
		}
		return output.toString().substring(0,output.length()-1);
	}
	
	@Test
	public void testMagicPortion() {
		assertEquals("A,B,*,C,*,D", getDistinctIngredients("ABABCABABCD"));
		assertEquals("A,B,C,*,E,A", getDistinctIngredients("ABCABCEA"));
		assertEquals("A", getDistinctIngredients("A"));
		assertEquals("a,*,b,b,c,c,b,b,c,c,*", getDistinctIngredients("aabbccbbccaabbccbbcc"));
	}
	
	static int getMagicCount(String str) {
		int output = 1;
		int i=1;
		while(i<str.length()) {
			if(str.charAt(0)==str.charAt(i)) {
				if(2*i<=str.length() &&  str.substring(0, i).equals(str.substring(i, 2*i))) {
					output++;
					i+=i;
				}else {
					output++;
					i++;
				}
			}else {
				output++;
				i++;
			}
		}
		return output;
	}
	
	@Test
	public void testMagicCount() {
		assertEquals(6, getMagicCount("ABABCABABCD"));
		assertEquals(6, getMagicCount("ABCABCEA"));
		assertEquals(8, getMagicCount("ABCDABCE"));
		assertEquals(5, getMagicCount("ABCABCE"));
		assertEquals(1, getMagicCount("A"));
		assertEquals(11, getMagicCount("aabbccbbccaabbccbbcc"));
	}
	
}
