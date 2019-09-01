package L7_Sep1;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 01-Sep-2019
 *
 */

public class Array2DDemo {

	public static void main(String[] args) {

		int[][] arr = null;
		System.out.println(arr);

		arr = new int[3][4];
		System.out.println(arr);

		// rows
		System.out.println(arr.length);
		// cols
		System.out.println(arr[1].length);

		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);

		System.out.println(arr[1][2]);
		arr[1][2] = 100;
		System.out.println(arr[1][2]);

		// JAGGED ARRAY
		System.out.println(" -- JA --");
		int[][] jarr = new int[3][];
		System.out.println(jarr);

		System.out.println(jarr[0]);
		System.out.println(jarr[1]);
		System.out.println(jarr[2]);

		jarr[0] = new int[2];
		jarr[1] = new int[4];
		jarr[2] = new int[3];

		System.out.println(jarr[0]);
		System.out.println(jarr[1]);
		System.out.println(jarr[2]);

		// rows
		System.out.println(jarr.length);
		System.out.println(jarr[0].length);
		System.out.println(jarr[1].length);
		System.out.println(jarr[2].length);

	}
}
