package L28_Oct31.StaticStory;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 31-Oct-2019
 *
 */

public class Student {

	String name;
	int rollNo;
	static int nos;

	public Student(String name) {
		nos++;
		this.rollNo = nos;
		this.name = name;
	}

	public void introduceYourself() {
		System.out.println(this.name + " has roll no as " + this.rollNo);
		System.out.println(nos);
	}

	public void sayHi(String name) {
		System.out.println(this.name + " says Hi to " + name);
	}

	// cant access this in static fxn
	// cant access non static variables
	// can access only static variables
	public static void fun() {
		System.out.println(nos);
	}
}
