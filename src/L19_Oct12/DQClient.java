package L19_Oct12;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 12-Oct-2019
 *
 */

public class DQClient {

	public static void main(String[] args) throws Exception {

		DynamicQueue q = new DynamicQueue();
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);

		q.dequeue();
		q.dequeue();

		q.enqueue(60);
		q.enqueue(70);

		q.display();

		q.enqueue(80);
		q.display();
	}
}
