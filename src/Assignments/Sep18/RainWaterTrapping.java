package Assignments.Sep18;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 18-Sep-2019
 *
 */

public class RainWaterTrapping {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int tc = scn.nextInt();

		while (tc > 0) {

			int[] arr = new int[scn.nextInt()];

			for (int i = 0; i < arr.length; i++) {
				arr[i] = scn.nextInt();
			}

			int[] left = new int[arr.length];

			left[0] = arr[0];
			for (int i = 1; i < left.length; i++) {
				left[i] = Math.max(left[i - 1], arr[i]);
			}

			int[] right = new int[arr.length];

			right[right.length - 1] = arr[arr.length - 1];
			for (int i = right.length - 2; i >= 0; i--) {
				right[i] = Math.max(right[i + 1], arr[i]);
			}

			int sum = 0;
			for (int i = 0; i < arr.length; i++) {

				int contribution = Math.min(left[i], right[i]) - arr[i];
				sum += contribution;
			}

			System.out.println(sum);

			tc--;
		}

	}
}
