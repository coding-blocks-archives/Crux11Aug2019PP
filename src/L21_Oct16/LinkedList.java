package L21_Oct16;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 16-Oct-2019
 *
 */

public class LinkedList {

	private class Node {
		int data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public int getFirst() throws Exception {

		if (size == 0) {
			throw new Exception("LL is Empty.");
		}

		return head.data;
	}

	public int getLast() throws Exception {

		if (size == 0) {
			throw new Exception("LL is Empty.");
		}

		return tail.data;
	}

	public int getAt(int idx) throws Exception {

		if (size == 0) {
			throw new Exception("LL is Empty.");
		}

		if (idx < 0 || idx >= size) {
			throw new Exception("Invalid Index.");
		}

		Node temp = head;

		for (int i = 1; i <= idx; i++) {
			temp = temp.next;
		}

		return temp.data;
	}

	private Node getNodeAt(int idx) throws Exception {

		if (size == 0) {
			throw new Exception("LL is Empty.");
		}

		if (idx < 0 || idx >= size) {
			throw new Exception("Invalid Index.");
		}

		Node temp = head;

		for (int i = 1; i <= idx; i++) {
			temp = temp.next;
		}

		return temp;
	}

	public void display() {

		System.out.println("----------------------");

		Node temp = head;

		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}

		System.out.println(".");
		System.out.println("----------------------");

	}

	public void addLast(int item) {

		// create a new node
		Node nn = new Node();
		nn.data = item;
		nn.next = null;

		// attach to already existing ll
		if (size > 0)
			tail.next = nn;

		// data members
		if (size == 0) {
			head = nn;
			tail = nn;
			size++;
		} else {
			tail = nn;
			size++;
		}
	}

	public void addFirst(int item) {

		Node nn = new Node();
		nn.data = item;
		nn.next = null;

		// attach
		nn.next = head;

		// data members
		if (size == 0) {
			head = nn;
			tail = nn;
			size++;
		} else {
			head = nn;
			size++;
		}

	}

	public void addAt(int idx, int item) throws Exception {

		if (idx < 0 || idx > size) {
			throw new Exception("Invalid Index.");
		}

		if (idx == 0) {
			addFirst(item);
		} else if (idx == size) {
			addLast(item);
		} else {

			// new node
			Node nn = new Node();
			nn.data = item;
			nn.next = null;

			// create links
			Node nm1 = getNodeAt(idx - 1);
			Node np1 = nm1.next;

			nm1.next = nn;
			nn.next = np1;

			// data members
			size++;

		}

	}

	public int removeFirst() throws Exception {

		if (size == 0) {
			throw new Exception("LL is Empty.");
		}

		int temp = head.data;

		// data members
		if (size == 1) {
			head = null;
			tail = null;
			size--;
		} else {
			head = head.next;
			size--;
		}

		return temp;

	}

	public int removeLast() throws Exception {

		if (size == 0) {
			throw new Exception("LL is Empty.");
		}

		int temp = tail.data;

		// data members
		if (size == 1) {
			head = null;
			tail = null;
			size--;
		} else {
			Node sm2 = getNodeAt(size - 2);
			sm2.next = null;

			tail = sm2;
			size--;
		}

		return temp;

	}

	public int removeAt(int idx) throws Exception {

		if (size == 0) {
			throw new Exception("LL is Empty.");
		}

		if (idx < 0 || idx >= size) {
			throw new Exception("Invalid Index.");
		}

		if (idx == 0) {
			return removeFirst();
		} else if (idx == size - 1) {
			return removeLast();
		} else {

			Node nm1 = getNodeAt(idx - 1);
			Node n = nm1.next;
			Node np1 = n.next;

			nm1.next = np1;

			size--;
			
			return n.data ;

		}

	}
}
