package L32_Nov9;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 09-Nov-2019
 *
 */

public class SegmentTreeGeneric {

	private class Node {
		int data;
		int si;
		int ei;
		Node left;
		Node right;
	}

	private Node root;
	private STI sti;

	public SegmentTreeGeneric(int[] arr, STI sti) {
		this.sti = sti;
		root = construct(arr, 0, arr.length - 1);
	}

	private Node construct(int[] arr, int lo, int hi) {

		Node nn = new Node();
		nn.si = lo;
		nn.ei = hi;

		if (lo == hi) {
			nn.data = arr[lo];
			return nn;
		}

		int mid = (lo + hi) / 2;
		nn.left = construct(arr, lo, mid);
		nn.right = construct(arr, mid + 1, hi);

		nn.data = sti.operation(nn.left.data, nn.right.data);

		return nn;
	}

	public void display() {
		System.out.println("------------------------");
		display(root);
		System.out.println("------------------------");
	}

	private void display(Node node) {

		if (node == null) {
			return;
		}

		String str = "";

		if (node.left == null) {
			str += ".";
		} else {
			str += node.left.data;
		}

		str += " -> " + node.data + " <- ";

		if (node.right == null) {
			str += ".";
		} else {
			str += node.right.data;
		}

		System.out.println(str);

		display(node.left);
		display(node.right);
	}

	public int query(int qsi, int qei) {
		return query(root, qsi, qei);
	}

	private int query(Node node, int qsi, int qei) {

		// full contribution
		if (node.si >= qsi && node.ei <= qei) {
			return node.data;
		}

		// no contribution
		else if (node.ei < qsi || node.si > qei) {
			return sti.defaultValue();
		}

		// partial contribution
		else {
			int l = query(node.left, qsi, qei);
			int r = query(node.right, qsi, qei);

			return sti.operation(l, r);

		}

	}

	public void update(int idx, int item) {
		update(root, idx, item);
	}

	private void update(Node node, int idx, int item) {

		// you have reached the desired node
		if (idx == node.si && idx == node.ei) {
			node.data = item;
		}

		// idx lies in the range
		else if (idx >= node.si && idx <= node.ei) {
			update(node.left, idx, item);
			update(node.right, idx, item);

			node.data = sti.operation(node.left.data, node.right.data);
		}

		// idx doesn't lie in the range
		else if (idx < node.si || idx > node.ei) {
			return;
		}

	}

}
