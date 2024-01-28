package com.meeran.dynamicprogramming;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;

import org.junit.Test;

public class UniqueTuples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	public static HashSet<String>uniqueTuples( String input, int len ){
		
		HashSet<String> outputSet = new LinkedHashSet<String>();
		for(int i=0; i<=input.length()-len;i++) {
			outputSet.add(input.substring(i,i+len));
		}
		return outputSet;
	}
	
	@Test
	public void testUniqueTuples() {
		assertEquals("[abc, bca]", Arrays.toString(uniqueTuples("abca", 3).toArray()));
		assertEquals("[ab, bb, bc, cc, cd, de]", Arrays.toString(uniqueTuples("abbccde", 2).toArray()));
	}
	

}
