package com.meeran.datastructure;

public class SortUsingStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackByArrayList<Integer> stack = new StackByArrayList<>();
        stack.push(3);
        stack.push(2);
        stack.push(5);
        stack.push(1);
        stack.push(4);

        System.out.println("Before sorting:");
        stack.printStack();

        sortStack(stack);

        System.out.println("\nAfter sorting:");
        stack.printStack();
	}

	private static void sortStack(StackByArrayList<Integer> stack) {
		// TODO Auto-generated method stub
		StackByArrayList<Integer> tempStack = new StackByArrayList<>();
		
		while(!stack.isEmpty()) {
			int current = stack.pop();
			while(!tempStack.isEmpty() && tempStack.peek()>current) {
				stack.push(tempStack.pop());
			}
			tempStack.push(current);
		}
		while(!tempStack.isEmpty()) {
			stack.push(tempStack.pop());
		}
	}

}
