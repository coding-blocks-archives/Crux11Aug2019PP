package L9_Sep8;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 08-Sep-2019
 *
 */

public class SBDemo {

	public static void main(String[] args) {

		// create
		String s = "hello";
		StringBuilder sb = new StringBuilder(s);

		// length
		System.out.println(sb.length());

		// charAt
		System.out.println(sb.charAt(2));

		// setCharAt
		sb.setCharAt(3, 'q');
		System.out.println(sb);

		// add
		sb.append("abc");
		System.out.println(sb);

		sb.insert(2, "def");
		System.out.println(sb);

		// delete
		sb.deleteCharAt(2);
		System.out.println(sb);

		// stringbuilder -> string
		String str = sb.toString();

		Scanner scn = new Scanner(System.in);

		System.out.println(changeCase(scn.next()));

		int[] arr = {8, 85, 89, 889, 897, 899, 859} ;
		
		formBiggestNumber(arr);
		for(int val : arr) {
			System.out.print(val);
		}
	}

	public static String changeCase(String str) {

		StringBuilder sb = new StringBuilder(str);

		// code
		for (int i = 0; i < sb.length(); i++) {

			char ch = sb.charAt(i);

			if (ch >= 'a' && ch <= 'z') {
				sb.setCharAt(i, (char) (ch - ('a' - 'A')));
			} else if (ch >= 'A' && ch <= 'Z') {
				sb.setCharAt(i, (char) (ch + ('a' - 'A')));
			}
		}

		return sb.toString();
	}

	public static String changeCaseUpdate(String str) {

		StringBuilder sb = new StringBuilder(str);

		// code
		for (int i = 0; i < sb.length(); i++) {

			char ch = sb.charAt(i);

			if (Character.isLowerCase(ch)) {
				sb.setCharAt(i, Character.toUpperCase(ch));
			} else if (Character.isUpperCase(ch)) {
				sb.setCharAt(i, Character.toLowerCase(ch));
			}
		}

		return sb.toString();
	}

	public static String changeCaseAppend(String str) {

		StringBuilder sb = new StringBuilder();

		// code
		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);

			if (Character.isLowerCase(ch)) {
				sb.append(Character.toUpperCase(ch));
			} else if (Character.isUpperCase(ch)) {
				sb.append(Character.toLowerCase(ch));
			}
		}

		return sb.toString();
	}

	public static void formBiggestNumber(int[] arr) {

		for (int count = 0; count <= arr.length - 2; count++) {

			for (int j = 0; j <= arr.length - count - 2; j++) {

				if (compare(arr[j], arr[j + 1])) {

					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}

			}

		
		}
	}
	
	public static boolean compare(int n1, int n2) {
		
		String n1n2s = n1+ "" + n2 ;
		String n2n1s = n2 + "" + n1 ;
		
		int res = n1n2s.compareTo(n2n1s)  ;
		
		if(res > 0) {
			return false ; // dont swap
		}else {
			return true ; // swap
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
