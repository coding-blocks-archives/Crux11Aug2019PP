package L1_Aug11 ;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 11-Aug-2019
 *
 */

public class Fibonacci {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		int first = 0;
		int second = 1;

		int c = 1;

		while (c <= n + 1) {
			
			System.out.println(first);
			
			int sum = first + second;
			first = second;
			second = sum;

			c++;
		}

	}
}








