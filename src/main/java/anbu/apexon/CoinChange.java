package anbu.apexon;

public class CoinChange {

    public static void main(String[] args) {
        System.out.println(Solution.coins(10,20));

        System.out.println(Solution.coins(1,1));
        System.out.println(Solution.coins(2,3));
        System.out.println(Solution.coins(2,2));
        System.out.println(Solution.coins(3,4));
        System.out.println(Solution.coins(4,4));

    }
}


 class Solution {
    public static int gcd(int a, int b) {
        while (a * b > 0) {
            if (a > b) a %= b;
            else       b %= a;
        }
        System.out.println("returning "+(a+b));
        return a + b;
    }

    public static int coins(int coin1, int coin2) {
        if (gcd(coin1, coin2) > 1) return -1;
        return coin1 * coin2 - coin1 - coin2;
    }

}