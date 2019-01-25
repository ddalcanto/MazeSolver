package Maze;

import java.util.Arrays;

public class Maze {

	private final int size = 6;

	public static void main(String[] args) {
		Maze program = new Maze();
		int maze[][] =
			{
					{1, 1, 1, 1, 1, 0},
					{0, 1, 0, 0, 1, 1},
					{1, 1, 1, 1, 0, 1},
					{1, 0, 0, 1, 0, 1},
					{0, 0, 0, 1, 0, 0},
					{0, 0, 1, 1, 1, 1}};

		program.run(maze);

	}

	private boolean isSafe(int maze[][], int x, int y) {
		if (x >= 0 && x < size && y >= 0 && y < size && maze[x][y] == 1) {
			return true;
		} else
			return false;
	}

	private void run(int maze[][]) {
		int sol[][] =
			{
					{0, 0, 0, 0, 0, 0},
					{0, 0, 0, 0, 0, 0},
					{0, 0, 0, 0, 0, 0},
					{0, 0, 0, 0, 0, 0},
					{0, 0, 0, 0, 0, 0},
					{0, 0, 0, 0, 0, 0}};

		if (explore(maze, 0, 0, sol) == false) {
			System.out.println("No path found");
		} else {
			printArray(sol);
		}
	}

	private void printArray(int sol[][]) {
		for (int[] x : sol) {
			for (int y : x) {
				System.out.print(y + " ");
			}
			System.out.println();
		}
	}

	private boolean explore(int maze[][], int x, int y, int sol[][]) {
		if (x == size - 1 && y == size - 1) {
			sol[x][y] = 1;
			System.out.println("Success!");
			System.out.println();
			System.out.println();
			System.out.println("The following path has been found:");
			System.out.println();
			return true;
		}
		if (isSafe(maze, x, y)) {
			sol[x][y] = 1;

			if (explore(maze, x + 1, y, sol)) {
				return true;
			}

			if (explore(maze, x, y + 1, sol)) {
				return true;
			}
		}
		

		return false;
	}
}
