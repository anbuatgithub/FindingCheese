package com.meeran.datastructure;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/*
 * 
Queue Method -> Equivalent Deque Method
add(e) -> addLast(e)
offer(e) -> offerLast(e)
remove() -> removeFirst()
poll() -> pollFirst()
element() -> getFirst()
peek() -> peekFirst()

Stack Method -> Equivalent Deque Method
push(e) -> addFirst(e)
pop() -> removeLast()
peek() -> peekFirst()

 * */
public class Deque {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	List<Integer> list = new ArrayList<>(); 
	
	public void addFirst(int a) {
		list.add(0, a);
	}
	
	public void addLast(int a) {
		list.add(list.size(), a);
	}

	public boolean removeFirst() {
		if(list.size()>0) {
			list.remove(0);
			return true;
		}else return false;
	}
	
	public boolean removeLast() {
		if(list.size()>0) {
			list.remove(list.size()-1);
			return true;
		}else return false;
	}
	
	public int peekFirst() {
		if(list.size()>0) return list.get(0);
		else return -1;
	}
	
	public int peekLast() {
		if(list.size()>0) return list.get(list.size()-1);
		else return -1;
	}
	
		
	@Test
	public void testDeque() {
		addFirst(0);
		addFirst(4);
		assertEquals(0, peekLast());
		assertEquals(4, peekFirst());
		addLast(5);
		assertEquals(5, peekLast());
		assertEquals(4, peekFirst());
		addFirst(3);
		assertEquals(5, peekLast());
		assertEquals(3, peekFirst());
		assertTrue(removeFirst());
		assertEquals(5, peekLast());
		assertEquals(4, peekFirst());
		assertTrue(removeLast());
		assertEquals(0, peekLast());
		assertEquals(4, peekFirst());
		assertTrue(removeLast());
		assertTrue(removeLast());
		assertEquals(-1, peekLast());
		assertEquals(-1, peekFirst());
		assertFalse(removeFirst());
		assertFalse(removeLast());
	}


}

