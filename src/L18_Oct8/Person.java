package L18_Oct8;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 08-Oct-2019
 *
 */

public class Person {

	String name;
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) throws ArrayIndexOutOfBoundsException {

		if (age < 0) {	
			throw new ArrayIndexOutOfBoundsException("Invalid Age.");
		}

		this.age = age;
	}

	public void setName(String name) throws NullPointerException {

		if (name == null) {
			throw new NullPointerException("Invalid Name.");
		}

		this.name = name;
	}
}
