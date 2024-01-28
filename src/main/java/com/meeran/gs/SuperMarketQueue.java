package com.meeran.gs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class SuperMarketQueue {

    public static int solveSuperMarketQueue(int[] customers, int n) {

        int[] result = new int[n];
        for (int i = 0; i < customers.length; i++) {
            result[0] += customers[i];
			//System.out.println(result[0]);
            Arrays.sort(result);
        }
		//Arrays.stream(result).forEach(System.out::println);

        return result[n - 1];
    }

    @Test
    public void testSuperMarketQueue() {

        assertEquals(5, solveSuperMarketQueue(new int[]{1,2,3 ,4 ,5}, 3));

    }

}
