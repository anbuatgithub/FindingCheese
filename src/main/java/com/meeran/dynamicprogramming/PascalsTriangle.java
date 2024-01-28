package com.meeran.dynamicprogramming;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PascalsTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(generate(9));
		System.out.println(pascal(4,8));
	}
	
	public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();

        // Base case; first row is always [1].
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int rowNum = 1; rowNum <= numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum-1);

            // The first row element is always 1.
            row.add(1);

            // Each triangle element (other than the first and last of each row)
            // is equal to the sum of the elements above-and-to-the-left and
            // above-and-to-the-right.
            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }

            // The last row element is always 1.
            row.add(1);
            
            triangle.add(row);
        }

        return triangle;
    }
	
	public static int pascal(int col, int numRows){
		if(col==0 || col==numRows) return 1;
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();

        // Base case; first row is always [1].
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int rowNum = 1; rowNum <= numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum-1);

            // The first row element is always 1.
            row.add(1);

            // Each triangle element (other than the first and last of each row)
            // is equal to the sum of the elements above-and-to-the-left and
            // above-and-to-the-right.
            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j-1) + prevRow.get(j));
                if(rowNum==numRows && j==col) return prevRow.get(j-1) + prevRow.get(j);
            }

            // The last row element is always 1.
            row.add(1);
            
            triangle.add(row);
        }

        return 0;
    }
	
	@Test
	public void testPascal() {
		assertEquals(70, pascal(4, 8));
		assertEquals(2, pascal(1, 2));
		assertEquals(1, pascal(0, 0));
		assertEquals(1, pascal(0, 5));
		assertEquals(1, pascal(7,7));
		assertEquals(8, pascal(7,8));
	}

}
