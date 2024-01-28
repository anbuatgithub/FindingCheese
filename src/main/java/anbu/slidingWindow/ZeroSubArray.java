package anbu.slidingWindow;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZeroSubArray {
    //https://www.algoexpert.io/questions/zero-sum-subarr

    @Test
    public void test() {
        assertEquals(true, SingleslidingWindow(new int[]{-5,5,2,3,-2}));
        assertEquals(true, SingleslidingWindow(new int[]{-1,1,-1}));
        assertEquals(false, SingleslidingWindow(new int[]{1,2,4}));
        assertEquals(true, SingleslidingWindow(new int[]{-3,0,36,8,9,4,8,8,9,3}));
        assertEquals(true, SingleslidingWindow(new int[]{2,-2}));
        assertEquals(true, SingleslidingWindow(new int[]{0}));
    }

    @Test
    public void test2() {
        assertEquals(true, usingSet(new int[]{-5,5,2,3,-2}));
        assertEquals(true, usingSet(new int[]{-1,1,-1}));
        assertEquals(false, usingSet(new int[]{1,2,4}));
        assertEquals(true, usingSet(new int[]{-3,0,36,8,9,4,8,8,9,3}));
        assertEquals(true, usingSet(new int[]{2,-2}));
        assertEquals(true, usingSet(new int[]{0}));


    }

    @Test
    public void test3() {

        assertEquals(true, bruteForce(new int[]{-5,5,2,3,-2}));
        assertEquals(true, bruteForce(new int[]{-1,1,-1}));
        assertEquals(false, bruteForce(new int[]{1,2,4}));
        assertEquals(true, bruteForce(new int[]{-3,0,36,8,9,4,8,8,9,3}));
        assertEquals(true, bruteForce(new int[]{2,-2}));
        assertEquals(true, bruteForce(new int[]{0}));


    }


//ZERO SUB ARRAY
    static Boolean SingleslidingWindow(int nums[]) {
        // n must be greater

        int n = nums.length;
        int count = 0;

        for(int k=1;k<nums.length+1;k++) {
            // Compute sum of first window of size k
            int sum = 0;
            for (int i = 0; i < k; i++){
                sum += nums[i];

            if (sum == 0) {
                return true;
            }}


            for (int i = k; i < n; i++) {
                sum += nums[i] - nums[i - k];
                if (sum == 0) {
                    return true;
                }

            }
        }
        return false;
    }


    static Boolean usingSet(int nums[]) {

        Set<Integer> sum = new HashSet<>();
        int currentsum=0;

        for(int i :nums){
            currentsum +=i;
            if(i==0 || currentsum==0 || !sum.add(currentsum)){
                return true;
            }
        }
        return false;
    }



 static Boolean bruteForce(int nums[]) {

     for (int i = 0; i < nums.length; i++) {
         if (nums[i] == 0)
             return true;
         int sum = nums[i];
         for (int j = i + 1; j < nums.length ; j++) {

             if (nums[j] == 0)
                 return true;
             sum += nums[j];
             if (sum == 0)
                 return true;

         }


     }

     return false;
 }



}
