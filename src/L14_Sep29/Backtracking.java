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

		QueenCombinationBoxRespect2DRecCall(new boolean[3][3], 0, 0, 2, 0, "");
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
		if (isItSafeToPlaceQueen(board, row, col)) {
			board[row][col] = true;
			QueenCombinationBoxRespect2DRecCall(board, row + 1, 0, tq, qpsf + 1, ans + "{" + row + "-" + col + "} ");
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

}
