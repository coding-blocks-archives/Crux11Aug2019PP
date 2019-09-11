package Assignments.Sep10;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 10-Sep-2019
 *
 */

public class BookAllocation {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int tc = scn.nextInt();

		while (tc > 0) {

			int nob = scn.nextInt();
			int nos = scn.nextInt();

			int[] arr = new int[nob];

			for (int i = 0; i < arr.length; i++) {
				arr[i] = scn.nextInt();
			}

			int lo = 0;
			int hi = 0;

			for (int val : arr) {
				hi += val;
			}

			int finalAns = 0;

			while (lo <= hi) {

				int mid = (lo + hi) / 2;

				if (isItPossible(nob, nos, arr, mid)) {
					finalAns = mid;
					hi = mid - 1;
				} else {
					lo = mid + 1;
				}

			}

			System.out.println(finalAns);
			tc--;
		}

	}

	private static boolean isItPossible(int nob, int nos, int[] arr, int mid) {

		int students = 1;
		int pagesRead = 0;

		int i = 0; // i denotes which book you are going to read

		while (i < arr.length) {

			if (pagesRead + arr[i] <= mid) {
				pagesRead = pagesRead + arr[i];
				i++;
			} else { // you were not able to read the book
				students++;
				pagesRead = 0;

				if (students > nos) {
					return false;
				}
			}

		}

		return true;

	}
}
