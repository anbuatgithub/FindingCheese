package com.meeran.stringandpatterns;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;

public class ClosestWeight {
	public static int[][] closest(String strng) {
		// your code
		if (strng == "")
			return new int[0][0];
		LinkedHashMap<String, Integer> weights = getWeight(strng);
		int bestCloseIndex = getBestCloseIndex(weights);
		String[] strArray = strng.split(" ");
		int[][] output = new int[2][3];
		String firstKey = "";
		String secondKey = "";
		if (bestCloseIndex == 1) {
			firstKey = (String) weights.keySet().toArray()[0];
			secondKey = (String) weights.keySet().toArray()[1];
		} else if (bestCloseIndex > 1) {
			firstKey = (String) weights.keySet().toArray()[bestCloseIndex - 1];
			secondKey = (String) weights.keySet().toArray()[bestCloseIndex];
		}
		Integer valueForFirstKey = weights.get(firstKey);
		Integer valueForSecondKey = weights.get(secondKey);
		
		output[0][0] = valueForFirstKey;
		output[1][0] = valueForSecondKey;
		if(firstKey.split(" ")[0].equals(secondKey.split(" ")[0])) {
			output[0][1] = getIndex(firstKey, strArray, 0);
			output[1][1] = getIndex(secondKey, strArray, 1);
		}else {
			output[0][1] = getIndex(firstKey, strArray, 0);
			output[1][1] = getIndex(secondKey, strArray, 0);
		}
		output[0][2] = Integer.parseInt(firstKey.split(" ")[0]);
		output[1][2] = Integer.parseInt(secondKey.split(" ")[0]);
		return output;
	}

	private static int getIndex(String str, String[] strArray, int index) {
		int count = 0;
		for (int i = 0; i < strArray.length; i++)
			if (str.split(" ")[0].equals(strArray[i])) {
				if (count == index)
					return i;
				else
					count++;
			}
		return -1;
	}

	private static int getBestCloseIndex(Map<String, Integer> weights) {
		int previousValue = 0, i = 0;
		int bestCloseIndex = Integer.MIN_VALUE;
		int bestClose = Integer.MAX_VALUE;
		for (Map.Entry<String, Integer> entry : weights.entrySet()) {
			if (i > 0) {
				int closeInt = Math.abs(entry.getValue() - previousValue);
				if (bestClose > closeInt) {
					bestClose = closeInt;
					bestCloseIndex = i;
				}
			}
			previousValue = entry.getValue();
			i++;
		}
		return bestCloseIndex;
	}

	private static LinkedHashMap<String, Integer> getWeight(String str) {
		Map<String, Integer> weights = new LinkedHashMap<>();
		String[] strNums = str.split(" ");
		for (int j = 0; j < strNums.length; j++) {
			int weight = 0;
			for (int i = 0; i < strNums[j].length(); i++)
				weight += Character.getNumericValue(strNums[j].charAt(i));
			weights.put(strNums[j] + " " + j, weight);
		}
		return weights.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
	}

	private static void testing(String actual, String expected) {
		assertEquals(expected, actual);
	}

	@Test
	public void test() {
		System.out.println("Fixed Tests closest");
		String s = "";
		String r = "[]";

		testing(Arrays.deepToString(ClosestWeight.closest(s)), r);
		s = "456899 50 11992 176 272293 163 389128 96 290193 85 52";
		r = "[[13, 9, 85], [14, 3, 176]]";
		testing(Arrays.deepToString(ClosestWeight.closest(s)), r);

		s = "239382 162 254765 182 485944 134 468751 62 49780 108 54";
		r = "[[8, 5, 134], [8, 7, 62]]";
		testing(Arrays.deepToString(ClosestWeight.closest(s)), r);
		s = "241259 154 155206 194 180502 147 300751 200 406683 37 57";
		r = "[[10, 1, 154], [10, 9, 37]]";
		testing(Arrays.deepToString(ClosestWeight.closest(s)), r);

		s = "89998 187 126159 175 338292 89 39962 145 394230 167 1";
		r = "[[13, 3, 175], [14, 9, 167]]";
		testing(Arrays.deepToString(ClosestWeight.closest(s)), r);

		s = "462835 148 467467 128 183193 139 220167 116 263183 41 52";
		r = "[[13, 1, 148], [13, 5, 139]]";
		testing(Arrays.deepToString(ClosestWeight.closest(s)), r);

		s = "189437 110 263080 175 55764 13 257647 53 486111 27 66";
		r = "[[8, 7, 53], [9, 9, 27]]";
		testing(Arrays.deepToString(ClosestWeight.closest(s)), r);
		s = "315411 165 53195 87 318638 107 416122 121 375312 193 59";
		r = "[[15, 0, 315411], [15, 3, 87]]";
		testing(Arrays.deepToString(ClosestWeight.closest(s)), r);

		s = "403749 18 278325 97 304194 119 58359 165 144403 128 38";
		r = "[[11, 5, 119], [11, 9, 128]]";
		testing(Arrays.deepToString(ClosestWeight.closest(s)), r);

		s = "28706 196 419018 130 49183 124 421208 174 404307 60 24";
		r = "[[6, 9, 60], [6, 10, 24]]";
		testing(Arrays.deepToString(ClosestWeight.closest(s)), r);

		s = "79257 160 44641 146 386224 147 313622 117 259947 155 58";
		r = "[[11, 3, 146], [11, 9, 155]]";
		testing(Arrays.deepToString(ClosestWeight.closest(s)), r);

	}
}
