package stack;

public class ArrayStack {
	private int capacity;
	private int[] stack;
	private int top;
	
	public ArrayStack() {
		capacity = 10; //default capacity
		top = -1;
		stack = new int[capacity];
	}
	
	public ArrayStack(int capacity) {
		this.capacity = capacity;
		top = -1;
		stack = new int[capacity];
	}
	
	public int getSize() {
		return top+1;
	}
	
	public void push(int data) {
		if(top == capacity-1) {
			System.out.println("Overflow");
			return;
		}
		
		stack[++top] = data;
	}
	
	public int pop() {
		if(top == -1) {
			System.out.println("Underflow");
			return -1;
		}
		
		int data = stack[top--];
		
		return data;
	}
	
	public boolean isEmpty() {
		if(top == -1)
			return true;
		
		return false;
	}
	
	public void display() {
		if(top == -1) {
			System.out.println("Empty");
			return;
		}
		
		int i=top;
		
		for(; i>0; i--) {
			System.out.print(stack[i]+" ");
		}
		
		System.out.println(stack[i]);
	}
	
}
