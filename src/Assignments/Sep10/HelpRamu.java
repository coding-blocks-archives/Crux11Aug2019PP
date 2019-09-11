package Assignments.Sep10;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 10-Sep-2019
 *
 */

public class HelpRamu {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int tc = scn.nextInt();

		while (tc > 0) {

			int c1 = scn.nextInt();
			int c2 = scn.nextInt();
			int c3 = scn.nextInt();
			int c4 = scn.nextInt();

			int nor = scn.nextInt();
			int noc = scn.nextInt();

			int[] rickshaw = new int[nor];
			int[] cabs = new int[noc];

			for (int i = 0; i < rickshaw.length; i++) {
				rickshaw[i] = scn.nextInt();
			}

			for (int i = 0; i < cabs.length; i++) {
				cabs[i] = scn.nextInt();
			}

			int ans = minCost(c1, c2, c3, c4, rickshaw, cabs);

			System.out.println(ans);
			
			tc--;
		}

	}

	private static int minCost(int c1, int c2, int c3, int c4, int[] rickshaw, int[] cabs) {

		int minR = minCostTransport(c1, c2, c3, rickshaw);
		int minC = minCostTransport(c1, c2, c3, cabs);

		int total = minR + minC;

		return Math.min(total, c4);

	}

	private static int minCostTransport(int c1, int c2, int c3, int[] freq) {

		int sum = 0;

		for (int i = 0; i < freq.length; i++) {
			sum += Math.min(freq[i] * c1, c2);
		}

		return Math.min(sum, c3);

	}
}
