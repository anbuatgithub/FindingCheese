package com.meeran.arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

public class SudokuValidator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean check(int[][] sudoku) {
        for (int i = 0; i < sudoku.length; i++) {
      for (int j = 0; j < sudoku.length; j++) {
        for (int i2 = 0; i2 < sudoku.length; i2++) {
          for (int j2 = 0; j2 < sudoku.length; j2++) {
            if(sudoku[i][j]==0)
              return false;
            if(i==i2 && j==j2) 
              continue;
            if(sudoku[i][j]==sudoku[i2][j2]) 
              if (i/3==i2/3 && j/3==j2/3 || i==i2 || j==j2) 
                return false;
          }
        }
      }
    }
        return true;
    }
	
	@Test
    public void exampleTest() {
        int[][] sudoku = {
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };
        assertTrue(SudokuValidator.check(sudoku));

        sudoku[0][0]++;
        sudoku[1][1]++;
        sudoku[0][1]--;
        sudoku[1][0]--;

        assertFalse(SudokuValidator.check(sudoku));   
        
        sudoku[0][0]--;
        sudoku[1][1]--;
        sudoku[0][1]++;
        sudoku[1][0]++;
        
        sudoku[4][4] = 0;

        assertFalse(SudokuValidator.check(sudoku));
    }

}
