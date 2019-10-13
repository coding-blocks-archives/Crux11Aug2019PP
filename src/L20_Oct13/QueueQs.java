package L20_Oct13;

import L18_Oct8.Queue;
import L19_Oct12.DynamicQueue;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 13-Oct-2019
 *
 */

public class QueueQs {

	public static void main(String[] args) throws Exception {

		Queue q = new DynamicQueue();
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);

		System.out.println(" -- Display Reverse --");
		q.display();
		displayReverse(q, 0);
		q.display();

		System.out.println(" -- Actual Reverse --");
		q.display();
		actualReverse(q);
		q.display();

	}

	public static void displayReverse(Queue q, int count) throws Exception {

		if (q.size() == count) {
			return;
		}

		int temp = q.dequeue();
		q.enqueue(temp);
		displayReverse(q, count + 1);
		System.out.println(temp);

	}

	public static void actualReverse(Queue q) throws Exception {

		if (q.isEmpty()) {
			return;
		}

		int temp = q.dequeue();
		actualReverse(q);
		q.enqueue(temp);

	}

}
