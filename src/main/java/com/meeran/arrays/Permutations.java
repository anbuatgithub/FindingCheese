package com.meeran.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.junit.Test;

public class Permutations {
	public static List<String> singlePermutations(String s) {
        // Your code here!
		TreeSet<String> outputSet = new TreeSet<String>();
		List<String> outputList = new ArrayList<String>();
		permutation(0, new StringBuilder(s), outputSet);
		outputList.addAll(outputSet);
		return outputList;
    }
	
	private static void permutation(int index, StringBuilder sb, TreeSet<String> outputSet) {
        if (index == sb.length()) {
        	outputSet.add(sb.toString());
        } else {
            for (int i = index; i < sb.length(); i++) {
            	char temp = sb.charAt(i);
            	sb.setCharAt(i, sb.charAt(index));
                sb.setCharAt(index, temp);
                permutation(index + 1, new StringBuilder(sb), outputSet);
                temp = sb.charAt(i);
                sb.setCharAt(i, sb.charAt(index));
                sb.setCharAt(index, temp);
            }
        }
    }
	
	@Test 
	public void example1() {
        assertEquals( new ArrayList<String>(Arrays.asList("a")),
                      Permutations.singlePermutations("a").stream().sorted().collect(Collectors.toList()) );
    }
    
    @Test 
    public void example2() {
        assertEquals( new ArrayList<String>(Arrays.asList("ab","ba")),
                      Permutations.singlePermutations("ab").stream().sorted().collect(Collectors.toList()) );
    }
    
    @Test 
    public void example3() {
        assertEquals( new ArrayList<String>(Arrays.asList("aabb", "abab", "abba", "baab", "baba", "bbaa")),
                      Permutations.singlePermutations("aabb").stream().sorted().collect(Collectors.toList()) );
    }
}
