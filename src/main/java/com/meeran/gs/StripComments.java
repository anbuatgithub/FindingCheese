package com.meeran.gs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.Test;

public class StripComments {

	public static String stripComments(String text, String[] commentSymbols) {
	    return text.replaceAll(" *([" + String.join("", commentSymbols) + "].*)?(\n|$)", "$2");
	  }
	
	public static String stripComments1(String text, String[] commentSymbols) {
		return Arrays.stream(text.split("\n")).map(s -> {
            for (String symbol : commentSymbols) s = s.replaceAll("(\\s+$)|(\\s*[" + symbol + "].*)", "");
            return s;
        }).collect(Collectors.joining("\n"));
	}
	
	public static String stripComments2(String text, String[] commentSymbols) {
		
		String pattern = String.format("[ ]*([%s].*)?$", Arrays.stream(commentSymbols).collect(Collectors.joining()));
		
		return Arrays.stream(text.split("\n"))
				.map(x -> x.replaceAll(pattern,""))
				.collect(Collectors.joining("\n"));
	}
	
	@Test
	public void testStripComments() {
		assertEquals("apples,pears\ngrapes\nbananas" ,
				stripComments2( "apples,pears # and bananas\ngrapes\nbananas !apples " , new String[] { "# " + "!" } )
		);

		assertEquals("a\nc\nd",
				stripComments2( "a #b\nc\nd $e f g" , new String[] { "#", "$" } )
		);
	}

}
