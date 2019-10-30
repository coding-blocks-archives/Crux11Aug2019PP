package L27_Oct30;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 30-Oct-2019
 *
 */

public class BSTClient {

	public static void main(String[] args) {

		int[] in = {};

		BST bst = new BST(in);
		bst.display();

		// System.out.println(bst.find(40));
		// System.out.println(bst.max());

		// bst.printInRange(15, 75) ;
		// bst.replaceWithSumLarger();
		// bst.display();

		bst.addReturn(10);
		bst.addReturn(20);
		bst.addReturn(5);
		bst.addReturn(7);
		bst.addReturn(13);

		bst.display();

		bst.removeReturn(10);
		bst.display();

	}
}
