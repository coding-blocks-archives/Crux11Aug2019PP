package L23_Oct20;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 20-Oct-2019
 *
 */

public class GTClient {

	// 10 3 20 2 50 0 60 0 30 2 70 2 110 2 150 0 160 0 120 0 80 0 40 2 90 2 130 2
	// 170 0 180 0 140 0 100 0
	public static void main(String[] args) {

		String str = "10 3 20 2 50 0 60 0 30 2 70 2 110 2 150 0 160 0 120 0 80 0 40 2 90 2 130 2 170 0 180 0 140 0 100 0";
		GenericTree gt = new GenericTree(str);
		gt.display();

		System.out.println(gt.size());
		System.out.println(gt.max());
		System.out.println(gt.ht());
		System.out.println(gt.find(70));

		// gt.mirror();
		// gt.display();
		//
		// gt.linearize();
		// gt.display();

		// gt.levelOrder();

		gt.levelOrderLW();
		System.out.println();
		gt.levelOrderZZ();
	}
}
