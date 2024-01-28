package com.meeran.numeric;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;

public class PickPeaks {
	public static Map<String, List<Integer>> getPeaks(int[] arr) {
		// Your code here!
		Map<String, List<Integer>> output = new HashMap<>();
		List<Integer> posList = new ArrayList<>();
		List<Integer> peaksList = new ArrayList<>();
		int pos=Integer.MIN_VALUE;
		int peak=Integer.MIN_VALUE;
		for(int i=1; i<arr.length; i++) {
			if(arr[i-1]<arr[i]) {
				pos=i;
				peak = arr[i];
			}
			if(arr[i-1] > arr[i] && pos!=Integer.MIN_VALUE) {
				posList.add(pos);
				peaksList.add(peak);
				pos=Integer.MIN_VALUE;
			}
		}
		output.put("pos", posList);
		output.put("peaks", peaksList);
		return output;
	}

	private static String[] msg = { "should support finding peaks",
			"should support finding peaks, but should ignore peaks on the edge of the array",
			"should support finding peaks; if the peak is a plateau, it should only return the position of the first element of the plateau",
			"should support finding peaks; if the peak is a plateau, it should only return the position of the first element of the plateau",
			"should support finding peaks, but should ignore peaks on the edge of the array" };

	private static int[][] array = { { 1, 2, 3, 6, 4, 1, 2, 3, 2, 1 }, { 3, 2, 3, 6, 4, 1, 2, 3, 2, 1, 2, 3 },
			{ 3, 2, 3, 6, 4, 1, 2, 3, 2, 1, 2, 2, 2, 1 }, { 2, 1, 3, 1, 2, 2, 2, 2, 1 }, { 2, 1, 3, 1, 2, 2, 2, 2 } };

	private static int[][] posS = { { 3, 7 }, { 3, 7 }, { 3, 7, 10 }, { 2, 4 }, { 2 }, };

	private static int[][] peaksS = { { 6, 3 }, { 6, 3 }, { 6, 3, 2 }, { 3, 2 }, { 3 } };

	@Test
	public void sampleTests() {
		for (int n = 0; n < msg.length; n++) {
			final int[] p1 = posS[n], p2 = peaksS[n];
			Map<String, List<Integer>> expected = new HashMap<String, List<Integer>>() {
				{
					put("pos", Arrays.stream(p1).boxed().collect(Collectors.toList()));
					put("peaks", Arrays.stream(p2).boxed().collect(Collectors.toList()));
				}
			}, actual = PickPeaks.getPeaks(array[n]);
			assertEquals(msg[n], expected, actual);
		}
	}
}
