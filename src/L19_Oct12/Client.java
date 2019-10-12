package L19_Oct12;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 12-Oct-2019
 *
 */

public class Client {

	public static void main(String[] args) {

		// case 1
		P obj1 = new P();
		System.out.println(obj1.d);
		System.out.println(obj1.d1);
		obj1.fun();
		obj1.fun1();

		// case 2
		System.out.println(" -- Case 2 -- ");
		P obj2 = new C();
		System.out.println(obj2.d); // P d
		System.out.println(((C) obj2).d); // C d
		System.out.println(obj2.d1);
		System.out.println(((C) obj2).d2);
		obj2.fun(); // C fun
		((P) obj2).fun(); // C fun
		obj2.fun1();
		((C) obj2).fun2();

		// case 3

		System.out.println(" -- Case 3 -- ");
		// C obj3 = new P();

		System.out.println(" -- Case 4 -- ");
		C obj4 = new C();
		System.out.println(obj4.d);
		System.out.println(((P) obj4).d);
		System.out.println(obj4.d1);
		System.out.println(obj4.d2);
		obj4.fun();
		obj4.fun1();
		obj4.fun2();

	}
}
