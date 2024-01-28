package com.meeran.gs;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

public class ValidParentheses {

	public static boolean validParentheses(String parens){
	    //Put code below
		int count=0;
		for(Character ch : parens.toCharArray()) {
			if(ch=='(') count++;
			else if(ch==')') count--;
			if(count<0) return false;
		}
		return count==0 ? true : false;	
	  }
	
	@Test
	public void testValidParentheses() {
		assertTrue(validParentheses( "()" ));  
		assertFalse(validParentheses( "())" ));
		assertTrue(validParentheses( "(32423(sgsdg))" ));
		assertFalse(validParentheses( "(dsgdsg))2432" ));
		assertTrue(validParentheses( "adasdasfa" ));
	}
}
