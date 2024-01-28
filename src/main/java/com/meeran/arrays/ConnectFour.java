package com.meeran.arrays;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ConnectFour {
	static char[][] board ;

	public static String whoIsWinner(List<String> piecesPositionList) {
		// retrun "Red" or "Yellow" or "Draw"
		board = new char[6][7];
		for (String str : piecesPositionList) {
			char column = str.charAt(0);
			char player = str.charAt(2);
			boolean isFull = true;
			char howConnected = 0;
				isFull = isBoardFull();
				if (!isFull) {
					int move = ((int) column - 65)+1;
					howConnected = 0;
					if (isColumnFull(move)) {
						// ignore
					} else if (player == 'R') {
						placeCounter('R', move);
						howConnected = validateConnection('R');
						if (howConnected != 0) {
							return "Red";
						}
					} else if (player == 'Y') {
						placeCounter('Y', move);
						howConnected = 0;
						howConnected = validateConnection('Y');
						if (howConnected != 0) {
							return "Yellow";
						}
					}
				} else {
					return "Draw";
				}

		}
		return "Draw";
	}

	static boolean isBoardFull() {
		boolean isfull = true;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] != 'R' && board[i][j] != 'Y') {
					return false;
				}
			}
		}
		return isfull;
	}

	static boolean isColumnFull(int move) {
		boolean isColumnFull = true;
		for (int i = 0; i < board.length; i++) {
			if (board[i][move - 1] != 'R' && board[i][move - 1] != 'Y') {
				return false;
			}
		}
		return isColumnFull;
	}

	static void placeCounter(char player, int position) {
		boolean placed = false;
		for (int i = board.length - 1; i >= 0; i--) {
			if (!placed) {
				if (board[i][position - 1] == 'R' || board[i][position - 1] == 'Y') {
				} else {
					board[i][position - 1] = player;
					placed = true;
					break;
				}
			}
		}
	}

	static char validateConnection(char player) {
		// check Horizontal
		char howConnected = 0;
		int count = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == player) {
					count = count + 1;
					if (count >= 4) {
						howConnected = 'H';
						return howConnected;
					}
				} else {
					count = 0;
				}
			}
			count = 0;
		}

		// check Vertical
		for (int i = 0; i < board[0].length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[j][i] == player) {
					count = count + 1;
					if (count >= 4) {
						howConnected = 'V';
						return howConnected;
					}
				} else {
					count = 0;
				}
			}
			count = 0;
		}

		// check Diagonal
		for (int i = 0; i < board.length - 3; i++) {
			for (int j = 0; j < board[i].length - 3; j++) {
				int element = board[i][j];
				if (element == player && element == board[i + 1][j + 1] && element == board[i + 2][j + 2]
						&& element == board[i + 3][j + 3]) {
					howConnected = 'D';
					return howConnected;
				}
			}
		}

		// check Counter Diagonal
		for (int i = 0; i < board.length - 3; i++) {
			for (int j = 3; j < board[i].length; j++) {
				int element = board[i][j];
				if (element == player && element == board[i + 1][j - 1] && element == board[i + 2][j - 2]
						&& element == board[i + 3][j - 3]) {
					howConnected = 'C';
					return howConnected;
				}
			}
		}
		return howConnected;
	}

	@Test
	public void firstTest() {
		List<String> myList = new ArrayList<String>(
				Arrays.asList("A_Red", "B_Yellow", "A_Red", "B_Yellow", "A_Red", "B_Yellow", "G_Red", "B_Yellow"));
		assertEquals("it should return Yellow", "Yellow", ConnectFour.whoIsWinner(myList));
	}

	@Test
	public void secondTest() {
		List<String> myList = new ArrayList<String>(Arrays.asList("C_Yellow", "E_Red", "G_Yellow", "B_Red", "D_Yellow",
				"B_Red", "B_Yellow", "G_Red", "C_Yellow", "C_Red", "D_Yellow", "F_Red", "E_Yellow", "A_Red", "A_Yellow",
				"G_Red", "A_Yellow", "F_Red", "F_Yellow", "D_Red", "B_Yellow", "E_Red", "D_Yellow", "A_Red", "G_Yellow",
				"D_Red", "D_Yellow", "C_Red"));
		assertEquals("it should return Yellow", "Yellow", ConnectFour.whoIsWinner(myList));
	}

	@Test
	public void thirdTest() {
		List<String> myList = new ArrayList<String>(
				Arrays.asList("A_Yellow", "B_Red", "B_Yellow", "C_Red", "G_Yellow", "C_Red", "C_Yellow", "D_Red",
						"G_Yellow", "D_Red", "G_Yellow", "D_Red", "F_Yellow", "E_Red", "D_Yellow"));
		assertEquals("it should return Red", "Red", ConnectFour.whoIsWinner(myList));
	}
}
