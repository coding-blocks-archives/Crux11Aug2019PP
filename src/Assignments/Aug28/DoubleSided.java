package Assignments.Aug28;

import java.util.Scanner;

public class DoubleSided {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int nst = 1;
		int nsp1 = n - 1;
		int nsp2 = -1;

		int rows = 1;

		while (rows <= n) {

			int val;
			if (rows <= n / 2 + 1) {
				val = rows;
			} else {
				val = n - rows + 1;
			}

			int csp1 = 1;
			while (csp1 <= nsp1) {

				System.out.print("  ");
				csp1++;
			}

			int cst = 1;
			while (cst <= nst) {
				System.out.print(val + " ");
				val--;
				cst++;
			}

			int csp2 = 1;
			while (csp2 <= nsp2) {

				System.out.print("  ");
				csp2++;
			}

			cst = 1;

			if (rows == 1 || rows == n) {
				cst = 2;
			}

			val++;
			while (cst <= nst) {
				System.out.print(val + " ");
				val++;
				cst++;
			}

			if (rows <= n / 2) {

				nst++;
				nsp1 -= 2;
				nsp2 += 2;
			} else {

				nst--;
				nsp1 += 2;
				nsp2 -= 2;
			}

			rows++;
			System.out.println();

		}

	}

}
