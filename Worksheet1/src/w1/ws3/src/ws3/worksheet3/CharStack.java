package ws3;

/**
 * Question 3
 * 
 * Student Name: Noreen Lenihan
 * Student ID: 13204807
 * Worksheet 3
 * 
 * **/

public class CharStack {
	
	private char[] array = new char[10];
	private int top = 0;
	
	public int size() {
		return top;
	}
	
	public boolean isEmpty() {
		return top == 0;
	}
	
	public void push(char value) {
		if (top == array.length) throw new StackFullException();
		array[top++] = value;
	}
	
	public int top() {
		if (top == 0) throw new StackEmptyException(); 
		return array[top-1];
	}

	public char pop() {
		if (top == 0) throw new StackEmptyException();
		
		return array[--top];
	}
	
	public String toString() {
		String out = "[" + top + " / " + array.length + "]";
		for (int i = 0;i<array.length; i++) {
			out += " " + array[i];
		}
		return out;
	}
	
	public static void main(String[] args) {
		
		//Answer: Characters popped from stack form the word 'HAPPY'
		
		CharStack stack = new CharStack();
		
		stack.push('Y');
		System.out.println(stack);

		stack.push('P');
		System.out.println(stack);
		
		stack.push('P');
		System.out.println(stack);
		
		stack.push('A');
		System.out.println(stack);
		
		stack.push('H');
		System.out.println(stack);
		
		System.out.print(stack.pop());
		System.out.print(stack.pop());
		System.out.print(stack.pop());
		System.out.print(stack.pop());
		System.out.print(stack.pop());
		

	}

}
