package com.meeran.stringandpatterns;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class AlphabetNuclearWar {
	public static String alphabetWar(String battlefield) {
		if (!battlefield.contains("#")) return battlefield.replace("[","").replace("]", "");
		int stricker = 0;
		List<Object> strickerList = new LinkedList<>();
		boolean shelter = false;
		String selTemp = "";
		for (int i = 0; i < battlefield.length(); i++) {
			char ch = battlefield.charAt(i);
			if (ch == '#') stricker++;
			else if (ch == '[') {
				strickerList.add(stricker);
				shelter = true;
				stricker = 0;
				selTemp = "";
			} else if (ch == ']') {
				shelter = false;
				strickerList.add(selTemp);
			} else if (shelter) selTemp += ch + "";
		}
		strickerList.add(stricker);
		String survived="";
		for (int i = 0; i < strickerList.size(); i++) {
			if (strickerList.get(i) instanceof String) {
				if ((int) strickerList.get(i - 1) + (int) strickerList.get(i + 1) < 2) {
					survived += strickerList.get(i);
				}
			}
		}
		return survived;
	}

	@Test
	public void SampleTestCases() {
		String[][] tests = { { "[a]#[b]#[c]", "ac" }, { "[a]#b#[c][d]", "d" }, { "[a][b][c]", "abc" },
				{ "##a[a]b[c]#", "c" }, { "abde[fgh]ijk", "abdefghijk" }, { "ab#de[fgh]ijk", "fgh" },
				{ "ab#de[fgh]ij#k", "" }, { "##abde[fgh]ijk", "" }, { "##abcde[fgh]", "" },
				{ "abcde[fgh]", "abcdefgh" }, { "##abde[fgh]ijk[mn]op", "mn" }, { "#abde[fgh]i#jk[mn]op", "mn" },
				{ "[ab]adfd[dd]##[abe]dedf[ijk]d#d[h]#", "abijk" } };
		for (String[] test : tests)
			assertEquals("For " + test[0], test[1], AlphabetNuclearWar.alphabetWar(test[0]));
	}
}
