package com.meeran.gs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class HumanReadableTime {

	public static String makeReadable(int seconds) {
	    // Do something
	    return String.format("%02d:%02d:%02d", seconds/60/60 , seconds/60%60, seconds%60);
	  }
	
	@Test
	public void testMakeReadable() {
		assertEquals("00:00:00",makeReadable(0));
	    assertEquals("00:00:05",makeReadable(5));
	    assertEquals("00:01:00",makeReadable(60));
	    assertEquals("23:59:59",makeReadable(86399));
	    assertEquals("99:59:59",makeReadable(359999));
	}
}
