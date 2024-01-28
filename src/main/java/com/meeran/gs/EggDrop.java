package com.meeran.gs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

/*
 * dp[M][K]means that, given K eggs and M moves,
	what is the maximum number of floor that we can check.
	
	The dp equation is:
	dp[m][k] = dp[m - 1][k - 1] + dp[m - 1][k] + 1,
	which means we take 1 move to a floor,
	if egg breaks, then we can check dp[m - 1][k - 1] floors.
	if egg doesn't breaks, then we can check dp[m - 1][k] floors.
	
	dp[m][k] is the number of combinations and it increase exponentially to N
*/
public class EggDrop {

	static int superEggDrop(int K, int N) {
        int dp[] = new int[K + 1], m = 0;
        for (; dp[K] < N; ++m)
            for (int j = K; j > 0; --j)
                dp[j] += dp[j - 1] + 1;
        return m;
    }
	
	@Test
	public void testEggDrop() {
		assertEquals(2,superEggDrop(1, 2));
		assertEquals(3,superEggDrop(2, 6));
		assertEquals(4,superEggDrop(3, 14));
		assertEquals(2,superEggDrop(3, 2));
		assertEquals(4,superEggDrop(64, 2));

	}

}
