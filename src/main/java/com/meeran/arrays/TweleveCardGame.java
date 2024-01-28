package com.meeran.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;

public class TweleveCardGame {
	public static boolean game(int[] frank, int[] sam, int[] tom) {
		return ((frank[3] > Math.max(sam[3], tom[3]) && frank[2] > Math.max(sam[2], tom[2]))
				|| (frank[3] > Math.max(sam[2], tom[2]) && frank[2] > Math.max(sam[1], tom[1]))
				|| (frank[3] > Math.max(sam[1], tom[1]) && frank[2] > Math.max(sam[0], tom[0]))) ? true : false;
	}

	public static boolean game1(int[] frank, int[] sam, int[] tom) {
		List<Integer> samList = IntStream.of(sam).boxed().sorted(Collections.reverseOrder())
				.collect(Collectors.toList());
		List<Integer> tomList = IntStream.of(tom).boxed().sorted(Collections.reverseOrder())
				.collect(Collectors.toList());
		Arrays.sort(frank);
		System.out.println(Arrays.toString(frank));
		System.out.println(samList);
		System.out.println(tomList);
		int i = frank.length, count = 0, fail = 0;
		while (i-- >= 0) {
			samList = getLeastNum(frank[i], samList);
			tomList = getLeastNum(frank[i], tomList);
			if (i == samList.size() && i == tomList.size())
				count++;
			else
				fail++;
			if (fail > 1 && fail > count)
				return false;
			else if (count > 1)
				return true;
		}
		return false;
	}

	private static List<Integer> getLeastNum(int frankNum, List<Integer> player) {
		for (int i = 0; i < player.size(); i++) {
			if (frankNum > player.get(i)) {
				player.remove(i);
				break;
			}
		}
		return player;
	}

	@Test
	public void exampleTests() {
		assertEquals(true,
				TweleveCardGame.game(new int[] { 2, 5, 8, 11 }, new int[] { 1, 4, 7, 10 }, new int[] { 0, 3, 6, 9 }));
		assertEquals(false,
				TweleveCardGame.game(new int[] { 1, 2, 3, 4 }, new int[] { 5, 6, 7, 8 }, new int[] { 0, 9, 10, 11 }));
		assertEquals(true,
				TweleveCardGame.game(new int[] { 4, 5, 6, 9 }, new int[] { 0, 1, 8, 11 }, new int[] { 2, 3, 7, 10 }));
		assertEquals(true,
				TweleveCardGame.game(new int[] { 2, 3, 6, 10 }, new int[] { 1, 7, 8, 11 }, new int[] { 0, 4, 5, 9 }));
		assertEquals(false,
				TweleveCardGame.game(new int[] { 0, 2, 4, 6 }, new int[] { 3, 5, 9, 10 }, new int[] { 1, 7, 8, 11 }));
		assertEquals(false,
				TweleveCardGame.game(new int[] { 0, 3, 4, 6 }, new int[] { 1, 9, 10, 11 }, new int[] { 2, 5, 7, 8 }));
	}
}
