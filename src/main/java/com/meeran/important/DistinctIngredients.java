package com.meeran.important;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class DistinctIngredients {
	
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
	
	static String getDistinctIngredients1(String str) {
		StringBuilder resultStr = new StringBuilder();
		
		resultStr.append(str.charAt(0));
		int i=1;
		while(i<str.length()) {
			if(str.charAt(0)==str.charAt(i)) {
				if(2*i <= str.length() && str.substring(0, i).equals(str.substring(i, 2*i))) {
					resultStr.append(',');
					resultStr.append('*');
					i+=i;
					continue;
				}else {
					resultStr.append(',');
					resultStr.append(str.charAt(i));
					i++;
					continue;
				}
			}else {
				resultStr.append(',');
				resultStr.append(str.charAt(i));
				i++;
				continue;
			}
		}
		return resultStr.toString();
	}
	
	@Test
	public void testDistinctIngredients() {
		assertEquals("A,B,*,C,*,D",getDistinctIngredients("ABABCABABCD"));
		assertEquals("A,B,C,*,E,A",getDistinctIngredients("ABCABCEA"));
		assertEquals("A",getDistinctIngredients("A"));
		assertEquals("a,*,b,b,c,c,b,b,c,c,*",getDistinctIngredients("aabbccbbccaabbccbbcc"));
	}
}
