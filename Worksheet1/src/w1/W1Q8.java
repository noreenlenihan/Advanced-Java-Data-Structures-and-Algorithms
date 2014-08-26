/** Question 8
 * 
 * The purpose of this program is to shift all elements in
 * the hard-coded integer array one place to the left, and
 * finally, place the element at the first index position
 * in the last index slot.
 * 
 * @author Noreen
 * 
 */


package w1;

public class W1Q8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {5, 7, 3, 12, 6, 11, 1, 19, 9, 4 };

		int j = 1;
		int t = A[0];

		while (j < 10) {
			A[j - 1] = A[j];
			j += 1;
		}

		A[j - 1] = t;

		for (j = 0; j < 10; j++) {
			System.out.print(A[j] + " ");
		}
	}

}
