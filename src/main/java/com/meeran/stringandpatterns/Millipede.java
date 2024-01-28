package com.meeran.stringandpatterns;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class Millipede {
	static String first = "";
	static boolean matched = true;
	
	public static boolean check(String[] millipede) {

		if(happyCase(millipede)) return true;
		first = millipede[0];
		matched = true;
		for (int i = 1; i < millipede.length; i++) {
			if (first.charAt(first.length() - 1) != millipede[i].charAt(0)) {
				first = millipede[i];
				break;
			}
		}
		ArrayList<String> newArray = new ArrayList<String>();
		for (String str : millipede) {
			if (!str.equals(first)) {
				if (first.charAt(first.length() - 1) != str.charAt(0)) {
					newArray.add(str);
				} else if (str.charAt(0) != str.charAt(str.length() - 1)) {
					newArray.add(str);
				}
			}
		}
		int count = isFirstDuplicate(millipede);
		if (count > 1) {
			while (count > 0) {
				count--;
				newArray.add(first);
			}
		}
		while (matched) {
			newArray = getArray(newArray);
		}
		if (newArray.size() > 0)
			return false;
		else
			return true;
	}

	private static int isFirstDuplicate(String[] millipede) {
		int count = 0;
		for (String str : millipede) {
			if (str.equals(first))
				count++;
		}
		return count;
	}

	private static ArrayList<String> getArray(ArrayList<String> newArray) {
		matched = false;
		for (int i = 0; i < newArray.size(); i++) {
			String newCharStr = newArray.get(i);
			if (newCharStr.charAt(0) == first.charAt(first.length() - 1)
					&& newCharStr.charAt(newCharStr.length() - 1) == first.charAt(first.length() - 1)) {
				newArray.remove(newCharStr);
			}
		}
		for (String newStr : newArray) {
			if (first.charAt(first.length() - 1) == newStr.charAt(0)) {
				newArray.remove(newStr);
				first = newStr;
				matched = true;
				return newArray;
			}
		}
		return newArray;
	}
	
	private static boolean happyCase(String[] millipede) {
		for (int i = 0; i+1 < millipede.length; i++) {
			if (millipede[i].charAt(millipede[i].length()-1) != millipede[i+1].charAt(0)) {
				return false;
			}
		}
		return true;
	}

	@Test
	public void random() {
		String[] message = new String[] { "engine", "elephant", "tablet", "temperature", "exotic", "cable", "endorse" };
		assertEquals(true, Millipede.check(message), String.join(", ", message));
	}

	@Test
	public void random1() {
		String[] message = new String[] { "exotic", "trade", "thesis", "elite", "excavate", "excavate", "embrace" };
		assertEquals(false, Millipede.check(message), String.join(", ", message));
	}

	@Test
	public void random2() {
		String[] message = new String[] { "strike", "thesis", "stereotype", "thesis", "excess", "empire" };
		assertEquals(false, Millipede.check(message), String.join(", ", message));
	}

	@Test
	public void descriptionTrue() {
		String[] message = new String[] { "excavate", "endure", "desire", "screen", "theater", "excess", "night" };
		assertEquals(true, Millipede.check(message), String.join(", ", message));
	}

	@Test
	public void descriptionFalse() {
		String[] message = new String[] { "trade", "pole", "view", "grave", "ladder", "mushroom", "president" };
		assertEquals(false, Millipede.check(message), String.join(", ", message));
	}

}
