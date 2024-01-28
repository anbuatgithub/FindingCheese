package com.meeran.maths;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class DecimalConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static String vulgarToDecimal(Long numerator, Long denominator) {
		String result = "";
		long quotient = numerator/denominator;
		result=String.valueOf(quotient);
		
		long remainder = numerator%denominator * 10;
		
		if(remainder==0) return result;
		else result+='.';
		
		Map<Long,Integer> map = new HashMap<Long,Integer>();
		
		while(remainder!=0) {
			if(map.containsKey(remainder)) {
				int beg=map.get(remainder);
				String part1 = result.substring(0, beg);
				String part2 = result.substring(beg, result.length());
				return part1 + "(" + part2 + ")";
			}else {
				map.put(remainder, result.length());
				quotient = remainder/denominator;
				result+=String.valueOf(quotient);
				remainder= (remainder%denominator) * 10;
			}
		}
		
		return result;
	}

	@Test
	public void testvulgarToDecimal(){
		assertTrue(vulgarToDecimal(1l, 2l).equals("0.5"));
		assertTrue(vulgarToDecimal(1l, 3l).equals("0.(3)"));
		assertTrue(vulgarToDecimal(1l, 30l).equals("0.0(3)"));
		assertTrue(vulgarToDecimal(1l, 75l).equals("0.01(3)"));
		assertTrue(vulgarToDecimal(4l, 7l).equals("0.(571428)"));
	}
}
