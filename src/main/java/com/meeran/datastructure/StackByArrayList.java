package com.meeran.datastructure;

import java.util.ArrayList;

public class StackByArrayList<T> {

	private ArrayList<T> stackList = new ArrayList<>();  
    
    public ArrayList<T> getStackList() {
        return stackList;
    }
    
    public void printStack() {
        for (int i = stackList.size()-1; i >= 0; i--) {
            System.out.println(stackList.get(i));
        }
    }
    
    public boolean isEmpty() {
        return stackList.size() == 0;
    }
    
    public T peek() {
        if (isEmpty()) {
            return null;
        } else {
            return stackList.get(stackList.size() - 1);
        }
    }
    
    public int size() {
        return stackList.size();
    }
    
    public void push(T value) {
        stackList.add(value);
    }
    
    public T pop() {
        if (isEmpty()) return null;
        return stackList.remove(stackList.size() - 1);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackByArrayList myStack = new StackByArrayList();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        
        System.out.println("Stack before pop():");
        myStack.printStack();
        
        System.out.println("\nPopped node:");
        System.out.println(myStack.pop());
        
        System.out.println("\nStack after pop():");
        myStack.printStack();
	}
}
