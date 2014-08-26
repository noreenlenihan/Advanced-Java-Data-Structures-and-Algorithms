/** Question 9
 * 
 * The purpose of this program is to produce a string 
 * representation of the number 'num' that has been padded
 * to have n-digits. In this case, it pads the number (75)
 * to have 6-digit width.
 * 
 */

package w1;

public class W1Q9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fn(75, 6));
	}

	public static String fn(int num, int digits) {
		String output = "";
		int mult = 1;

		for (int j = 1; j <= digits; j++) {
			if (num < mult) {
				output += "0";
			}
			mult *= 10;
		}

		output += num;
		return output;

	}

}
