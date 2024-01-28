package com.meeran.numeric;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

public class PowerSumDigTerm {
	public static long powerSumDigTerm(int n) {
        // your code
		List<Long> resultList = new ArrayList<>();
		if (resultList.size() < n) {
			for (int i = 2; i < 500; i++) {
				for (int j = 2; j < 50; j++) {
					long product = (long) Math.pow(i, j);
                    if (sumOfDigits(product) == i) {
                        resultList.add(product);
                    }
				}
			}
			Collections.sort(resultList);
		}
		return resultList.get(n - 1);
    }
	private static long sumOfDigits(long n) {
        return Stream.of(Long.toString(n).split(""))
                .mapToInt(x -> Integer.parseInt(x))
                .sum();
    }
	
	@Test
    public void test1() {
        testing(powerSumDigTerm(1), 81);
        testing(powerSumDigTerm(2), 512);
        testing(powerSumDigTerm(3), 2401);
        testing(powerSumDigTerm(4), 4913);
    }
	
	private static void testing(long act, long exp) {
        assertEquals(exp, act);
    }
}
