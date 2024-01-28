package com.meeran.datastructure;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class StackImplementationUsingQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

	Queue<Integer> queue = new LinkedList<Integer>();
	Queue<Integer> OutputQueue = new LinkedList<Integer>();
	int top;
	public void push(int x) {
		queue.add(x);
		top=x;
	}
	public int peek() {
		if(queue.isEmpty()) return -1;
		else return top;
	}
	
	public boolean pop() {
		if(queue.isEmpty()) return false;
		OutputQueue.clear();
		while(queue.size()>1) {
			top=queue.remove();
			OutputQueue.add(top);
		}
		
		Queue<Integer> temp = queue;
		queue = OutputQueue;
		OutputQueue=temp;
		return true;
	}
	
	public Boolean isEmpty() {
		return queue.isEmpty() && OutputQueue.isEmpty();
	}

	@Test
	public void testStack() {
		push(0);
		push(4);
		assertEquals(4, peek());
		push(5);
		assertEquals(5, peek());
		push(3);
		assertEquals(3, peek());
		assertTrue(pop());
		assertEquals(5, peek());
		assertTrue(pop());
		assertEquals(4, peek());
		assertTrue(pop());
		assertTrue(pop());
		assertFalse(pop());
		assertEquals(-1, peek());
		
	}
}
