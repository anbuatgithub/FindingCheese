package anbu.algo;

import java.util.Arrays;

public class SortedSquareArray {
    public static void main(String[] args) {
        int []array = { -2, -1 , 3 };
        //System.out.println(sortedSquaredArray(array));
        Arrays.stream(sortedSquaredArray(array)).forEach(System.out::println);

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
