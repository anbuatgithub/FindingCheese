package com.meeran.stringandpatterns;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Stack;

import org.junit.Test;

public class ReverseAString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static String reverseStr( String str ){
		String output="";
		Stack<Character> stack = new Stack<>();
		for(Character ch : str.toCharArray()) stack.add(ch);
		
		while(!stack.isEmpty()) output+=stack.pop();
		
		return output;
	}
	
	@Test
	public void testReverseStr() {
		assertEquals("dcba", reverseStr("abcd"));
	}

}
