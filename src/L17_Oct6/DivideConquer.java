package L17_Oct6;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 06-Oct-2019
 *
 */

public class DivideConquer {

	public static void main(String[] args) {

		int[] arr = { 70, 80, 20, 30, 90, 10 };

		// int[] ans = mergeSort(arr, 0, arr.length - 1);

		quickSort(arr, 0, arr.length - 1);

		for (int val : arr) {
			System.out.println(val);
		}

	}

	public static int[] mergeTwoSortedArrays(int[] one, int[] two) {

		int[] ans = new int[one.length + two.length];

		int i = 0;
		int j = 0;
		int k = 0;

		while (i < one.length && j < two.length) {

			if (one[i] < two[j]) {

				ans[k] = one[i];
				k++;
				i++;

			} else {

				ans[k] = two[j];
				k++;
				j++;

			}

		}

		if (i == one.length) {

			while (j < two.length) {

				ans[k] = two[j];
				k++;
				j++;

			}
		}

		if (j == two.length) {

			while (i < one.length) {

				ans[k] = one[i];
				k++;
				i++;

			}
		}

		return ans;
	}

	public static int[] mergeSort(int[] arr, int lo, int hi) {

		if (lo == hi) {
			int[] br = new int[1];
			br[0] = arr[lo];
			return br;
		}

		int mid = (lo + hi) / 2;

		int[] fh = mergeSort(arr, lo, mid);
		int[] sh = mergeSort(arr, mid + 1, hi);

		int[] merged = mergeTwoSortedArrays(fh, sh);

		return merged;

	}

	public static void quickSort(int[] arr, int lo, int hi) {

		if (lo >= hi) {
			return;
		}

		int mid = (lo + hi) / 2;

		int pivot = arr[mid];

		// partitioning
		int left = lo;
		int right = hi;

		while (left <= right) {

			// left problem
			while (arr[left] < pivot) {
				left++;
			}

			// right problem
			while (arr[right] > pivot) {
				right--;
			}

			// problem solve

			if (left <= right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;

				left++;
				right--;
			}

		}
		// partitioning completed

		// smaller parts sort
		quickSort(arr, lo, right);
		quickSort(arr, left, hi);

	}

}
