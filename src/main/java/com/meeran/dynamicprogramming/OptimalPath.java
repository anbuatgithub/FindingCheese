package com.meeran.dynamicprogramming;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class OptimalPath {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int optimalPath(int[][] grid) {
		int sum=0,row=grid.length-1, col=0;
		return getMax(grid, sum, row, col);
	}
	
	public static int getMax(int[][] grid, int sum, int row, int col) {
        if(!isValid(grid, row, col))
            return sum;
        
        sum = sum + grid[row][col];
        
        if(isTopRight(grid, row, col))
            return sum;
        
        return Math.max(getMax(grid, sum, row - 1, col), getMax(grid, sum, row, col + 1));
    }
	
	public static boolean isTopRight(int[][] grid, int row, int col) {
        return row == 0 && col == grid[row].length - 1;
    }

    public static boolean isValid(int[][] grid, int row, int col) {
        return (row >= 0 &&  row < grid.length) && (col >= 0 && col < grid[row].length);
    }
	
	@Test
	public void testOptimalPath() {
		int[][] intialGrid = { {0,0,0,0,5}, 
	   			   {0,1,1,1,0},
	   			   {2,0,0,0,0}
	 			 };
		assertEquals(10, optimalPath(intialGrid));
	}
	
	int total = 0;
	
	public int calculateOptimalPath(int[][] grid) {
		if(grid==null || grid.length<=0) throw new IllegalArgumentException();
		
		total=grid[grid.length-1][0];
		
		if(grid.length==1 && grid[0].length==1) return total;
		
		if(grid.length==1) {
			int[] newArray = Arrays.copyOfRange(grid[0], 1, grid[0].length);
			return total+=calculateOptimalPath(new int[][] {newArray});
		}
		if(grid[0].length==1) {
			int[][] newGrid = new int[1][1];
			newGrid[0][0] = grid[0][0];
			return total+=calculateOptimalPath(newGrid);
		}else {
			int[][] upPath = new int[grid.length-1][];
			
			for(int i=grid.length-2;i>=0;i--) upPath[i] = Arrays.copyOfRange(grid[i], 0, grid[0].length);
			
			int[][] alongPath = new int[grid.length][grid[0].length-1];
			for(int i=grid.length-1;i>=0;i--) alongPath[i] = Arrays.copyOfRange(grid[i], 1, grid[0].length);
			return total+=Math.max(calculateOptimalPath(upPath), calculateOptimalPath(alongPath));
		}
	}
	
	@Test
	public void testCalculateOptimalPath() {
		int[][] intialGrid = { {0,0,0,0,5}, 
	   			   {0,1,1,1,0},
	   			   {2,0,0,0,0}
	 			 };
		assertEquals(10, calculateOptimalPath(intialGrid));
	}

}
