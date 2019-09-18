package Assignments.Sep18;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 18-Sep-2019
 *
 */

public class MaxFreqChar {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		String str  = scn.next() ;
		
		int maxFreq = 0 ;
		char maxFreqChar = ' ' ;
		
		int[] arr = new int[256] ;
		
		for(int i=0 ; i < str.length() ; i++) {
			
			char ch = str.charAt(i) ;
			
			arr[ch] ++ ;
			
			if(arr[ch] > maxFreq) {
				maxFreq = arr[ch] ;
				maxFreqChar = ch ;
			}
		}
		
		System.out.println(maxFreqChar);

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
