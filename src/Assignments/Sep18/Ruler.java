package Assignments.Sep18;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 18-Sep-2019
 *
 */

public class Ruler {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in) ;
		
		int totalLength = scn.nextInt() ;
		int tickLength = scn.nextInt() ;
		
		loop(totalLength, tickLength);

	}

	public static void loop(int totalLength, int tickLength) {

		printMajorTicks(tickLength, 0);

		for (int i = 1; i <= totalLength; i++) {
			
			repeat(tickLength - 1);

			printMajorTicks(tickLength, i);

		}
	}

	public static void repeat(int num) {

		if (num == 0) {
			return;
		}

		repeat(num - 1);

		printMinorTicks(num);

		repeat(num - 1);

	}

	public static void printMinorTicks(int num) {

		for (int i = 1; i <= num; i++) {
			System.out.print("-");
		}
		System.out.println();

	}

	public static void printMajorTicks(int num, int val) {

		for (int i = 1; i <= num; i++) {
			System.out.print("-");
		}

		System.out.println(" " + val);

	}
}
