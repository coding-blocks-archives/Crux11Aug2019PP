package L8_Sep7;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 07-Sep-2019
 *
 */

public class StringOps {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		// String str = scn.next();
		// printChars(str);
		// substrings(str);
		System.out.println(countPalindromicSS("nitin"));
	}

	public static void printChars(String str) {

		for (int i = 0; i < str.length(); i++) {
			System.out.println(str.charAt(i));
		}
	}

	public static boolean palindrome(String str) {

		int i = 0;
		int j = str.length() - 1;

		while (i <= j) {

			if (str.charAt(i) != str.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}

		return true;
	}

	public static void substrings(String str) {

		for (int si = 0; si <= str.length() - 1; si++) {

			for (int ei = si + 1; ei <= str.length(); ei++) {

				String ss = str.substring(si, ei);

				System.out.println(ss);
			}
		}

	}

	public static int countPalindromicSS(String str) {

		int count = 0;

		for (int si = 0; si <= str.length() - 1; si++) {

			for (int ei = si + 1; ei <= str.length(); ei++) {

				String ss = str.substring(si, ei);

				if (palindrome(ss))
					count++;
			}
		}

		return count;

	}

}
