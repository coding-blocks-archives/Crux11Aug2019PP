package L9_Sep8;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 08-Sep-2019
 *
 */

public class Recursion {

	public static void main(String[] args) {

		// PD(3);
		// System.out.println(factorial(4));

		int[] arr = { 100, 20, 60, 20, 20, 5 };

		// displayArray(arr, 0);

		// System.out.println(max(arr, 0));
		System.out.println(firstIndex(arr, 0, 20));
		System.out.println(lastIndex(arr, 0, 20));
		int[] res = allIndex(arr, 0, 20, 0);

		for (int val : res)
			System.out.println(val);
	}

	public static void PD(int n) {

		if (n == 0) {
			return;
		}

		System.out.println("hi " + n);

		PD(--n);

		System.out.println("bye " + n);

	}

	public static void PI(int n) {

		// base case
		if (n == 0) {
			return;
		}

		// smaller problem
		PI(n - 1);

		// how to make the result of sp to bp : self work
		System.out.println(n);

	}

	public static int factorial(int n) {

		if (n == 1) {
			return 1;
		}

		int fnm1 = factorial(n - 1); // smaller problem

		int fn = fnm1 * n; // self work

		return fn;

	}

	public static int power(int x, int n) {

		if (n == 0) {
			return 1;
		}

		int pnm1 = power(x, n - 1);

		int pn = pnm1 * x;

		return pn;
	}

	public static int fibonacci(int n) {

		if (n == 0 || n == 1) {
			return n;
		}

		// 2 smaller problems
		int fnm1 = fibonacci(n - 1);
		int fnm2 = fibonacci(n - 2);

		// self work
		int fn = fnm1 + fnm2;

		return fn;

	}

	public static void displayArray(int[] arr, int vidx) {

		// base case
		if (vidx == arr.length) {
			return;
		}

		// self work
		System.out.println(arr[vidx]);

		// smaller problem
		displayArray(arr, vidx + 1);
	}

	public static int max(int[] arr, int vidx) {

		// base case
		if (vidx == arr.length - 1) {
			return arr[vidx];
		}

		// smaller problem
		int sp = max(arr, vidx + 1);

		// self work
		return Math.max(sp, arr[vidx]);

	}

	public static int firstIndex(int[] arr, int vidx, int item) {

		if (vidx == arr.length) {
			return -1;
		}

		if (arr[vidx] == item) {
			return vidx;
		} else {
			return firstIndex(arr, vidx + 1, item);
		}

	}

	public static int lastIndex(int[] arr, int vidx, int item) {

		if (vidx == arr.length) {
			return -1;
		}

		int rr = lastIndex(arr, vidx + 1, item);

		if (arr[vidx] == item && rr == -1) {
			return vidx;
		}

		return rr;

	}

	public static int[] allIndex(int[] arr, int vidx, int item, int count) {

		if (vidx == arr.length) {
			int[] br = new int[count];
			return br;
		}

		int[] rr;

		if (arr[vidx] == item) {
			rr = allIndex(arr, vidx + 1, item, count + 1);
			rr[count] = vidx;
		} else {
			rr = allIndex(arr, vidx + 1, item, count);
		}

		return rr;

	}
}
