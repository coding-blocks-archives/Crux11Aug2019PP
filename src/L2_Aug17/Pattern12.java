package L2_Aug17;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 17-Aug-2019
 *
 */

public class Pattern12 {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();

		int nsp = n - 1;
		int nst = 1;

		// rows
		int row = 1;

		while (row <= n) {

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

				if (cst % 2 == 0)
					System.out.print(" ");
				else
					System.out.print("*");
				
				cst++;
			}

			// prep
			row++;
			nsp--;
			nst += 2;
			System.out.println();

		}

	}
}
