package Assignments.Sep10;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 10-Sep-2019
 *
 */

public class SubarraySum {

	public static void main(String[] args) {

		int[] arr = { 10, 20, 40, 50 };
		subarraySum3Loops(arr);
	}

	public static void maxSubarraySum2Loops(int[] arr) {

		int max = Integer.MIN_VALUE;

		for (int si = 0; si <= arr.length - 1; si++) {

			int sum = 0;

			for (int ei = si; ei <= arr.length - 1; ei++) {

				sum += arr[ei];

				if (sum > max) {
					max = sum;
				}
			}
		}

		System.out.println(max);
	}

	public static void subarraySum2Loops(int[] arr) {

		for (int si = 0; si <= arr.length - 1; si++) {

			int sum = 0;

			for (int ei = si; ei <= arr.length - 1; ei++) {

				sum += arr[ei];
				System.out.println(si + " " + ei + " : " + sum);

			}
		}
	}

	public static void subarraySum3Loops(int[] arr) {

		for (int si = 0; si <= arr.length - 1; si++) {

			for (int ei = si; ei <= arr.length - 1; ei++) {

				int sum = 0;

				for (int k = si; k <= ei; k++) {
					sum += arr[k];
				}

				System.out.println(si + " " + ei + " : " + sum);

			}
		}
	}

}
