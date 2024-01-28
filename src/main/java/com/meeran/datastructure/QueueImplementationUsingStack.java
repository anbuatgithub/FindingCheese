package com.meeran.datastructure;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Stack;

import org.junit.Test;

public class QueueImplementationUsingStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	Stack<Integer> stack = new Stack<>();
	Stack<Integer> outputStack = new Stack<>();
	
	public void add(int x) {
		stack.push(x);
	}
	
	public int peek() {
		if(outputStack.isEmpty()) {
			while(!stack.isEmpty()) {
				outputStack.add(stack.pop());
			}
		}
		return outputStack.isEmpty() ? -1 : outputStack.peek();
	}
	
	public boolean remove() {
		peek();
		if(outputStack.isEmpty()) return false;
		else {
			outputStack.pop();
			return true;
		}
	}
	
	public Boolean isEmpty() {
		return stack.isEmpty() && outputStack.isEmpty();
	}
	
	@Test
	public void testQueue() {
		add(0);
		add(4);
		assertEquals(0, peek());
		add(5);
		assertEquals(0, peek());
		add(3);
		assertEquals(0, peek());
		assertTrue(remove());
		assertEquals(4, peek());
		assertTrue(remove());
		assertEquals(5, peek());
		assertTrue(remove());
		assertTrue(remove());
		assertEquals(-1, peek());
		assertFalse(remove());
	}

}
