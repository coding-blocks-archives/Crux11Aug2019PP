package L25_Oct25;

import java.util.Scanner;

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

	private Node root;

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

}



