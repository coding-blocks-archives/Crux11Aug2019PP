package L32_Nov9;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 09-Nov-2019
 *
 */

public class STClient {

	public static void main(String[] args) {

		int[] arr = { -2, 8, 9, 10, 6, 5, 4 };
		SegmentTreeGeneric st = new SegmentTreeGeneric(arr, new STMax());
		st.display();

		System.out.println(st.query(2, 6));

		st.update(4, 16);

		st.display();

		System.out.println(st.query(2, 6));
	}
}
