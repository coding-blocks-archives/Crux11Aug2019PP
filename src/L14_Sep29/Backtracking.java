package L14_Sep29;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 29-Sep-2019
 *
 */

public class Backtracking {

	public static void main(String[] args) {

		// QueenCombinationBoxRespect(new boolean[5], 0, 3, 0, "");

		// coinChange(new int[] { 2, 3, 5, 6 }, 0, 10, "");

		// QueenCombinationBoxRespect2D(new boolean[2][3], 0, 0, 1, 0, "");

		// QueenCombinationBoxRespect2DRecCall(new boolean[4][4], 0, 0, 4, 0, "");

		// int[][] board = { { 0, 1, 0, 0 }, { 0, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 0, 1,
		// 0 } };
		// blockedMaze(board, 0, 0, "", new boolean[board.length][board[0].length]);

		// char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'E', 'C', 'S' }, { 'A',
		// 'E', 'E', 'E' } };
		//
		// String word = "XYZ";
		//
		// boolean res = false;
		// for (int i = 0; i < board.length; i++) {
		// for (int j = 0; j < board[0].length; j++) {
		//
		// if (board[i][j] == word.charAt(0)) {
		// res = res || searchWord(board, word, 0, i, j, new
		// boolean[board.length][board[0].length]);
		//
		// }
		// }
		// }
		//
		// System.out.println(res);

		// NQueen(new boolean[4][4], 0, "");

		KQueen(new boolean[4][4], 0, "", 0, 3);

	}

	static int count = 0;

	public static void QueenCombinationBoxRespect(boolean[] board, int col, int tq, int qpsf, String ans) {

		if (qpsf == tq) {
			System.out.println(++count + ".  " + ans);
			return;
		}

		if (col == board.length) {
			return;
		}

		// place
		board[col] = true;
		QueenCombinationBoxRespect(board, col + 1, tq, qpsf + 1, ans + "b" + col + " ");
		board[col] = false;

		// not place
		QueenCombinationBoxRespect(board, col + 1, tq, qpsf, ans);

	}

	public static void coinChange(int[] arr, int vidx, int amount, String ans) {

		if (amount == 0) {
			System.out.println(ans);
			return;
		}

		if (vidx == arr.length || amount < 0) {
			return;
		}

		// yes
		coinChange(arr, vidx, amount - arr[vidx], ans + arr[vidx]);

		// no
		coinChange(arr, vidx + 1, amount, ans);

	}

	public static void QueenCombinationBoxRespect2D(boolean[][] board, int row, int col, int tq, int qpsf, String ans) {

		if (qpsf == tq) {
			System.out.println(++count + ".  " + ans);
			return;
		}

		if (col == board[0].length) {
			row++;
			col = 0;
		}

		if (row == board.length) {
			return;
		}

		// place
		board[row][col] = true;
		QueenCombinationBoxRespect2D(board, row, col + 1, tq, qpsf + 1, ans + "{" + row + "-" + col + "} ");
		board[row][col] = false;

		// not place
		QueenCombinationBoxRespect2D(board, row, col + 1, tq, qpsf, ans);

	}

	public static void QueenCombinationBoxRespect2DRecCall(boolean[][] board, int row, int col, int tq, int qpsf,
			String ans) {

		if (qpsf == tq) {
			System.out.println(++count + ". " + ans);
			return;
		}

		if (col == board[0].length) {
			QueenCombinationBoxRespect2DRecCall(board, row + 1, 0, tq, qpsf, ans);
			return;
		}

		if (row == board.length) {
			return;
		}

		// place
		// if (isItSafeToPlaceQueen(board, row, col)) {
		if (isItSafeToPlaceKnight(board, row, col)) {
			board[row][col] = true;
			QueenCombinationBoxRespect2DRecCall(board, row, col + 1, tq, qpsf + 1, ans + "{" + row + "-" + col + "} ");
			board[row][col] = false;
		}

		// not place
		QueenCombinationBoxRespect2DRecCall(board, row, col + 1, tq, qpsf, ans);

	}

	public static boolean isItSafeToPlaceQueen(boolean[][] board, int row, int col) {

		// vertically up
		int r = row - 1;
		int c = col;

		while (r >= 0) {

			if (board[r][c]) {
				return false;
			}

			r--;
		}

		// horizontally left
		r = row;
		c = col - 1;

		while (c >= 0) {

			if (board[r][c]) {
				return false;
			}

			c--;
		}

		// digonally left
		r = row - 1;
		c = col - 1;

		while (c >= 0 && r >= 0) {

			if (board[r][c]) {
				return false;
			}

			r--;
			c--;
		}

		// digonally right
		r = row - 1;
		c = col + 1;

		while (c < board[0].length && r >= 0) {

			if (board[r][c]) {
				return false;
			}

			r--;
			c++;
		}

		return true;

	}

	// Q :https://www.geeksforgeeks.org/rat-in-a-maze-backtracking-2/
	
	public static void blockedMaze(int[][] board, int row, int col, String ans, boolean[][] visited) {

		if (row == board.length - 1 && col == board[0].length - 1) {
			System.out.println(ans);
			return;
		}

		if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col] == true
				|| board[row][col] == 1) {
			return;
		}

		visited[row][col] = true;

		// B
		blockedMaze(board, row + 1, col, ans + "B", visited);
		// T
		blockedMaze(board, row - 1, col, ans + "T", visited);
		// L
		blockedMaze(board, row, col - 1, ans + "L", visited);
		// R
		blockedMaze(board, row, col + 1, ans + "R", visited);

		visited[row][col] = false;

	}

	// Q : https://leetcode.com/problems/word-search/
		
	public static boolean searchWord(char[][] board, String word, int vidx, int row, int col, boolean[][] visited) {

		if (vidx == word.length()) {
			return true;
		}

		if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col] == true) {
			return false;
		}

		if (word.charAt(vidx) != board[row][col]) {
			return false;
		}

		visited[row][col] = true;

		// T
		boolean t = searchWord(board, word, vidx + 1, row - 1, col, visited);
		// L
		boolean l = searchWord(board, word, vidx + 1, row, col - 1, visited);
		// R
		boolean r = searchWord(board, word, vidx + 1, row, col + 1, visited);
		// B
		boolean b = searchWord(board, word, vidx + 1, row + 1, col, visited);

		visited[row][col] = false;

		return t || l || r || b;

	}

	public static boolean isItSafeToPlaceKnight(boolean[][] board, int row, int col) {

		int[] rowArr = { -1, -2, -2, -1 };
		int[] colArr = { -2, -1, 1, 2 };

		for (int i = 0; i < rowArr.length; i++) {

			int nr = row + rowArr[i];
			int nc = col + colArr[i];

			if (nr >= 0 && nc >= 0 && nr < board.length && nc < board[0].length) {

				if (board[nr][nc]) {
					return false;
				}
			}
		}

		return true;

	}

	public static void NQueen(boolean[][] board, int row, String ans) {

		if (row == board.length) {
			System.out.println(++count + ". " + ans);
			return;
		}

		for (int col = 0; col < board[0].length; col++) {

			if (isItSafeToPlaceQueen(board, row, col)) {
				board[row][col] = true;
				NQueen(board, row + 1, ans + "{" + row + "-" + col + "}");
				board[row][col] = false;
			}
		}

	}

	public static void KQueen(boolean[][] board, int row, String ans, int qpsf, int tq) {

		if (qpsf == tq) {
			System.out.println(++count + ". " + ans);
			return;
		}

		if (row == board.length) {
			return;
		}

		for (int col = 0; col < board[0].length; col++) {

			if (isItSafeToPlaceQueen(board, row, col)) {
				board[row][col] = true;
				KQueen(board, row + 1, ans + "{" + row + "-" + col + "}", qpsf + 1, tq);
				board[row][col] = false;
			}
		}

		KQueen(board, row + 1, ans, qpsf, tq);

	}

}
