package com.meeran.datastructure;

import java.util.Arrays;

public class BubbleSelectionInsertionSort {
	
	
	// BubbleSort
	// Space Complexity - O(1)
	// Time Complexity - O(n2)
	private static void bubbleSort(int[] array) {
		for(int i=array.length-1; i>0; i--) {
			for(int j=0; j<i; j++) {
				if(array[j]>array[j+1]) {
					int temp = array[j];
					array[j]=array[j+1];
					array[j+1] = temp;
				}
			}
		}
	}
	
	// SelectionSort
	// Space Complexity - O(1)
	// Time Complexity - O(n2)
	private static void selectionSort(int[] array) {
		for(int i=0; i<array.length; i++) {
			int minIndex=i;
			for(int j=i+1; j<array.length; j++) {
				if(array[j] < array[minIndex]) {
					minIndex=j;
				}
			}
			if(i!=minIndex) {
				int temp = array[i];
				array[i]=array[minIndex];
				array[minIndex]=temp;
			}
		}
	}
	
	// InsertionSort
	// Space Complexity - O(1)
	// Time Complexity - O(n2)
	private static void insertionSort(int[] array) {
		for(int i=1; i<array.length; i++) {
			int temp = array[i];
			int j = i-1;
			while(j>-1 && temp < array[j]) {
				array[j+1] = array[j];
				array[j] = temp;
				j--;
			}
		}
	}
	
	public static void main(String[] args) {	
		int[] bubbleArray = {4,2,6,5,1,3};
		bubbleSort(bubbleArray);
		System.out.println("Bubble Sort -->    "+Arrays.toString(bubbleArray));
		
		int[] selectionArray = {4,2,6,5,1,3};
		selectionSort(selectionArray);
		System.out.println("Selection Sort --> "+Arrays.toString(selectionArray));
		
		int[] insertionArray = {4,2,6,5,1,3};
		insertionSort(insertionArray);
		System.out.println("Insertion Sort --> "+Arrays.toString(insertionArray));
	}
	
}
