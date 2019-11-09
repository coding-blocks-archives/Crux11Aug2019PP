package L32_Nov9;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 09-Nov-2019
 *
 */

public class STMin implements STI {

	@Override
	public int operation(int l, int r) {
		return Math.min(l, r);
	}

	@Override
	public int defaultValue() {
		return Integer.MAX_VALUE;
	}

}
