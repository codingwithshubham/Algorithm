package queue;

public class LinkedQueue {
	private ListNode front = null;
	private ListNode rear = null;
	private int length = 0;
	
	public int getLength() {
		return length;
	}
	
	public void enqueue(int data) {
		
		ListNode newNode = new ListNode();
		newNode.setData(data);
		
		if(front == null) {
			front = rear = newNode;
		}
		else {
			rear.setNext(newNode);
			rear = newNode;
		}
		
		length++;
	}
	
	public int dequeue() {
		if(front == null)
			return -1;
		
		int data = front.getData();
		
		if(front == rear)
			front = rear = null;
		else
			front = front.getNext();
		
		length--;
		
		return data;
	}
	
	public void display() {
		
		if(front == null) {
			System.out.println("Queue is Empty");
			return;
		}
		
		ListNode ptr = front;
		
		while(ptr.getNext()!=null) {
			System.out.print(ptr.getData()+" ");
			ptr = ptr.getNext();
		}
		
		System.out.println(ptr.getData());
	}
	

}

class ListNode{
	private int data;
	private ListNode next;
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public ListNode getNext() {
		return next;
	}
	public void setNext(ListNode next) {
		this.next = next;
	}
	
}
