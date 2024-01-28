package anbu.algo;

import java.util.Arrays;

public class ArrayOfProducts {

    public static void main(String[] args) {

        int array[]={5,1,4,2};


        int[] products = new int[array.length];
        int[] leftProducts = new int[array.length];
        int[] rightProducts = new int[array.length];
        int leftRunningProduct = 1;
        for (int i = 0; i < array.length; i++) {
            leftProducts[i] = leftRunningProduct;
            leftRunningProduct *= array[i];
        }
        int rightRunningProduct = 1;
        for (int i = array.length - 1; i >= 0; i--) {
            rightProducts[i] = rightRunningProduct;
            rightRunningProduct *= array[i];
        }

        for (int i = 0; i < array.length; i++) {
            products[i]=leftProducts[i]*rightProducts[i];
        }


        Arrays.stream(products).forEach(System.out::println);
    }
}
