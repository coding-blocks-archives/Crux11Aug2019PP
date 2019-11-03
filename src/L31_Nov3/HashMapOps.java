package L31_Nov3;

import java.util.HashMap;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 03-Nov-2019
 *
 */

public class HashMapOps {

	public static void main(String[] args) {

		// System.out.println(maxFreqChar("abcaaadbcbbbbbbbbbb"));

		int[] one = { 5, 20, 10, 10, 20, 20 };
		int[] two = { 5, 40, 10, 10, 10 };

		// intersection(one, two);

		int[] arr = { 2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6, 7 };

		longestSequence(arr);

	}

	public static char maxFreqChar(String s) {

		HashMap<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {

			char ch = s.charAt(i);

			// if (map.containsKey(ch)) {
			// int of = map.get(ch);
			// int nf = of + 1;
			// map.put(ch, nf);
			// } else {
			// map.put(ch, 1);
			// }

			int of = map.getOrDefault(ch, 0);
			map.put(ch, of + 1);
		}

		int max = 0;
		char maxFreqChar = ' ';

		for (char key : map.keySet()) {

			int freq = map.get(key);

			if (freq > max) {
				max = freq;
				maxFreqChar = key;
			}
		}

		return maxFreqChar;
	}

	public static void intersection(int[] one, int[] two) {

		// make a freq map using first array
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int val : one) {
			int of = map.getOrDefault(val, 0);
			map.put(val, of + 1);
		}

		for (int val : two) {

			if (map.containsKey(val) && map.get(val) > 0) {

				System.out.println(val);
				map.put(val, map.get(val) - 1);

			}

		}

	}

	public static void longestSequence(int[] arr) {

		HashMap<Integer, Boolean> map = new HashMap<>();

		for (int val : arr) {

			if (map.containsKey(val - 1)) {
				map.put(val, false);
			} else {
				map.put(val, true);
			}

			if (map.containsKey(val + 1)) {
				map.put(val + 1, false);
			}

		}

		int maxLength = 0;
		int starting = 0;

		for (int key : map.keySet()) {

			if (map.get(key)) {

				int count = 0;
				while (map.containsKey(key + count)) {
					count++;
				}

				if (count > maxLength) {
					maxLength = count;
					starting = key;
				}

			}

		}

		for (int i = 0; i < maxLength; i++) {
			System.out.println(starting + i);
		}

	}

}
