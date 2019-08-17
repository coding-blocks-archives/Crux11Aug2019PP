package L2_Aug17;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 17-Aug-2019
 *
 */

public class Pattern32Way2 {

	public static void main(String[] args) {

		int n = 5;

		int nst = 1;

		int row = 1;
		while (row <= 2 * n - 1) {

			int val;

			if (row <= n) {
				val = row;
			} else {
				val = 2 * n - row;
			}

			int cst = 1;
			while (cst <= nst) {

				if (cst % 2 == 0)
					System.out.print("*");
				else
					System.out.print(val);
				cst++;
			}

			// prep
			if (row <= n - 1) {
				nst += 2;
			} else {
				nst -= 2;
			}

			row++;
			System.out.println();

		}

	}
}
