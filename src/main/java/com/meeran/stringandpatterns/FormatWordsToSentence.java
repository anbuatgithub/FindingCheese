package com.meeran.stringandpatterns;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

public class FormatWordsToSentence {
	public static String formatWords(String[] words) {
	    // Do the things...
		if(words== null || words.length==0) return "";
		String output = Arrays.asList(words)
		          .stream()
		          .filter(word -> !(word == null))
		          .filter(word -> !word.equals(""))
		          .collect(Collectors.joining(", "));
	    if(! output.contains(",")) return output;
	    else return output.substring(0, output.lastIndexOf(",")) + " and" +output.substring(output.lastIndexOf(",") + 1);
	  }
	
private static Random rnd = new Random();
    
    private static String generateRandomWord() {
      return IntStream.range(0, rnd.nextInt(10)).mapToObj(x -> Character.toString((char) (rnd.nextInt((123 - 97) + 1) + 97))).collect(Collectors.joining());
    }
    
    private static String solution(String[] words) {
      return words == null || words.length == 0
        ? ""
        : Stream.of(words).filter(x -> !x.isEmpty()).collect(Collectors.joining(", ")).replaceAll(", (?=\\S+$)", " and ");
    }
    
    @Test
    public void sampleTests() {
        assertEquals("one, two, three and four", formatWords(new String[] {"one", "two", "three", "four"}));
        assertEquals("one", formatWords(new String[] {"one"}));
        assertEquals("one and three", formatWords(new String[] {"one", "", "three"}));
        assertEquals("three", formatWords(new String[] {"", "", "three"}));
        assertEquals("one and two", formatWords(new String[] {"one", "two", ""}));
        assertEquals("", formatWords(new String[] {}));
        assertEquals("", formatWords(null));
        assertEquals("", formatWords(new String[] {""}));
    }
    
    @Test
    public void randomTests() {
      int tests = 100;
      
      for (int i = 0; i < tests; i++) {
        String[] test = IntStream.range(0, rnd.nextInt(20)).mapToObj(x -> generateRandomWord()).toArray(String[]::new);
        if (rnd.nextInt(20) == 0) test = null;
        
        String expected = solution(test);
        String actual = formatWords(test);
        
        assertEquals(expected, actual);
      }
    }
}
