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

		// int[] arr = takeInput();
		int[] arr = { 11, 44, 5, 9, 8 };
		// display(arr);

		// System.out.println(max(arr));
		// int res = linearSearch(arr, 40) ;
		// System.out.println(res);

		// System.out.println(linearSearch(arr, 4));

		// reverse(arr);
		// rotate2(arr, 4);

		// int[] res = inverse(arr);
		// display(res);

		// subarray(arr);

		// subset(arr);
		// bubbleSort(arr);
		// selectionSort(arr);
		insertionSort(arr);
		// display(arr);

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

	public static int linearSearch(int[] arr, int item) {

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == item) {
				return i;
			}
		}

		return -1;
	}

	public static int binarySearch(int[] arr, int item) {

		int lo = 0;
		int hi = arr.length - 1;

		while (lo <= hi) {

			int mid = (lo + hi) / 2;

			if (item > arr[mid]) { // upper half
				lo = mid + 1;
			} else if (item < arr[mid]) {
				hi = mid - 1;
			} else {
				return mid;
			}

		}

		return -1;

	}

	public static void reverse(int[] arr) {

		int lo = 0;
		int hi = arr.length - 1;

		while (lo <= hi) {
			int temp = arr[lo];
			arr[lo] = arr[hi];
			arr[hi] = temp;

			lo++;
			hi--;

		}

	}

	public static void reverse(int[] arr, int start, int end) {

		int lo = start;
		int hi = end;

		while (lo <= hi) {
			int temp = arr[lo];
			arr[lo] = arr[hi];
			arr[hi] = temp;

			lo++;
			hi--;

		}

	}

	public static void rotate(int[] arr, int rot) {

		for (int r = 1; r <= rot; r++) {

			// store the last value
			int temp = arr[arr.length - 1];

			// shifting
			for (int i = arr.length - 1; i >= 1; i--) {
				arr[i] = arr[i - 1];
			}

			arr[0] = temp;
		}
	}

	public static void rotate2(int[] arr, int rot) {

		int idx = arr.length - rot;

		reverse(arr, 0, idx - 1);
		reverse(arr, idx, arr.length - 1);
		reverse(arr);

	}

	public static int[] inverse(int[] arr) {

		int[] na = new int[arr.length];

		for (int i = 0; i < na.length; i++) {
			na[arr[i]] = i;
		}

		return na;
	}

	public static void subarray(int[] arr) {

		for (int si = 0; si <= arr.length - 1; si++) {

			for (int ei = si; ei <= arr.length - 1; ei++) {

				System.out.print(si + " " + ei + " : ");

				for (int k = si; k <= ei; k++) {
					System.out.print(arr[k] + " ");
				}

				System.out.println();
			}
		}
	}

	public static void subset(int[] arr) {

		int limit = (int) Math.pow(2, arr.length);

		for (int i = 0; i <= limit - 1; i++) {

			int temp = i;

			// binary
			for (int digit = 0; digit < arr.length; digit++) {

				int rem = temp % 2;

				if (rem == 1) {
					System.out.print(arr[digit] + " ");
				}

				temp = temp / 2;
			}

			System.out.println();
		}

	}

	public static void bubbleSort(int[] arr) {

		for (int count = 0; count <= arr.length - 2; count++) {

			for (int j = 0; j <= arr.length - count - 2; j++) {

				if (arr[j] > arr[j + 1]) {

					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}

			}

			display(arr);
		}
	}

	public static void selectionSort(int[] arr) {

		for (int count = 0; count <= arr.length - 2; count++) {

			int min = count;

			for (int j = count + 1; j <= arr.length - 1; j++) {

				if (arr[j] < arr[min]) {
					min = j;
				}
			}

			// smallest value index
			int temp = arr[min];
			arr[min] = arr[count];
			arr[count] = temp;

			display(arr);
		}

	}

	public static void insertionSort(int[] arr) {

		for (int count = 1; count <= arr.length - 1; count++) {

			// capture
			int temp = arr[count];

			// shifting
			int j = count - 1;

			while (j >= 0 && arr[j] > temp) {
				arr[j + 1] = arr[j];
				j--;
			}

			arr[j + 1] = temp;

			display(arr);
		}
	}

}
