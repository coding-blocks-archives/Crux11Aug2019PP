package Assignments.Oct17;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 17-Oct-2019
 *
 */

public class Chessboard1 {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		System.out.println("\n" + chessboard1(0, 0, n - 1, n - 1, ""));
	}

	public static int chessboard1(int cr, int cc, int er, int ec, String ans) {

		if (cr == er && cc == ec) {
			System.out.print(ans + "{" + er + "-" + ec + "}  ");
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}

		int c = 0;

		// knight
		c += chessboard1(cr + 2, cc + 1, er, ec, ans + "{" + cr + "-" + cc + "}K");
		c += chessboard1(cr + 1, cc + 2, er, ec, ans + "{" + cr + "-" + cc + "}K");

		// rook
		if (cr == 0 || cr == er || cc == 0 || cc == ec) {
			// horizontal
			for (int move = 1; move <= ec; move++) {
				c += chessboard1(cr, cc + move, er, ec, ans + "{" + cr + "-" + cc + "}R");
			}

			// vertical
			for (int move = 1; move <= er; move++) {
				c += chessboard1(cr + move, cc, er, ec, ans + "{" + cr + "-" + cc + "}R");
			}

		}

		// bishop
		if (cr == cc || cr + cc == er) {

			for (int move = 1; move <= er && move <= ec; move++) {
				c += chessboard1(cr + move, cc + move, er, ec, ans + "{" + cr + "-" + cc + "}B");
			}

		}

		return c;

	}
}
