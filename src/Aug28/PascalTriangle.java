package Aug28;

import java.util.Scanner;

public class PascalTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();

		int nst = 1;
		int rows = 1;

		while (rows <= n) {

			int cst = 1;
			while (cst <= nst) {
				System.out.print(ncr(rows - 1, cst - 1)+"\t");
				cst++;
			}

			System.out.println();
			rows++;
			nst++;
		}

	}

	public static int ncr(int n, int r) {

		int ans = 1;
		for (int i = 0; i < r; i++) {

			ans *= (n - i);
			ans /= (i + 1);
		}

		return ans;
	}

}
