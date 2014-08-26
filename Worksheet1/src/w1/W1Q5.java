/** Question 5
 * 
 * The purpose of Question 5 is to produce a comma-delimited list of 
 * decreasing even-numbers, starting at 20 and ceasing at 0.
 * 
 * @author Noreen 
 * 
 */

package w1;

public class W1Q5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int i = 20;

		while (i >= 0) {
			if (i < 20) {
				System.out.print(", "); // I have added a space after the comma
										// for ease of reading of list
			}
			System.out.print(i);
			i -= 2;
		}

	}

}
