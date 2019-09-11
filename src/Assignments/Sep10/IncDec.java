package Assignments.Sep10;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 10-Sep-2019
 *
 */

public class IncDec {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int n = scn.nextInt();

		// int[] arr = new int[n] ;
		//
		// for(int i=0 ; i < arr.length ; i++) {
		// arr[i] = scn.nextInt() ;
		// }
		//
		// System.out.println(IncDec(arr));

		System.out.println(IncDecWithoutArray(n));

	}

	public static boolean IncDec(int[] arr) {

		boolean gd = true;

		for (int i = 0; i < arr.length - 1; i++) {

			if (gd) {

				if (arr[i] > arr[i + 1]) {

				} else {
					gd = false;
				}

			} else {

				if (arr[i] < arr[i + 1]) {

				} else {
					return false;
				}

			}

		}

		return true;
	}

	public static boolean IncDecWithoutArray(int n) {

		int prev = scn.nextInt();

		boolean gd = true;

		for (int i = 1; i <= n - 1; i++) {

			int curr = scn.nextInt();

			if (gd) {

				if (prev > curr) {

				} else {
					gd = false;
				}

			} else {

				if (prev < curr) {

				} else {
					return false;
				}

			}

			prev = curr;

		}

		return true;
	}
}
