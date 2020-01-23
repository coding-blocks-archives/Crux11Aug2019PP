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

		public Node(int data) {
			this.data = data;
		}

		public Node() {
		}
	}

	private Node head;
	private Node tail;
	private int size;

	// O(1)
	public boolean isEmpty() {
		return size == 0;
	}

	// O(1)
	public int size() {
		return size;
	}

	// O(1)
	public int getFirst() throws Exception {

		if (size == 0) {
			throw new Exception("LL is Empty.");
		}

		return head.data;
	}

	// O(1)
	public int getLast() throws Exception {

		if (size == 0) {
			throw new Exception("LL is Empty.");
		}

		return tail.data;
	}

	// O(n)
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

	// O(n)
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

	// O(n)
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

	// O(1)
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

	// O(1)
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

	// O(n)
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

	// O(1)
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

	// O(n)
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

	// O(n)
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

			return n.data;

		}

	}

	public void RDI() throws Exception {

		int left = 0;
		int right = size - 1;

		while (left < right) {

			Node ln = getNodeAt(left);
			Node rn = getNodeAt(right);

			int temp = ln.data;
			ln.data = rn.data;
			rn.data = temp;

			// wrong
			// int ld = getAt(left);
			// int rd = getAt(right);
			//
			// int temp = ld;
			// ld = rd;
			// rd = temp;

			left++;
			right--;
		}

	}

	public void RPI() {

		Node prev = null;
		Node curr = head;

		while (curr != null) {
			Node ahead = curr.next;
			curr.next = prev;
			prev = curr;
			curr = ahead;
		}

		// swap head and tail
		Node temp = head;
		head = tail;
		tail = temp;

		// tail.next = null ;

	}

	public void RPR() {
		RPR(null, head);

		// swap head and tail
		Node temp = head;
		head = tail;
		tail = temp;

	}

	private void RPR(Node prev, Node curr) {

		if (curr == null) {
			return;
		}

		RPR(curr, curr.next);
		curr.next = prev;

	}

	public void RDR() {
		// RDRReturn(head, head, 0);

		HeapMover mover = new HeapMover();
		mover.left = head;

		RDRHeap(mover, head, 0);

	}

	private Node RDRReturn(Node left, Node right, int count) {

		if (right == null) {
			return left;
		}

		Node cl = RDRReturn(left, right.next, count + 1);

		if (count >= size / 2) {
			// swap
			int temp = cl.data;
			cl.data = right.data;
			right.data = temp;
		}

		return cl.next;

	}

	private class HeapMover {
		Node left;
	}

	private void RDRHeap(HeapMover mover, Node right, int count) {
		if (right == null) {
			return;
		}

		RDRHeap(mover, right.next, count + 1);

		if (count >= size / 2) {
			int temp = mover.left.data;
			mover.left.data = right.data;
			right.data = temp;
		}

		mover.left = mover.left.next;
	}

	public void fold() {
		fold(head, head, 0);
	}

	private Node fold(Node left, Node right, int count) {

		if (right == null) {
			return left;
		}

		Node cl = fold(left, right.next, count + 1);

		if (count > size / 2) {

			Node ahead = cl.next;

			cl.next = right;
			right.next = ahead;

			return ahead;
		}

		if (count == size / 2) {
			tail = right;
			tail.next = null;
		}

		return null;

	}

	public int mid() {

		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {

			slow = slow.next;
			fast = fast.next.next;

		}

		return slow.data;
	}

	public int kFromLast(int k) {

		Node front = head;
		Node back = head;

		for (int i = 1; i <= k; i++) {
			front = front.next;
		}

		while (front != null) {
			front = front.next;
			back = back.next;
		}

		return back.data;
	}

	public void createDummyList() {
		Node n1 = new Node(10);
		Node n2 = new Node(20);
		Node n3 = new Node(30);
		Node n4 = new Node(40);
		Node n5 = new Node(50);
		Node n6 = new Node(60);
		Node n7 = new Node(70);
		Node n8 = new Node(80);
		Node n9 = new Node(90);
		Node n10 = new Node(100);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = null;
		n9.next = n10;
		n10.next = n7;
		Node h1 = n1;
		Node h2 = n9;
		System.out.println(intersection(h1, h2));
	}

	public int intersection(Node h1, Node h2) {

		Node fp = h1;
		Node sp = h2;

		while (fp != sp) {

			if (fp == null) {
				fp = h2;
			} else {
				fp = fp.next;
			}

			if (sp == null) {
				sp = h1;
			} else {
				sp = sp.next;
			}

		}

		return fp.data;
	}

	public void kReverse(int k) throws Exception {

		LinkedList prev = null;

		while (size != 0) {

			LinkedList curr = new LinkedList();

			for (int i = 1; i <= k && size != 0; i++) {
				curr.addFirst(this.removeFirst());
			}

			if (prev == null) {
				prev = curr;
			} else {
				prev.tail.next = curr.head;
				prev.tail = curr.tail;
				prev.size += curr.size;
			}
		}

		this.head = prev.head;
		this.tail = prev.tail;
		this.size = prev.size;

	}

	public void OddEven() {

		Node fake_head_even = new Node();
		Node fake_head_odd = new Node();

		Node even = fake_head_even;
		Node odd = fake_head_odd;

		Node temp = this.head;

		while (temp != null) {

			if (temp.data % 2 == 0) {

				even.next = temp;
				even = even.next;
			} else {

				odd.next = temp;
				odd = odd.next;
			}

			temp = temp.next;

		}

		// Attach
		odd.next = fake_head_even.next;

		this.head = fake_head_odd.next;
		this.tail = even;
		this.tail.next = null;

	}

}
