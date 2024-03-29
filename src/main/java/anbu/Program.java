package anbu;

import java.util.Arrays;

public class Program {
     public static void main(String[] args) {
            Arrays.stream(sortedSquaredArray(new int[]{-3,-4,-1,2})).forEach(System.out::println);
        }

        public static int[] sortedSquaredArray(int[] array) {
            int[] sortedSquares = new int[array.length];
            int smallerValueIdx = 0;
            int largerValueIdx = array.length - 1;
            for (int idx = array.length - 1; idx >= 0; idx--) {
                int smallerValue = array[smallerValueIdx];
                int largerValue = array[largerValueIdx];
                if (Math.abs(smallerValue) > Math.abs(largerValue)) {
                    sortedSquares[idx] = smallerValue * smallerValue;
                    smallerValueIdx++;
                } else {
                    sortedSquares[idx] = largerValue * largerValue;
                    largerValueIdx--;
                }
            }
            return sortedSquares;
        }
    }
