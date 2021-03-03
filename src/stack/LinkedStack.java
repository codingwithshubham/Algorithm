package stack;

public class LinkedStack {
	private ListNode top;
	private int size;
	
	public int getSize() {
		return size;
	}
	
	public void push(int data) {
		ListNode node = new ListNode(data);
		node.setNext(top);
		top = node;
	}
	
	public int pop() {
		if(top == null) {
			System.out.println("Underflow");
			return -1;
		}
		
		int data = top.getData();
		top = top.getNext();
		
		return data;
	}
	
	public boolean isEmpty() {
		if(top == null)
			return true;
		
		return false;
	}
	
	public void display() {
		if(top == null) {
			System.out.println("Empty");
			return;
		}
		
		ListNode node = top;
		
		while(node.getNext() != null) {
			System.out.println(node.getData()+" ");
			node = node.getNext();
		}
		
		System.out.println(node.getData());
	}

}

class ListNode{
	
	private int data;
	private ListNode next;
	
	public ListNode(int data) {
		this.data = data;
	}

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
