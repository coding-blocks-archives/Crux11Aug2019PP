package L4_Aug24;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 24-Aug-2019
 *
 */

public class FunctionDemo {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		System.out.println("hello ");

		// fxn call
		// addition();
		// subtraction();

		// int n1 = scn.nextInt() ;
		// int n2 = scn.nextInt() ;
		// additionParams(n1, n2, 10, 800);

		System.out.println(additionReturn(30));

		if (additionReturn(50) > 500) {
			System.out.println("Good");
		}

		additionParams(2, 3, 4, 5);

		// Part-3
		System.out.println("----------- Part-3 -----------");
		int one = 10, two = 20;
		int sum = DemoScopes(one, two);
		System.out.println(sum);

		System.out.println("bye");

		System.out.println("----------- Part-5 -----------");
		System.out.println(one + ", " + two);
		Swap(one, two);
		System.out.println(one + ", " + two);

	}

	public static void Swap(int one, int two) {
		System.out.println(one + ", " + two);

		int temp = one;
		one = two;
		two = temp;

		System.out.println(one + ", " + two);
	}

	public static int DemoScopes(int one, int another) {

		int sum = one + another;
		return sum;
	}

	public static int additionReturn(int x) {

		int res = x * x;

		return 1000;
	}

	public static void additionParams(int a, int b, int c, int d) {

		int sum = a + b;
		System.out.println(sum);
	}

	// fxn definition
	public static void addition() {

		int a = 10;
		int b = 20;

		int sum = a + b;

		subtraction();

		System.out.println(sum);

	}

	public static void subtraction() {

		int a = 100;
		int b = 60;

		int sub = a - b;
		System.out.println(sub);

	}

}
