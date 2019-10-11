package Assignments.Oct11;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 11-Oct-2019
 *
 */

public class IPAddress {

	// Q : https://leetcode.com/problems/restore-ip-addresses/

	public static void main(String[] args) {
		// ip("25525511135", "", 0);
	}

	public List<String> restoreIpAddresses(String s) {

		List<String> res = new ArrayList<String>();
		ip(s, "", 0, res);
		return res;

	}

	public void ip(String ques, String ans, int dot, List<String> list) {

		if (ques.length() == 0 && dot == 4) {

			if (dot == 4)
				list.add(ans.substring(0, ans.length() - 1));

			return;
		}

		for (int i = 1; i <= 3 && i <= ques.length(); i++) {

			String val = ques.substring(0, i);
			String roq = ques.substring(i);

			if (isValid(val)) {
				ip(roq, ans + val + ".", dot + 1, list);
			}

		}

	}

	public boolean isValid(String str) {

		if (str.length() > 1 && str.charAt(0) == '0') {
			return false;
		}

		if (Integer.parseInt(str) >= 256) {
			return false;
		}

		return true;
	}
}
