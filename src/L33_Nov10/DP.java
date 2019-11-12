package L33_Nov10;

import java.util.Arrays;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 10-Nov-2019
 *
 */

public class DP {

	public static void main(String[] args) {

		long start = System.currentTimeMillis();

		int n = 3;
		// System.out.println(fibonacciTD(n, new int[n + 1]));
		// System.out.println(fibonacciBU(n));
		// System.out.println(fibonacciBUSE(n));

		// System.out.println(boardPathTD(0, n, new int[n]));
		// System.out.println(boardPathBU(n));
		// System.out.println(boardPathBUSE(n));

		// System.out.println(mazePathTD(0, 0, n, n, new int[n + 1][n + 1]));
		// System.out.println(mazePathBU(n, n));
		// System.out.println(mazePathBUSE(n, n));
		// System.out.println(mazePathDiagBUSE(n, n));

		String s1 = "saturday";
		String s2 = "sunday";

		int[][] strg = new int[s1.length() + 1][s2.length() + 1];

		for (int[] val : strg) {
			Arrays.fill(val, -1);
		}

		// System.out.println(LCSTD(s1, s2, strg));
		// System.out.println(LCSBU(s1, s2));

		System.out.println(EditDistance(s1, s2));

		long end = System.currentTimeMillis();

		System.out.println("Time: " + (end - start));
	}

	// T : 2^n , S : Rec Extra Space
	public static int fibonacci(int n) {

		if (n == 0 || n == 1) {
			return n;
		}

		// 2 smaller problems
		int fnm1 = fibonacci(n - 1);
		int fnm2 = fibonacci(n - 2);

		// self work
		int fn = fnm1 + fnm2;

		return fn;

	}

	// T : n , S : Rec Extra Space + Array
	public static int fibonacciTD(int n, int[] strg) {

		if (n == 0 || n == 1) {
			return n;
		}

		if (strg[n] != 0) { // result re-use
			return strg[n];
		}

		int fnm1 = fibonacciTD(n - 1, strg);
		int fnm2 = fibonacciTD(n - 2, strg);

		int fn = fnm1 + fnm2;

		strg[n] = fn; // result store

		return fn;

	}

	// T : n , S : n
	public static int fibonacciBU(int n) {

		int[] strg = new int[n + 1];

		strg[0] = 0;
		strg[1] = 1;

		for (int i = 2; i <= n; i++) {
			strg[i] = strg[i - 1] + strg[i - 2];
		}

		return strg[n];

	}

	// T : n , S : constant
	public static int fibonacciBUSE(int n) {

		int[] strg = new int[2];
		strg[0] = 0;
		strg[1] = 1;

		for (int slide = 1; slide <= n - 1; slide++) {

			int sum = strg[0] + strg[1];
			strg[0] = strg[1];
			strg[1] = sum;

		}

		return strg[1];

	}

	// T : 6^n , S : Rec Extra Space
	public static int boardPath(int curr, int end) {

		if (curr == end) {
			return 1;
		}

		if (curr > end) {
			return 0;
		}

		int c = 0;

		for (int dice = 1; dice <= 6; dice++) {
			c += boardPath(curr + dice, end);
		}

		return c;
	}

	// T : n , S : Rec Extra Space + Array n Size
	public static int boardPathTD(int curr, int end, int[] strg) {

		if (curr == end) {
			return 1;
		}

		if (curr > end) {
			return 0;
		}

		if (strg[curr] != 0) { // re-use
			return strg[curr];
		}

		int c = 0;

		for (int dice = 1; dice <= 6; dice++) {
			c += boardPathTD(curr + dice, end, strg);
		}

		strg[curr] = c; // values store

		return c;
	}

	// T : n , S : n
	public static int boardPathBU(int n) {

		int[] strg = new int[n + 6];

		strg[n] = 1;

		for (int i = n - 1; i >= 0; i--) {
			strg[i] = strg[i + 1] + strg[i + 2] + strg[i + 3] + strg[i + 4] + strg[i + 5] + strg[i + 6];
		}

		return strg[0];
	}

	// T : n , S : constant
	public static int boardPathBUSE(int n) {

		int[] strg = new int[6];
		strg[0] = 1;

		for (int slide = 1; slide <= n; slide++) {

			int sum = strg[0] + strg[1] + strg[2] + strg[3] + strg[4] + strg[5];

			strg[5] = strg[4];
			strg[4] = strg[3];
			strg[3] = strg[2];
			strg[2] = strg[1];
			strg[1] = strg[0];

			strg[0] = sum;
		}

		return strg[0];

	}

	public static int mazePathTD(int cr, int cc, int er, int ec, int[][] strg) {

		if (cr == er && cc == ec) {
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}

		if (strg[cr][cc] != 0) {
			return strg[cr][cc];
		}

		int ch = mazePathTD(cr, cc + 1, er, ec, strg);
		int cv = mazePathTD(cr + 1, cc, er, ec, strg);

		strg[cr][cc] = ch + cv;

		return ch + cv;
	}

	public static int mazePathBU(int er, int ec) {

		int[][] strg = new int[er + 2][ec + 2];

		strg[er][ec] = 1;

		for (int r = er; r >= 0; r--) {

			for (int c = ec; c >= 0; c--) {

				if (r == er && c == ec) {
					continue;
				}

				strg[r][c] = strg[r][c + 1] + strg[r + 1][c];
			}
		}

		return strg[0][0];

	}

	public static int mazePathBUSE(int er, int ec) {

		int[] strg = new int[ec + 1];

		Arrays.fill(strg, 1);

		for (int slide = er - 1; slide >= 0; slide--) {

			for (int col = ec; col >= 0; col--) {

				if (col == ec) {
					strg[col] = 1;
				} else {
					strg[col] = strg[col] + strg[col + 1];
				}
			}
		}

		return strg[0];

	}

	public static int mazePathDiagBUSE(int er, int ec) {

		int diag = 0;
		int[] strg = new int[ec + 1];

		Arrays.fill(strg, 1);

		for (int slide = er - 1; slide >= 0; slide--) {

			for (int col = ec; col >= 0; col--) {

				if (col == ec) {
					strg[col] = 1;
					diag = 1;
				} else {
					int temp = strg[col] + strg[col + 1] + diag;
					diag = strg[col];
					strg[col] = temp;
				}
			}
		}

		return strg[0];

	}

	public static int LCS(String s1, String s2) {

		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}

		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		int ans = 0;

		if (ch1 == ch2) {
			ans = LCS(ros1, ros2) + 1;
		} else {

			int o1 = LCS(s1, ros2);
			int o2 = LCS(ros1, s2);

			ans = Math.max(o1, o2);

		}

		return ans;
	}

	public static int LCSTD(String s1, String s2, int[][] strg) {

		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}

		if (strg[s1.length()][s2.length()] != -1) {
			return strg[s1.length()][s2.length()];
		}

		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		int ans = 0;

		if (ch1 == ch2) {
			ans = LCSTD(ros1, ros2, strg) + 1;
		} else {

			int o1 = LCSTD(s1, ros2, strg);
			int o2 = LCSTD(ros1, s2, strg);

			ans = Math.max(o1, o2);

		}

		strg[s1.length()][s2.length()] = ans;

		return ans;
	}

	public static int LCSBU(String s1, String s2) {

		int[][] strg = new int[s1.length() + 1][s2.length() + 1];

		for (int row = s1.length() - 1; row >= 0; row--) {

			for (int col = s2.length() - 1; col >= 0; col--) {

				if (s1.charAt(row) == s2.charAt(col)) {
					strg[row][col] = strg[row + 1][col + 1] + 1;
				} else {

					int o1 = strg[row][col + 1];
					int o2 = strg[row + 1][col];

					strg[row][col] = Math.max(o1, o2);
				}
			}
		}

		return strg[0][0];

	}

	public static int EditDistance(String s1, String s2) {

		if (s1.length() == 0 || s2.length() == 0) {
			return Math.max(s1.length(), s2.length());
		}

		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		int ans = 0;

		if (ch1 == ch2) {
			ans = EditDistance(ros1, ros2);
		} else {

			int i = EditDistance(ros1, s2);
			int d = EditDistance(s1, ros2);
			int r = EditDistance(ros1, ros2);

			ans = Math.min(r, Math.min(i, d)) + 1;
		}

		return ans;

	}

}
