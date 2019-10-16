package L21_Oct16;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 16-Oct-2019
 *
 */

public class Client {

	public static void main(String[] args) throws Exception {

		LinkedList list = new LinkedList();
		
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.addLast(40);
		list.display();
		list.addFirst(50);
		list.addFirst(60);
		list.addAt(list.size(), 70);
		
		list.display();
		
		System.out.println(list.removeFirst());
		System.out.println(list.removeLast());
		list.display();
		System.out.println(list.removeAt(2));
		list.display();
	}
}











