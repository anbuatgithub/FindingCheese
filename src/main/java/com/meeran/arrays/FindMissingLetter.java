package com.meeran.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class FindMissingLetter {
	public static char findMissingLetter(char[] array) {
		for (int i = 1; i < array.length; i++) if (array[i]-array[i-1]!=1) return (char)(array[i]-1);
		return ' ';
	}
	
	public static char findMissingLetter1(char[] array) {
		for (int i = 1; i < array.length; i++) {
			char nextChar = (char) (((int) array[i - 1]) + 1);
			if (nextChar != array[i])
				return nextChar;
		}
		return ' ';
	}
	

	@Test
	public void exampleTests() {
		assertEquals('e', findMissingLetter(new char[] { 'a', 'b', 'c', 'd', 'f' }));
		assertEquals('P', findMissingLetter(new char[] { 'O', 'Q', 'R', 'S' }));
	}
}
