package com.meeran.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class SurviveTheAttack {
	public static boolean block(int[] attackers, int[] defenders){
	    int attackLength = attackers.length, defLength = defenders.length;
	    int attackSurv =0, defSurive =0, attackSum=0, defSum =0;
	    int length = defLength;
	    if (attackLength>=defLength)length=attackLength;
	    for(int i=0; i<length;i++) {
	    	if(i<attackLength && i<defLength) {
	    		if(attackers[i]>defenders[i]) attackSurv+=1;
	    		else defSurive+=1;
	    		if(i==0) {
	    			if(Arrays.stream(attackers).sum() > Arrays.stream(defenders).sum()) attackSum+=1;
	    			else if (Arrays.stream(attackers).sum() < Arrays.stream(defenders).sum()) defSum+=1;
	    		}
	    	}else if (i<attackLength && i>=defLength)attackSurv+=1;
	    	else if (i>=attackLength && i<defLength)defSurive+=1;
	    }
	    return defSurive>attackSurv ? true : defSurive==attackSurv ? (defSum>=attackSum ? true : false) : false;
	}
	
	@Test
	public void testDefenders() {
		assertEquals(true, block(new int[] { 1, 3, 5, 7 }, new int[] { 2, 4, 6, 8 }));
		assertEquals(false, block(new int[] { 2, 9, 9, 7 }, new int[] { 1, 1, 3, 8 }));
	    assertEquals(true, block(new int[] { 10, 10, 1, 1 }, new int[] { 4, 4, 7, 7 }));
	    assertEquals(true, block(new int[] { }, new int[] { 1,2,3 }));
		assertEquals(false, block(new int[] {1,2,3 }, new int[] { }));
		 
	}
}
