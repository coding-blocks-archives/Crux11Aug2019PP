package L2_Aug17;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 17-Aug-2019
 *
 */

public class Pattern16 {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();

		int nsp = n - 1;
		int nst = n;

		int row = 1;

		while (row <= 2 * n - 1) {

			// work

			// spaces
			int csp = 1;
			while (csp <= nsp) {
				System.out.print(" ");
				csp++;
			}

			// stars
			int cst = 1;
			while (cst <= nst) {
				System.out.print("*");
				cst++;
			}

			// prep
			if (row <= n - 1) {
				nst--;
				nsp--;
			} else {
				nst++;
				nsp++;
			}

			row++ ;
			System.out.println();
		}

	}
}
