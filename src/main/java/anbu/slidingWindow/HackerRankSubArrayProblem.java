package anbu.slidingWindow;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HackerRankSubArrayProblem {
    //https://www.hackerrank.com/challenges/the-birthday-bar/problem


    @Test
    public void testFakeBin1() {
        assertEquals(2, slidingWindow(new int[]{1, 2, 1, 3, 2}, 3, 2));
        assertEquals(0, slidingWindow(new int[]{1, 1, 1, 1, 1, 1}, 3, 2));
        assertEquals(1, slidingWindow(new int[]{4}, 4, 1));
        assertEquals(-1, slidingWindow(new int[]{4}, 4, 3));
    }

    static int slidingWindow(int arr[], int d, int k) {
        // n must be greater
        int n = arr.length;

        if (n < k) {
            System.out.println("Invalid");
            return -1;
        }
        int count = 0;

        // Compute sum of first window of size k
        int sum = 0;
        for (int i = 0; i < k; i++)
            sum += arr[i];

        if (sum == d) {
            count++;
        }


        for (int i = k; i < n; i++) {
            sum += arr[i] - arr[i - k];
            if (sum == d) {
                count++;
            }

        }

        return count;
    }


}
