package com.meeran.dynamicprogramming;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class PathFinderShortPath {
	public static int pathFinder(String maze) {
		String[] mazeRow = maze.split("\n");
		System.out.println("rows-->" + Arrays.toString(mazeRow));
		Character[][] drawMaze = new Character[mazeRow.length + 2][mazeRow.length + 2];
		boolean[][] isSpotVisited = new boolean[mazeRow.length + 2][mazeRow.length + 2];
		for (int i = 0; i < drawMaze.length; i++) {
			drawMaze[0][i] = 'W';
			drawMaze[drawMaze.length - 1][i] = 'W';
			drawMaze[i][0] = 'W';
			drawMaze[i][drawMaze.length - 1] = 'W';
		}
		for (int i = 0; i < mazeRow.length; i++) {
			for (int j = 0; j < mazeRow.length; j++) {
				drawMaze[i + 1][j + 1] = mazeRow[i].charAt(j);
			}
			System.out.println("drawMaze-->" + Arrays.toString(drawMaze[i]));
		}
		Queue<int[]> moveQueue = new LinkedList<int[]>();
		moveQueue.add(new int[] { 1, 1, 0 });
		isSpotVisited[1][1] = true;
		while (!moveQueue.isEmpty()) {
			int[] move = moveQueue.remove();
			System.out.println("move-->" + Arrays.toString(move));
			int x = move[0];
			int y = move[1];
			int d = move[2];
			if (x == mazeRow.length && y == mazeRow.length) {
				return d;
			}
			moveToQueue(drawMaze, isSpotVisited, moveQueue, x - 1, y, d + 1);
			moveToQueue(drawMaze, isSpotVisited, moveQueue, x + 1, y, d + 1);
			moveToQueue(drawMaze, isSpotVisited, moveQueue, x, y - 1, d + 1);
			moveToQueue(drawMaze, isSpotVisited, moveQueue, x, y + 1, d + 1);
		}
		return -1;
	}

	private static void moveToQueue(Character[][] mazeArray, boolean[][] isSpotVisited, Queue<int[]> moveQueue, int x,
			int y, int d) {
		if (!isSpotVisited[x][y] && mazeArray[x][y] == '.') {
			isSpotVisited[x][y] = true;
			moveQueue.add(new int[] { x, y, d });
		}
	}

	@Test
	public void sampleTests() {

		String a = ".W.\n" + ".W.\n" + "...",

				b = ".W.\n" + ".W.\n" + "W..",

				c = "......\n" + "......\n" + "......\n" + "......\n" + "......\n" + "......",

				d = "......\n" + "......\n" + "......\n" + "......\n" + ".....W\n" + "....W.";

		assertEquals(a, 4, PathFinderShortPath.pathFinder(a));
		assertEquals(b, -1, PathFinderShortPath.pathFinder(b));
		assertEquals(c, 10, PathFinderShortPath.pathFinder(c));
		assertEquals(d, -1, PathFinderShortPath.pathFinder(d));
	}
}
