package L28_Oct31.InterfaceStory;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 31-Oct-2019
 *
 */

public class Client {

	public static void main(String[] args) {

		StackI s = new Stack();
		s.pop();
		s.push(10);

		Queue<Integer> q = new LinkedList<>();
		q.add(10);

	}
}
