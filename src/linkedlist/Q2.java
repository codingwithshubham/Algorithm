package linkedlist;
//insert into sorted List
public class Q2 {
	
	public void insertInSorted(LinkedList myList, int data) {
		ListNode node = new ListNode(data);
		
		if(myList.getHead() == null) {
			myList.setHead(node);
			return;
		}
		
		// if need to insert before head
		if(myList.getHead().getData()>data) {
			node.setNext(myList.getHead());
			myList.setHead(node);
			return;
		}
		
		ListNode curNode = myList.getHead();
		
		//move to correct pos and condn 1 break if next is null thus save frrom NPE in condn 2
		while(curNode.getNext() != null && curNode.getNext().getData()<=data) {
			curNode = curNode.getNext();
		}
		
		node.setNext(curNode.getNext());
		curNode.setNext(node);
	}

}
