package L29_Nov1.GenericFxn;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 01-Nov-2019
 *
 */

public class Car {

	int speed;
	int price;
	String color;

	public Car(int speed, int price, String color) {
		this.speed = speed;
		this.price = price;
		this.color = color;
	}

	public String toString() {
		return "S:" + this.speed + " P:" + this.price + " C:" + this.color;
	}

	// public int compareTo(Car other) {
	// // return this.speed - other.speed;
	// return other.price - this.price;
	// // return this.color.compareTo(other.color);
	// }

}
