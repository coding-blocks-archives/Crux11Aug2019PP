package L25_Oct25;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 25-Oct-2019
 *
 */

public class BinaryTree {

	Scanner scn;

	private class Node {
		int data;
		Node left;
		Node right;
	}

	private static Node root;

	public BinaryTree(String str) {
		scn = new Scanner(str);
		root = takeInput(null, false);
	}

	private Node takeInput(Node parent, boolean ilc) {

		if (parent == null) {
			System.out.println("Enter the data for root node");
		} else {

			if (ilc) {
				System.out.println("Enter the data for left child of " + parent.data);
			} else {
				System.out.println("Enter the data for right child of " + parent.data);

			}
		}

		int item = scn.nextInt();

		Node nn = new Node();
		nn.data = item;

		System.out.println(nn.data + " has left child ?");
		boolean hlc = scn.nextBoolean();

		if (hlc) {
			nn.left = takeInput(nn, true);
		}

		System.out.println(nn.data + " has right child ?");
		boolean hrc = scn.nextBoolean();

		if (hrc) {
			nn.right = takeInput(nn, false);
		}

		return nn;

	}

	public BinaryTree(int[] pre, int[] in) {
		root = construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
	}

	private Node construct(int[] pre, int plo, int phi, int[] in, int ilo, int ihi) {

		if (plo > phi || ilo > ihi) {
			return null;
		}

		Node nn = new Node();
		nn.data = pre[plo];

		// search for pre[plo] in inorder

		int nel = 0;
		int si = -1;

		for (int i = ilo; i <= ihi; i++) {
			if (in[i] == pre[plo]) {
				si = i;
				break;
			}
			nel++;
		}

		nn.left = construct(pre, plo + 1, plo + nel, in, ilo, si - 1); // left
		nn.right = construct(pre, plo + nel + 1, phi, in, si + 1, ihi); // right

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

	public int size() {
		return size(root);
	}

	private int size(Node node) {

		if (node == null) {
			return 0;
		}

		int ls = size(node.left);
		int rs = size(node.right);

		return ls + rs + 1;
	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {

		if (node == null) {
			return Integer.MIN_VALUE;
		}

		int lm = max(node.left);
		int rm = max(node.right);

		return Math.max(node.data, Math.max(lm, rm));

	}

	public int min() {
		return min(root);
	}

	private int min(Node node) {

		if (node == null) {
			return Integer.MAX_VALUE;
		}

		int lm = min(node.left);
		int rm = min(node.right);

		return Math.min(node.data, Math.min(lm, rm));

	}

	public int ht() {
		return ht(root);
	}

	private int ht(Node node) {

		if (node == null) {
			return -1;
		}

		int lh = ht(node.left);
		int rh = ht(node.right);

		return Math.max(lh, rh) + 1;
	}

	public boolean find(int item) {
		return find(root, item);
	}

	private boolean find(Node node, int item) {

		if (node == null) {
			return false;
		}

		if (node.data == item) {
			return true;
		}

		boolean lf = find(node.left, item);
		boolean rf = find(node.right, item);

		return lf || rf;

	}

	// Q : https://leetcode.com/problems/diameter-of-binary-tree/

	public int diameter1() {
		diameter1(root);
		return maxDiameter;
	}

	private int maxDiameter = 0;

	private void diameter1(Node node) {

		if (node == null) {
			return;
		}

		int self = ht(node.left) + ht(node.right) + 2;

		if (self > maxDiameter) {
			maxDiameter = self;
		}

		diameter1(node.left);
		diameter1(node.right);

	}

	public int diameter2() {
		return diameter2(root);
	}

	private int diameter2(Node node) {

		if (node == null) {
			return 0;
		}

		int ld = diameter2(node.left);
		int rd = diameter2(node.right);

		int sd = ht(node.left) + ht(node.right) + 2;

		return Math.max(sd, Math.max(ld, rd));

	}

	private class DiaPair {
		int diameter = 0;
		int ht = -1;
	}

	public int diameter3() {
		return diameter3(root).diameter;
	}

	private DiaPair diameter3(Node node) {

		if (node == null) {
			return new DiaPair();
		}

		DiaPair ldp = diameter3(node.left);
		DiaPair rdp = diameter3(node.right);

		DiaPair sdp = new DiaPair();

		int sd = ldp.ht + rdp.ht + 2;
		sdp.diameter = Math.max(sd, Math.max(ldp.diameter, rdp.diameter));

		sdp.ht = Math.max(ldp.ht, rdp.ht) + 1;

		return sdp;

	}

	public boolean isBalanced2() {
		return isBalanced2(root);
	}

	private boolean isBalanced2(Node node) {

		if (node == null) {
			return true;
		}

		boolean ilb = isBalanced2(node.left);
		boolean irb = isBalanced2(node.right);

		int bf = ht(node.left) - ht(node.right);

		if (ilb && irb && (bf == -1 || bf == 0 || bf == 1)) {
			return true;
		} else {
			return false;
		}

	}

	private class BalPair {
		boolean isBal = true;
		int ht = -1;
	}

	public boolean isBalanced3() {
		return isBalanced3(root).isBal;
	}

	private BalPair isBalanced3(Node node) {

		if (node == null) {
			return new BalPair();
		}

		BalPair lbp = isBalanced3(node.left);
		BalPair rbp = isBalanced3(node.right);

		BalPair sbp = new BalPair();

		int bf = lbp.ht - rbp.ht;

		if (lbp.isBal && rbp.isBal && (bf == -1 || bf == 0 || bf == 1)) {
			sbp.isBal = true;
		} else {
			sbp.isBal = false;
		}

		sbp.ht = Math.max(lbp.ht, rbp.ht) + 1;

		return sbp;

	}

	// Q : https://leetcode.com/problems/flip-equivalent-binary-trees/

	public boolean flipEquivalent(BinaryTree other) {
		return flipEquivalent(root, other.root);
	}

	private boolean flipEquivalent(Node t, Node o) {

		if (t == null && o == null) {
			return true;
		}

		if (t == null || o == null) {
			return false;
		}

		if (t.data != o.data) {
			return false;
		}

		// when we dont need flips
		boolean ll = flipEquivalent(t.left, o.left);
		boolean rr = flipEquivalent(t.right, o.right);

		// when we need flip
		boolean lr = flipEquivalent(t.left, o.right);
		boolean rl = flipEquivalent(t.right, o.left);

		return (ll && rr) || (lr && rl);

	}

	// NLR : preorder
	// LNR : inorder
	// LRN : postorer
	// NRL : rev postorder
	// RNL : rev inorder
	// RLN : rev preorder
	public void preorder() {
		preorder(root);
		System.out.println();
	}

	private void preorder(Node node) {

		if (node == null) {
			return;
		}

		// N
		System.out.print(node.data + " ");

		// L
		preorder(node.left);

		// R
		preorder(node.right);
	}

	private class Pair {
		Node n;
		boolean sd;
		boolean ld;
		boolean rd;

	}

	public void preorderI() {

		Stack<Pair> stack = new Stack<>();

		Pair sp = new Pair();
		sp.n = root;

		stack.add(sp);

		while (!stack.isEmpty()) {

			Pair tp = stack.peek();

			if (tp.n == null) {
				stack.pop();
				continue;
			}

			if (tp.sd == false) {
				System.out.print(tp.n.data + " ");
				tp.sd = true;
			} else if (tp.ld == false) {

				Pair np = new Pair();
				np.n = tp.n.left;

				stack.push(np);

				tp.ld = true;

			} else if (tp.rd == false) {

				Pair np = new Pair();
				np.n = tp.n.right;

				stack.push(np);

				tp.rd = true;

			} else {
				stack.pop();
			}

		}

		System.out.println();

	}

	// Q : https://www.geeksforgeeks.org/find-largest-subtree-sum-tree/

	public int maxSubtreeSum1() {
		int[] arr = new int[1];
		arr[0] = Integer.MIN_VALUE;

		maxSubtreeSum1(root, arr);

		return arr[0];
	}

	private int maxSubtreeSum1(Node node, int[] arr) {

		if (node == null)
			return 0;

		int lsum = maxSubtreeSum1(node.left, arr);
		int rsum = maxSubtreeSum1(node.right, arr);

		int tsum = lsum + rsum + node.data;

		if (tsum > arr[0]) {
			arr[0] = tsum;
		}

		return tsum;

	}

	private class STPair {
		int entireSum = 0;
		int maxSTSum = Integer.MIN_VALUE;
	}

	public int maxSubtreeSum3() {
		return maxSubtreeSum3(root).maxSTSum;
	}

	private STPair maxSubtreeSum3(Node node) {

		if (node == null) {
			return new STPair();
		}

		STPair lp = maxSubtreeSum3(node.left);
		STPair rp = maxSubtreeSum3(node.right);

		STPair sp = new STPair();

		sp.entireSum = lp.entireSum + rp.entireSum + node.data;

		sp.maxSTSum = Math.max(sp.entireSum, Math.max(lp.maxSTSum, rp.maxSTSum));

		return sp;

	}

	private class BSTPair {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		boolean isBST = true;

		Node largestBSTRootNode;
		int largestBSTSize;
	}

	public void largestBST() {
		BSTPair ans = largestBST2(root);
		System.out.println(ans.isBST);
		System.out.println(ans.largestBSTRootNode.data);
		System.out.println(ans.largestBSTSize);
	}

	private boolean largestBST(Node node) {

		if (node == null) {
			return true;
		}

		boolean lbst = largestBST(node.left);
		boolean rbst = largestBST(node.right);

		boolean sbst = false;

		if (node.data > max(node.left) && node.data < min(node.right)) {
			sbst = true;
		}

		return lbst && rbst && sbst;

	}

	private BSTPair largestBST2(Node node) {

		if (node == null) {
			return new BSTPair();
		}

		BSTPair lbp = largestBST2(node.left);
		BSTPair rbp = largestBST2(node.right);

		BSTPair sbp = new BSTPair();

		sbp.max = Math.max(node.data, Math.max(lbp.max, rbp.max));
		sbp.min = Math.min(node.data, Math.min(lbp.min, rbp.min));

		if (node.data > lbp.max && node.data < rbp.min && lbp.isBST && rbp.isBST) {
			sbp.isBST = true;
			sbp.largestBSTRootNode = node;
			sbp.largestBSTSize = lbp.largestBSTSize + rbp.largestBSTSize + 1;
		} else {

			sbp.isBST = false;

			if (lbp.largestBSTSize > rbp.largestBSTSize) {
				sbp.largestBSTRootNode = lbp.largestBSTRootNode;
				sbp.largestBSTSize = lbp.largestBSTSize;
			} else {
				sbp.largestBSTRootNode = rbp.largestBSTRootNode;
				sbp.largestBSTSize = rbp.largestBSTSize;
			}

		}

		return sbp;

	}

	private class VOPair implements Comparable<VOPair> {
		int data;
		int vlevel;
		int hlevel;

		@Override
		public String toString() {
			return data + "";
		}

		@Override
		public int compareTo(VOPair o) {
			return this.hlevel - o.hlevel;
		}
	}

	public void verticalOrder() {

		HashMap<Integer, ArrayList<VOPair>> map = new HashMap<>();

		verticalOrder(root, 0, 0, map);

		ArrayList<Integer> keys = new ArrayList<>(map.keySet());
		Collections.sort(keys);

		for (int key : keys) {
			ArrayList<VOPair> list = map.get(key);
			Collections.sort(list);
			System.out.println(key + "->" + list);
		}

		System.out.println(map);
	}

	private void verticalOrder(Node node, int hl, int vl, HashMap<Integer, ArrayList<VOPair>> map) {

		if (node == null) {

			return;
		}

		if (!map.containsKey(vl)) {
			map.put(vl, new ArrayList<>());
		}

		VOPair np = new VOPair();
		np.data = node.data;
		np.vlevel = vl;
		np.hlevel = hl;

		map.get(vl).add(np);

		verticalOrder(node.left, hl + 1, vl - 1, map);
		verticalOrder(node.right, hl + 1, vl + 1, map);

	}

}
