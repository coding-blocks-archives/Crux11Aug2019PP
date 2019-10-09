package L18_Oct8;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 08-Oct-2019
 *
 */

public class Student {

	String name = "Rohit";
	int age = 90;

	// public Student(String name, int age) {
	// this.name = name;
	// this.age = age;
	// }

	public Student() {

		System.out.println("constructor called");
	}

	public void Student() {

		System.out.println("in fxn");
	}

	public void introduceYourself() {

		System.out.println(name + " is " + age + " years old.");
	}

	public void sayHi(String name, Student s) {
		System.out.println(this.name + " says hi to " + name);

		s.introduceYourself();
	}

}
