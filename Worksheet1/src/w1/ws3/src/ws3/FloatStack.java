package ws3;

public class FloatStack {
	
	private float [] array = new float[10];
	private int top = 0;
	
	public int size(){
		return top;
	}
	
	public boolean isEmpty(){
		return top == 0;
	}
	
	public boolean isFull(){
		return top == array.length;
	}
	
	public void push(float value) throws StackFullException {
		if(top == array.length) {
			throw new StackFullException();
		}
		array[top++] = value;
	}
	
	public float top() throws StackEmptyException {
		if(top == 0) {
			throw new StackEmptyException();
		}
		return array[top - 1];
		
	}
	
	public float pop() throws StackEmptyException {
		if(top == 0){
			throw new StackEmptyException();
		}
		
		return array[--top];
	}
	


	public String toString(){
		String out = "[" + top + " / " + array.length + "]";
		
		for(int i= 0; i < array.length; i++){
			out += "  " + array[i];
			
		}
		
		return out;
	}
	

	public static void main(String [] args) throws StackFullException, StackEmptyException{
		FloatStack stack = new FloatStack();
		
		
			stack.push(13.2f);
			System.out.println(stack);
			
			stack.push(4.2f);
			System.out.println(stack);
			
			stack.push(3.0f);
			System.out.println(stack);
			
			stack.push(2.6f);
			System.out.println(stack);
			
			stack.pop();
			System.out.println(stack);
			
			stack.pop();
			System.out.println(stack);
			
			stack.push(1.2f);
			System.out.println(stack);
			
			stack.pop();
			System.out.println(stack);
			
			stack.pop();
			System.out.println(stack);
			
			stack.push(5.4f);
			System.out.println(stack);
			
			stack.push(6.9f);
			System.out.println(stack);
			
			
			while(!stack.isEmpty()){
				stack.pop();
				System.out.println(stack);
			}
			
			System.out.println("\n" + stack);
			
		
}
	
	

}