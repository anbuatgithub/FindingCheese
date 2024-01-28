package anbu.algo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TheeSum {
    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {

        List<Integer[]> triplets = new ArrayList<Integer[]>();

        for(int i=0;i<array.length-2;i++) {
            Arrays.sort(array);
            int left = i+1;
            int right = array.length - 1;

            while (left < right) {
                int currentSum = array[i] + array[left] + array[right];
                if (currentSum == targetSum) {
                    triplets.add(new Integer[]{array[i], array[left],array[right]});
                    left++;
                    right--;
                } else if (currentSum < targetSum) {
                    left++;
                } else if (currentSum > targetSum){
                    right--;
                }
            }
        }

        return triplets;
    }

    public static List<Integer[]>  threeNumberSumBF(int[] array, int targetSum) {
        List<Integer[]> triplets = new ArrayList<Integer[]>();
        for (int i = 0; i < array.length - 2; i++) {
            for (int j = i + 1; j < array.length-1; j++) {
                for(int z=j+1;z<array.length;z++){
                    if (array[i] + array[j] + array[z] == targetSum) {
                        triplets.add(new Integer[]{array[i], array[j],array[z]});
                    }

                }

            }
        }
        return triplets;
    }


    @Test
    public void testNumberSum() {
        List<Integer[]> result = threeNumberSum(new int[]{12,3,1,2,-6,5,-8,6},0);
        for(Integer[] arr : result){
            Arrays.stream(arr).forEach(System.out::println);
        }
    }
}