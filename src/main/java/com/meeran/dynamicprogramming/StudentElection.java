package com.meeran.dynamicprogramming;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class StudentElection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int whoIsElected(int n, int k) {
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=1;i<=n;i++) queue.offer(i);
		
		while(queue.size()>1) {
			
			for(int delete=k-1; delete>0; delete--) {
				queue.offer(queue.remove());
			}
			queue.remove();
		}
		return queue.remove();
	}
	
	public static int josephus(int n, int k) {
		if(n==1) return 1;
		else
			return (josephus(n-1,k)+k-1)%n+1;
	}
	
	@Test
	public void testWhoIsElected() {
		
		assertEquals(1, whoIsElected(1, 1));
		assertEquals(1, whoIsElected(2, 2));
		assertEquals(1, whoIsElected(4, 2));
		assertEquals(13, whoIsElected(14, 2));
		assertEquals(3, whoIsElected(5, 2));
	}
	
	@Test
	public void testJosephus() {
		
		assertEquals(1, josephus(1, 1));
		assertEquals(1, josephus(2, 2));
		assertEquals(1, josephus(4, 2));
		assertEquals(13, josephus(14, 2));
		assertEquals(3, josephus(5, 2));
	}

}
