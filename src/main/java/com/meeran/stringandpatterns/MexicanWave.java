package com.meeran.stringandpatterns;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import org.junit.Test;

public class MexicanWave {
	public static String[] wave(String str) {
        // Your code here
		int len = str.replaceAll("\\s","").length();
		String[] waves = new String[len];
		for (int i=0,j=0; i<str.length(); i++,j++) {
			StringBuilder sb = new StringBuilder(str);
            while (Character.toString(str.charAt(i)).equals(" ")) {
                if (i+1>=str.length()) return waves;
                i++;
            }
            sb.setCharAt(i, Character.toUpperCase(str.charAt(i)));
            waves[j] = sb.toString();
        }
        return waves;
    }
	
	@Test
    public void basicTest1() {
        System.out.println("Testing for 'a       b    '");
        String[] result = new String[] { "A       b    ", "a       B    " };
        assertArrayEquals("it should return '" + Arrays.toString(result) + "'", result, MexicanWave.wave("a       b    "));
    }
    
    @Test
    public void basicTest2() {
        System.out.println("Testing for 'this is a few words'");
        String[] result = new String[] { "This is a few words", "tHis is a few words", "thIs is a few words", "thiS is a few words", "this Is a few words", "this iS a few words", "this is A few words", "this is a Few words", "this is a fEw words", "this is a feW words", "this is a few Words", "this is a few wOrds", "this is a few woRds", "this is a few worDs", "this is a few wordS" };
        assertArrayEquals("it should return '" + Arrays.toString(result) + "'", result, MexicanWave.wave("this is a few words"));
    }
    
    @Test
    public void basicTest3() {
        System.out.println("Testing for ''");
        String[] result = new String[] { };
        assertArrayEquals("it should return '" + Arrays.toString(result) + "'", result, MexicanWave.wave(""));
    }
    
    @Test
    public void basicTest4() {
        System.out.println("Testing for ' gap '");
        String[] result = new String[] { " Gap ", " gAp ", " gaP " };
        assertArrayEquals("it should return '" + Arrays.toString(result) + "'", result, MexicanWave.wave(" gap "));
    }
    
    @Test
    public void randomTest() {
        for (int i = 0; i <= 200; i++) {
          String word = getWord();
          System.out.println("Testing for '" + word + "'");
          String[] result = wave2(word);
          assertArrayEquals("it should return '" + Arrays.toString(result) + "'", result, MexicanWave.wave(word));
        }
    }
    
    private Random rand = new Random();
    private String letters = "abcd efghi jklmno pqrstu vwxyz";

    private String getWord() {
        StringBuilder builder = new StringBuilder();

        for (int let = 0; let < rand.nextInt(200); let++) {
            builder.append(letters.charAt(rand.nextInt(letters.length())));
        }

        return builder.toString();
    }
    
    private String[] wave2(String str) {
        return IntStream
                .range(0, str.length())
                .mapToObj(x -> new StringBuilder(str).replace(x, x+1, String.valueOf(str.charAt(x)).toUpperCase()).toString())
                .filter(x -> !x.equals(str))
                .toArray(String[]::new);
    }
}
