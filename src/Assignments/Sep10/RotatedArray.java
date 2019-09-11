package Assignments.Sep10;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 10-Sep-2019
 *
 */

public class RotatedArray {

	public static void main(String[] args) {

		int[] arr = { 5, 8, 9, 10, 2, 3, 4 };
		System.out.println(findMin(arr));

	}

	public static int findMin(int[] arr) {

		int lo = 0;
		int hi = arr.length - 1;

		while (lo <= hi) {

			if (arr[lo] <= arr[hi]) {
				return arr[lo];
			}

			int mid = (lo + hi) / 2;

			if (arr[lo] <= arr[mid]) {

				lo = mid + 1;
			} else {
				hi = mid;
			}
		}

		return -1;

	}

}
