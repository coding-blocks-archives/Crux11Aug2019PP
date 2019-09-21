
package L10_Sep14;

import java.util.ArrayList;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 14-Sep-2019
 *
 */

public class RecursionGet {

	public static void main(String[] args) {

		// System.out.println(getSSAscii("ab").size());
		// System.out.println(getKPC("14567").size());

		// System.out.println(getPermutation("abc"));

		// System.out.println(getCases("a1B2"));

		// System.out.println(getBoardPath(0, 10));

		// System.out.println(getMazePathDMM(0, 0, 2, 2).size());

		System.out.println(parenthesis("2*3-4*5"));

	}

	public static ArrayList<String> getSS(String str) {

		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		// smaller problem
		ArrayList<String> rr = getSS(ros);

		// self work
		ArrayList<String> mr = new ArrayList<>();

		for (String val : rr) {
			mr.add(val); // no
			mr.add(ch + val); // yes
		}

		return mr;

	}

	public static ArrayList<String> getSSAscii(String str) {

		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		// smaller problem
		ArrayList<String> rr = getSSAscii(ros);

		// self work
		ArrayList<String> mr = new ArrayList<>();

		for (String val : rr) {
			mr.add(val); // no
			mr.add(ch + val); // yes
			mr.add((int) ch + val); // yes
		}

		return mr;

	}

	public static ArrayList<String> getKPC(String str) { // 145

		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char ch = str.charAt(0); // 1
		String ros = str.substring(1); // 45

		// smaller problem
		ArrayList<String> rr = getKPC(ros);

		// self work
		ArrayList<String> mr = new ArrayList<>();

		String code = getCode(ch); // abc

		for (String val : rr) {

			for (int i = 0; i < code.length(); i++) { // a , b, c
				mr.add(code.charAt(i) + val);
			}

		}

		return mr;
	}

	public static String getCode(char ch) {
		if (ch == '1')
			return "abc";
		else if (ch == '2')
			return "def";
		else if (ch == '3')
			return "ghi";
		else if (ch == '4')
			return "jk";
		else if (ch == '5')
			return "lmno";
		else if (ch == '6')
			return "pqr";
		else if (ch == '7')
			return "stu";
		else if (ch == '8')
			return "vwx";
		else if (ch == '9')
			return "yz";
		else if (ch == '0')
			return "@#";
		else
			return "";
	}

	public static ArrayList<String> getPermutation(String str) {

		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> rr = getPermutation(ros);

		ArrayList<String> mr = new ArrayList<>();

		for (String val : rr) {

			for (int i = 0; i <= val.length(); i++) {

				String ans = val.substring(0, i) + ch + val.substring(i);
				mr.add(ans);
			}
		}

		return mr;

	}

	public static ArrayList<String> getCoinToss(int n) {

		if (n == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		ArrayList<String> rr = getCoinToss(n - 1);
		ArrayList<String> mr = new ArrayList<>();

		for (String val : rr) {
			mr.add("H" + val);
			mr.add("T" + val);
		}

		return mr;
	}

	public static ArrayList<String> getCases(String str) {

		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> rr = getCases(ros);

		ArrayList<String> mr = new ArrayList<>();

		if (Character.isDigit(ch)) {
			for (String val : rr) {
				mr.add(ch + val);
			}
		} else {
			for (String val : rr) {
				mr.add(Character.toLowerCase(ch) + val);
				mr.add(Character.toUpperCase(ch) + val);
			}
		}

		return mr;

	}

	public static ArrayList<String> getBoardPath(int curr, int end) {

		if (curr == end) {
			ArrayList<String> br = new ArrayList<>();
			br.add("\n");
			return br;
		}

		if (curr > end) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();

		for (int dice = 1; dice <= 6; dice++) {

			ArrayList<String> rr = getBoardPath(curr + dice, end);

			for (String val : rr) {
				mr.add(dice + val);
			}

		}

		return mr;

	}

	public static ArrayList<String> getMazePath(int cr, int cc, int er, int ec) {

		if (cr == er && cc == ec) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		if (cr > er || cc > ec) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();

		ArrayList<String> rrh = getMazePath(cr, cc + 1, er, ec);

		for (String val : rrh) {
			mr.add("H" + val);
		}

		ArrayList<String> rrv = getMazePath(cr + 1, cc, er, ec);

		for (String val : rrv) {
			mr.add("V" + val);
		}

		return mr;
	}

	public static ArrayList<String> getMazePathD(int cr, int cc, int er, int ec) {

		if (cr == er && cc == ec) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		if (cr > er || cc > ec) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();

		ArrayList<String> rrh = getMazePathD(cr, cc + 1, er, ec);

		for (String val : rrh) {
			mr.add("H" + val);
		}

		ArrayList<String> rrv = getMazePathD(cr + 1, cc, er, ec);

		for (String val : rrv) {
			mr.add("V" + val);
		}

		ArrayList<String> rrd = getMazePathD(cr + 1, cc + 1, er, ec);

		for (String val : rrd) {
			mr.add("D" + val);
		}

		return mr;

	}

	public static ArrayList<String> getMazePathDMM(int cr, int cc, int er, int ec) {

		if (cr == er && cc == ec) {
			ArrayList<String> br = new ArrayList<>();
			br.add("\n");
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();

		for (int move = 1; move <= ec - cc; move++) {
			ArrayList<String> rrh = getMazePathDMM(cr, cc + move, er, ec);

			for (String val : rrh) {
				mr.add("H" + move + val);
			}
		}

		for (int move = 1; move <= er - cr; move++) {

			ArrayList<String> rrv = getMazePathDMM(cr + move, cc, er, ec);

			for (String val : rrv) {
				mr.add("V" + move + val);
			}
		}

		for (int move = 1; move <= Math.min(ec - cc, er - cr); move++) {

			ArrayList<String> rrd = getMazePathDMM(cr + move, cc + move, er, ec);

			for (String val : rrd) {
				mr.add("D" + move + val);
			}
		}
		return mr;

	}

	public static ArrayList<Integer> parenthesis(String str) {

		ArrayList<Integer> mr = new ArrayList<>();

		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);

			if (ch == '+' || ch == '-' || ch == '*') {

				String p1 = str.substring(0, i);
				String p2 = str.substring(i + 1);

				// smaller problem
				ArrayList<Integer> rr1 = parenthesis(p1);
				ArrayList<Integer> rr2 = parenthesis(p2);

				// self work
				for (int val1 : rr1) {

					for (int val2 : rr2) {

						if (ch == '+') {
							mr.add(val1 + val2);
						} else if (ch == '-') {
							mr.add(val1 - val2);
						} else if (ch == '*') {
							mr.add(val1 * val2);
						}

					}
				}

			}
		}

		if (mr.size() == 0) {
			mr.add(Integer.parseInt(str));
		}

		return mr;

	}

}
