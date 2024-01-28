package com.meeran.important;

import java.util.Arrays;

public class MinSquarePath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[][] grid = new int[][] 
				 	{
			 			{1,3,1,1},
			 			{1,5,1,1},
			 			{4,2,1,2},
			 			{4,2,4,1}
			 		};
                
        System.out.println("Resut-10->"+minPathSum(grid));
        
        grid = new int[][] 
			 	{
			 		{1,3,1,1},
			 		{1,5,1,1},
			 		{4,2,1,2},
			 		{4,2,4,1}
		 		};
			 		
		System.out.println("Resut-10->"+minPath(grid, grid[0].length-1, grid.length-1));
        
        grid = new int[][] {{1,2,3},{4,5,6}};
        System.out.println("Resut-12->"+minPath(grid, grid[0].length-1, grid.length-1));
        
       int[][] smallSquare = new int[][]
                {
                    { 1, 2, 3, 6, 2, 8, 1 },
                    { 4, 8, 2, 4, 3, 1, 9 },
                    { 1, 5, 3, 7, 9, 3, 1 },
                    { 4, 9, 2, 1, 6, 9, 5 },
                    { 7, 6, 8, 4, 7, 2, 6 },
                    { 2, 1, 6, 2, 4, 8, 7 },
                    { 8, 4, 3, 9, 2, 5, 8 }
                };
                
                System.out.println("Resut-1->"+minPath(smallSquare, 0, 0));
                System.out.println("Resut-5->"+minPath(smallSquare, 0, 1));
                System.out.println("Resut-11->"+minPath(smallSquare, 2, 2));
                System.out.println("Resut-24->"+minPath(smallSquare, 4, 2));
                System.out.println("Resut-39->"+minPath(smallSquare, 6, 6));
                System.out.println("Resut-24->"+minPath(smallSquare, 4, 5));
                
                int[][] intialGrid = { {0,0,0,0,5}, 
			   			   {0,1,1,1,0},
			   			   {2,0,0,0,0}
			 			 };
                System.out.println("Resut-1->"+minPath(intialGrid,intialGrid[0].length-1,intialGrid.length-1));
	}
	
	
	public static int minPathSum(int[][] grid) {
		int[] s = new int[grid[0].length+1];
		Arrays.fill(s, Integer.MAX_VALUE);
		s[1]=0;
		for(int i=0;i<grid.length;i++) {
			for(int j=0; j<grid[i].length;j++) {
				s[j+1] = Math.min(s[j], s[j+1])+grid[i][j];
			}
		}
		return s[s.length-1];
	}
	
	public static int minPath(int[][] grid, int m, int n) {
		int[] s = new int[m+2];
		Arrays.fill(s, Integer.MAX_VALUE);
		s[1]=0;
		for(int i=0; i<=n; i++) {
			for(int j=0; j<=m; j++) {
				s[j+1] = Math.min(s[j], s[j+1])+grid[i][j];
			}
		}
		return s[s.length-1];
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// 00	01
	//		11
	public static int minPath(int[][] grid) {
		int m = grid.length, n=grid[0].length;
		for(int i=1;i<m; i++) grid[i][0] +=grid[i-1][0];
		for(int j=1;j<n; j++) grid[0][j] +=grid[0][j-1];
		for(int i=1;i<m; i++) {
			for(int j=1;j<n; j++) {
				grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
			}
		}
		return grid[m-1][n-1];
	}
	
	public static int minPath2(int[][] grid, int m, int n) {
		int[] s = new int[m+2];
		Arrays.fill(s, Integer.MAX_VALUE);
		s[1]=0;
		
		for(int i=0; i<=n; i++) {
			for(int j=0; j<=m; j++) {
				s[j+1] = Math.min(s[j], s[j+1]) + grid[i][j];
			}
		}
		
		return s[s.length-1];
	}
	
	public int minPathSum1(int[][] grid) {
        int[] s = new int[grid[0].length+1];
        Arrays.fill(s,Integer.MAX_VALUE);
        s[1]=0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                s[j+1]=Math.min(s[j],s[j+1])+grid[i][j];
            }
        }
        return s[s.length-1];
    }
	
	
	public static int minPath1(int[][] grid, int m, int n) {
		int[] s = new int[m+2];
        Arrays.fill(s, Integer.MAX_VALUE);
        System.out.println("ss--->"+Arrays.toString(s));
        s[1] = 0;
        System.out.println("ss--11->"+Arrays.toString(s));
        for (int i = 0 ; i <= n ; i++)
            for (int j = 0 ; j <= m ; j++) {
            	System.out.println("min-->"+Math.min(s[j], s[j+1]));
            	System.out.println("Grid==>"+grid[i][j]);
                s[j+1] = Math.min(s[j], s[j+1]) + grid[i][j];
                System.out.println("Loopss--->"+Arrays.toString(s));
            }
                
        return s[s.length-1];
	}
	
}
