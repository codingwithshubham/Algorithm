package linkedlist;

public class LinkedList {
	private int length;
	private ListNode head;
	
	public ListNode getHead() {
		return head;
	}
	
	public void setHead(ListNode head) {
		this.head = head;
	}
	
	public int getLength() {
		return length;
	}
	
	public void addBegin(int data) {
		ListNode node = new ListNode(data);
		
		node.setNext(head);
		head = node;
		
		length++;	
	}
	
	public void addEnd(int data) {
		
		if(head==null) {
			addBegin(data);
			return;
		}
		
		ListNode curNode = head;
		
		while(curNode.getNext()!=null) {
			curNode = curNode.getNext();
		}
		
		ListNode node = new ListNode(data);
		
		curNode.setNext(node);
		
		length++;
	}
	
	public void add(int loc, int data) {
		if(loc<0 || loc>length)
			return;
		
		// covers if list empty, 
		if(loc == 0) {
			addBegin(data);
			return;
		}
		
		int temp=1;
		
		ListNode curNode = head;
		
		while(temp<=loc-1) {
			curNode = curNode.getNext();
			temp++;
		}
		
		ListNode node = new ListNode(data);
		
		node.setNext(curNode.getNext());
		curNode.setNext(node);

		length++;
	}
	
	public int deleteBegin() {
		
		if(head == null)
			return -1;
		
		ListNode node = head;
		
		head = head.getNext();
		
		node.setNext(null);
		
		length--;
		
		return node.getData();
	}
	
	public int deleteEnd() {
		
		if(head == null)
			return -1;
		
		if(head.getNext() == null)
			return deleteBegin();
		
		ListNode curNode = head;
		
		while(curNode.getNext().getNext() != null) {
			curNode = curNode.getNext();
		}
		
		ListNode node = curNode.getNext();
		
		curNode.setNext(null);
		length--;
		
		return node.getData();
	}
	
	public int delete(int loc) {
		
		//covers if list empty case as well
		if(loc<0 || loc>=length)
			return -1;
		
		if(loc == 0) {
			return deleteBegin();
		}
		
		int temp = 1;
		
		ListNode curNode = head;
		
		while(temp<=loc-1) {
			curNode = curNode.getNext();
			temp++;
		}
		
		ListNode node = curNode.getNext();
		
		curNode.setNext(curNode.getNext().getNext());
		
		node.setNext(null);
		
		length--;
		
		return node.getData();
	}
	
	public int get(int index) {
		
		if(index<0 || index>=length)
			return -1;
		
		int temp = 1;
		
		ListNode curNode = head;
		
		while(temp<=index) {
			curNode = curNode.getNext();
			temp++;
		}
		
		return curNode.getData();
	}
	
	public void print() {
		
		if(head == null)
			return;
		
		ListNode curNode = head;
		
		while(curNode.getNext() != null) {
			System.out.print(curNode.getData()+"->");
			
			curNode = curNode.getNext();
		}
		
		System.out.println(curNode.getData());
		
	}
	
public void print(ListNode head) {
		
		if(head == null)
			return;
		
		ListNode curNode = head;
		
		while(curNode.getNext() != null) {
			System.out.print(curNode.getData()+"->");
			
			curNode = curNode.getNext();
		}
		
		System.out.println(curNode.getData());
		
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
