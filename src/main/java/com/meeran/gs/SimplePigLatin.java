package com.meeran.gs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.Test;

public class SimplePigLatin {

	public String pigIt(String str) {
		return Arrays.stream(str.split(" "))
		.map(w->w.matches("[A-Za-z]+") ? w.substring(1,w.length())+w.substring(0,1)+"ay" : w)
		.collect(Collectors.joining(" "));
	}
	
	@Test
	public void testSimplePigLatin() {
		assertEquals("igPay atinlay siay oolcay",pigIt("Pig latin is cool"));
        assertEquals("hisTay siay ymay tringsay",pigIt("This is my string"));
        assertEquals("hisTay siay aay tringsay",pigIt("This is a string"));
	}
	
}
