package L3_Aug18;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 18-Aug-2019
 *
 */

public class Rotate {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int rot = scn.nextInt();

		// number of digits
		int nod = 0;
		int temp = n;
		while (temp != 0) {
			nod++;
			temp = temp / 10;
		}

		// rotation logic

		rot = rot % nod;
		
		if (rot < 0) {
			rot = rot + nod;
		}

		for (int i = 1; i <= rot; i++) {

			int rem = n % 10;
			int quotient = n / 10;

			int newNum = rem * (int) Math.pow(10, nod - 1) + quotient;

			n = newNum;

		}

		System.out.println(n);
	}
}
