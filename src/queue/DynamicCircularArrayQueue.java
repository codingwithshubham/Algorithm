package queue;

public class DynamicCircularArrayQueue {

	private int length =0;
	private int front = -1;
	private int rear = -1;
	private int[] queue;
	private int capacity = 5;
	
	public DynamicCircularArrayQueue() {
		queue = new int[capacity]; //default capacity
	}
	
	public int getLength() {
		return length;
	}
	
	public void enqueue(int data) {
		
		//need to expand array
		if((rear+1)%capacity == front) {
			int[] newQueue = new int[capacity*2];
			
			int i=front, j=0;
			
			for( ; i!=rear; i=(i+1)%capacity, j++) {
				newQueue[j] = queue[i];
			}
			
			newQueue[j] = queue[i];
			
			front = 0;
			rear = j;
			queue = newQueue;
			capacity = 2*capacity;
		}
		
		if(front == -1)
			front = rear = 0;
		else
			rear = (rear+1) % capacity;
		
		queue[rear] = data;
		length++;	
	}
	
	public int dequeue() {
		
		if(front == -1)
			return -1;
		
		int data = queue[front];
		
		if(front == rear) 
			front = rear = -1;
		else
			front = (front+1)%capacity;
		
		length--;
		
		return data;
	}
	
	public void display() {
		if(front == -1) {
			System.out.println("Queue is Empty");
			return;
		}
		
		int i=front;
		
		for(; i!=rear; i = (i+1)%capacity) {
			System.out.print(queue[i]+" ");
		}
		
		System.out.println(queue[i]);
			
	}
}
