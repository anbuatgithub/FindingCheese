package com.meeran.stringandpatterns;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.jupiter.api.Order;

public class Scramblies {
	public static boolean scramble(String str1, String str2) {    
		
		Map<Character,Integer> str1Map = new HashMap<>();
		Map<Character,Integer> str2Map = new HashMap<>();
		for(Character ch : str1.toCharArray()) str1Map.put(ch, str1Map.getOrDefault(ch, 0)+1);
		for(Character ch : str2.toCharArray()) str2Map.put(ch, str2Map.getOrDefault(ch, 0)+1);
		for (Map.Entry<Character, Integer> entry : str2Map.entrySet()) {
            	if(str1Map.get(entry.getKey()) != null) {
            		if (entry.getValue() > str1Map.get(entry.getKey())) return false;
            	}else return false;
        }
		return true;
	 }
	
	public static boolean scramble1(String str1, String str2) {
	    Map<String, Long> str1Map = Stream.of(str1.split("")).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
	    Map<String, Long> str2Map = Stream.of(str2.split("")).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
	    return str2Map.entrySet().stream().allMatch(e -> str1Map.get(e.getKey()) != null && e.getValue() <= str1Map.get(e.getKey()));
	  }
	
	private static void testing(boolean actual, boolean expected) {
        assertEquals(expected, actual);
    }
   
    @Test @Order(1)
    public void sampleTests() {
        testing(Scramblies.scramble("rkqodlw","world"), true);
        testing(Scramblies.scramble("cedewaraaossoqqyt","codewars"),true);
        testing(Scramblies.scramble("katas","steak"),false);
        testing(Scramblies.scramble("scriptjavx","javascript"),false);
        testing(Scramblies.scramble("scriptingjava","javascript"),true);
        testing(Scramblies.scramble("scriptsjava","javascripts"),true);
        testing(Scramblies.scramble("javscripts","javascript"),false);
        testing(Scramblies.scramble("aabbcamaomsccdd","commas"),true);
        testing(Scramblies.scramble("commas","commas"),true);
        testing(Scramblies.scramble("sammoc","commas"),true);
    }
  
  @Test @Order(2)
  public void largeTest() {
    
    String s1 = "abcdefghijklmnopqrstuvwxyz".repeat(10_000);
    String s2 = "zyxcba".repeat(9_000);
    
    testing(Scramblies.scramble(s1, s2), true);
  }
}
