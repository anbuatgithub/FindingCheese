package com.meeran.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class BestAverageGrade {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static Integer bestAverageGrade(String[][] scores) {
		Map<String,Integer> map = new HashMap<>();
		for(String[] score : scores) {
			String name = score[0];
			Integer mark = Integer.parseInt(score[1]);
			map.put(name, (map.getOrDefault(name, mark)+mark)/2);
		}
		return map.values().stream().sorted(Comparator.reverseOrder()).findFirst().get();
	}
	
	@Test
	public void testBestAverageGrade() {
		String[][] input = new String[][] {{ "Bobby", "87" },
			{ "Charles", "100" },
			{ "Eric", "64" },
			{ "Charles", "22" }};
		assertEquals(87, bestAverageGrade(input));
		
		String[][] input2 = new String[][] {{"Sarah", "91"},
			{"Goldie", "92"},
			{"Elaine", "93"},
			{"Elaine", "95"},
			{"Goldie", "94"},
			{"Sarah", "93"}};
		assertEquals(94, bestAverageGrade(input2));
	}
}
