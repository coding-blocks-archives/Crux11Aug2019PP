import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 11-Aug-2019
 *
 */

public class EvenOdd {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		// int rem = n % 2;

		if (n % 2 == 0) {
			System.out.println("Even");
		} else {
			System.out.println("Odd");
		}

	}

}





