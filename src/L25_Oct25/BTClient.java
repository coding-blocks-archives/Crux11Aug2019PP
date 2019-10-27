package L25_Oct25;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 25-Oct-2019
 *
 */

public class BTClient {

	// 10 true 20 true 40 false false true 50 false false true 30 true 60 false
	// false false
	public static void main(String[] args) {

		// String str = "10 true 20 true 40 false false false false";
		// String str = "1 true 2 true 4 false false true 5 true 7 false false true 8
		// false false true 3 true 6 false false false";
		//
		// String s3 = "1 true 2 true 4 false false true -5 false false true -3 true -4
		// false false true 5 true 6 false false true 7 false false";

		int[] pre = { 10, 20, 40, 50, 30, 60, 70, 80 };
		int[] in = { 40, 20, 50, 10, 60, 30, 70, 80 };
		BinaryTree bt = new BinaryTree(pre, in);
		bt.display();

		// System.out.println(bt.diameter3());
		// System.out.println(bt.isBalanced2());
		// System.out.println(bt.isBalanced3());
		//
		// String s2 = "1 true 3 false true 6 false false true 2 true 40 false false
		// true 5 true 8 false false true 7 false false";
		//
		// BinaryTree bt1 = new BinaryTree(s3);
		// bt1.display();
		// System.out.println(bt.flipEquivalent(bt1));
		//
		// bt.preorder();
		// bt.preorderI();
		//
		// System.out.println(bt.maxSubtreeSum1());
		// System.out.println(bt.maxSubtreeSum3());

	}
}
