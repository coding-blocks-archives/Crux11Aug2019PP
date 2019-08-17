package L2_Aug17;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 17-Aug-2019
 *
 */

public class Pattern21 {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		int nst = 1;
		int nsp = 2 * n - 3;

		int row = 1;

		while (row <= n) {

			// star
			int cst = 1;
			while (cst <= nst) {
				System.out.print("*");
				cst++;
			}

			// space
			int csp = 1;
			while (csp <= nsp) {
				System.out.print(" ");
				csp++;
			}

			// star
			cst = 1;
			
			if(row == n)
				cst = 2 ;
			
			while (cst <= nst) {
				System.out.print("*");
				cst++;
			}

			// prep
			nst++;
			nsp -= 2;
			System.out.println();
			row++;

		}

	}
}
