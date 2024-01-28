package com.meeran.important;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.Test;

public class BalancedParanthesis {

	public static boolean validParentheses(String parens) {
		if(parens==null || parens.length()<=0) return false;
		Deque<Character> deque = new LinkedList<Character>();
		for(Character ch : parens.toCharArray()) {
			if(ch=='{' || ch=='[' || ch=='(')
				deque.offer(ch);
			else if (!deque.isEmpty() && ((ch=='}' && deque.peekLast()=='{') || (ch==']' && deque.peekLast()=='[') || 
					(ch==')' && deque.peekLast()=='('))) deque.removeLast();
			else return false;
		}
		return deque.isEmpty() ? true : false;
	}
	
	public static boolean validParentheses1(String parens) {
		if(parens==null || parens.length() <= 0)return false;
		Deque<Character> deque = new LinkedList<>();
		for (char ch : parens.toCharArray()) {
			if (ch == '{' || ch == '[' || ch == '(')
				deque.add(ch);
			else {
				if (!deque.isEmpty()) {
					if ((deque.peekLast() == '{' && ch == '}') 
							|| (deque.peekLast() == '[' && ch == ']')
							|| (deque.peekLast() == '(' && ch == ')')) {
						deque.removeLast();
					} else return false;
				} else return false;
			}
		}
		return deque.isEmpty() ? true : false;
	}
	
	@Test
	public void testBalancedParanthesis() {
		  assertTrue(validParentheses("{[()]}"));
		  assertTrue(validParentheses("{{[[(())]]}}"));
		  assertTrue(validParentheses("[]{}"));
		  assertFalse(validParentheses("{[(])}"));
		  assertFalse(validParentheses("[({}"));
		  assertFalse(validParentheses("[]}"));
		  assertFalse(validParentheses("[}]"));
		  assertFalse(validParentheses(""));
		  assertFalse(validParentheses(null));
	}
	
	@Test
	public void testBalancedParanthesis1() {
		  assertTrue(validParentheses1("{[()]}"));
		  assertTrue(validParentheses1("{{[[(())]]}}"));
		  assertTrue(validParentheses1("[]{}"));
		  assertFalse(validParentheses1("{[(])}"));
		  assertFalse(validParentheses1("[({}"));
		  assertFalse(validParentheses1("[]}"));
		  assertFalse(validParentheses1("[}]"));
		  assertFalse(validParentheses1(""));
		  assertFalse(validParentheses1(null));
	}

}
