package L30_Nov2;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 02-Nov-2019
 *
 */

public class HeapClient {

	public static void main(String[] args) {

		Heap heap = new Heap();
		heap.add(10);
		heap.display();
		heap.add(2);
		heap.display();
		heap.add(3);
		heap.display();
		heap.add(25);
		heap.display();
		heap.add(4);
		heap.display();

		while (!heap.isEmpty()) {
			System.out.println(heap.remove());
			heap.display();
		}
	}
}
