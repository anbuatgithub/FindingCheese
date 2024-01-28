package anbu.algo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TwoNumSum {
    public static int[] twoNumberSum(int[] array, int targetSum) {

        int l = 0;
        int r = array.length - 1;
        Arrays.sort(array);

        while (l < r) {
            int currentSum = array[l] + array[r];
            if (currentSum == targetSum) {
                return new int[]{array[l], array[r]};
            } else if (currentSum < targetSum) {
                l++;
            } else {
                r--;
            }
        }
        return new int[0];
    }

    public static int[] twoNumberSumBF(int[] array, int targetSum) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == targetSum) {
                    return new int[]{array[i], array[j]};
                }
            }
        }
        return new int[0];
    }


    @Test
    public void testNumberSum() {
        assertEquals(Arrays.toString(new int[]{-1,11}), Arrays.toString(twoNumberSum(new int[]{3,5,-4,8,11,1,-1,6},10)));
        assertEquals(Arrays.toString(new int[]{3, 5}), Arrays.toString(twoNumberSum(new int[]{3, 5, -4, 8, 11, 1, -1, 6}, 8)));
        // if this should work , we should sort the array
        //assertEquals(Arrays.toString(new int[]{-1,11}), Arrays.toString(twoNumberSumBF(new int[]{3,5,-4,8,11,1,-1,6},10)));
        assertEquals(Arrays.toString(new int[]{3, 5}), Arrays.toString(twoNumberSumBF(new int[]{3, 5, -4, 8, 11, 1, -1, 6}, 8)));
        assertEquals(Arrays.toString(new int[]{11,-1}), Arrays.toString(twoNumberSumBF(new int[]{3,5,-4,8,11,1,-1,6},10)));

        assertEquals(Arrays.toString(new int[0]), Arrays.toString(twoNumberSumBF(new int[]{3,5,-4,8,11,1,-1,6},35)));


    }

}