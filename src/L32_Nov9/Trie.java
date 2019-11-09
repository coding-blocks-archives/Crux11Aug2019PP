package L32_Nov9;

import java.util.HashMap;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 09-Nov-2019
 *
 */

public class Trie {

	private class Node {
		char ch;
		boolean eow;
		HashMap<Character, Node> children = new HashMap<>();

		public Node(char ch) {
			this.ch = ch;
		}
	}

	private Node root;

	public Trie() {
		this.root = new Node('*');
	}

	public void addWord(String word) {
		addWord(root, word);
	}

	private void addWord(Node node, String word) {

		if (word.length() == 0) {
			node.eow = true;
			return;
		}

		char ch = word.charAt(0);
		String row = word.substring(1);

		if (node.children.containsKey(ch)) {
			addWord(node.children.get(ch), row);
		} else {

			Node child = new Node(ch);
			node.children.put(ch, child);

			addWord(child, row);
		}

	}

	public boolean searchWord(String word) {
		return searchWord(root, word);
	}

	private boolean searchWord(Node node, String word) {

		if (word.length() == 0) {
			return node.eow;
		}

		char ch = word.charAt(0);
		String row = word.substring(1);

		if (node.children.containsKey(ch)) {
			return searchWord(node.children.get(ch), row);
		} else {
			return false;
		}

	}

	public boolean prefixWord(String word) {
		return prefixWord(root, word);
	}

	private boolean prefixWord(Node node, String word) {

		if (word.length() == 0) {
			return true;
		}

		char ch = word.charAt(0);
		String row = word.substring(1);

		if (node.children.containsKey(ch)) {
			return prefixWord(node.children.get(ch), row);
		} else {
			return false;
		}

	}

	public void display() {
		display(root);
		System.out.println("----------------------");
	}

	private void display(Node node) {

		String str = node.ch + " -> " + node.children.keySet();

		System.out.println(str);

		for (char key : node.children.keySet()) {
			display(node.children.get(key));
		}

	}

	public void removeWord(String word) {
		removeWord(root, word);
	}

	private void removeWord(Node node, String word) {

		if (word.length() == 0) {
			node.eow = false;
			return;
		}

		char ch = word.charAt(0);
		String row = word.substring(1);

		if (node.children.containsKey(ch)) {
			removeWord(node.children.get(ch), row);
		}

		Node child = node.children.get(ch);
		if (child.eow == false && child.children.size() == 0) {
			node.children.remove(ch);
		}

	}

}
