/** Question 2 of DSA Practical, Worksheet 9
 * 
 * @author noreen
 */


package w9;

public class LinkedListQueue<T> implements Queue<T>{
	private List<T> queuelist = new LinkedList<T>();
	
	@Override
	public void enqueue(T value) {
		queuelist.insertLast(value);
		
	}

	@Override
	public T dequeue() {
		return queuelist.remove(queuelist.first());
		
	}

	@Override
	public T front() {
		return queuelist.first().element();
	}

	@Override
	public boolean isEmpty() {
		return queuelist.isEmpty();
	}

	@Override
	public int size() {
		return queuelist.size();
	}
	public String toString() {
		return queuelist.toString();

	}
	
	public static void main(String[] args) {
		Queue<Integer> queuelistTest = new LinkedListQueue<Integer>();
		
		queuelistTest.enqueue(10);
		System.out.println(queuelistTest);
		queuelistTest.enqueue(5);
		System.out.println(queuelistTest);
		queuelistTest.dequeue();
		System.out.println(queuelistTest);
		queuelistTest.enqueue(15);
		System.out.println(queuelistTest);
		queuelistTest.enqueue(3);
		System.out.println(queuelistTest);
		queuelistTest.dequeue();
		System.out.println(queuelistTest);
		queuelistTest.enqueue(7);
		System.out.println(queuelistTest);
		queuelistTest.dequeue();
		System.out.println(queuelistTest);
		queuelistTest.enqueue(20);
		System.out.println(queuelistTest);
		
		int sum = 0;
		while (!queuelistTest.isEmpty()) {
			sum += queuelistTest.dequeue();
		}
		
		System.out.println("Total sum of remaining integers: " + sum);

	}


}