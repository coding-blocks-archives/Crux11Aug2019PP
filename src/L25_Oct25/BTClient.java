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

		String str = "10 true 20 true 40 false false false false";
		BinaryTree bt = new BinaryTree(str);
		bt.display();

		System.out.println(bt.diameter3());
		System.out.println(bt.isBalanced2());
		System.out.println(bt.isBalanced3());

	}
}
