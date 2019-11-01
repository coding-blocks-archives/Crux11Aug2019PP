package L29_Nov1.GenericFxn;

import java.util.Comparator;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 01-Nov-2019
 *
 */

public class FxnDemo {

	public static void main(String[] args) {

		Integer[] arr = { 100, 20, 30, 40, 50 };
		display(arr);

		String[] sarr = { "a", "z", "hi", "hello", "bye" };
		display(sarr);

		Car[] carr = new Car[5];
		display(carr);

		carr[0] = new Car(10, 6, "Black");
		carr[1] = new Car(500, 8, "White");
		carr[2] = new Car(80, 2, "Red");
		carr[3] = new Car(90, 9, "Yellow");
		carr[4] = new Car(5, 1, "Grey");

		display(carr);
		// bubbleSort(carr);
		display(carr);

		bubbleSort(arr);
		display(arr);

		bubbleSort(carr, new CarSpeedComparator());
		display(carr);

		bubbleSort(carr, new CarPriceComparator());
		display(carr);

		bubbleSort(carr, new CarColorComparator());
		display(carr);
		
		bubbleSort(arr, new IntegerComparator());
		display(arr);
	}

	public static <T> void display(T[] arr) {
		System.out.println("------------------");
		for (T val : arr) {
			System.out.println(val);
		}
		System.out.println("------------------");
	}

	public static <T extends Comparable<T>> void bubbleSort(T[] arr) {

		for (int count = 0; count <= arr.length - 2; count++) {

			for (int j = 0; j <= arr.length - count - 2; j++) {

				if (arr[j].compareTo(arr[j + 1]) > 0) {

					T temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}

			}

		}
	}

	public static <T> void bubbleSort(T[] arr, Comparator<T> comp) {

		for (int count = 0; count <= arr.length - 2; count++) {

			for (int j = 0; j <= arr.length - count - 2; j++) {

				if (comp.compare(arr[j], arr[j + 1]) > 0) {

					T temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}

			}

		}
	}

}




