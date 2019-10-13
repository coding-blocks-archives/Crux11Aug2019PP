package L20_Oct13;

import L18_Oct8.Stack;
import L19_Oct12.DynamicStack;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 13-Oct-2019
 *
 */

public class StackQs {

	public static void main(String[] args) throws Exception {

		Stack s = new DynamicStack();
		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);
		s.push(50);
		s.push(60);

		System.out.println(" -- Display Reverse -- ");
		s.display();
		// displayReverse(s);
		s.display();

		System.out.println(" -- Actual Reverse -- ");
		s.display();
		// actualReverse(s, new DynamicStack());
		s.display();

		System.out.println(" -- NGE --");
		int[] arr = { 50, 20, 10, 40, 30, 60, 15, 12 };
		int[] ans = nextGreaterElement2(arr);

		int i = 0;
		for (int val : ans) {
			System.out.println(arr[i++] + " -> " + val);
		}

		System.out.println(" -- Stock Span -- ");
		int[] a = { 90, 60, 15, 70, 45, 25, 50, 100, 5, 30, 80 };
		int[] res = stockSpan(a);

		for (int val : res) {
			System.out.print(val + " ");
		}
	}

	public static void displayReverse(Stack s) throws Exception {

		if (s.isEmpty()) {
			return;
		}

		int temp = s.pop();
		displayReverse(s);
		System.out.println(temp);
		s.push(temp);

	}

	public static void actualReverse(Stack s, Stack helper) throws Exception {

		if (s.isEmpty()) {
			actualReverse2(s, helper);
			return;
		}

		int temp = s.pop();
		helper.push(temp);
		actualReverse(s, helper);
	}

	public static void actualReverse2(Stack s, Stack helper) throws Exception {

		if (helper.isEmpty())

		{
			return;
		}

		int temp = helper.pop();

		actualReverse2(s, helper);
		s.push(temp);

	}

	public static void nextGreaterElement(int[] arr) {

		java.util.Stack<Integer> s = new java.util.Stack<>();

		for (int i = 0; i < arr.length; i++) {

			while (!s.isEmpty() && arr[i] > s.peek()) {
				System.out.println(s.pop() + " -> " + arr[i]);
			}

			s.push(arr[i]);

		}

		while (!s.isEmpty()) {
			System.out.println(s.pop() + " -> " + -1);
		}

	}

	public static int[] nextGreaterElement2(int[] arr) {

		int[] ans = new int[arr.length];

		java.util.Stack<Integer> s = new java.util.Stack<>();

		for (int i = 0; i < arr.length; i++) {

			while (!s.isEmpty() && arr[i] > arr[s.peek()]) {
				ans[s.pop()] = arr[i];
			}

			s.push(i);

		}

		while (!s.isEmpty()) {
			ans[s.pop()] = -1;
		}

		return ans;

	}

	public static int[] stockSpan(int[] arr) {

		java.util.Stack<Integer> s = new java.util.Stack<>();

		int[] ans = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {

			while (!s.isEmpty() && arr[i] > arr[s.peek()]) {
				s.pop();
			}

			if (s.isEmpty()) {
				ans[i] = i + 1;
			} else {
				ans[i] = i - s.peek();
			}

			s.push(i);

		}

		return ans;

	}

}






