package com.meeran.gs;

public class SnailProblem2D {
	static int counter=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] array
        = {{1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}};
		traverseSnail(array);
		System.out.println();
		
		int[][] array1
        = {{1, 2, 3,1},
        {4, 5, 6,4},
        {7, 8, 9,7},
        {7,8,9,7}};
		traverseSnail(array1);
		System.out.println();
		
		int[][] array2
        = {{1, 2},
        {7, 8}};
		traverseSnail(array2);
		System.out.println();
		
		int[][] array3
        = {{1, 2, 3,1,2},
        {4, 5, 6,4,5},
        {7, 8, 9,7,8},
        {4, 5, 6,4,5},
        {7,8,9,7,9}};
		traverseSnail(array3);
		System.out.println();
		
		int[][] array4
        = {{1, 2, 3,9},
        {4, 5, 6,4},
        {7, 8, 9,1},
        {1,2,3,4}};
		traverseSnail(array4);
		System.out.println();
		
		int[][] array5
        = {{7},
        {9},
        {6}};
		traverseSnail(array5);
		System.out.println();
		
		int[][] array6
        = {{7,8,9}};
		traverseSnail(array6);
		System.out.println();
		
		int[][] array7
        = {{7,1},
        {9,2},
        {6,3}};
		traverseSnail(array7);
		System.out.println();
	}
	private static void traverseSnail(int[][] array) {
		int colMax = array[0].length;
		int rowMax= array.length-1;
		int row=0, col=-1, move=1;
		for(int i=0; i<array.length; i++) {
			for(int j=0; j<colMax;j++) {
				col+=move;
				System.out.print(array[row][col]+",");
			}
			if(colMax>0) {
				for(int j=0; j<rowMax; j++) {
					row+=move;
					System.out.print(array[row][col]+",");
				}
				move=move*-1;
				colMax--;
				rowMax--;
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static void traverseSnail2(int[][] array) {
		int rowMax=array.length;
		int colMax=array[0].length;
		int row=0;
		int col=-1;
		int move=1;
		for(int i=0; i<array.length; i++) {
			for(int j=0; j<colMax; j++) {
				col=col+move;
				System.out.print(array[row][col]+", ");
			}
			
			if(colMax>0) {
				rowMax--;
				for(int j=0; j<rowMax; j++) {
					row=row+move;
					System.out.print(array[row][col]+", ");
				}
			}
			colMax--;
			move=move*-1;
		}
	}

	private static String traverseSnail1(int[][] array) {
		// TODO Auto-generated method stub
		
		// print first row
		for(int i=0; i<array[0].length;i++) {
			System.out.print(array[0][i]+", ");
		}
		
		//print last column (except first row last column value)
		for(int j=1; j<array.length; j++) {
			System.out.print(array[j][array[0].length-1]+", ");
		}
		
		//print last row (except last row, column index value)
		for(int k=array[0].length-2;k>=0;k--) {
			System.out.print(array[array.length-1][k]+", ");
		}
		int count=0;
		//print first low first coln and check the count
		for(int z=array.length-2;z>0; z--) {
			System.out.print(array[z][0]+", ");
			count++;
		}
		
		if(count==1) {
			System.out.print(array[1][1]);
		}else if(count>1) {
			int[][] newArray= new int[count][count];
			counter++;
			for(int m=0;m<count;m++) {
				for(int n=0; n<count; n++) {
					newArray[m][n] = array[m+counter][n+counter];
				}
			}
			traverseSnail(newArray);
		}
		
		return null;
	}

}
