package com.meeran.stringandpatterns;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class PhoneWords {
	public static String phoneWords(String str) {
	    // 416666663105558822255
	    
	    return str == null || str.isBlank() ? "" : str
	                        .replaceAll("222", "c")
	                        .replaceAll("22", "b")
	                        .replaceAll("2", "a")
	                        .replaceAll("333", "f")
	                        .replaceAll("33", "e")
	                        .replaceAll("3", "d")
	                        .replaceAll("444", "i")
	                        .replaceAll("44", "h")
	                        .replaceAll("4", "g")
	                        .replaceAll("555", "l")
	                        .replaceAll("55", "k")
	                        .replaceAll("5", "j")
	                        .replaceAll("666", "o")
	                        .replaceAll("66", "n")
	                        .replaceAll("6", "m")
	                        .replaceAll("7777", "s")
	                        .replaceAll("777", "r")
	                        .replaceAll("77", "q")
	                        .replaceAll("7", "p")
	                        .replaceAll("888", "v")
	                        .replaceAll("88", "u")
	                        .replaceAll("8", "t")
	                        .replaceAll("9999", "z")
	                        .replaceAll("999", "y")
	                        .replaceAll("99", "x")
	                        .replaceAll("9", "w")
	                        .replaceAll("0", " ")
	                        .replaceAll("1", "");
	  }  
	
	@Test
	public void edgeCasesTest(){
		assertEquals("", PhoneWords.phoneWords(""));
		assertEquals("", PhoneWords.phoneWords("111"));
    assertEquals("", PhoneWords.phoneWords(null));
	}

	@Test
	public void basicTest() {
		assertEquals("hello how are you", PhoneWords.phoneWords("443355555566604466690277733099966688"));
		assertEquals("kata", PhoneWords.phoneWords("55282"));
		assertEquals("im a tester", PhoneWords.phoneWords("44460208337777833777"));
		assertEquals("codewars", PhoneWords.phoneWords("22266631339277717777"));
		assertEquals("null", PhoneWords.phoneWords("66885551555"));
		assertEquals("text", PhoneWords.phoneWords("833998"));
		assertEquals("   ", PhoneWords.phoneWords("000"));
		assertEquals("java", PhoneWords.phoneWords("528882"));
		assertEquals("kumite", PhoneWords.phoneWords("55886444833"));
		assertEquals("apple", PhoneWords.phoneWords("271755533"));
	}
}
