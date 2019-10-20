package L23_Oct20;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 20-Oct-2019
 *
 */

public class GenericTree {

	Scanner scn = new Scanner(System.in);

	private class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	private Node root;

	public GenericTree() {
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

}
