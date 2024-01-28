package com.meeran.important;

import java.util.Arrays;

public class SecondLargest {
	public static void main(String Args[]) {
		int arr[] = {12, 35, 1, 35, 34, 1};
		System.out.println("Second Largest is 34 "+getSecondLargest(arr));
		int arr1[] = {12, 35, 1, 10, 34, 1};
		System.out.println("Second Largest is 34 "+getSecondLargest(arr1));
		int arr2[] = {12, 12, 12, 12, 12, 12};
		System.out.println("Second Largest is 0 "+getSecondLargest(arr2));
		int arr3[] = {12};
		System.out.println("Second Largest is 0 "+getSecondLargest(arr3));
		int arr4[] = {2,5,6,8};
		System.out.println("Second Largest is 6 "+getSecondLargest(arr4));
	}
	static int getSecondLargest(int[] arr) {
		Arrays.sort(arr);
		for(int i=arr.length-1;i>0; i--) if(arr[i]!=arr[i-1]) return arr[i-1];
		return 0;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	static int getSecondLargest1(int[] arr) {
		int result=-1;
		
		Arrays.sort(arr);
		
		for(int i=arr.length-1; i>0; i--) {
			if(arr[i]!=arr[i-1]) {
				return arr[i-1];
			}
		}
		
		return result;
	}
}
