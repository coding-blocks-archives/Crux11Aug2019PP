package L2_Aug17;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 17-Aug-2019
 *
 */

public class Pattern17 {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		int nst = n / 2;
		int nsp = 1;

		int row = 1;

		while (row <= n) {

			// work
			// star
			int cst = 1;
			while (cst <= nst) {
				System.out.print("*");
				cst++;
			}

			// spaces
			int csp = 1;
			while (csp <= nsp) {
				System.out.print(" ");
				csp++;
			}

			// star
			cst = 1;
			while (cst <= nst) {
				System.out.print("*");
				cst++;
			}

			// prep
			if (row <= n / 2) {
				nst--;
				nsp += 2;
			} else {
				nst++;
				nsp -= 2;
			}

			row++;
			System.out.println();

		}

	}
}
