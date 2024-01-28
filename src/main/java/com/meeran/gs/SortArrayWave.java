package com.meeran.gs;

import java.util.Arrays;

public class SortArrayWave {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int arr[] = {10, 5, 6, 3, 2, 20, 100, 80};
	        sortInWave(arr);
	        for (int i : arr)
	            System.out.print(i + " ");
	}


	static void sortInWave(int arr[]) {
		Arrays.sort(arr);
		for(int i=0;i<arr.length-1; i+=2) {
			swap(arr,i,i+1);
		}
	}
	static void swap(int arr[], int i, int j){
		int temp = arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}

}
