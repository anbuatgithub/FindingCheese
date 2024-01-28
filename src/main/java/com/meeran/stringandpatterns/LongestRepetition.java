package com.meeran.stringandpatterns;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.Test;

public class LongestRepetition {

	public static Object[] longestRepetition(String s) {
		
		if(s.length()==0) return new Object[]{"", 0};
		if(s.length()==1) return new Object[]{s.charAt(0),1};
		StringBuilder output = new StringBuilder();
		Character current = s.charAt(0);
		int count=1;
		int maxCount=0;
		String outputStr="";
		for(int i=1;i<s.length();i++) {
			if(current == s.charAt(i)) {
				count++;
			}else {
				output.append(current+""+count);
				count=1;
				current=s.charAt(i);
			}
			if(i==s.length()-1) output.append(current+""+count);
			if(maxCount<count) {
				maxCount=count;
				outputStr = Character.toString(current);
			}
		}
		return new Object[]{outputStr,maxCount};
	   }
	
	/**
	 * 
	 */
	@Test
    public void exampleTests() {
        assertArrayEquals(new Object[]{"a", 4}, longestRepetition("aaaabb"));
        assertArrayEquals(new Object[]{"a", 4}, longestRepetition("bbbaaabaaaa"));
        assertArrayEquals(new Object[]{"u", 3}, longestRepetition("cbdeuuu900"));
        assertArrayEquals(new Object[]{"b", 5}, longestRepetition("abbbbb"));
        assertArrayEquals(new Object[]{"a", 2}, longestRepetition("aabb"));
        assertArrayEquals(new Object[]{"", 0}, longestRepetition(""));
    }
}
