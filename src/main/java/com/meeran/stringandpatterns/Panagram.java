	package com.meeran.stringandpatterns;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class Panagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	String findMissingLetters(String sentence) {
		
		boolean[] present = new boolean[26];
		
		for(int i=0; i<sentence.length();i++) {
			char ch = sentence.charAt(i);
			if(ch>='A' && ch<='Z') present[ch-'A']=true;
			if(ch>='a' && ch<='z') present[ch-'a']=true;
		}
		String output = "";
		for(int i=0;i<26;i++) {
			if(present[i]==false) output+=(char) (i+'a');
		}
		return output;
	}
	
	@Test
	public void testFindMissingLetters() {
		assertEquals("bfgjkvz", findMissingLetters("The slow purple oryx meanders past the quiescent canine"));
		assertEquals("alyz", findMissingLetters("The quick brown fox jumps over the dog"));
	}
}
