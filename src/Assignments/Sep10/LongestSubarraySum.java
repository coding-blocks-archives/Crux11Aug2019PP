package Assignments.Sep10;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 10-Sep-2019
 *
 */

public class LongestSubarraySum {

	public static void main(String[] args) {

		int[] arr = { -1, 4, -2, -5, 6, -8 };
		System.out.println(longestArray(arr));
	}

	public static int longestArray(int[] arr) {

		int[] nums = new int[arr.length];

		// create an array of prefix sum
		nums[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			nums[i] = nums[i - 1] + arr[i];
		}

		int max = 0;
		for (int i = 0; i < arr.length; i++) {

			for (int j = i + 1; j < arr.length; j++) {

				if (i == 0) {

					if (nums[j] >= 0) {
						max = Math.max(max, j + 1);
					}

				} else if (nums[j] - nums[i - 1] >= 0) {
					max = Math.max(max, j - i);
				}

			}
		}

		return max;

	}

}
