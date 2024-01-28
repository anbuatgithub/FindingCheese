package com.meeran.datastructure;

import java.util.Arrays;

public class MergeSort {
	
	private static int[] merge(int[] array1, int[] array2) {
		int[] combined = new int[array1.length + array2.length];
		int index=0, i=0, j=0;
		
		while(i<array1.length && j<array2.length) {
			if(array1[i]<array2[j]) {
				combined[index]=array1[i];
				i++;
			}else {
				combined[index]=array2[j];
				j++;
			}
			index++;
		}
		while(i<array1.length) {
			combined[index] = array1[i];
			index++;
			i++;
		}
		while(j<array2.length) {
			combined[index] = array2[j];
			index++;
			j++;
		}
		return combined;
	}
	
	// Space Complexity O(n)
	// Time Complexity O(n log n)
	private static int[] mergeSort(int[] array) {
		if(array.length==1) return array;
		int midIndex = array.length/2;
		int[] left = mergeSort(Arrays.copyOfRange(array, 0, midIndex));
		int[] right = mergeSort(Arrays.copyOfRange(array, midIndex, array.length));
		
		return merge(left,right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array1 = {1,3,7,8};
		int[] array2 = {2,4,5,6};
		
		System.out.println(Arrays.toString(merge(array1, array2)));
		
		int[] mergeArray = {1,3,8,7,2,4,6,5};
		System.out.println(Arrays.toString(mergeSort(mergeArray)));
		
	}

}
