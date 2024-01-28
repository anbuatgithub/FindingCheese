package com.meeran.important;

import java.util.stream.IntStream;

import org.junit.Test;

public class EqualSidesOfArray {

	public static int findEvenIndex(int[] arr) {
		return IntStream.range(0, arr.length)
		.filter(n->IntStream.of(arr).limit(n).sum()==IntStream.of(arr).skip(n+1).sum())
		.findFirst().orElse(-1);
	}
	public static int findEvenIndex1(int[] arr) {
	    // your code
		int left=0;
		for(int i=0; i< arr.length; i++) {
			int right=0;
			for(int j=i+1; j<arr.length; j++) {
				right+=arr[j];
				if(left==right) {
					return i;
				}
			}
			left+=arr[i];
		}
		return -1;
	  }
	
	public static int findEvenIndex2(int[] arr) {
		
		return IntStream.range(0, arr.length).
				filter(n-> IntStream.of(arr).limit(n).sum() == IntStream.of(arr).skip(n+1).sum())
				.findFirst().orElse(-1);
	}
	
	@Test
	public void testFindEvenIndex(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Result - 3 " +findEvenIndex(new int[] {1,2,3,4,3,2,1}));
		System.out.println("Result - 0 " +findEvenIndex(new int[] {1,1,-1}));
        System.out.println("Result - 1 " +findEvenIndex(new int[] {1,100,50,-51,1,1}));
        System.out.println("Result - -1 " +findEvenIndex(new int[] {1,2,3,4,5,6}));
        System.out.println("Result - 3 " +findEvenIndex(new int[] {20,10,30,10,10,15,35}));
        System.out.println("Result - -1 " +findEvenIndex(new int[] {-8505, -5130, 1926, -9026}));
        System.out.println("Result - 1 " +findEvenIndex(new int[] {2824, 1774, -1490, -9084, -9696, 23094}));
        System.out.println("Result - 6 " +findEvenIndex(new int[] {4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4}));
	}

}
