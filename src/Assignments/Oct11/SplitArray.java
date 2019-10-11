package Assignments.Oct11;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 11-Oct-2019
 *
 */

public class SplitArray {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 3, 4, 5 };
		System.out.println(split(arr, 0, 0, "", 0, ""));
	}

	public static int split(int[] arr, int vidx, int g1sum, String g1ans, int g2sum, String g2ans) {

		if (vidx == arr.length) {

			if (g1sum == g2sum) {
				System.out.println(g1ans + " and " + g2ans);
				return 1;
			}

			return 0;

		}

		int rr1 = split(arr, vidx + 1, g1sum + arr[vidx], g1ans + arr[vidx] + " ", g2sum, g2ans);
		int rr2 = split(arr, vidx + 1, g1sum, g1ans, g2sum + arr[vidx], g2ans + arr[vidx] + " ");

		return rr1 + rr2;
	}
}
