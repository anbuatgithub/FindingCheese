package com.meeran.gs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class ReverseAString {

	String reverseAString(String s) {
		List<String> list = new ArrayList<String>();
		list = Arrays.asList(s.split(" "));
		Collections.reverse(list);
		return String.join(" ", list);
	}

	String reverseAString4(String s) {
		return new StringBuffer(s).reverse().toString();
	}
	
	@Test
	public void testReverseAString() {
		String s = "getting good at coding needs a lot of practice" ;
		assertEquals("practice of lot a needs coding at good getting",reverseAString(s));
	}




}
