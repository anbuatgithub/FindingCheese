package com.meeran.important;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MedianSortedArrays {
	public static void main(String Arg[]) {
		List<Integer> firstArray = new ArrayList<Integer>();
		firstArray.add(30);
		firstArray.add(20);
		firstArray.add(10);
		firstArray.add(40);
		List<Integer> secondArray = new ArrayList<Integer>();
		secondArray.add(25);
		secondArray.add(15);
		secondArray.add(5);
		secondArray.add(35);
		System.out.println("Median of these two array is: "+ findMedian(firstArray, secondArray));
	}
	
	static double findMedian(List<Integer> firstArray, List<Integer> secondArray) {
		firstArray.addAll(secondArray);
		Collections.sort(firstArray);
		if(firstArray.size()%2==0) return (firstArray.get(firstArray.size()/2-1)+firstArray.get(firstArray.size()/2))/2d;
		else return (double) firstArray.get(firstArray.size()/2);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	static double findMedian1(List<Integer> firstArray, List<Integer> secondArray) {
		double median = 0.0;
		firstArray.addAll(secondArray);
		Collections.sort(firstArray);
		System.out.println("Merged-->"+firstArray.toString());
		System.out.println("1-->"+firstArray.get(firstArray.size()/2-1));
		System.out.println("2-->"+firstArray.get(firstArray.size()/2));
		if(firstArray.size()%2==0) {
			median= (firstArray.get(firstArray.size()/2-1)+firstArray.get(firstArray.size()/2))/2d;
		}else {
			median = firstArray.get(firstArray.size()/2);
		}
		return median;
	}
}
