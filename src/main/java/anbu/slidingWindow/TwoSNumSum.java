package anbu.slidingWindow;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TwoSNumSum {
    public static void main(String[] args) {
        Arrays.stream(twoNumberSum(new int[]{3,5,-4,8,11,1,-1,6},10)).forEach(System.out::println);
        Arrays.stream(twoNumberSum(new int[]{-21, 301, 12, 4, 65, 56, 210, 356, 9, -47},163)).forEach(System.out::println);


    }


    public static int[] twoNumberSum(int[] array, int targetSum) {
        int l=0;
        int r=array.length-1;
        Arrays.sort(array);
        while(l<r){
            int currentSum= array[l]+array[r];
            if(currentSum==targetSum) {
                return new int[]{array[l], array[r]};
                }else if(currentSum<=targetSum){
                l++;
            }else{
                r--;
            }
        }
        return new int[2];
    }
}
