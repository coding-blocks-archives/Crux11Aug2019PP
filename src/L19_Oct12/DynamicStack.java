package L19_Oct12;

import L18_Oct8.Stack;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 12-Oct-2019
 *
 */

public class DynamicStack extends Stack {

	@Override
	public void push(int item) throws Exception  {

		if (isFull()) {

			// create a new array of double size
			int[] na = new int[data.length * 2];

			// copy the elements
			for (int i = 0; i < data.length; i++) {
				na[i] = data[i];
			}

			// reference change
			data = na;

		}
		
		super.push(item) ;

	}
}



