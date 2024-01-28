package com.meeran.gs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackAndQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class QueueImplementationUsingStack{
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
		return outputStack.peek();
	}
	
	public void remove() {
		peek();
		outputStack.pop();
	}
	
	public Boolean isEmpty() {
		return stack.isEmpty() && outputStack.isEmpty();
	}
}


class StackImplementationUsingQueue{
	Queue<Integer> queue = new LinkedList<Integer>();
	Queue<Integer> OutputQueue = new LinkedList<Integer>();
	int top;
	public void push(int x) {
		queue.add(x);
		top=x;
	}
	public int peek() {
		return top;
	}
	
	public void pop() {
		while(queue.size()>1) {
			top=queue.remove();
			OutputQueue.add(top);
		}
		
		Queue<Integer> temp = queue;
		queue = OutputQueue;
		OutputQueue=temp;
	}
	
	public Boolean isEmpty() {
		return queue.isEmpty() && OutputQueue.isEmpty();
	}
}
