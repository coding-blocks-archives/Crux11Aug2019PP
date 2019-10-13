package L20_Oct13;

import L18_Oct8.Queue;
import L19_Oct12.DynamicQueue;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 13-Oct-2019
 *
 */

public class StackUsingQueuePopEff {

	Queue primary = new DynamicQueue();

	public void push(int item) throws Exception {

		try {
			Queue helper = new DynamicQueue();
			helper.enqueue(item);

			while (!primary.isEmpty()) {
				helper.enqueue(primary.dequeue());
			}

			primary = helper;

		} catch (Exception e) {
			throw new Exception("Stack is Full.");
		}
	}

	public int pop() throws Exception {

		try {
			return primary.dequeue();
		} catch (Exception e) {
			throw new Exception("Stack is Empty.");
		}

	}

	public int peek() throws Exception {

		try {
			return primary.getFront();
		} catch (Exception e) {
			throw new Exception("Stack is Empty.");
		}
	}

	public void display() {
		primary.display();
	}

}
