package com.meeran.stringandpatterns;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class FourLetterWordMutation {

	public static int mutations(String[] alice, String[] bob, String word, int first) {
		Map<String, Integer> wordMap = new HashMap<>();
		boolean isFirstPassed = true;
		boolean isSecondPassed = true;
		String firstStr = "";
		String secondStr = "";
		if(getWord(alice, word, wordMap) == null && getWord(bob, word, wordMap) == null) return -1;
		wordMap.put(word, 1);
		while(isFirstPassed && isSecondPassed) {
			if(first==0) firstStr = getWord(alice, word, wordMap);
			else firstStr = getWord(bob, word, wordMap);
			if(firstStr!=null) {
				wordMap.put(firstStr, 1);
				isFirstPassed = true;
			}else if (secondStr!=null) {
				isFirstPassed = false;
				break;
			}else isFirstPassed = false;
			
			if(firstStr!=null) word = firstStr;
			
			if(first==0) secondStr = getWord(bob, word, wordMap);
			else secondStr = getWord(alice, word, wordMap);
			
			if(secondStr!=null) {
				wordMap.put(secondStr, 1);
				isSecondPassed = true;
			}else {
				isSecondPassed = false;
				break;
			}
			
			word = secondStr;
		}
		
	    return (isFirstPassed && !isSecondPassed) ? ((first==0) ? 0 : 1) : (!isFirstPassed && isSecondPassed) ? ((first==0) ? 1 : 0) : -1;
	  }
	
	private static String getWord(String[] player, String word, Map<String,Integer> wordMap) {
		if(word==null) return null;
		for(int i=0 ;i<player.length;i++) {
			String firstStr = player[i];
			int count=0;
			if(isUnique(firstStr) && !wordMap.containsKey(firstStr)) {
				if(word.charAt(0)==firstStr.charAt(0)) count++;
				if(word.charAt(1)==firstStr.charAt(1)) count++;
				if(word.charAt(2)==firstStr.charAt(2)) count++;
				if(word.charAt(3)==firstStr.charAt(3)) count++;
			}
			if(count==3) {
				return firstStr;
			}
		}
		return null;
	}
	
	private static boolean isUnique(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        for (int i = 1; i < chars.length; ++i) {
            if (chars[i] == chars[i-1]) {
                return false;
            }
        }
        return true;
    }
	
	@Test
    public void basicTests() {
        String[] alice = new String[]{"plat", "rend", "bear", "soar", "mare", "pare", "flap", "neat", "clan", "pore"};
        String[] bob = new String[]{"boar", "clap", "mere", "lend", "near", "peat", "pure", "more", "plan", "soap"};
        assertEquals( 0, FourLetterWordMutation.mutations(alice, bob, "maze", 0)); // Alice goes  first, Alice   wins
        assertEquals( 1, FourLetterWordMutation.mutations(alice, bob, "send", 0)); // Alice goes  first, Bob     wins
        assertEquals( 1, FourLetterWordMutation.mutations(alice, bob, "boat", 0)); // Alice fails first, Bob     wins
        assertEquals(-1, FourLetterWordMutation.mutations(alice, bob, "apse", 0)); // Alice fails first, neither wins
        assertEquals( 1, FourLetterWordMutation.mutations(alice, bob, "neat", 1)); // Bob   goes  first, Bob     wins
        assertEquals( 0, FourLetterWordMutation.mutations(alice, bob, "soar", 1)); // Bob   goes  first, Alice   wins
        assertEquals( 0, FourLetterWordMutation.mutations(alice, bob, "more", 1)); // Bob   fails first, Alice   wins
        assertEquals(-1, FourLetterWordMutation.mutations(alice, bob, "calm", 1)); // Bob   fails first, neither wins
    }
}
