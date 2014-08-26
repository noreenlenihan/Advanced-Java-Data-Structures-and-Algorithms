/** Question corresponding to Question 1 in Worksheet 5
 * 
 * @author noreen
 */

package w5;

public class ArrayStack<E> implements Stack<E> {
		
		private E[] array = null;
		private int top = 0;
		
		public ArrayStack() {
			this(20);
		}
		
		public ArrayStack(int capacity) {
			array = (E[])(new Object[capacity]);
		}
		
		public int size() {
			return top;
		}
		
		public boolean isEmpty() {
			return top == 0;
		}
		
		public void push(E value) {
			if (top == array.length) throw new StackFullException();
			array[top++] = value;
		}
		
		public E top() {
			if (top == 0) throw new StackEmptyException(); 
			return array[top-1];
		}

		public E pop() {
			if (top == 0) throw new StackEmptyException();
			
			E temp = array[--top];
			array[top] = null;
			return temp;
		}
		
		public String toString() {
			String out = "[" + top + " / " + array.length + "]";
			for (int i=0; i< array.length; i++) {
				out += " " + array[i];
			}
			return out;
		}
		
		public static void main(String[] args) {
			ArrayStack<Object> stack = new ArrayStack<Object>();
			
			
			stack.push("er");
			System.out.println(stack);

			stack.pop();
			System.out.println(stack);
			
			stack.push(49);
			System.out.println(stack);

			stack.push(3);
			System.out.println(stack);

			stack.pop();
			System.out.println(stack);
			
			stack.push(6);
			System.out.println(stack);

			stack.push(12);
			System.out.println(stack);

			stack.pop();
			System.out.println(stack);
			
			stack.push(5);
			System.out.println(stack);

			stack.push(2);
			System.out.println(stack);

			stack.pop();
			System.out.println(stack);

			stack.push(5);
			System.out.println(stack);
			
			
		

	}
}