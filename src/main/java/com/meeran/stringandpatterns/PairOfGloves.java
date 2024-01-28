package com.meeran.stringandpatterns;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import org.junit.Test;

public class PairOfGloves {
	public static int numberOfPairs(String[] gloves) {
		Map<String, Integer> gloveMap = new HashMap<>();
		for (String glove : gloves) gloveMap.put(glove, gloveMap.getOrDefault(glove, 0) + 1);
		return gloveMap.entrySet().stream().filter(e -> e.getValue() >= 2).mapToInt(e -> e.getValue() / 2).sum();
	}

	public static int numberOfPairs1(String[] gloves) {
		return (int) Arrays.asList(gloves).stream().collect(Collectors.groupingBy(s -> s, Collectors.counting()))
				.entrySet().stream().mapToLong(entry -> entry.getValue() / 2).sum();
	}

	@Test
	public void fixedTest() {
		assertEquals(0, PairOfGloves.numberOfPairs(new String[] {}));
		assertEquals(1, PairOfGloves.numberOfPairs(new String[] { "red", "red" }));
		assertEquals(0, PairOfGloves.numberOfPairs(new String[] { "red", "green", "blue" }));
		assertEquals(3, PairOfGloves.numberOfPairs(new String[] { "gray", "black", "purple", "purple", "gray", "black" }));
		assertEquals(4, PairOfGloves.numberOfPairs(new String[] { "red", "green", "blue", "blue", "red", "green", "red", "red", "red" }));
	}

	private static String[] base = { "White", "Yellow", "Fuchsia", "Red", "Silver", "Gray", "Olive", "Purple", "Maroon",
			"Aqua", "Lime", "Teal", "Green", "Blue", "Navy", "Black" };

	private static int reference(String[] a) {
		var s = new HashSet<String>();
		var r = 0;
		for (var x : a)
			if (s.contains(x)) {
				s.remove(x);
				r++;
			} else
				s.add(x);
		return r;
	}

	@Test
	public void randomTest() {
		var random = new Random();
		for (var i = 0; i < 100; i++) {
			var n = random.nextInt(25);
			var a = new String[n];
			while (n-- > 0)
				a[n] = base[random.nextInt(base.length)];
			assertEquals(reference(a), PairOfGloves.numberOfPairs(a));
		}
	}
}