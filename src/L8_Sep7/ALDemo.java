package L8_Sep7;

import java.util.ArrayList;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 07-Sep-2019
 *
 */

public class ALDemo {

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<>();

		System.out.println(list);
		// size
		System.out.println(list.size());

		// add : last
		list.add(10);
		list.add(20);
		list.add(30);

		System.out.println(list);
		System.out.println(list.size());

		// add at a particular pos : performance : n , range : 0 -> size
		list.add(1, 40);
		list.add(list.size(), 50);
		System.out.println(list);

		// set : performance : constant , range : 0 -> size-1
		list.set(2, 60);
		System.out.println(list);

		// get : perfomance : constant, range : 0 -> size-1
		System.out.println(list.get(4));

		// remove : performance : n , range : 0 -> size -1
		list.remove(2);
		System.out.println(list);

		// for loop
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		// enhanced for loop
		for (int val : list) {
			System.out.println(val);
		}

	}
}
