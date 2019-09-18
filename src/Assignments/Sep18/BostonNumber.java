package Assignments.Sep18;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 18-Sep-2019
 *
 */

public class BostonNumber {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();

		int numberDigitSum = sumDigits(n);
		
		int factorSum = 0 ;

		for (int div = 2; div * div <= n; div++) {

			if (isPrime(div)) {

				while (n % div == 0) {
					
					factorSum += sumDigits(div) ;					
					n = n / div;
				}

			}

		}
		
		if(n > 1) {
			factorSum += sumDigits(n) ;
		}
		
		if(numberDigitSum == factorSum) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}

	}

	public static int sumDigits(int n) {

		int sum = 0;

		while (n != 0) {
			int rem = n % 10;
			sum += rem;
			n = n / 10;
		}

		return sum;
	}

	public static boolean isPrime(int n) {

		for (int div = 2; div * div <= n; div++) {

			if (n % div == 0) {
				return false;
			}

		}

		return true;

	}

}
