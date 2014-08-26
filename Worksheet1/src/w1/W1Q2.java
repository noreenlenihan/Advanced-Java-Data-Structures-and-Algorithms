/** These programs were developed by Noreen A. Lenihan in fulfilment
 * of Worksheet 1. 
 * 
 * The object of this first assignment is to practice the conversion
 * of pseudo-code into Java. It is based on Week 1's Pseudo Code/Program
 * Comprehension quiz. 
 * 
 * Student ID: 13204807
 * Worksheet: 1
 * Course: COMP 47160
 * Question 2
 * 
 * The purpose of the Question 2 is to print a user-inputted number,
 * padded to contain 5-digits overall, by prefixing a number with "0"'s,
 * if necessary.
 * */

package w1;

import java.util.Scanner;

public class W1Q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("enter a number: ");
		int num = input.nextInt();
		System.out.print("you entered: ");

		if (num < 10000) {
			System.out.print("0");
		}

		if (num < 1000) {
			System.out.print("0");
		}

		if (num < 100) {
			System.out.print("0");
		}

		if (num < 10) {
			System.out.print("0");
		}

		System.out.println(num);

		input.close();

	}

}
