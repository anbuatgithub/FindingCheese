package com.meeran.gs;

import static java.lang.Character.isLowerCase;
import static java.lang.Character.toLowerCase;
import static java.lang.Character.toUpperCase;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class AlternateCase {

	static String toAlternativeString1(String str) {
		String result = "";
		for(char ch : str.toCharArray()) {
			if(ch>='A' && ch<='Z') {
				result += Character.toLowerCase(ch);
			}else if(ch>='a' && ch<='z') {
				result += Character.toUpperCase(ch);
			}else {
				result+=ch;
			}
		}
		return result;
	}
	
	static String toAlternativeString2(String str) {
		String result = "";
		for(Character ch : str.toCharArray()) {
			if(Character.isUpperCase(ch)) {
				result += Character.toLowerCase(ch);
			}else {
				result+= Character.toUpperCase(ch);
			}
		}
		return result;
	}
	
	static String toAlternativeString(String str) {
		return str.chars()
				.map(ch -> isLowerCase(ch) ? toUpperCase(ch) : toLowerCase(ch))
				.collect(StringBuilder:: new, StringBuilder::appendCodePoint, StringBuilder::append)
				.toString();
	}

	static String toAlternativeString4(String str) {
		char[] arr= str.toCharArray();
		Character[] newArray = new Character[arr.length];
		int i = 0;
		for (char value : arr) {
			newArray[i++] = Character.valueOf(value);
		}

		return Arrays.stream(newArray)
				.map(ch -> isLowerCase(ch) ? toUpperCase(ch) : toLowerCase(ch))
				.collect(StringBuilder:: new, StringBuilder::append, StringBuilder::append)
				.toString();
	}


	static String toAlternativeString6(String str) {
		return String.valueOf(str.chars()
				.map(ch -> isLowerCase(ch) ? toUpperCase(ch) : toLowerCase(ch))
				.map(ch->(char) ch).toArray());
	}
	
	@Test
	public void testAlternativeString() {
		assertEquals("HELLO WORLD", toAlternativeString("hello world"));
		assertEquals("hello world", toAlternativeString("HELLO WORLD"));
		assertEquals("HELLO world", toAlternativeString("hello WORLD"));
		assertEquals("hEllO wOrld", toAlternativeString("HeLLo WoRLD"));
		assertEquals("12345", toAlternativeString("12345"));
		assertEquals("1A2B3C4D5E", toAlternativeString("1a2b3c4d5e"));
	}

	@Test
	public void testAlternativeString6() {
		assertEquals("HELLO WORLD", toAlternativeString6("hello world"));
		assertEquals("hello world", toAlternativeString6("HELLO WORLD"));
		assertEquals("HELLO world", toAlternativeString6("hello WORLD"));
		assertEquals("hEllO wOrld", toAlternativeString6("HeLLo WoRLD"));
		assertEquals("12345", toAlternativeString6("12345"));
		assertEquals("1A2B3C4D5E", toAlternativeString6("1a2b3c4d5e"));
	}
	
	@Test
	public void testAlternativeString1() {
		assertEquals("HELLO WORLD", toAlternativeString1("hello world"));
		assertEquals("hello world", toAlternativeString1("HELLO WORLD"));
		assertEquals("HELLO world", toAlternativeString1("hello WORLD"));
		assertEquals("hEllO wOrld", toAlternativeString1("HeLLo WoRLD"));
		assertEquals("12345", toAlternativeString1("12345"));
		assertEquals("1A2B3C4D5E", toAlternativeString1("1a2b3c4d5e"));
	}
	
	@Test
	public void testAlternativeString2() {
		assertEquals("HELLO WORLD", toAlternativeString2("hello world"));
		assertEquals("hello world", toAlternativeString2("HELLO WORLD"));
		assertEquals("HELLO world", toAlternativeString2("hello WORLD"));
		assertEquals("hEllO wOrld", toAlternativeString2("HeLLo WoRLD"));
		assertEquals("12345", toAlternativeString2("12345"));
		assertEquals("1A2B3C4D5E", toAlternativeString2("1a2b3c4d5e"));
	}
	
	@Test
	public void testAlternativeString3() {
		assertEquals("HELLO WORLD", toAlternativeString3("hello world"));
		assertEquals("hello world", toAlternativeString3("HELLO WORLD"));
		assertEquals("HELLO world", toAlternativeString3("hello WORLD"));
		assertEquals("hEllO wOrld", toAlternativeString3("HeLLo WoRLD"));
		assertEquals("12345", toAlternativeString3("12345"));
		assertEquals("1A2B3C4D5E", toAlternativeString3("1a2b3c4d5e"));
	}
	
	String toAlternativeString3(String str) {
		StringBuffer outputStr = new StringBuffer();
		for(Character ch: str.toCharArray()) {
			if(Character.isLowerCase(ch)) outputStr.append(Character.toUpperCase(ch));
			else outputStr.append(Character.toLowerCase(ch));
		}
		return outputStr.toString();
	}

}
