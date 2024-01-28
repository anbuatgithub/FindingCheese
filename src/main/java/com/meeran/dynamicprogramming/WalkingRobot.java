package com.meeran.dynamicprogramming;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class WalkingRobot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static Integer[] walk(String path) {
		int x=0,y=0;
		for(Character ch : path.toCharArray()) {
			switch(ch) {
			case 'U': y--; break;
			case 'D': y++; break;
			case 'L': x--; break;
			case 'R': x++; break;
			}
		}
		return new Integer[] {x,y};
	}
	
	@Test
	public void testWalk() {
		assertEquals(Arrays.toString(new Integer[] {0,0}), Arrays.toString(walk("")));
		assertEquals(Arrays.toString(new Integer[] {-1,0}), Arrays.toString(walk("L")));
		assertEquals(Arrays.toString(new Integer[] {0,-3}), Arrays.toString(walk("UUU")));
		assertEquals(Arrays.toString(new Integer[] {0,0}), Arrays.toString(walk("ULDR")));
		assertEquals(Arrays.toString(new Integer[] {0,-2}), Arrays.toString(walk("UUUDLR")));
	}

}
