package L1_Aug11 ;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 11-Aug-2019
 *
 */

public class ConditionalStatements {

	public static void main(String[] args) {

		int marks = 55;
		int pack = 25 ;

		System.out.println("Hi");

		if (marks > 80 || pack == 15) {
			System.out.println("Excellent");
		}else if(marks > 50 && pack > 20) {
			System.out.println("Good");
		}else if(marks > 60 || pack > 5) {
			System.out.println("Avg");
		}else {
			System.out.println("Poor");
		}

		
		System.out.println("Bye");
	}
}








