package Assignments.Oct11;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 11-Oct-2019
 *
 */

public class Subset {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3 };

		System.out.println("\n" + subsetTarget(arr, 0, 0, "", 3));
	}

	public static int subsetTarget(int[] arr, int vidx, int sum, String ans, int target) {

		if (vidx == arr.length) {

			if (sum == target) {
				System.out.print(ans + "  ");
				return 1;
			}

			return 0;
		}

		int rr1 = subsetTarget(arr, vidx + 1, sum + arr[vidx], ans + arr[vidx] + " ", target);
		int rr2 = subsetTarget(arr, vidx + 1, sum, ans, target);

		return rr1 + rr2;
	}
}
