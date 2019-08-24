package L2_Aug17;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 24-Aug-2019
 *
 */

public class PascalTriangle {

	public static void main(String[] args) {

		int n = 5;

		for (int row = 0; row < n; row++) {

			int val = 1;

			for (int col = 0; col <= row; col++) {
				System.out.print(val);

				val = (val * (row - col)) / (col + 1);
			}

			System.out.println();
		}
	}
}








