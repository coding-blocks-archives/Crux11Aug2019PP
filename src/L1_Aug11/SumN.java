package L1_Aug11 ;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 11-Aug-2019
 *
 */

public class SumN {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();

		int sum = 0;
		int c = 1;

		while (c <= n) {

			sum = sum + c;
			c = c + 1;
		}

		System.out.println(sum);

	}

}
