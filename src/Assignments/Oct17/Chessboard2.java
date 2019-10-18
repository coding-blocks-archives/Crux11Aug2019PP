package Assignments.Oct17;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 17-Oct-2019
 *
 */

public class Chessboard2 {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		char[] mp = makeMinesPorts(SOE(n * n));

		System.out.println("\n" + chessboard2(0, 0, n - 1, n - 1, "", mp));
	}

	public static int chessboard2(int cr, int cc, int er, int ec, String ans, char[] mp) {

		if (cr == er && cc == ec) {
			System.out.println(ans + "{" + er + "-" + ec + "}  ");
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}

		int c = 0;

		int val = cr * (ec + 1) + cc + 1;

		if (mp[val] == 'M') {
			return 0;
		} else if (mp[val] == 'P') {
			c += chessboard2(er, ec, er, ec, ans + "{" + cr + "-" + cc + "}P", mp);
		}

		// knight
		c += chessboard2(cr + 2, cc + 1, er, ec, ans + "{" + cr + "-" + cc + "}K", mp);
		c += chessboard2(cr + 1, cc + 2, er, ec, ans + "{" + cr + "-" + cc + "}K", mp);

		// rook
		if (cr == 0 || cr == er || cc == 0 || cc == ec) {
			// horizontal
			for (int move = 1; move <= ec; move++) {
				c += chessboard2(cr, cc + move, er, ec, ans + "{" + cr + "-" + cc + "}R", mp);
			}

			// vertical
			for (int move = 1; move <= er; move++) {
				c += chessboard2(cr + move, cc, er, ec, ans + "{" + cr + "-" + cc + "}R", mp);
			}

		}

		// bishop
		if (cr == cc || cr + cc == er) {

			for (int move = 1; move <= er && move <= ec; move++) {
				c += chessboard2(cr + move, cc + move, er, ec, ans + "{" + cr + "-" + cc + "}B", mp);
			}

		}

		return c;

	}

	public static char[] makeMinesPorts(boolean[] primes) {

		char[] minePort = new char[primes.length];

		int count = 0;

		for (int i = 0; i < primes.length; i++) {

			if (primes[i]) {

				// mine
				if (count % 2 == 0) {
					minePort[i] = 'M';
				}
				// port
				else {
					minePort[i] = 'P';
				}

				count++;

			}

		}

		return minePort;
	}

	public static boolean[] SOE(int n) {

		boolean[] primes = new boolean[n + 1];

		Arrays.fill(primes, true);

		primes[0] = false;
		primes[1] = false;

		for (int table = 2; table * table <= n; table++) {

			if (primes[table] == false) {
				continue;
			}

			for (int mult = 2; table * mult <= n; mult++) {
				primes[table * mult] = false;
			}

		}

		return primes;
	}

}
