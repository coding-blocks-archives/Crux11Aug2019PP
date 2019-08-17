package L2_Aug17;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 17-Aug-2019
 *
 */

public class Pattern32 {

	public static void main(String[] args) {

		int n = 5;

		int nst = 1;
		int start = 1;

		int row = 1;
		while (row <= 2 * n - 1) {

			int cst = 1;
			while (cst <= nst) {

				if (cst % 2 == 0)
					System.out.print("*");
				else
					System.out.print(start);
				cst++;
			}

			// prep
			if (row <= n - 1) {
				nst += 2;
				start++;
			} else {
				nst -= 2;
				start--;
			}

			row++;
			System.out.println();

		}

	}
}
