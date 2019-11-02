package L30_Nov2;

import java.util.ArrayList;

import L19_Oct12.P;
import L29_Nov1.GenericFxn.Car;
import L29_Nov1.GenericFxn.CarPriceComparator;
import L29_Nov1.GenericFxn.CarSpeedComparator;
import L29_Nov1.GenericFxn.IntegerComparator;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 02-Nov-2019
 *
 */

public class HGClient {

	public static void main(String[] args) {

		Car[] carr = new Car[5];

		carr[0] = new Car(10, 6, "Black");
		carr[1] = new Car(500, 8, "White");
		carr[2] = new Car(80, 2, "Red");
		carr[3] = new Car(90, 9, "Yellow");
		carr[4] = new Car(5, 1, "Grey");

		HeapGeneric2<Car> heap = new HeapGeneric2<>(new CarPriceComparator());

		for (int i = 0; i < carr.length; i++) {
			heap.add(carr[i]);
		}

		while (!heap.isEmpty()) {
			System.out.println(heap.remove());
		}

		ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
		lists.add(new ArrayList<>());
		lists.add(new ArrayList<>());
		lists.add(new ArrayList<>());
		lists.add(new ArrayList<>());

		lists.get(0).add(7);
		lists.get(0).add(10);
		lists.get(0).add(15);
		lists.get(1).add(2);
		lists.get(1).add(3);
		lists.get(1).add(11);
		lists.get(1).add(14);
		lists.get(2).add(1);
		lists.get(2).add(5);
		lists.get(3).add(4);
		lists.get(3).add(6);
		lists.get(3).add(12);

		mergeKSortedLists(lists);

		int[] arr = { 5, 12, 16, 20, 40, 3, 60 };
		KLargestElements(arr, 3);
	}

	private static class Pair implements Comparable<Pair> {
		int data;
		int listNo;
		int idxNo;

		@Override
		public int compareTo(Pair o) {
			return o.data - this.data;
		}
	}

	public static void mergeKSortedLists(ArrayList<ArrayList<Integer>> lists) {

		HeapGeneric<Pair> heap = new HeapGeneric<>();

		for (int i = 0; i < lists.size(); i++) {
			Pair np = new Pair();
			np.data = lists.get(i).get(0);
			np.listNo = i;
			np.idxNo = 0;

			heap.add(np);
		}

		while (!heap.isEmpty()) {

			Pair rp = heap.remove();

			System.out.print(rp.data + " ");

			rp.idxNo++;

			if (rp.idxNo < lists.get(rp.listNo).size()) {

				rp.data = lists.get(rp.listNo).get(rp.idxNo);
				heap.add(rp);

			}
		}
		System.out.println();

	}

	public static void KLargestElements(int[] arr, int k) {

		HeapGeneric2<Integer> heap = new HeapGeneric2<>(new IntegerComparator());

		for (int i = 0; i < k; i++) {
			heap.add(arr[i]);
		}

		for (int i = k; i < arr.length; i++) {

			int smaller = heap.get();

			if (arr[i] > smaller) {
				heap.remove();
				heap.add(arr[i]);
			}

		}

		while (!heap.isEmpty()) {
			System.out.println(heap.remove());
		}

	}

}
