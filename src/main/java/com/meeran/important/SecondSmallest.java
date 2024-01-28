package com.meeran.important;

import java.util.Arrays;

public class SecondSmallest {
	public static void main(String Args[]) {
		int arr[] = {12, 35, 1, 35, 34, 1};
		System.out.println("Second Smallest is 12 "+getSecondSmallest(arr));
		int arr1[] = {12, 35, 1, 10, 34, 1};
		System.out.println("Second Smallest is 10 "+getSecondSmallest(arr1));
		int arr2[] = {12, 12, 12, 12, 12, 12};
		System.out.println("Second Smallest is 0 "+getSecondSmallest(arr2));
		int arr3[] = {12};
		System.out.println("Second Smallest is 0 "+getSecondSmallest(arr3));
		int arr5[] = {12,11};
		System.out.println("Second Smallest is 12 "+getSecondSmallest(arr5));
		int arr4[] = {2,5,6,8};
		System.out.println("Second Smallest is 5 "+getSecondSmallest(arr4));
	}
	static int getSecondSmallest(int[] arr) {
		Arrays.sort(arr);
		for(int i=0; i+1<arr.length; i++) {
			if(arr[i]!=arr[i+1]) return arr[i+1];
		}
		return 0;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	static int getSecondSmallest1(int[] arr) {
		Arrays.sort(arr);
		
		for(int i=0; i+1<arr.length;i++) {
			if(arr[i]!=arr[i+1]) {
				return arr[i+1];
			}
		}
		return 0;
	}
}