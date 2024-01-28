package com.meeran.stringandpatterns;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;

import org.junit.Test;

public class StringIncrementer {
	
	public static String incrementString(String str) {
	      if ("".equals(str) || !Character.isDigit(str.charAt(str.length() - 1)))
	      return str + "1";
	    for (int i = str.length() - 1; i >= 0; i-- ){
	      if (Character.isDigit(str.charAt(i))  && str.charAt(i) != '9'){
	        return str.substring(0, i) + (Integer.parseInt(str.substring(i)) + 1);
	      }
	      if (!Character.isDigit(str.charAt(i)) && i < str.length() - 1){
	        return str.substring(0, i + 1) + Integer.toString(Integer.parseInt(str.substring(i + 1)) + 1);
	      }
	    }
	    return Integer.toString(Integer.parseInt(str) + 1);
	  }
	
	public static String incrementString2(String str) {
		if (str.equals("")) return "1";

		//Pattern NUMBER = Pattern.compile("\\d+");
		//return NUMBER.matcher(str)
			//	.replaceAll(s -> String.format("%0" + s.group().length() + "d", Integer.parseInt(s.group()) + 1));

		int intCount = 0;
		int strCount = 0;
		for (int i = str.length() - 1; i >= 0; i--) {
			if (Character.isDigit(str.charAt(i)) && strCount == 0) intCount++;
			else strCount++;
		}
		String outputString = str.substring(0, strCount);
		String numString = str.substring(strCount, str.length());
		if (numString.equals("")) return outputString + "1";
		BigInteger bigNum = new BigInteger(numString);
		BigInteger increment = new BigInteger("1");
		String outputNumber = String.format("%0" + numString.length() + "d", bigNum.add(increment));
		return outputString + outputNumber;
	}

	private static void doTest(String str, String expected) {
		assertEquals(expected, incrementString(str), "input: <" + str + ">");
	}

	@Test
	public void exampleTests() {
		doTest("10337564677419724331818110695", "10337564677419724331818110696");
		doTest("fo99obar99", "fo99obar100");
		doTest("foobar000", "foobar001");
		doTest("foo", "foo1");
		doTest("foobar001", "foobar002");
		doTest("foobar99", "foobar100");
		doTest("foobar099", "foobar100");
		doTest("", "1");
	}
}
