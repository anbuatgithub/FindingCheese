package com.meeran.stringandpatterns;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class LongestUniformSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int[] longestUniformSubstring(String input) {
		int count =0;
		int maxCount=0;
		int index=-1;
		int tmpIndex=-1;
		int endIndex=-1;
		for(int i=0; i+1<input.length(); i++) {
			if(input.charAt(i)==input.charAt(i+1)) {
				if(count==0) tmpIndex=i;
				count++;
			}else {
				count=0;
			}
			if(count>maxCount) {
				maxCount=count;
				index=tmpIndex;
				endIndex=i;
			}
		}
		return new int[] {index,endIndex+1};
	}
	
	@Test
	public void testLongestUniformSubstring() {
		assertEquals(Arrays.toString(new int[] {1,4}), Arrays.toString(longestUniformSubstring("10000111")));
		assertEquals(Arrays.toString(new int[] {2,6}), Arrays.toString(longestUniformSubstring("aabbbbbCdAA")));
		assertEquals(Arrays.toString(new int[] {0,4}), Arrays.toString(longestUniformSubstring("aaaaa")));
		assertEquals(Arrays.toString(new int[] {6,13}), Arrays.toString(longestUniformSubstring("aaaaabcccccccc")));
	}

}
