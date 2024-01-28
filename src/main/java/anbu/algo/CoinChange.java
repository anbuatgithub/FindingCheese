package anbu.algo;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {

        //System.out.println(nonConstructibleChange(new int[]{5,7,1,2,3,22}));
        System.out.println(nonConstructibleChange(new int[]{1,2,6}));



    }


    public static int nonConstructibleChange(int[] coins) {
        Arrays.sort(coins);
        int currentChangeCreated = 0;
        for (int coin : coins) {
            if (coin > currentChangeCreated + 1) {
                return currentChangeCreated + 1;
            }
            currentChangeCreated += coin;
        }
        return currentChangeCreated + 1;
    }
}