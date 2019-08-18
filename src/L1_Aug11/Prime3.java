package L1_Aug11 ;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 11-Aug-2019
 *
 */

public class Prime3 {

	public static void main(String[] args) {

		int n = 12;

		int flag = 0;

		int div = 2;

		while (div <= n - 1) {

			if (n % div == 0) {
				System.out.println("Not Prime");
				flag = 1;
				break;
			}

			div++;

		}

		if (flag == 0)
			System.out.println("Prime");
	}
}
