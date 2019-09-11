package Assignments.Sep10;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 10-Sep-2019
 *
 */

public class MaximumCircularSum {

	public static void main(String[] args) {

		int[] arr = { 4, -1, 3, 4, -9, -5, -6 };
		System.out.println(kadane(arr));

	}

	public static int cirCularSum(int[] arr) {

		int maxSum = kadane(arr);

		int total_sum = 0;
		for (int i = 0; i < arr.length; i++) {

			total_sum += arr[i];
			arr[i] = -arr[i];

		}

		total_sum = total_sum + kadane(arr);

		return Math.max(total_sum, maxSum);

	}

	public static int kadane(int[] arr) {

		int currSum = 0;
		int maxSum = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {

			currSum += arr[i];
			maxSum = Math.max(maxSum, currSum);

			if (currSum < 0) {
				currSum = 0;
			}
		}

		return maxSum;
	}

}
