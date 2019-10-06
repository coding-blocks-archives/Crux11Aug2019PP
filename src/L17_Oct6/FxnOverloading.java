package L17_Oct6;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 06-Oct-2019
 *
 */

public class FxnOverloading {

	public static void main(String[] args) {

		sum(4, 5, 6, 7);

	}

	public static int sum(int a, int b, int... args) {

		System.out.println("var args");

		int res = 0;

		for (int val : args) {
			res += val;
		}

		return res;

	}

	public static int sum(int a, int b) {
		return a + b;
	}

	public static void sum(double a, int b) {
		System.out.println(a + b);
	}

	public static void sum(int a, int b, int c) {
		System.out.println(a + b + c);
	}

}
