package anbu.apexon;

import java.util.Arrays;

public class ArrayRotation {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6 };
        bruteForce(Arrays.copyOf(arr,arr.length),3);
        System.out.println();
       // withExtraArray(arr,2);


    }


    static void bruteForce(int[] arr, int k) {
        // check invalid input
        k %= arr.length;
        int temp;
        int previous;
        for (int i = 0; i < k; i++) {
            previous = arr[arr.length - 1];
            for (int j = 0; j < arr.length; j++) {
                temp = arr[j];
                arr[j] = previous;
                previous = temp;
            }
        }
        Arrays.stream(arr).forEach(System.out::print);
    }



    static void withExtraArray(int[] arr, int k) {
        // check invalid input
       // k %= arr.length;

        int[] extraArray = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            extraArray[(i + k) % arr.length] = arr[i];
        }
        System.arraycopy(extraArray, 0, arr, 0, arr.length);
        Arrays.stream(arr).forEach(System.out::print);

    }


}
