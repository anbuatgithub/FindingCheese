package com.meeran.stringandpatterns;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.junit.Test;

public class FirstNonRepeatChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	char findFirst(String input){
		
		Map<Character,Integer> map = new LinkedHashMap<>();
		for(Character ch: input.toCharArray()) map.merge(Character.toLowerCase(ch), 1, (a,b)->a+b);
		//return map.entrySet().stream().filter(e->e.getValue()==1).count()<1 ? 0 : 
			//map.entrySet().stream().filter(e->e.getValue()==1).findFirst().get().getKey();
		
		try {
			return map.entrySet().stream().filter(e->e.getValue()==1).findFirst().get().getKey();
	    } catch (NoSuchElementException | IllegalArgumentException iae) {
	        return 0;
	    }
		
	}
	
	@Test
	public void testFindFirst() {
		
		assertEquals('a', findFirst("Apple"));
		assertEquals(0, findFirst("xxyyzz"));
	}

}
