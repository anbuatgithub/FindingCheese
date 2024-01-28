package com.meeran.important;


// (H)d_ -> d_  -> d_ -> (L)d_->null
public class LinkedList {
	Node head;
	
	static class Node{
		int data;
		Node next;
		
		Node(int d){
			data = d;
			next = null;
		}
	}	
	
	public static LinkedList add(LinkedList list, int data) {
		
		Node newNode = new Node(data);
		
		if(list.head ==null) list.head = newNode;
		else {
			Node lastNode = list.head;
			while(lastNode.next !=null) lastNode = lastNode.next;
			lastNode.next = newNode;
		}
		
		return list;
	}
	
	public static void printLinkedList(LinkedList list) {
		Node currentNode = list.head;
		while(currentNode!=null) {
			System.out.print(currentNode.data+" ");
			currentNode = currentNode.next;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList list = new LinkedList();
		
		list = add(list,1);
		list = add(list,2);
		list = add(list,3);
		list = add(list,4);
		list = add(list,5);
		list = add(list,6);
		list = add(list,7);
		list = add(list,8);
		
		printLinkedList(list);
	}

}
