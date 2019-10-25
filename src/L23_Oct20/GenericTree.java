package L23_Oct20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 20-Oct-2019
 *
 */

public class GenericTree {

	Scanner scn;

	private class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	private Node root;

	public GenericTree(String str) {

		scn = new Scanner(str);
		root = takeInput(null, -1);
	}

	private Node takeInput(Node parent, int ith) {

		// give prompt to user
		if (parent == null) {
			System.out.println("Enter the data for Root Node ?");
		} else {
			System.out.println("Enter the data for " + ith + " child of " + parent.data);
		}

		// take input
		int item = scn.nextInt();

		// make a new node
		Node nn = new Node();
		nn.data = item;

		// ask how many children a node has ?
		System.out.println("No. of children for " + nn.data + " ?");
		int noc = scn.nextInt();

		// work for all children
		for (int i = 0; i < noc; i++) {

			// take input of children
			Node child = takeInput(nn, i);

			// add children in ur array list
			nn.children.add(child);
		}

		return nn;

	}

	public void display() {
		System.out.println("-----------------------");
		display(root);
		System.out.println("-----------------------");
	}

	private void display(Node node) {

		// self work
		String str = node.data + " -> ";

		for (Node child : node.children) {
			str += child.data + ", ";
		}

		str += ".";
		System.out.println(str);

		// child
		for (Node child : node.children) {
			display(child);
		}

	}

	public int size() {
		return size(root);
	}

	private int size(Node node) {

		int ts = 0;

		for (Node child : node.children) {
			int cs = size(child);
			ts += cs;
		}

		return ts + 1;

	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {

		int tm = node.data;

		for (Node child : node.children) {
			int cm = max(child);

			if (cm > tm) {
				tm = cm;
			}
		}

		return tm;

	}

	public int ht() {
		return ht(root);
	}

	private int ht(Node node) {

		int th = -1;

		for (Node child : node.children) {
			int ch = ht(child);

			if (ch > th) {
				th = ch;
			}
		}

		return th + 1;

	}

	public boolean find(int item) {
		return find(root, item);
	}

	private boolean find(Node node, int item) {

		if (node.data == item) {
			return true;
		}

		for (Node child : node.children) {
			boolean cf = find(child, item);

			if (cf) {
				return true;
			}
		}

		return false;
	}

	public void mirror() {
		mirror(root);
	}

	private void mirror(Node node) {

		for (Node child : node.children) {
			mirror(child);
		}

		// int l = 0;
		// int r = node.children.size() - 1;
		//
		// while (l < r) {
		//
		// Node ln = node.children.get(l);
		// Node rn = node.children.get(r);
		//
		// node.children.set(l, rn);
		// node.children.set(r, ln);
		//
		// l++;
		// r--;
		// }

		Collections.reverse(node.children);
	}

	public void linearize() {
		linearize(root);
	}

	private void linearize(Node node) {

		for (Node child : node.children) {
			linearize(child);
		}

		while (node.children.size() > 1) {
			Node temp = node.children.remove(1);
			Node tail = getTail(node.children.get(0));
			tail.children.add(temp);
		}

	}

	private Node getTail(Node node) {

		if (node.children.size() == 0) {
			return node;
		}

		return getTail(node.children.get(0));
	}

	public void printAtLevel(int level) {
		printAtLevel(root, level, 0);
	}

	private void printAtLevel(Node node, int level, int count) {

		if (level == count) {
			System.out.println(node.data);
			return;
		}

		for (Node child : node.children) {
			printAtLevel(child, level, count + 1);
		}

	}

	public void display2() {
		display2(root);
	}

	private void display2(Node node) {

		System.out.println("Hii " + node.data);

		for (Node child : node.children) {
			System.out.println("Going towards " + child.data);
			display2(child);
			System.out.println("Coming back from " + child.data);
		}

		System.out.println("Bye " + node.data);
	}

	public void preorder() {
		preorder(root);
		System.out.println();
	}

	private void preorder(Node node) {

		System.out.print(node.data + " ");

		for (Node child : node.children) {
			preorder(child);
		}

	}

	public void postorder() {
		postorder(root);
		System.out.println();
	}

	private void postorder(Node node) {

		for (Node child : node.children) {
			postorder(child);
		}

		System.out.print(node.data + " ");

	}

	public void levelOrder() {

		LinkedList<Node> queue = new LinkedList<>();

		queue.addLast(root);

		while (!queue.isEmpty()) {

			Node rn = queue.removeFirst();

			System.out.print(rn.data + " ");

			for (Node child : rn.children) {
				queue.addLast(child);
			}

		}

		System.out.println();

	}

	public void levelOrderLW() {

		LinkedList<Node> queue = new LinkedList<>();

		queue.addLast(root);
		queue.addLast(null);

		while (!queue.isEmpty()) {

			Node rn = queue.removeFirst();

			if (rn == null) {

				if (queue.isEmpty()) {
					break;
				}

				System.out.println();

				queue.addLast(null);
				continue;
			}

			System.out.print(rn.data + " ");

			for (Node child : rn.children) {
				queue.addLast(child);
			}

		}
	}

	public void levelOrderLW2() {

		LinkedList<Node> primary = new LinkedList<>();
		LinkedList<Node> helper = new LinkedList<>();

		primary.addLast(root);

		while (!primary.isEmpty()) {

			Node rn = primary.removeFirst();

			System.out.print(rn.data + " ");

			for (Node child : rn.children) {
				helper.addLast(child);
			}

			if (primary.isEmpty()) {
				primary = helper;
				helper = new LinkedList<>();

				System.out.println();
			}

		}
	}

	public void levelOrderZZ() {

		int count = 0;

		LinkedList<Node> queue = new LinkedList<>();
		LinkedList<Node> stack = new LinkedList<>();

		queue.addLast(root);

		while (!queue.isEmpty()) {

			Node rn = queue.removeFirst();

			System.out.print(rn.data + " ");

			if (count % 2 == 0) {
				for (Node child : rn.children) {
					stack.addFirst(child);
				}
			} else {
				for (int i = rn.children.size() - 1; i >= 0; i--) {
					stack.addFirst(rn.children.get(i));
				}
			}

			if (queue.isEmpty()) {
				queue = stack;
				stack = new LinkedList<>();

				System.out.println();

				count++;
			}

		}

	}

}
