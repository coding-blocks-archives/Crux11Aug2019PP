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

		// int n = 1000;
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

		// System.out.println(EditDistance(s1, s2));

		// int[] wt = { 1, 3, 4, 5 };
		// int[] price = { 1, 4, 5, 7 };

		int cap = 7;

		// System.out.println(Knapsack(wt, price, cap, 0));
		// System.out.println(KnapsackTD(wt, price, cap, 0, new int[wt.length][cap +
		// 1]));
		// System.out.println(KnapsackBU(wt, price, cap));

		String src = "abcdenjvhdiuhv";
		String pat = "?b*?**cbvjdhvui";

		// System.out.println(WildcardMatching(src, pat));
		// System.out.println(WildcardMatchingTD(src, pat, new int[src.length() +
		// 1][pat.length() + 1]));
		// System.out.println(WilcardMatchingBU(src, pat));

		int[] prices = { 0, 3, 5, 8, 9, 10, 17, 17, 20, 78, 45, 23, 1, 9, 10 };

		// System.out.println(rodCut(prices, prices.length - 1));
		// System.out.println(rodCutTD(prices, prices.length - 1, new
		// int[prices.length]));
		// System.out.println(rodCutBU(prices));

		// System.out.println(noOfBSTTD(10000, new int[10000 + 1]));
		// setBits(10);

		System.out.println(boundaryPaths(0, 1, 0, 2, 3));
		System.out.println(boundaryPathsBU(0, 1, 0, 2, 3));

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

	// Q : https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/

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

	// Q : https://www.geeksforgeeks.org/edit-distance-dp-5/

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

	public static int EditDistanceTD(String s1, String s2, int[][] strg) {

		if (s1.length() == 0 || s2.length() == 0) {
			return Math.max(s1.length(), s2.length());
		}

		if (strg[s1.length()][s2.length()] != -1) {
			return strg[s1.length()][s2.length()];
		}

		int ch1 = s1.charAt(0);
		int ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		int ans;
		if (ch1 == ch2) {
			ans = EditDistanceTD(ros1, ros2, strg);
		} else {

			int i = EditDistanceTD(ros1, s2, strg);
			int d = EditDistanceTD(s1, ros2, strg);
			int r = EditDistanceTD(ros1, ros2, strg);

			ans = Math.min(i, Math.min(d, r)) + 1;
		}

		strg[s1.length()][s2.length()] = ans;

		return ans;

	}

	public static int EditDistanceBU(String s1, String s2) {

		int[][] strg = new int[s1.length() + 1][s2.length() + 1];

		for (int row = s1.length(); row >= 0; row--) {

			for (int col = s2.length(); col >= 0; col--) {

				if (row == s1.length()) {
					strg[row][col] = s2.length() - col;
					continue;
				}

				if (col == s2.length()) {
					strg[row][col] = s1.length() - row;
					continue;
				}

				if (s1.charAt(row) == s2.charAt(col)) {
					strg[row][col] = strg[row + 1][col + 1];
				} else {

					int i = strg[row + 1][col];
					int d = strg[row][col + 1];
					int r = strg[row + 1][col + 1];

					strg[row][col] = Math.min(i, Math.min(d, r)) + 1;
				}
			}
		}

		return strg[0][0];

	}

	// Q : https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/

	public static int MCM(int[] arr, int si, int ei) {

		if (si + 1 == ei) {
			return 0;
		}

		int min = Integer.MAX_VALUE;

		for (int k = si + 1; k <= ei - 1; k++) {

			int fp = MCM(arr, si, k); // arr[si]*arr[k]
			int sp = MCM(arr, k, ei); // arr[k]*arr[ei]

			int sw = arr[si] * arr[k] * arr[ei];

			int total = fp + sp + sw;

			if (total < min) {
				min = total;
			}

		}

		return min;

	}

	public static int MCMTD(int[] arr, int si, int ei, int[][] strg) {

		if (si + 1 == ei) {
			return 0;
		}

		if (strg[si][ei] != 0) {
			return strg[si][ei];
		}

		int min = Integer.MAX_VALUE;

		for (int k = si + 1; k <= ei - 1; k++) {

			int fp = MCMTD(arr, si, k, strg); // arr[si]*arr[k]
			int sp = MCMTD(arr, k, ei, strg); // arr[k]*arr[ei]

			int sw = arr[si] * arr[k] * arr[ei];

			int total = fp + sp + sw;

			if (total < min) {
				min = total;
			}

		}

		strg[si][ei] = min;

		return min;

	}

	public static int MCMBU(int[] arr) {

		int n = arr.length;

		int[][] strg = new int[n][n];

		for (int slide = 2; slide <= n - 1; slide++) {

			for (int si = 0; si <= n - slide - 1; si++) {

				int ei = si + slide;

				// copy paste
				int min = Integer.MAX_VALUE;

				for (int k = si + 1; k <= ei - 1; k++) {

					int fp = strg[si][k]; // arr[si]*arr[k]
					int sp = strg[k][ei]; // arr[k]*arr[ei]

					int sw = arr[si] * arr[k] * arr[ei];

					int total = fp + sp + sw;

					if (total < min) {
						min = total;
					}

				}

				strg[si][ei] = min;

			}

		}

		return strg[0][n - 1];

	}

	// Q : https://www.hackerearth.com/practice/notes/dynamic-programming-i-1/
	// Q : https://www.geeksforgeeks.org/maximum-profit-sale-wines/

	public static int WineProblem(int[] price, int si, int ei, int yr) {

		if (si == ei) {
			return price[si] * yr;
		}

		int start = WineProblem(price, si + 1, ei, yr + 1) + price[si] * yr;
		int end = WineProblem(price, si, ei - 1, yr + 1) + price[ei] * yr;

		int ans = Math.max(start, end);

		return ans;

	}

	public static int WineProblemTD(int[] price, int si, int ei, int[][] strg) {

		int yr = price.length - ei + si;

		if (si == ei) {
			return price[si] * yr;
		}

		if (strg[si][ei] != 0) {
			return strg[si][ei];
		}

		int start = WineProblemTD(price, si + 1, ei, strg) + price[si] * yr;
		int end = WineProblemTD(price, si, ei - 1, strg) + price[ei] * yr;

		int ans = Math.max(start, end);

		strg[si][ei] = ans;

		return ans;

	}

	public static int WineProblemBU(int[] price) {

		int n = price.length;

		int[][] strg = new int[price.length][price.length];

		for (int slide = 0; slide <= n - 1; slide++) {

			for (int si = 0; si <= n - slide - 1; si++) {

				int ei = si + slide;

				int yr = price.length - ei + si;

				if (si == ei) {
					strg[si][ei] = price[si] * yr;
					continue;
				}

				// copy
				int start = strg[si + 1][ei] + price[si] * yr;
				int end = strg[si][ei - 1] + price[ei] * yr;

				int ans = Math.max(start, end);

				strg[si][ei] = ans;

			}

		}

		return strg[0][n - 1];

	}

	// Q : 0-1 Knapsack : https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
	// Q : Fractional Knapsack :
	// https://www.geeksforgeeks.org/fractional-knapsack-problem/

	public static int Knapsack(int[] wt, int[] price, int cap, int vidx) {

		if (vidx == wt.length) {
			return 0;
		}

		int include = 0;
		if (cap >= wt[vidx]) {
			include = Knapsack(wt, price, cap - wt[vidx], vidx + 1) + price[vidx];
		}

		int exclude = Knapsack(wt, price, cap, vidx + 1);

		return Math.max(include, exclude);
	}

	public static int KnapsackNBC(int[] wt, int[] price, int cap, int vidx) {

		if (cap < 0) {
			return Integer.MIN_VALUE;
		}

		if (vidx == wt.length) {
			return 0;
		}

		int include = KnapsackNBC(wt, price, cap - wt[vidx], vidx + 1) + price[vidx];
		int exclude = KnapsackNBC(wt, price, cap, vidx + 1);

		return Math.max(include, exclude);
	}

	public static int KnapsackTD(int[] wt, int[] price, int cap, int vidx, int[][] strg) {

		if (vidx == wt.length) {
			return 0;
		}

		if (strg[vidx][cap] != 0) {
			return strg[vidx][cap];
		}

		int include = 0;
		if (cap >= wt[vidx]) {
			include = KnapsackTD(wt, price, cap - wt[vidx], vidx + 1, strg) + price[vidx];
		}

		int exclude = KnapsackTD(wt, price, cap, vidx + 1, strg);

		strg[vidx][cap] = Math.max(include, exclude);

		return Math.max(include, exclude);
	}

	public static int KnapsackBU(int[] wt, int[] price, int cap) {

		int[][] strg = new int[wt.length + 1][cap + 1];

		for (int row = wt.length - 1; row >= 0; row--) {

			for (int col = cap; col >= 1; col--) {

				int include = 0;
				if (col >= wt[row]) {
					include = strg[row + 1][col - wt[row]] + price[row];
				}

				int exclude = strg[row + 1][col];

				strg[row][col] = Math.max(include, exclude);
			}

		}

		return strg[0][cap];

	}

	// Q : https://www.geeksforgeeks.org/wildcard-pattern-matching/

	public static boolean WildcardMatching(String src, String pat) {

		if (src.length() == 0 && pat.length() == 0) {
			return true;
		}

		if (src.length() != 0 && pat.length() == 0) {
			return false;
		}

		if (src.length() == 0 && pat.length() != 0) {

			for (int i = 0; i < pat.length(); i++) {
				if (pat.charAt(i) != '*') {
					return false;
				}
			}

			return true;
		}

		char chs = src.charAt(0);
		char chp = pat.charAt(0);

		String ros = src.substring(1);
		String rop = pat.substring(1);

		boolean ans;

		if (chs == chp || chp == '?') {
			ans = WildcardMatching(ros, rop);
		} else if (chp == '*') {
			ans = WildcardMatching(src, rop) || WildcardMatching(ros, pat);
		} else {
			ans = false;
		}

		return ans;

	}

	public static boolean WildcardMatchingTD(String src, String pat, int[][] strg) {

		if (src.length() == 0 && pat.length() == 0) {
			return true;
		}

		if (src.length() != 0 && pat.length() == 0) {
			return false;
		}

		if (src.length() == 0 && pat.length() != 0) {

			for (int i = 0; i < pat.length(); i++) {
				if (pat.charAt(i) != '*') {
					return false;
				}
			}

			return true;
		}

		if (strg[src.length()][pat.length()] != 0) {
			return strg[src.length()][pat.length()] == 2 ? true : false;
		}

		char chs = src.charAt(0);
		char chp = pat.charAt(0);

		String ros = src.substring(1);
		String rop = pat.substring(1);

		boolean ans;

		if (chs == chp || chp == '?') {
			ans = WildcardMatchingTD(ros, rop, strg);
		} else if (chp == '*') {
			ans = WildcardMatchingTD(src, rop, strg) || WildcardMatchingTD(ros, pat, strg);
		} else {
			ans = false;
		}

		strg[src.length()][pat.length()] = (ans == true ? 2 : 1);

		return ans;

	}

	public static boolean WilcardMatchingBU(String src, String pat) {

		boolean[][] strg = new boolean[src.length() + 1][pat.length() + 1];

		strg[src.length()][pat.length()] = true;

		for (int row = src.length(); row >= 0; row--) {

			for (int col = pat.length() - 1; col >= 0; col--) {

				if (row == src.length()) {

					if (pat.charAt(col) == '*') {
						strg[row][col] = strg[row][col + 1];
					} else {
						strg[row][col] = false;
					}

					continue;
				}

				// copy
				char chs = src.charAt(row);
				char chp = pat.charAt(col);

				boolean ans;

				if (chs == chp || chp == '?') {
					ans = strg[row + 1][col + 1];
				} else if (chp == '*') {
					ans = strg[row][col + 1] || strg[row + 1][col];
				} else {
					ans = false;
				}

				strg[row][col] = ans;

			}
		}

		return strg[0][0];

	}

	// Q : https://www.geeksforgeeks.org/cutting-a-rod-dp-13/

	public static int rodCut(int[] price, int n) {

		int max = price[n];

		int left = 1;
		int right = n - 1;

		while (left <= right) {

			int fp = rodCut(price, left);
			int sp = rodCut(price, right);

			int total = fp + sp;

			if (total > max) {
				max = total;
			}

			left++;
			right--;
		}

		return max;
	}

	public static int rodCutTD(int[] price, int n, int[] strg) {

		if (strg[n] != 0) {
			return strg[n];
		}

		int max = price[n];

		int left = 1;
		int right = n - 1;

		while (left <= right) {

			int fp = rodCutTD(price, left, strg);
			int sp = rodCutTD(price, right, strg);

			int total = fp + sp;

			if (total > max) {
				max = total;
			}

			left++;
			right--;
		}

		strg[n] = max;

		return max;
	}

	public static int rodCutBU(int[] price) {

		int[] strg = new int[price.length];

		strg[0] = price[0];
		strg[1] = price[1];

		for (int n = 2; n < strg.length; n++) {

			int max = price[n];

			int left = 1;
			int right = n - 1;

			while (left <= right) {

				int fp = strg[left];
				int sp = strg[right];

				int total = fp + sp;

				if (total > max) {
					max = total;
				}

				left++;
				right--;
			}

			strg[n] = max;

		}

		return strg[strg.length - 1];

	}

	// Q : https://leetcode.com/problems/unique-binary-search-trees/

	public static int noOfBSTTD(int n, int[] strg) {

		if (n <= 1) {
			return 1;
		}

		if (strg[n] != 0) {
			return strg[n];
		}

		int sum = 0;

		for (int i = 1; i <= n; i++) {

			int lbst = noOfBSTTD(i - 1, strg);
			int rbst = noOfBSTTD(n - i, strg);

			int total = lbst * rbst;

			sum += total;

		}

		strg[n] = sum;

		return sum;

	}

	// Q : https://leetcode.com/problems/counting-bits/

	public static void setBits(int n) {

		int[] strg = new int[n + 1];

		strg[0] = 0;
		strg[1] = 1;

		for (int i = 2; i <= n; i++) {

			if (i % 2 == 0) {
				strg[i] = strg[i / 2];
			} else {
				strg[i] = strg[i / 2] + 1;
			}
		}

		for (int val : strg) {
			System.out.println(val);
		}

	}

	// Q : https://leetcode.com/problems/out-of-boundary-paths/

	public static int boundaryPaths(int cr, int cc, int er, int ec, int moves) {

		if (cr < 0 || cr > er || cc < 0 || cc > ec) {
			return 1;
		}

		if (moves == 0) {
			return 0;
		}

		int t = boundaryPaths(cr - 1, cc, er, ec, moves - 1);
		int d = boundaryPaths(cr + 1, cc, er, ec, moves - 1);
		int l = boundaryPaths(cr, cc - 1, er, ec, moves - 1);
		int r = boundaryPaths(cr, cc + 1, er, ec, moves - 1);

		return t + d + l + r;
	}

	public static int boundaryPathsTD(int cr, int cc, int er, int ec, int moves, int[][][] strg) {

		if (cr < 0 || cr > er || cc < 0 || cc > ec) {
			return 1;
		}

		if (moves == 0) {
			return 0;
		}

		if (strg[moves][cr][cc] != -1) {
			return strg[moves][cr][cc];
		}

		int t = boundaryPathsTD(cr - 1, cc, er, ec, moves - 1, strg);
		int d = boundaryPathsTD(cr + 1, cc, er, ec, moves - 1, strg);
		int l = boundaryPathsTD(cr, cc - 1, er, ec, moves - 1, strg);
		int r = boundaryPathsTD(cr, cc + 1, er, ec, moves - 1, strg);

		strg[moves][cr][cc] = t + d + l + r;

		return t + d + l + r;
	}

	public static int boundaryPathsBU(int cr, int cc, int er, int ec, int moves) {

		int[][][] strg = new int[moves + 1][er + 1][ec + 1];

		for (int m = 1; m <= moves; m++) {

			for (int r = 0; r <= er; r++) {

				for (int c = 0; c <= ec; c++) {

					// copy
					int top = r - 1 < 0 ? 1 : strg[m - 1][r - 1][c];
					int down = r + 1 > er ? 1 : strg[m - 1][r + 1][c];
					int left = c - 1 < 0 ? 1 : strg[m - 1][r][c - 1];
					int right = c + 1 > ec ? 1 : strg[m - 1][r][c + 1];

					strg[m][r][c] = (top + down + left + right) % 1_000_000_007;

				}
			}
		}

		return strg[moves][cr][cc];

	}

}
