package com.meeran.datastructure;

public class QueueByLinkedList {
	
	private Node first, last;
	private int length;
	
	QueueByLinkedList(int value){
		Node newNode = new Node(value);
		first = newNode;
		last = newNode;
		length=1;
	}
	
	public void printQueue() {
		Node temp = first;
		while(temp!=null) {
			System.out.println("Items in the Queue - "+ temp.value);
			temp = temp.next;
		}
	}
	
	public void enqueue(int value) {
		Node newNode = new Node(value);
		if(length==0) {
			first = newNode;
			last=newNode;
		} else {
			last.next = newNode;
			last=newNode;
		}
		length++;
	}
	
	public Node dequeue() {
		Node temp = first;
		if(length==0) return null;
		else if(length==1) {
			first = null;
			last = null;
		}else {
			first = first.next;
			temp.next =null;
		}
		length--;
		return temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueByLinkedList queue = new QueueByLinkedList(1);
		queue.printQueue();
		
		System.out.println("----enqueue TestCase--");
		queue.enqueue(2);
		queue.enqueue(3);
		queue.printQueue();
		
		System.out.println("----dequeue TestCase--");
		System.out.println("----Removed Node--"+queue.dequeue().value);
		queue.printQueue();
	}

}
