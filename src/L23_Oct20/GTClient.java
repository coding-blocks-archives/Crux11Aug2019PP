package L23_Oct20;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 20-Oct-2019
 *
 */

public class GTClient {

	// 10 3 20 2 50 0 60 0 30 1 70 0 40 0
	public static void main(String[] args) {

		GenericTree gt = new GenericTree();
		gt.display();

		System.out.println(gt.size());
		System.out.println(gt.max());
		System.out.println(gt.ht());
	}
}
