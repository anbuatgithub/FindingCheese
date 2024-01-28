package com.meeran.stringandpatterns;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.Test;

public class HexStringToRGB {
	public static int[] hexStringToRGB(String hex) {
	    
	    // hex -> {r, g, b}
		
		return new int[] {
	            Integer.valueOf( hex.substring( 1, 3 ), 16 ),
	            Integer.valueOf( hex.substring( 3, 5 ), 16 ),
	            Integer.valueOf( hex.substring( 5, 7 ), 16 ) };
	  }
	
	@Test 
	public void allOne() {
        assertArrayEquals(HexStringToRGB.hexStringToRGB("#111111"), new int[] {17, 17, 17});
    }
  
    @Test 
    public void allZero() {
        assertArrayEquals(HexStringToRGB.hexStringToRGB("#000000"), new int[] {0, 0, 0});
    }
  
    @Test 
    public void more() {
        assertArrayEquals(HexStringToRGB.hexStringToRGB("#FF9933"), new int[] {255, 153, 51});
        assertArrayEquals(HexStringToRGB.hexStringToRGB("#beaded"), new int[] {190, 173, 237});
        assertArrayEquals(HexStringToRGB.hexStringToRGB("#Fa3456"), new int[] {250, 52, 86});
    }
}
