package Assignments.Aug28;

import java.util.Scanner;

public class InvertedHourGlass {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int nst = 1;
		int nsp = 2 * n - 1;

		int rows = 1;

		while (rows <= 2 * n + 1) {

			int val = n;

			int cst = 1;
			while (cst <= nst) {
				System.out.print(val);
				cst++;
				val--;
			}

			int csp = 1;
			while (csp <= nsp) {

				System.out.print(" ");
				csp++;
			}

			cst = 1;
			if (rows == n + 1) {
				cst = 2;
				val++;
			}
			val++;
			while (cst <= nst) {
				System.out.print(val);
				cst++;
				val++;
			}

			if (rows <= n) {
				nst++;
				nsp -= 2;

			} else {

				nst--;
				nsp += 2;

			}

			rows++;
			System.out.println();

		}

	}

}
