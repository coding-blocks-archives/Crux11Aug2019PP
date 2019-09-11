package Assignments.Sep10;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 11-Sep-2019
 *
 */

public class LongestSubarraySum2 {

	public static void main(String[] args) {

		int[] arr = { -1, 4, -2, -5, 6, -8 };
		longestSubarraySum(arr);

	}

	public static void longestSubarraySum(int[] arr) {

		int maxLength = 0;

		for (int si = 0; si <= arr.length - 1; si++) {

			int sum = 0;

			for (int ei = si; ei <= arr.length - 1; ei++) {

				sum += arr[ei];

				if (sum >= 0) {

					// maxLength = Math.max(maxLength, ei - si + 1);

					if (ei - si + 1 > maxLength) {
						maxLength = ei - si + 1;
					}
				}
			}
		}

		System.out.println(maxLength);
	}
}
