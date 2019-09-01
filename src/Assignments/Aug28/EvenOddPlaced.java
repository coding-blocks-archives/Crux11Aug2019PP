package Assignments.Aug28;

import java.util.Scanner;

public class EvenOddPlaced {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		int sum_even = 0;
		int sum_odd = 0;

		int place = 1;

		while (n != 0) {

			int rem = n % 10;

			if (place % 2 == 0) {
				sum_even = sum_even + rem;
			} else {
				sum_odd = sum_odd + rem;
			}

			n = n / 10;
			place++;

		}

		System.out.println(sum_odd);
		System.out.println(sum_even);

	}

}
