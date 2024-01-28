package com.meeran.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class NextSmallerNumber {
	public static long nextSmaller(long n)
    {
		final char[] chars = Long.toString(n).toCharArray();
	    
	    for (int i = chars.length;  i>0; i--) {
	      char digit = chars[i-1];
	      
	      for (int j = i; j < chars.length; j++) {
	        if (chars[j] < digit) {
	          chars[i-1] = chars[j];
	          chars[j] = digit;
	          Long result = Long.parseLong(new String(chars));
	          if(Long.toString(n).length() == Long.toString(result).length()){
	            return result;
	          } else{
	            return -1;
	          }
	        }
	      }
	      
	      System.arraycopy(chars, i, chars, i-1, chars.length - i);
	      chars[chars.length-1] = digit;
	    }
	    
	    return -1;
    }
    
    @Test
    public void basicTests() {
         assertEquals(12, nextSmaller(21));
         assertEquals(790, nextSmaller(907));
         assertEquals(513, nextSmaller(531));
         assertEquals(-1, nextSmaller(1027));
         assertEquals(414, nextSmaller(441));
         assertEquals(123456789, nextSmaller(123456798));
    }    
}
