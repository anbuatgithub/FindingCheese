package com.meeran.datastructure;

import java.util.ArrayList;

public class HashTable {
	
	private int size=7;
	private Node[] dataMap;
	
	HashTable(){
		dataMap = new Node[size];
	}
	
	private void printHashTable() {
		for(int i=0; i<dataMap.length; i++) {
			System.out.println(i +" : ");
			Node temp = dataMap[i];
			while(temp!=null) {
				System.out.println(" {"+ temp.key + " = "+temp.value +"}");
				temp=temp.next;
			}
		}
	}
	
	private int hash(String key) {
		int hash=0;
		char[] keyChars = key.toCharArray();
		for(int i=0; i<keyChars.length; i++) {
			int asciiValue = keyChars[i];
			hash= (hash+asciiValue*23) % dataMap.length;
		}
		return hash;
	}
	
	private void set(String key, int value) {
		int index = hash(key);
		Node newNode = new Node(key,value);
		if(dataMap[index]==null) dataMap[index]=newNode;
		else {
			Node temp = dataMap[index];
			while(temp.next!=null) {
				temp=temp.next;
			}
			temp.next = newNode;
		}
	}
	
	private int get(String key) {
		int index = hash(key);
		Node temp = dataMap[index];
		while(temp!=null) {
			if(temp.key==key) return temp.value;
			temp=temp.next;
		}
		return 0;
	}
	
	private ArrayList keys() {
		ArrayList<String> allKeys = new ArrayList<>();
		for(int i=0; i< dataMap.length; i++) {
			Node temp = dataMap[i];
			while(temp!=null) {
				allKeys.add(temp.key);
				temp=temp.next;
			}
		}
		return allKeys;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashTable myHashTable = new HashTable();

        myHashTable.set("nails", 100);
        myHashTable.set("tile", 50);
        myHashTable.set("lumber", 80);
        myHashTable.set("bolts", 200);
        myHashTable.set("screws", 140);
        myHashTable.printHashTable();
        
        
        System.out.println("\nLumber:"+myHashTable.get("lumber"));

        System.out.println("\nBolts:"+myHashTable.get("bolts")) ;
        
        System.out.println("\nPaint:"+myHashTable.get("paint")) ;

        System.out.println("\nget Keys:"+myHashTable.keys()) ;
	}

}
