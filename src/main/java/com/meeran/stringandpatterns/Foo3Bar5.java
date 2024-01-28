package com.meeran.stringandpatterns;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Foo3Bar5 {
	
	public static String fooOrBar(int number) {
		if(number==0) return "";
		StringBuilder result = new StringBuilder();
		if(number%3==0) result.append("Foo");
		if(number%5==0) result.append("Bar");
		
		for(char ch : Integer.toString(number).toCharArray())  result.append(getFooOrBar(ch));
		return number <0 ? "-"+result.toString() : result.toString();
	}

	private static String getFooOrBar(char ch) {
		return ch=='3'?"Foo":ch=='5'?"Bar":"";
	} 
	
	@Test
	public void testFooOrBar() {
		assertEquals("FooFoo", fooOrBar(3));
		assertEquals("BarBar", fooOrBar(5));
		assertEquals("Foo", fooOrBar(13));
		assertEquals("FooBarBar", fooOrBar(15));
		assertEquals("Bar", fooOrBar(100));
		assertEquals("FooBarFooBar", fooOrBar(135));
		assertEquals("", fooOrBar(0));
		assertEquals("", fooOrBar(19));
		assertEquals("-FooFoo", fooOrBar(-3));
	}

}
