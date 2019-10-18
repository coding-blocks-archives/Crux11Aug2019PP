package Assignments.Oct17;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 17-Oct-2019
 *
 */

public class KSwaps {

	public static void main(String[] args) {

		String str = "5432";
		int k = 2;

		char[] arr = str.toCharArray();

		System.out.println(kswaps(arr, 0, k));
	}

	public static int kswaps(char[] arr, int vidx, int k) {

		int ans = 0;

		if (k == 0 || vidx == arr.length) {
			String s = new String(arr);
			return Integer.parseInt(s);
		}

		// find out the max value after vidx
		char max = maxAfterIndex(arr, vidx);

		// may be vidx itself contains the largest element
		if (arr[vidx] == max) {
			ans = kswaps(arr, vidx + 1, k);
		} else {
			// find all the places where max value is prsent
			for (int i = vidx; i < arr.length; i++) {

				if (arr[i] == max) {

					// swap b/w i and vidx
					swap(arr, i, vidx);

					// recursive call
					int rr = kswaps(arr, vidx + 1, k - 1);

					if (rr > ans) {
						ans = rr;
					}

					// undo
					swap(arr, i, vidx);

				}

			}
		}

		return ans;

	}

	public static void swap(char[] arr, int i, int j) {

		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static char maxAfterIndex(char[] arr, int idx) {

		char max = arr[idx];

		for (int i = idx + 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}

		return max;
	}
}
