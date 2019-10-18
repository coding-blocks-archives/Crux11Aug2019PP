package Assignments.Oct17;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 17-Oct-2019
 *
 */

public class Sudoku {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();

		int[][] arr = new int[n][n];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = scn.nextInt();
			}

		}

		sudoku(arr, 0, 0);

	}

	public static void sudoku(int[][] arr, int row, int col) {

		if (col == arr[0].length) {
			row++;
			col = 0;
		}

		if (row == arr.length) {
			display(arr);
			return;
		}

		if (arr[row][col] != 0) {
			sudoku(arr, row, col + 1);
			return;
		}

		for (int i = 1; i <= 9; i++) {

			if (isItSafe(arr, row, col, i)) {
				// place
				arr[row][col] = i;

				// call
				sudoku(arr, row, col + 1);

				// undo
				arr[row][col] = 0;
			}
		}

	}

	public static boolean isItSafe(int[][] board, int row, int col, int val) {

		// row
		for (int c = 0; c < board[0].length; c++) {
			if (board[row][c] == val) {
				return false;
			}
		}

		// col
		for (int r = 0; r < board.length; r++) {
			if (board[r][col] == val) {
				return false;
			}
		}

		// cell
		int sr = row - row % 3;
		int sc = col - col % 3;

		for (int i = sr; i < sr + 3; i++) {
			for (int j = sc; j < sc + 3; j++) {
				if (board[i][j] == val) {
					return false;
				}
			}
		}

		return true;
	}

	public static void display(int[][] arr) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
