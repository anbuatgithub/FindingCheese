package com.meeran.datastructure;

public class StackByLinkedList {
	
	
	private Node top;
	private int height;
	
	StackByLinkedList(int value){
		Node newNode = new Node(value);
		top=newNode;
		height=1;
	}
	
	public void printStack() {
		Node temp = top;
		while(temp!=null) {
			System.out.println("Items in the Stack - "+temp.value);
			temp = temp.next;
		}
	}
	
	public void push(int value) {
		Node newNode = new Node(value);
		if(height==0) top=newNode;
		else {
			newNode.next = top;
			top=newNode;
		}
		height++;
	}
	
	public Node pop() {
		Node temp=top;
		if(height==0) return null;
		else if(height==1) top=null;
		else {
			top = top.next;
			temp.next = null;
		}
		height--;
		return temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackByLinkedList stack = new StackByLinkedList(1);
		stack.printStack();
		
		System.out.println("----push TestCase--");
		stack.push(2);
		stack.push(3);
		stack.printStack();
		
		System.out.println("----Pop TestCase--");
		System.out.println("----Removed Node--"+stack.pop().value);
		stack.printStack();
	}

}
