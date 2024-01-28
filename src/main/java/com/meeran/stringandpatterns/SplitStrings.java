package com.meeran.stringandpatterns;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class SplitStrings {
	public static String[] solution(String s) {
        //Write your code here
		int size=0;
		if(s.length()%2==0) size=s.length()/2;
		else size=s.length()/2+1;
		String[] solution = new String[size];
		int k=0;
		for(int i=0;i<s.length()-1;i+=2,k++) {
			solution[k]=s.charAt(i)+""+s.charAt(i+1);
		}
		if(s.length()%2!=0) {
			solution[k]=s.charAt(s.length()-1)+"_";
		}
		return solution;
    }
	
	@Test
    public void testEvenString() {
       String s = "abcdef";
       String s1 = "HelloWorld";
       assertEquals("[ab, cd, ef]", Arrays.toString(solution(s)));
       assertEquals("[He, ll, oW, or, ld]", Arrays.toString(solution(s1)));
    }
    
    @Test
    public void testOddString() {
       String s = "abcde";
       String s1 = "LovePizza";
       assertEquals("[ab, cd, e_]", Arrays.toString(solution(s)));
       assertEquals("[Lo, ve, Pi, zz, a_]", Arrays.toString(solution(s1)));
    }
}
