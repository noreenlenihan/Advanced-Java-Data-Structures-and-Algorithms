package ws3;

public class LinkedList {
		
		private Node top = null;        // The bottom of the stack is null (no trays left)
		private int size = 0;			// Initially, the stack has no trays, thus size = 0
		
		public int size(){
			return size;
		}
		
		public boolean isEmpty() {       // When the top tray doesn't exist, its because it an empty stack
			if(top == null){
				return true;
			}
			else{
				return false;
			}
		}
		
		public void push(int value) {		// 
			Node n = new Node(value);		// Create a new Node Instance (n) with an element-value and a further Node instance (next)
			n.next = top;					// Point instance "next" to the current "top" instance
			top = n;						// Make Node Instance n (parent of the next Instance) the "Top" Node
			size++;
		}
		
		public int top(){ //just returns a value..doesn't change structure
			
			return top.element;
		}

		public int pop(){
			if (isEmpty()){
				throw new StackEmptyException();
			}
			int toReturn = top.element;
			top = top.next;
			size--;
			
			return toReturn;
		}		
		
		public String toString() {
			String output = "";
			Node temp = top;
			while(temp != null){
				output += temp.element + ", ";
				temp = temp.next;
				
			}
		return output;
		}
		
		private class Node {
			int element;
			Node next;
			
			public Node(int value){
				element = value;
			}
		}
		
		public static void main(String[] args) throws StackEmptyException{
			
			LinkedIntegerStack stack = new LinkedIntegerStack();
			
			stack.push(17);
			System.out.println(stack);
		
			stack.push(11);
			System.out.println(stack);
		
			try{
					stack.pop();
					System.out.println(stack);
				}
			catch(StackEmptyException ex){
					System.out.print("Stack is Empty: Error");
				}
			System.out.println("Stack: " + stack);
		}
	

}
