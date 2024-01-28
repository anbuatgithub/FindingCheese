package com.meeran.important;

import java.util.Arrays;

public class TwoDAverage {
	public static void main(String Args[]) {
		int[][] twoDArr = {{40,50,60},{56,67,98},{87,99,98}};
		findAveragePerRow(twoDArr);
		findBestAverage(twoDArr);
		printArray(twoDArr);
		double[] averageArr = findAverageRow(twoDArr);
		System.out.println("Average is: "+Arrays.toString(averageArr));
	}
	
	static void findAveragePerRow(int[][] twoDArr) {
		double average = 0;
		int sum=0;
		
		for(int row=0; row<twoDArr.length; row++) {
			for(int col=0; col<twoDArr[row].length; col++) {
				sum += twoDArr[row][col];
			}
			average = sum/twoDArr[row].length;
			System.out.println("Average of "+(row+1)+" row: "+average);
			sum=0;average=0;
		}
	}
	
	static void findBestAverage(int[][] twoDArr) {
		double average = 0;
		double bestAverage=0;
		int sum=0;
		
		for(int row=0; row<twoDArr.length; row++) {
			for(int col=0; col<twoDArr[row].length; col++) {
				sum += twoDArr[row][col];
			}
			average = sum/twoDArr[row].length;
			if(average>bestAverage) {
				bestAverage=average;
			}
			sum=0;average=0;
		}
		System.out.println("Best Average is: "+bestAverage);
	}
	
	static void printArray(int[][] twoDArr) {
		for(int row=0; row<twoDArr.length; row++) {
			for(int col=0; col<twoDArr[row].length; col++) {
				System.out.print(twoDArr[row][col]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	static double[] findAverageRow(int[][] twoDArr) {
		double[] averageArr = new double[twoDArr.length];
		
		for(int row=0; row<twoDArr.length; row++) {
			int sum=0;
			for(int col=0; col<twoDArr[row].length; col++) {
				sum+=twoDArr[row][col];
			}
			averageArr[row]=sum/twoDArr[row].length;
		}
		return averageArr;
	}
}
