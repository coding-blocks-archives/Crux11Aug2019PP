package Assignments.Oct17;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 17-Oct-2019
 *
 */

public class GenerateSortedArrays {

	public static void main(String[] args) {

		int[] A = { 10, 15, 25 };
		int[] B = { 1, 5, 20, 30 };

		generateArrays(A, B, 0, 0, "", 'A', Integer.MIN_VALUE);
	}

	public static void generateArrays(int[] A, int[] B, int avidx, int bvidx, String ans, char turn, int lastIncluded) {

		if (turn == 'A' && ans.length() != 0)
			System.out.println(ans);

		if (turn == 'A') {

			for (int i = avidx; i < A.length; i++) {

				if (A[i] > lastIncluded) {
					generateArrays(A, B, i + 1, bvidx, ans + A[i] + " ", 'B', A[i]);
				}

			}

		} else {

			for (int j = bvidx; j < B.length; j++) {

				if (B[j] > lastIncluded) {

					generateArrays(A, B, avidx, j + 1, ans + B[j] + " ", 'A', B[j]);

				}

			}

		}

	}
}
