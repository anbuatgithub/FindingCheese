package com.meeran.datastructure;

import java.util.Arrays;

public class QuickSort {
	
	private static int pivot(int[] array, int pivotIndex, int endIndex) {
		int swapIndex = pivotIndex;
		for(int i=pivotIndex+1; i<=endIndex; i++) {
			if(array[i]<array[pivotIndex]) {
				swapIndex++;
				swap(array, swapIndex, i);
			}
		}
		swap(array, pivotIndex, swapIndex);
		return swapIndex;
	}
	
	private static void swap(int[] array, int firstIndex, int secondIndex) {
		int temp = array[firstIndex];
		array[firstIndex] = array[secondIndex];
		array[secondIndex] = temp;
	}
	
	private static void quickSortHelper(int[] array, int left, int right) {
		if(left<right) {
			int pivotIndex = pivot(array, left,right);
			quickSortHelper(array, left, pivotIndex-1);
			quickSortHelper(array, pivotIndex+1,right);
		}
	}

	// Space Complexity - O(1)
	// Time Complexity - O(n log n)   ==> Worst posibility is O(n) if its already sorted
	private static void quickSort(int[] array) {
		quickSortHelper(array, 0, array.length-1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] pivotArray = {4,6,1,7,3,2,5};
		
		System.out.println("index: "+pivot(pivotArray, 0, 6));
		System.out.println(Arrays.toString(pivotArray));
		
		int[] quickArray = {4,6,1,7,3,2,5};
		quickSort(quickArray);
		
		System.out.println(Arrays.toString(quickArray));
	}

}
