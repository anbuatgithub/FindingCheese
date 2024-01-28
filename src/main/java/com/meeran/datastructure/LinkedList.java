package com.meeran.datastructure;

import java.util.HashSet;
import java.util.Set;

public class LinkedList {

	private Node head;
    private Node tail;
    private int length;

    LinkedList(int value){
        Node newNode = new Node(value);
        head=newNode;
        tail=newNode;
        length=1;
    }

    void printLinkedList(){
        Node temp = head;
        while(temp!=null){
            System.out.println("Value-->"+temp.value);
            temp=temp.next;
        }
    }

    void getHead(){
        if(head!=null) System.out.println("Head is :"+head.value);
    }

    void getTail(){
        if(tail !=null) System.out.println("Tail is : "+tail.value);
    }
    
    public Node getHeadNode(){
        return head;
    }

    public Node getTailNode(){
        return tail;
    }
    
	private int getLength() {
		return length;
	}

    //Insert last
    void append(int value){
        Node newNode = new Node(value);
        if(length==0){
            head=newNode;
            tail=newNode;
        } else{
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    // Insert First
    void prepend(int value){
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    //Remove First
    Node removeFirst(){
        if(length==0) return null;
        Node temp=head;
        head=head.next;
        temp.next = null;
        length--;
        if(length==0){
            tail=null;
        }
        return temp;
    }

    //Remove Last
    Node removeLast(){
        if(length==0) return null;
        Node temp=head;
        Node pre = head;
        while(temp.next!=null){
            pre=temp;
            temp=temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        if(length==0){
            head=null;
            tail=null;
        }
        return temp;
    }

    Node get(int index){
        if(index<0 || index >=length ) return null;
        Node temp = head;
        for(int i=0; i<index; i++){
            temp = temp.next;
        }
        return temp;
    }

    void set(int index, int value){
        Node temp = get(index);
        if(temp!=null) temp.value= value;
    }

    void insert(int index, int value){
        if(index==0) prepend(value);
        if(index==length) append(value);
        Node newNode = new Node(value);
        Node pre=get(index-1);
        newNode.next = pre.next;
        pre.next = newNode;
        length++;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length) return null;
        if (index == 0) return removeFirst();
        if (index == length - 1) return removeLast();

        Node prev = get(index - 1);
        Node temp = prev.next;

        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;
        Node after = temp.next;
        Node before = null;
        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }
    
    public Node findMiddleNode() {
    	if(head==null) return null;
    	Node slow = head;
    	Node fast = head;
    	while(fast!=null && fast.next!=null) {
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	return slow;
    }
    
    public boolean hasLoop() {
    	if(head==null) return false;
    	Node slow = head;
    	Node fast = head;
    	while(fast!=null && fast.next!=null) {
    		slow = slow.next;
    		fast = fast.next.next;
    		if(slow==fast) return true;
    	}
    	return false;
    }
    
    public Node findKthFromEnd(int k) {
    	Node fast = head;
    	Node slow = head;
    	for(int i=0; i<k; i++) {
    		if(fast==null) return null;
    		fast = fast.next;
    	}
    	
    	while(fast!=null) {
    		slow=slow.next;
    		fast=fast.next;
    	}
    	return slow;
    }
    
    public void removeDuplicates() {
    	Set<Integer> values = new HashSet<>();
    	Node current = head;
    	Node previous = null;
    	while(current != null){
    		if(values.contains(current.value)) {
    			previous.next = current.next;
    			length--;
    		}else {
    			values.add(current.value);
    			previous=current;
    		}
    		current=current.next;
    	}
    }
    
    public void reverseBetween(int m, int n) {
    	if(head==null) return;
    	Node dummy = new Node(0);
    	dummy.next = head;
    	Node previous = dummy;
    	
    	for(int i=0; i<m; i++) previous = previous.next;
    	
    	Node current = previous.next;
    	for(int i=0; i<n-m; i++) {
    		Node temp = current.next;
    		current.next = temp.next;
    		temp.next = previous.next;
    		previous.next = temp;
    	}
    	
    	head = dummy.next;
    }
    
    public void partitionList(int x) {
        if (head == null) return;
 
        Node dummy1 = new Node(0);
        Node dummy2 = new Node(0);
        Node prev1 = dummy1;
        Node prev2 = dummy2;
        Node current = head;
 
        while (current != null) {
            if (current.value < x) {
                prev1.next = current;
                prev1 = current;
            } else {
                prev2.next = current;
                prev2 = current;
            }
            current = current.next;
        }
 
        prev2.next = null;
        prev1.next = dummy2.next;
 
        head = dummy1.next;
    }  
    
    public void insertionSort() {
		if (length < 2) {
			return; // List is already sorted
		}
 
		Node sortedListHead = head;
		Node unsortedListHead = head.next;
		sortedListHead.next = null;
 
		while (unsortedListHead != null) {
			Node current = unsortedListHead;
			unsortedListHead = unsortedListHead.next;
 
			if (current.value < sortedListHead.value) {
				current.next = sortedListHead;
				sortedListHead = current;
			} else {
				Node searchPointer = sortedListHead;
				while (searchPointer.next != null && current.value > searchPointer.next.value) {
					searchPointer = searchPointer.next;
				}
				current.next = searchPointer.next;
				searchPointer.next = current;
			}
		}
 
		head = sortedListHead;
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		tail = temp;
	}
    
    public void merge(LinkedList otherList) {
        Node otherHead = otherList.getHeadNode();
        Node dummy = new Node(0);
        Node current = dummy;
 
        while (head != null && otherHead != null) {
            if (head.value < otherHead.value) {
                current.next = head;
                head = head.next;
            } else {
                current.next = otherHead;
                otherHead = otherHead.next;
            }
            current = current.next;
        }
 
        if (head != null) {
            current.next = head;
        } else {
            current.next = otherHead;
            tail = otherList.getTailNode();
        }
 
        head = dummy.next;
        length += otherList.getLength();
    }
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList ll = new LinkedList(4);
        ll.printLinkedList();
        System.out.println("----------");
        ll.append(5);
        ll.printLinkedList();

        ll.getHead();
        ll.getTail();

        ll.prepend(3);
        ll.printLinkedList();
        System.out.println("Remove First: "+ll.removeFirst().value);
        ll.printLinkedList();
        System.out.println("Remove First: "+ll.removeFirst().value);
        ll.printLinkedList();
        System.out.println("Remove First: "+ll.removeFirst().value);
        ll.printLinkedList();
        System.out.println("Remove First: "+ll.removeFirst());
        ll.printLinkedList();

        ll.append(1);
        ll.printLinkedList();
        System.out.println("----------");
        ll.append(2);
        ll.printLinkedList();
        System.out.println("----------");
        ll.prepend(0);
        ll.printLinkedList();

        System.out.println("Remove Last: "+ll.removeLast().value);
        ll.printLinkedList();
        System.out.println("Remove Last: "+ll.removeLast().value);
        ll.printLinkedList();
        System.out.println("Remove Last: "+ll.removeLast().value);
        ll.printLinkedList();
        System.out.println("Remove Last: "+ll.removeLast());
        ll.printLinkedList();

        ll.append(1);
        ll.printLinkedList();
        System.out.println("----------");
        ll.append(2);
        ll.printLinkedList();
        System.out.println("----------");
        ll.prepend(0);
        ll.printLinkedList();

        System.out.println("Get the Element of index 1-->"+ll.get(1).value);
        System.out.println("Get the Element of index 2-->"+ll.get(2).value);

        ll.set(0,10);
        ll.printLinkedList();
        System.out.println("----------");
        ll.insert(1,11);
        ll.printLinkedList();
        ll.remove(1);
        System.out.println("----------");
        ll.printLinkedList();
        System.out.println("----Reverse------");
        ll.reverse();
        ll.printLinkedList();
        
        System.out.println("----Middle Node------"+ll.findMiddleNode().value);
        
        ll.append(5);
        ll.append(6);
        
        //ll.getTailNode().next = ll.getHeadNode().next;
        System.out.println(ll.hasLoop());
        ll.printLinkedList();
        int k=2;
        System.out.println(ll.findKthFromEnd(k).value);
        ll.append(5);
        ll.append(6);
        ll.printLinkedList();
        System.out.println("----Remove Duplicates------");
        ll.removeDuplicates();
        ll.printLinkedList();
        System.out.println("----reverse between 1,3------");
        ll.reverseBetween(1, 3);
        ll.printLinkedList();
        
        System.out.println("LL before partitionList:");
        ll.printLinkedList(); 

        ll.partitionList(5);

        System.out.println("\nLL after partitionList:");
        ll.printLinkedList(); 
        
        
        LinkedList myLinkedList = new LinkedList(4);
        myLinkedList.append(2);
        myLinkedList.append(6);
        myLinkedList.append(5);
        myLinkedList.append(1);
        myLinkedList.append(3);


        System.out.println("Unsorted Linked List:");
        myLinkedList.printLinkedList();

        myLinkedList.insertionSort();

        System.out.println("\nSorted Linked List:");
        myLinkedList.printLinkedList();
        
        
        LinkedList l1 = new LinkedList(1);
        l1.append(3);
        l1.append(5);
        l1.append(7);
        
        LinkedList l2 = new LinkedList(2);
        l2.append(4);
        l2.append(6);
        l2.append(8);
        
        l1.merge(l2);

        System.out.println("Merged Linked List:");
        l1.printLinkedList();
	}

}
