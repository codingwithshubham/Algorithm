package linkedlist;

//reverse linked list
public class Q3 {
	
	//resvesing by swapping node.data (O(n2))
	public static void reverse1(LinkedList myList) {
		
		if(myList.getHead() == null)
			return;
		
		//because intially curNode is head pos
		int length=1;
		
		ListNode curNode = myList.getHead();
		
		while(curNode.getNext()!=null) {
			length++;
			curNode = curNode.getNext();
		}
		
		ListNode frontNode = myList.getHead();
		ListNode endNode = myList.getHead();
		
		int frontIndex=0, endIndex=length-1;
		
		while(frontIndex<endIndex) {
			int k=1;
			
			while(k<=endIndex) {
				endNode = endNode.getNext();
				k++;
			}
			
			int temp = frontNode.getData();
			frontNode.setData(endNode.getData());
			endNode.setData(temp);
			
			frontNode = frontNode.getNext();
			endNode = myList.getHead();
			
			frontIndex++;
			endIndex--;
		}
		
	}
	
	//reverse by reversing links
	public static ListNode reverse2(ListNode head) {
		ListNode prev = null, cur = head;
		
		while(cur != null) {
			ListNode next = cur.getNext();
			cur.setNext(prev);
			prev = cur;
			cur = next;
		}
		return prev;
	}
	
	//recursive
	public static ListNode reverseRecursive(ListNode head) {
		
		if(head == null)
			return null;
		
		if(head.getNext() == null)
			return head;
			
		ListNode newHead = reverseRecursive(head.getNext());
		
		ListNode next = head.getNext();
		
		next.setNext(head);
		
		head.setNext(null);
		
		return newHead;
		
	}

}
