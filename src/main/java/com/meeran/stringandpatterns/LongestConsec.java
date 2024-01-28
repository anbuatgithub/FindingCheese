package com.meeran.stringandpatterns;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class LongestConsec {
	public static String longestConsec(String[] strarr, int k) {
        // your code
		if(k<1 || k>strarr.length) return "";
		String result="";
		for(int i=0; i<strarr.length; i++) {
			String current = "";
			for(int j=i; j<k+i;j++) if(j<strarr.length) current+=strarr[j];
			if(result.length()<current.length()) result=current;
		}
		return result;
    }
	private static void testing(String actual, String expected) {
        assertEquals(expected, actual);
    }
    @Test
    public void test() {
        System.out.println("longestConsec Fixed Tests");
        testing(LongestConsec.longestConsec(new String[] {"zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"}, 2), "abigailtheta");
        testing(LongestConsec.longestConsec(new String[] {"ejjjjmmtthh", "zxxuueeg", "aanlljrrrxx", "dqqqaaabbb", "oocccffuucccjjjkkkjyyyeehh"}, 1), "oocccffuucccjjjkkkjyyyeehh");
        testing(LongestConsec.longestConsec(new String[] {}, 3), "");
        testing(LongestConsec.longestConsec(new String[] {"itvayloxrp","wkppqsztdkmvcuwvereiupccauycnjutlv","vweqilsfytihvrzlaodfixoyxvyuyvgpck"}, 2), "wkppqsztdkmvcuwvereiupccauycnjutlvvweqilsfytihvrzlaodfixoyxvyuyvgpck");
        testing(LongestConsec.longestConsec(new String[] {"wlwsasphmxx","owiaxujylentrklctozmymu","wpgozvxxiu"}, 2), "wlwsasphmxxowiaxujylentrklctozmymu");
        testing(LongestConsec.longestConsec(new String[] {"zone", "abigail", "theta", "form", "libe", "zas"}, -2), "");
        testing(LongestConsec.longestConsec(new String[] {"it","wkppv","ixoyx", "3452", "zzzzzzzzzzzz"}, 3), "ixoyx3452zzzzzzzzzzzz");
        testing(LongestConsec.longestConsec(new String[] {"it","wkppv","ixoyx", "3452", "zzzzzzzzzzzz"}, 15), "");
        testing(LongestConsec.longestConsec(new String[] {"it","wkppv","ixoyx", "3452", "zzzzzzzzzzzz"}, 0), "");
    }
}
