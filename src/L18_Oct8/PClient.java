package L18_Oct8;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 08-Oct-2019
 *
 */

public class PClient {

	public static void main(String[] args) throws Exception {

		System.out.println("hi");

		Person p = new Person();

		try {
			System.out.println("hi try");
			p.setAge(10);
			p.setName(null);
			System.out.println("bye try");
		}

		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
			System.out.println("ArrayIndexOutOfBound");
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
			System.out.println("NullPointer");
		}

		System.out.println(p.getAge());
		System.out.println("bye");

		fun1();

	}

	public static void fun1() throws Exception {

		System.out.println("hi fun1");
		fun2();
		System.out.println("bye fun1");

	}

	public static void fun2() throws Exception {

		System.out.println("hi fun2");
		fun3();
		System.out.println("bye fun2");

	}

	public static void fun3() throws Exception {

		System.out.println("hi fun3");
		throw new Exception("Wrong");

	}

}
