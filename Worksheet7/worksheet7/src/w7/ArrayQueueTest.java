/** Implementation of ArrayQueueTest which tests the array-based queue 
 * with various operations
 * 
 * @author noreen
 */

package w7;

public class ArrayQueueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> queueie = new ArrayQueue<Integer>();
		
		try{
		queueie.enqueue(10);
		System.out.println(queueie);
		
		queueie.enqueue(5);
		System.out.println(queueie);
		
		queueie.dequeue();
		System.out.println(queueie);
		
		queueie.enqueue(15);
		System.out.println(queueie);
		
		queueie.enqueue(3);
		System.out.println(queueie);
		
		queueie.dequeue();
		System.out.println(queueie);
		
		queueie.enqueue(7);
		System.out.println(queueie);
		
		queueie.dequeue();
		System.out.println(queueie);
		
		queueie.enqueue(20);
		System.out.println(queueie);
		}
		catch(Exception ex){
			System.out.println("Sorry bro, queue is either too full or too empty!");
		}
		
		int sum=0;
		while( !queueie.isEmpty()){
			sum+=queueie.dequeue();
		}
		
		System.out.println("Total value of remaining integers: " + sum);
		
	}

}
