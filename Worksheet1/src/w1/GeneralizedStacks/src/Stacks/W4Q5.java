/**
 * Question 5
 * 
 * @author noreen
 * 
 * */


package Stacks;

import java.util.Scanner;

public class W4Q5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		System.out.print("Please enter a string: ");
		String a = input.nextLine();

		System.out.print("Reverse is: ");
		reverse(a);
		input.close();

	}

	public static void reverse(String s) {
		ArrayStack stack = new ArrayStack();

		for (int i = 0; i < s.length(); i++) {
			stack.push(s.charAt(i));
		}

		while (stack.size() != 0) {
			System.out.print(stack.pop());
		}

	}

}