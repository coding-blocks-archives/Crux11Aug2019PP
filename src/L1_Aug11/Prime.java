package L1_Aug11;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 11-Aug-2019
 *
 */

public class Prime {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();

		int fact = 0;

		int div = 1;

		while (div <= n) {

			if (n % div == 0) {
				fact++;
			}

			div = div + 1;
		}

		if (fact == 2) {
			System.out.println("Prime");
		} else {
			System.out.println("Not Prime");
		}

	}

}
