package com.meeran.numeric;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

public class FindTheSmallest {
	public static long[] smallest(long n) {
        // your code
		
		long smallest = n, indexI=0,indexJ=0;
		String ipStr = String.valueOf(n);
		for(int i=0; i<ipStr.length();i++) {
			for(int j=0; j<ipStr.length(); j++) {
				long shift_Num = shiftDigit(ipStr, i, j);
				if(i!=j && shift_Num < smallest) {
					smallest = shift_Num;
					indexI=i;
					indexJ=j;
				}
			}
		}
		return new long[]{smallest,indexI, indexJ};
    }
	
	private static long shiftDigit(String ipStr, int i, int j) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder(ipStr);
		char ch = sb.charAt(i);
		sb.deleteCharAt(i);
		sb.insert(j, ch);
		return Long.valueOf(sb.toString());
	}

	private static void testing(long n, String res) {
        assertEquals(res, 
                     Arrays.toString(smallest(n)));
    }
    @Test
    public void test() {
        System.out.println("Basic Tests smallest");
        testing(261235, "[126235, 2, 0]");
        testing(209917, "[29917, 0, 1]");
        testing(285365, "[238565, 3, 1]");
        testing(269045, "[26945, 3, 0]");
        testing(296837, "[239687, 4, 1]");

        testing(187863002809L, "[18786300289, 10, 0]");
        testing(199819884756L, "[119989884756, 4, 0]");
        testing(94883608842L, "[9488368842, 6, 0]");
        testing(256687587015L, "[25668758715, 9, 0]");
        testing(935855753L, "[358557539, 0, 8]");
    }
    //........
    private static long[] smallestSol(long n) {
        String s = Long.toString(n), tmp = s; long [] mem = new long[] {-1, -1, -1};
        int l = s.length();
        for (int i = 0; i < l; i++) {
            char c = s.charAt(i);
            String str1 = s.substring(0, i) + s.substring(i+1, l);
            for (int j = 0; j < l; j++) {
                String str2 = str1.substring(0, j) + c + str1.substring(j, str1.length());
                int cmp = str2.compareTo(tmp);
                if (cmp < 0) {
                    tmp = str2;
                    mem[0] = Long.parseLong(tmp);  mem[1] = i; mem[2] = j;
                }
            }
        }
        return mem;
    }
    //........
    private static long randint(Random rnd, long min, long max) {
        long randomNumber = (long)(rnd.nextDouble()*(max - min));
        return randomNumber;
    }
    private static void wTests1() 
    {
        for (int i = 0; i < 200; i++) {
            Random rnd = new Random();
            long nmx = randint(rnd, 4000, 1000000000000000000L);
            String ans = Arrays.toString(smallestSol(nmx));
            //System.out.println("number " + nmx + " --> " + ans);
            testing(nmx, ans);
        }
    }
    @Test
    public void tests1() {
        System.out.println("Random Tests  smallest ****");
        wTests1();
    } 
}
