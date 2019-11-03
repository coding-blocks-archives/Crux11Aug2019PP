package L31_Nov3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 03-Nov-2019
 *
 */

public class HashMapDemo {

	public static void main(String[] args) {

		HashMap<String, Integer> map = new HashMap<>();

		// add
		map.put("India", 10);
		map.put("Aus", 100);
		map.put("China", 50);
		System.out.println(map);
		map.put("India", 20);
		System.out.println(map);
		map.put("US", 5);
		System.out.println(map);

		// get
		System.out.println(map.get("India"));
		System.out.println(map.get("UK"));

		// containsKey
		System.out.println(map.containsKey("India"));
		System.out.println(map.containsKey("UK"));

		// remove
		System.out.println(map);
		System.out.println(map.remove("US"));
		System.out.println(map);
		System.out.println(map.remove("UK"));
		System.out.println(map);

		// way 1
		Set<String> keys = map.keySet();

		for (String key : keys) {
			System.out.println(key + "->" + map.get(key));
		}

		// way 2
		for (String key : map.keySet()) {
			System.out.println(key + "->" + map.get(key));
		}

		// way 3
		ArrayList<String> list = new ArrayList<>(map.keySet());

		for (String val : list) {
			System.out.println(val + " -> " + map.get(val));
		}

	}
}
