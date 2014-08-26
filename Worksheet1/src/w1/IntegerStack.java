package w1;

public class IntegerStack {
	private int [] array = new int[2];
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
	
	public void push(int value) {
		if(top == array.length) throw new StackFullException();
		array[top++] = value;
	}
	
	public int top() {
		if(top == 0) throw new StackEmptyException();	//Checked exception
		return array[top - 1];
	}
	
	public int pop() {
		if(top == 0) throw new StackEmptyException();
		return array[--top];
	}
	
	public String toString(){
		String out = "[" + top + " / " + array.length + "]";
		
		for(int i= 0; i < array.length; i++){
			out += "  " + array[i];
			
		}
		
		return out;
		}
	

	public static void main(String [] args){
		IntegerStack stack = new IntegerStack();
		
		try {
			stack.push(17);
		} catch (StackFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(stack);
		
		try {
			stack.push(11);
		} catch (StackFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(stack);
		
		try {
			stack.push(12);
		} catch (StackFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(stack);
}
	
	
}