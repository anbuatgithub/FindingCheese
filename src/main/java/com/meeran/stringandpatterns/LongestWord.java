package com.meeran.stringandpatterns;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class LongestWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String[] longestWord(String letters, String[] dictionary) {
		ArrayList<String> result = new ArrayList<String>();
		int maxLength=0;
		for(String word : dictionary) {
			if(isMatches(letters, word)) {
				if(maxLength<word.length()) {
					maxLength=word.length();
					result.clear();
				}
				if(!result.contains(word)) result.add(word);
			}
		}
		return  result.toArray(String[]::new);
	}
	
	boolean isMatches(String letters, String word) {
		for(Character ch : word.toCharArray()) {
			if(letters.indexOf(ch)==-1)return false;
		}
		return true;
	}
	
	@Test
	public void testLongestWord() {
		String[] input = new String[]{"to", "toe", "toes", "doe", "dog", "god", "dogs",
				"book", "banana"};
		
		assertEquals(Arrays.toString(new String[] {"toe"}), Arrays.toString(longestWord("toe", input)));
		assertEquals(Arrays.toString(new String[] {"toe","doe", "dog", "god"}), Arrays.toString(longestWord("oetdg", input)));
	}

}
