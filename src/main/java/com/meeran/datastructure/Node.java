package com.meeran.datastructure;

public class Node {
	int value;
	Node next, prev; // Linked List
	Node left,right; // Tree
	String key; // Hash Table
	
	public Node() {
	}

	public Node(int value) {
		this.value = value;
	}

	public Node(Node left, Node right, int val) {
		this.value = val;
		this.left = left;
		this.right = right;
	}
	
	public Node(String key, int value) {
		this.key=key;
		this.value=value;
	}
	
	
}
