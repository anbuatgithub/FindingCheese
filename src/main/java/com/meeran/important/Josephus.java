package com.meeran.important;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class Josephus {

	static int josephus(int n, int k) {
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 1; i <= n; i++)
			queue.offer(i);

		while (queue.size() > 1) {

			for (int delete = k - 1; delete > 0; delete--) {
				queue.offer(queue.remove());
			}
			queue.remove();
		}
		return queue.remove();
	}

	@Test
	public void test1() {
		josephusTest(7, 3, 4);
	}

	@Test
	public void test2() {
		josephusTest(11, 19, 10);
	}

	@Test
	public void test3() {
		josephusTest(40, 3, 28);
	}

	@Test
	public void test4() {
		josephusTest(14, 2, 13);
	}

	@Test
	public void test5() {
		josephusTest(100, 1, 100);
	}

	public void josephusTest(final int n, final int k, final int result) {
		String testDescription = String.format("Testing where n = %d and k = %d", n, k);
		assertEquals(testDescription, result, Josephus.josephus(n, k));
	}

	static int josephus1(int n, int k) {
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 1; i <= n; i++)
			queue.offer(i);

		while (queue.size() > 1) {
			int delete = k - 1;
			while (delete > 0) {
				queue.offer(queue.remove());
				delete--;
			}
			queue.remove();
		}
		return queue.remove();
	}

	static int josephus2(int n, int k) {
		if (n == 1)
			return 1;
		else
			return (josephus(n - 1, k) + k - 1) % n + 1;
	}

}
