/** Question 2
 * 
 * @author noreen
 * 
 * */


package Stacks;

public class LinkedStack implements Stack {
	private Node top = null;
	private int size = 0;

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void push(Object object) {
		Node n = new Node(object);
		n.next = top;

		top = n;
		size++;
	}

	public Object top() {
		if (isEmpty()) {
			throw new StackEmptyException();
		}
		return top.element;
	}

	public Object pop() {
		if (isEmpty()) {
			throw new StackEmptyException();
		}
		Object toReturn = top.element;

		top = top.next;
		size--;

		return toReturn;
	}

	private class Node {
		Object element;
		Node next;

		public Node(Object object) {
			element = object;
		}
	}

	public String toString() {

		String out = "[" + size + " element(s)]: ";
		Node n = top;
		while (n != null) {
			out += "[" + n.element + "|-]-> ";
			n = n.next;
		}
		return out;
	}

	/** Testing link-based approach using various push and pop operations */
	public static void main(String[] args) {
		LinkedStack linkstk = new LinkedStack();

		linkstk.push('e');
		System.out.println(linkstk);

		linkstk.push('2');
		System.out.println(linkstk);

		linkstk.pop();
		System.out.println(linkstk);

		linkstk.pop();
		System.out.println(linkstk);
	}
}
