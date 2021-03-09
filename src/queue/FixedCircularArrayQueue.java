package queue;

public class FixedCircularArrayQueue {
	
	private int length = 0;
	private int front = -1;
	private int rear = -1;
	final int capacity = 5;
	private int[] queue;
	
	public FixedCircularArrayQueue() {
		queue = new int[capacity];
	}
	
	public void enqueue(int data) {
		//overflow
		if((rear+1)%capacity == front) {
			System.out.println("Overflow");
			return;
		}
		
		//if empty
		if(front == -1) {
			front = rear = 0;
		}
		else {
			rear = (rear+1)%capacity;
		}
		
		queue[rear] = data;
		
		length++;
	}
	
	public int dequeue() {
		//underflow
		if(front == -1)
			return -1;
		
		int data = queue[front];
		
		//single element
		if(front == rear) {
			front = -1;
			rear = -1;
		}
		else {
			front = (front+1)%capacity;
		}
		
		length--;
			
		return data;
	}
	
	public int getLength() {
		return length;
	}
	
	public void display() {
		
		if(front == -1) {
			System.out.println("Queue is Empty");
			return;
		}
		
		int i = front;
		
		for( ; i!=rear; i=(i+1)%capacity) {
			System.out.print(queue[i]+" ");
		}
		
		System.out.println(queue[i]);
	}
	
}
