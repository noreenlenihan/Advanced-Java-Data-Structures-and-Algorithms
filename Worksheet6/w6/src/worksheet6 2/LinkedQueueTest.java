/** Question 3 of Worksheet 6
 * 
 * This program demonstrates various operations
 * of the LinkedQueue class.
 * 
 * @author noreen
 * 
 * 
 */

package worksheet6;

public class LinkedQueueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Queue<Integer> q = new LinkedQueue<Integer>();

		q.enqueue(10);
		System.out.println(q);

		q.enqueue(5);
		System.out.println(q);

		q.dequeue();
		System.out.println(q);

		q.enqueue(15);
		System.out.println(q);

		q.enqueue(3);
		System.out.println(q);

		q.dequeue();
		System.out.println(q);

		q.enqueue(7);
		System.out.println(q);

		q.dequeue();
		System.out.println(q);

		q.enqueue(20);
		System.out.println(q);

		int sum = 0;
		while (!q.isEmpty()) {
			sum += q.dequeue();
			System.out.println(q);
		}

		System.out.println("Total of remaining integers \nleft in queue: "
				+ sum);

	}

}