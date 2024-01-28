package anbu.slidingWindow;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxSumOfSubArrays {
    public static void main(String[] args) {

        // int arr[] = {1, 4, 2, 10, 2, 3, 1, 0, 20};
        int arr[] = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println(bruteForce(arr, k));
        System.out.println(slidingWindow(arr, k));

    }


    @Test
    public void test() {
        assertEquals(9, slidingWindow(new int[]{2, 1, 5, 1, 3, 2},3));
        assertEquals(700, slidingWindow(new int[]{100,200,300,400},2));
    }


    static int bruteForce(int arr[], int k) {
        // Initialize result
        int max_sum = Integer.MIN_VALUE;
        // Consider all blocks starting with i.
        //for (int i = 0; i < arr.length - k + 1; i++) {
        for (int i = 0; i <= arr.length - k; i++) {
            int current_sum = 0;

            for (int j = i; j < i + k; j++) {
                current_sum = current_sum + arr[j];
            }
            max_sum = Math.max(current_sum, max_sum);
        }

        return max_sum;

    }


    static int slidingWindow(int arr[], int k) {
        // n must be greater

        int n = arr.length;

        if (n < k) {
            System.out.println("Invalid");
            return -1;
        }

        // Compute sum of first window of size k
        int max_sum = 0;
        for (int i = 0; i < k; i++)
            max_sum += arr[i];

        // Compute sums of remaining windows by
        // removing first element of previous
        // window and adding last element of
        // current window.
        int window_sum = max_sum;
        for (int i = k; i < n; i++) {
            window_sum += arr[i] - arr[i - k];
            max_sum = Math.max(max_sum, window_sum);
        }

        return max_sum;
    }


}
