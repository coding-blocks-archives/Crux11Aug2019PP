package L2_Aug17;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 17-Aug-2019
 *
 */

public class Pattern27 {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();

		int nsp = n - 1;
		int nst = 1;

		int val = 1;

		// rows
		int row = 1;

		while (row <= n) {

			val = row;

			// work
			// spaces
			int csp = 1;
			while (csp <= nsp) {
				System.out.print("\t");
				csp++;
			}

			// stars
			int cst = 1;
			while (cst <= nst) {
				System.out.print(val + "\t");

				if (cst <= nst / 2)
					val++;
				else
					val--;
				
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
