package com.meeran.numeric;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class FibDigits {
	public static int[][] fibDigits(int n) {
		BigInteger a = BigInteger.valueOf(0);
		int limit=n;
		BigInteger fact = BigInteger.valueOf(1);
		BigInteger minus = BigInteger.valueOf(-1);
		if(n<0) {
			limit = -1 * n;
			if(n%2==0) {
				fact = fact.multiply(minus);
			}
		}
        BigInteger b = BigInteger.valueOf(1);
        BigInteger c = BigInteger.valueOf(1);
        for (int j=2 ; j<=limit ; j++)
        {
            c =  a.add(b);
            a = b;
            b = c;
        }
  
        String nthValue = b.multiply(fact).toString(); 
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : nthValue.toCharArray()) {
        	map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        int[][] array = map.entrySet().stream().sorted(Map.Entry.<Character, Integer>comparingByValue(Comparator.reverseOrder())
        		.thenComparing(Map.Entry.comparingByKey(Comparator.reverseOrder())))
        		.map(e -> new int[]{e.getValue(), Character.getNumericValue(e.getKey())})
                .toArray(int[][]::new);

        System.out.println(Arrays.deepToString(array));
		
	    return array;
	  }
	
	 @Test
	  @DisplayName("F<sub>10</sub> = 55 => {{2, 5}}")
	  public void FibDigtis_10() {
	    int n = 10;
	    int[][] expectedResult = {{2, 5}};
	    int[][] result = fibDigits(n);
	    assertArrayEquals(expectedResult, result);
	  }
	  
	  @Test
	  @DisplayName("F<sub>10000</sub>")
	  public void FibDigtis_10000() {
	    int n = 10000;
	    int[][] expectedResult = {
	      {254, 3},
	      {228, 2},
	      {217, 6},
	      {217, 0},
	      {202, 5},
	      {199, 1},
	      {198, 7},
	      {197, 8},
	      {194, 4},
	      {184, 9}
	    };
	    int[][] result = fibDigits(n);
	    assertArrayEquals(expectedResult,result);
	  }
	  
	  @Test
	  @DisplayName("F<sub>100000</sub>")
	  public void FibDigtis_100000() {
	    int n = 100000;
	    int[][] expectedResult = {
	      {2149, 2},
	      {2135, 1},
	      {2131, 8},
	      {2118, 9},
	      {2109, 0},
	      {2096, 3},
	      {2053, 5},
	      {2051, 6},
	      {2034, 7},
	      {2023, 4},
	    };
	    int[][] result = fibDigits(n);   
	    assertArrayEquals(expectedResult, result);
	  }
}
