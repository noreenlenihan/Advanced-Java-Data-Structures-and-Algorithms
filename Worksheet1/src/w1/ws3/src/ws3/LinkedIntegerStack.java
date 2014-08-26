package ws3;

public class LinkedIntegerStack {
	private Node top = null;
	private int size = 0;
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		if(top == null){
		return true;
		}
		else{
		return false;
		}
		// or return size == 0;
	}
	
	public void push(int value){
		Node n = new Node(value);
		n.next = top;
		top = n;
		size++;
	}
	
	public int top(){
		return top.element;
	}
	
	public int pop(){
		if(isEmpty()){
			throw new StackEmptyException();
		}
		int temp = top.element;
		top = top.next;
		size--;
		return temp;
		
	}
	
	private class Node{
		int element;
		Node next;
		
		public Node(int value){
			element = value;
		}
		
		
	}
	
	public String toString(){
		String out = size + " " + top() ;
		
		
		
		return out;
	}
}
