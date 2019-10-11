package Assignments.Oct11;

import java.util.ArrayList;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 11-Oct-2019
 *
 */

public class CodesOfString {

	static ArrayList<String> res = new ArrayList<>();

	public static void main(String[] args) {

		CodesString("1128", "");
		System.out.println(CodesStringGet("1128"));

		// System.out.println(res);
	}

	public static void CodesString(String ques, String ans) {

		if (ques.length() == 0) {
			// System.out.println(ans);
			res.add(ans);
			return;
		}

		String oneChar = ques.substring(0, 1); // "1"
		int oneCharNum = Integer.parseInt(oneChar); // 1
		char oneCharCode = (char) (oneCharNum + 96); // a

		String roq1 = ques.substring(1);

		CodesString(roq1, ans + oneCharCode);

		// second call

		if (ques.length() > 1) {

			String twoChar = ques.substring(0, 2); // "11"
			int twoCharNum = Integer.parseInt(twoChar); // 11

			char twoCharCode = (char) (twoCharNum + 96); // k
			String roq2 = ques.substring(2);

			if (twoCharNum <= 26) {
				CodesString(roq2, ans + twoCharCode);
			}
		}

	}

	public static ArrayList<String> CodesStringGet(String ques) {

		if (ques.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();

		String oneChar = ques.substring(0, 1); // "1"
		int oneCharNum = Integer.parseInt(oneChar); // 1
		char oneCharCode = (char) (oneCharNum + 96); // a

		String roq1 = ques.substring(1);

		ArrayList<String> rr1 = CodesStringGet(roq1);

		for (String val : rr1) {
			mr.add(oneCharCode + val);
		}

		// second call
		if (ques.length() > 1) {

			String twoChar = ques.substring(0, 2); // "11"
			int twoCharNum = Integer.parseInt(twoChar); // 11

			char twoCharCode = (char) (twoCharNum + 96); // k
			String roq2 = ques.substring(2);

			if (twoCharNum <= 26) {
				ArrayList<String> rr2 = CodesStringGet(roq2);

				for (String val : rr2) {
					mr.add(twoCharCode + val);
				}
			}
		}

		return mr;

	}

}
