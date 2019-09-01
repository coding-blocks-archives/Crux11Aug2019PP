package Assignments.Aug28;

import java.util.Scanner;

public class ChewBacca {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		long n = scn.nextLong();
		long ans = 0;
		long mult = 1;

		while (n != 0) {

			long rem = n % 10;

			if (n / 10 == 0 && rem == 9) {

			} else if (rem >= 5 && rem <= 9) {

				rem = 9 - rem;
			}
			ans = ans + rem * mult;
			mult = mult * 10;
			n = n / 10;
		}

		System.out.println(ans);

	}

}
