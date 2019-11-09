package L32_Nov9;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 09-Nov-2019
 *
 */

public class STMax implements STI {

	@Override
	public int operation(int l, int r) {
		return Math.max(l, r);
	}

	@Override
	public int defaultValue() {
		return Integer.MIN_VALUE;
	}

}
