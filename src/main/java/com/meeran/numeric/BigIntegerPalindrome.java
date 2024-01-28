package com.meeran.numeric;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.*;

import org.junit.Test;

public class BigIntegerPalindrome {
	public static BigInteger findReverseNumber(long n) {
		System.out.println("n-->" + n);
		BigInteger a = BigInteger.ZERO;
		int i = 1;
		long del = 9;
		if (n <= 10) {
			a = BigInteger.valueOf(n - 1);
			return a;
		} else if (n < 20) {
			a = BigInteger.valueOf((n - 10) * 11);
			return a;
		}
		n -= 10;
		System.out.println("n--->>>>" + n);
		while (n >= del) {
			n -= del;
			System.out.println("n-11-->>>>" + n + "   del00--->" + del);
			i++;
			if (i % 2 == 0) {
				del *= 10;
			}

		}
		i++;
		System.out.println("n--->" + n + "  a--->" + a + "  i--->" + i + "  del--->" + del);

		double val = (Math.pow(10, (Math.floor((i - 1) / 2))) + (n - 1));

		System.out.println("val-->" + val);

		String firstHalf = BigDecimal.valueOf(Math.floor((val))).toBigInteger().toString();
		String reverse = "";
		if (i % 2 == 0) {
			String str = BigDecimal.valueOf(Math.floor((val))).toBigInteger().toString();
			System.out.println("str--->" + str);
			reverse = new StringBuilder(str).reverse().toString();
		} else {
			String str = BigDecimal.valueOf(Math.floor((val / 10))).toBigInteger().toString();
			System.out.println("str--->" + str);
			reverse = new StringBuilder(str).reverse().toString();
		}
		System.out.println("if reverse-->" + reverse + " firstHalf--->" + firstHalf);
		return new BigInteger(firstHalf + reverse);
	}

	public static BigInteger findReverseNumber1(long n) {
		BigInteger a = BigInteger.ZERO;
		long b = 0;
		long i = 0;
		for (; i <= 100000000000L; i++) {
			String s = a.toString();
			StringBuilder sb = new StringBuilder(s);
			if (a.equals(new BigInteger(sb.reverse().toString()))) {
				System.out.println("A0--->" + a);
				if (b >= n - 1)
					return a;
				b++;
			}
			a = a.add(new BigInteger("1"));
		}
		return BigInteger.ZERO;
	}

	public static boolean checkPalindrome(BigInteger number) {

		BigInteger div = new BigInteger("1");

		while ((number.divide(div)).compareTo(BigInteger.TEN) >= 0) {
			div = div.multiply(BigInteger.TEN);
		}

		while (!number.equals(new BigInteger("0"))) {
			BigInteger len = number.divide(div);
			BigInteger revs = number.mod(BigInteger.TEN);

			if (!len.equals(revs))
				return false;

			number = (number.mod(div)).divide(BigInteger.TEN);
			div = div.divide(BigInteger.valueOf(100));
		}
		return true;
	}

	@Test
	public void testFixed() {
		assertEquals(new BigInteger("0"), BigIntegerPalindrome.findReverseNumber(1));
		assertEquals(new BigInteger("1"), BigIntegerPalindrome.findReverseNumber(2));
		assertEquals(new BigInteger("9"), BigIntegerPalindrome.findReverseNumber(10));
		assertEquals(new BigInteger("909"), BigIntegerPalindrome.findReverseNumber(100));
		assertEquals(new BigInteger("90009"), BigIntegerPalindrome.findReverseNumber(1000));
		assertEquals(new BigInteger("10000001"), BigIntegerPalindrome.findReverseNumber(11000));
		assertEquals(new BigInteger("20000002"), BigIntegerPalindrome.findReverseNumber(12000));
		assertEquals(new BigInteger("9000009"), BigIntegerPalindrome.findReverseNumber(10000));
		assertEquals(new BigInteger("900000009"), BigIntegerPalindrome.findReverseNumber(100000));
		assertEquals(new BigInteger("900000000000000000009"), BigIntegerPalindrome.findReverseNumber(100000000000L));
	}
}
