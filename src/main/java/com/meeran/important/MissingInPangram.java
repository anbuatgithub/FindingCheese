package com.meeran.important;

import java.util.*;

public class MissingInPangram {
	public static void main(String Args[]) {
		String str = "The quick brown fox jumps over the dog";
		
		ArrayList<Character> missingChar = getMissingChar(str);
		
		for(Character misschar : missingChar) {
			System.out.print(misschar);
		}
	}
	
	static ArrayList<Character> getMissingChar(String str) {
		boolean[] present = new boolean[26];
		for(Character ch: str.toCharArray()) {
			if(ch>='A' && ch<='Z') present[ch-'A']=true;
			if(ch>='a' && ch<='z') present[ch-'a']=true;
		}
		ArrayList<Character> list = new ArrayList<Character>();
		for(int i=0; i<26;i++) if(present[i]==false) list.add((char)(i+'a'));
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	static ArrayList<Character> getMissingChar1(String str) {
		ArrayList<Character> missingChar = new ArrayList<Character>();
		
		boolean[] present = new boolean[26];
		
		for(int i=0; i<str.length(); i++) {
			if('A'<= str.charAt(i) && str.charAt(i)<='Z') {
				present[str.charAt(i)-'A'] = true;
			}
			if('a'<= str.charAt(i) && str.charAt(i)<='z') {
				present[str.charAt(i)-'a'] = true;
			}
		}
		
		for(int i=0; i<26; i++) {
			if(present[i]==false) {
				missingChar.add((char)(i + 'a'));
			}
		}
		
		return missingChar;
	}
	
}
