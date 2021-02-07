package linkedlist;

public class RandomListNode {
	private int data;
	private RandomListNode next;
	private RandomListNode random;
	
	public RandomListNode(int data) {
		this.data = data;
	}
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public RandomListNode getNext() {
		return next;
	}
	public void setNext(RandomListNode next) {
		this.next = next;
	}
	public RandomListNode getRandom() {
		return random;
	}
	public void setRandom(RandomListNode random) {
		this.random = random;
	}


}
