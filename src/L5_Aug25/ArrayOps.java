package L5_Aug25;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 25-Aug-2019
 *
 */

public class ArrayOps {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int[] arr = takeInput();
		// int[] arr = { 2, 3, 4, 5, 6 };
		// display(arr);

		System.out.println(max(arr));

	}

	public static int[] takeInput() {

		System.out.println("Size ?");
		int n = scn.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		return arr;

	}

	public static void display(int[] arr) {

		for (int val : arr) {
			System.out.print(val + " ");
		}

		System.out.println();

	}

	public static int max(int[] arr) {

		int m = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > m) {
				m = arr[i];
			}
		}

		return m;
	}

//	public static int linearSearch(int[] arr, int item) {
//
//	}
}
