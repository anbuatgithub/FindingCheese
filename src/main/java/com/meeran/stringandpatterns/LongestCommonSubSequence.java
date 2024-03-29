package com.meeran.stringandpatterns;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class LongestCommonSubSequence {
	static String lcs_recurrsion(String a, String b) {
	    int aLen = a.length();
	    int bLen = b.length();
	    if(aLen == 0 || bLen == 0){
	        return "";
	    }else if(a.charAt(aLen-1) == b.charAt(bLen-1)){
	        return lcs(a.substring(0,aLen-1),b.substring(0,bLen-1))
	            + a.charAt(aLen-1);
	    }else{
	        String x = lcs(a, b.substring(0,bLen-1));
	        String y = lcs(a.substring(0,aLen-1), b);
	        return (x.length() > y.length()) ? x : y;
	    }
	}
	
	public static String lcs(String a, String b) {
	    int[][] lengths = new int[a.length()+1][b.length()+1];

	    // row 0 and column 0 are initialized to 0 already

	    for (int i = 0; i < a.length(); i++)
	        for (int j = 0; j < b.length(); j++)
	            if (a.charAt(i) == b.charAt(j))
	                lengths[i+1][j+1] = lengths[i][j] + 1;
	            else
	                lengths[i+1][j+1] =
	                    Math.max(lengths[i+1][j], lengths[i][j+1]);

	    // read the substring out from the matrix
	    StringBuffer sb = new StringBuffer();
	    for (int x = a.length(), y = b.length();
	         x != 0 && y != 0; ) {
	        if (lengths[x][y] == lengths[x-1][y])
	            x--;
	        else if (lengths[x][y] == lengths[x][y-1])
	            y--;
	        else {
	            assert a.charAt(x-1) == b.charAt(y-1);
	            sb.append(a.charAt(x-1));
	            x--;
	            y--;
	        }
	    }

	    return sb.reverse().toString();
	}
	
	@Test
	public void fixedTests() {
		assertEquals("", lcs("", ""));
		assertEquals("", lcs("abc", ""));
		assertEquals("", lcs("", "abc"));
		assertEquals("", lcs("a", "b"));
		assertEquals("a", lcs("a", "a"));
		assertEquals("ac", lcs("abc", "ac"));
		assertEquals("abc", lcs("abcdef", "abc"));
		assertEquals("acf", lcs("abcdef", "acf"));
		assertEquals("nottest", lcs("anothertest", "notatest"));
		assertEquals("12356", lcs("132535365", "123456789"));
		assertEquals("final", lcs("nothardlythefinaltest", "zzzfinallyzzz"));
		assertEquals("acdefghijklmnoq", lcs("abcdefghijklmnopq", "apcdefghijklmnobq"));
	}
}
