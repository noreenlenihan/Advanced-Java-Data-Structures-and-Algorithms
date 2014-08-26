package ws3;

public class LongStack {
	

	private long [] array = new long[10];
	private int top = 0;
	private long sum = 0;
	private int n = 0;
	
	public int size(){
		return top;
	}
	
	public boolean isEmpty(){
		return top == 0;
	}
	
	public boolean isFull(){
		return top == array.length;
	}
	
	public void push(long value) throws StackFullException {
		if(top == array.length) {
			throw new StackFullException();
		}
		array[top++] = value;
	}
	
	public long top() throws StackEmptyException {
		if(top == 0) {
			throw new StackEmptyException();
		}
		return array[top - 1];
		
	}
	
	public long pop() throws StackEmptyException {
		if(top == 0){
			throw new StackEmptyException();
		}
		long popped = array[--top];
		sum += popped;
		n++;
		return popped;
	}
	
	public long getSumOfPopped(){
		return sum;
	}
	
	public long numberOfPops(){
		return n;
	}


	public String toString(){
		String out = "[" + top + " / " + array.length + "]";
		
		for(int i= 0; i < array.length; i++){
			out += "  " + array[i];
			
		}
		
		return out;
	}
	

	public static void main(String [] args) throws StackFullException, StackEmptyException{
		LongStack stack = new LongStack();
		
		
			stack.push(2l);
			System.out.println(stack);
			
			stack.pop();
			System.out.println(stack);
			
			stack.push(4l);
			System.out.println(stack);
			
			stack.push(3l);
			System.out.println(stack);
			
			stack.pop();
			System.out.println(stack);
			
			stack.push(6l);
			System.out.println(stack);
			
			stack.push(12l);
			System.out.println(stack);
			
			stack.pop();
			System.out.println(stack);
			
			stack.push(5l);
			System.out.println(stack);
			
			stack.push(9l);
			System.out.println(stack);
			
			stack.pop();
			System.out.println(stack);
			
			stack.push(3l);
			System.out.println(stack);
			
			
			while(!stack.isEmpty()){
				stack.pop();
				System.out.println(stack);
			}
			
			System.out.println("Average: " + stack.getSumOfPopped()/stack.numberOfPops());
			
			
		
}
	

}