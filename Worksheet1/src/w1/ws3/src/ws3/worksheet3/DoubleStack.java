package ws3;

/**
 * Question 1
 * Worksheet 3
 * 
 * Student Name: Noreen Lenihan
 * Student ID: 13204807
 * 
 * 
 * **/
public class DoubleStack {

	private double[] array = new double[10];
	private int top = 0;

	public double size() {
		return top;
	}

	public boolean isEmpty() {
		return top == 0;
	}

	public boolean isFull() {
		return top == array.length;
	}

	public void push(double value) {
		if (top == array.length) {
			throw new StackFullException();
		}
		array[top++] = value;
	}

	public double top() {
		if (top == 0) {
			throw new StackEmptyException();
		}
		return array[top - 1];

	}

	public double pop() throws StackEmptyException {
		if (top == 0) {
			throw new StackEmptyException();
		}
		return array[--top];
	}

	public String toString() {
		String out = "[" + top + " / " + array.length + "]";

		for (int i = 0; i < array.length; i++) {
			out += "  " + array[i];

		}
		return out;
	}

	public static void main(String[] args) throws StackFullException,
			StackEmptyException {
		DoubleStack stack = new DoubleStack();

		stack.push(3.2);
		System.out.println(stack);

		stack.pop();
		System.out.println(stack);

		stack.push(4.2);
		System.out.println(stack);

		stack.push(3.0);
		System.out.println(stack);

		stack.push(2.6);
		System.out.println(stack);

		stack.pop();
		System.out.println(stack);

		stack.push(1.2);
		System.out.println(stack);

		stack.pop();
		System.out.println(stack);

		stack.pop();
		System.out.println(stack);

	}

}
