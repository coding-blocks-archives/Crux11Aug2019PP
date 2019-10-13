package L20_Oct13;

import L18_Oct8.Stack;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 13-Oct-2019
 *
 */

public class StackUsingQClient {

	public static void main(String[] args) throws Exception {

		StackUsingQueuePopEff s = new StackUsingQueuePopEff();

		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);
		s.push(50);
		s.push(60);

		s.display();

		System.out.println(s.pop());
		s.display();

		System.out.println(s.peek());
		s.display();

	}
}
