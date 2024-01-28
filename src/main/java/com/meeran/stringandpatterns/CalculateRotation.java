package com.meeran.stringandpatterns;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class CalculateRotation {

	static int shiftedDiff(String first, String second){
		if(first.equals(second)) return 0;
		for(int i=0; i<second.length(); i++) {
			String tempWord = second.substring(i+1, second.length()) + second.substring(0, i+1);
			if(first.equals(tempWord)) return i+1;
		}
	    return -1;
	  }
	
	@Test
    public void test() {
      assertEquals(-1, CalculateRotation.shiftedDiff("hoop","pooh"));
      assertEquals(2, CalculateRotation.shiftedDiff("coffee","eecoff"));
      assertEquals(4, CalculateRotation.shiftedDiff("eecoff","coffee"));
    }
}
