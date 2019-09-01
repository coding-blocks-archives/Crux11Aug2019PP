package Assignments.Aug28;

import java.util.Scanner;

public class FiboPattern {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		pattern(scn.nextInt());
		
	}

	public static void pattern(int n) {

		int nst = 1;
		int rows = 1;

		int a = 0;
		int b = 1;

		while (rows <= n) {

			int cst = 1;
			while (cst <= nst) {
				System.out.print(a + " ");
				int sum = a + b;
				a = b;
				b = sum;
				cst++;
			}

			System.out.println();
			rows++;
			nst++;

		}

	}

}
