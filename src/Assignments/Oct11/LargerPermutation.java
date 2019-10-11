package Assignments.Oct11;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 11-Oct-2019
 *
 */

public class LargerPermutation {

	public static void main(String[] args) {

		printPermutation("bcad", "", false);
	}

	public static void printPermutation(String ques, String ans, boolean isLarger) {

		if (ques.length() == 0) {
			if (isLarger)
				System.out.println(ans);
			return;
		}

		for (int i = 0; i < ques.length(); i++) {

			char ch = ques.charAt(i);
			String roq = ques.substring(0, i) + ques.substring(i + 1);

			if (isLarger) {
				printPermutation(roq, ans + ch, true);
			} else {

				if (ch < ques.charAt(0)) {
					// no call
				} else if (ch > ques.charAt(0)) {
					printPermutation(roq, ans + ch, true);
				} else {
					printPermutation(roq, ans + ch, false);
				}

			}
		}

	}

}
