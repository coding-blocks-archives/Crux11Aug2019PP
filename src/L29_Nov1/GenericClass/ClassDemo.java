package L29_Nov1.GenericClass;

import java.util.ArrayList;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 01-Nov-2019
 *
 */

public class ClassDemo {

	public static void main(String[] args) throws Exception {

		Pair<Pair<String, Integer>, Double> p = new Pair<>();
		System.out.println(p.a);
		p.a = new Pair<>();
		p.a.b = new Integer(10);
		System.out.println(p.a.b);

		ArrayList<ArrayList<Integer>> list = new ArrayList<>();

		System.out.println(list);
		System.out.println(list.size());

		list.add(new ArrayList<>());
		list.get(0).add(10);
		list.get(0).add(20);
		System.out.println(list);
		System.out.println(list.size());
		System.out.println(list.get(0).size());
		list.add(new ArrayList<>());
		list.get(1).add(30);
		System.out.println(list);

		LinkedListGeneric<ArrayList<Integer>> l = new LinkedListGeneric<>();
		l.addLast(new ArrayList<>());
		l.getLast().add(10);
		l.getLast().add(20);
		l.getLast().add(30);
		l.addLast(new ArrayList<>());
		l.getLast().add(40);
		l.getLast().add(50);
		l.getLast().add(60);

		l.display();

	}
}
