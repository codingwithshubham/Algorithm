package linkedlist;
/*
 * rotate list right by k
 */
public class Q13 {
	
	public static ListNode rotateRight(ListNode head, int k) {
		if(k<=0)
			return head;
		
		ListNode ptr1=head, ptr2 = null;
		
		for(int i=1; i<k && ptr1!=null; i++) {
			if(ptr1.getNext() == null)
				ptr1 = head;
			else
				ptr1 = ptr1.getNext();
		}
		
		
		while(ptr1!=null && ptr1.getNext()!=null) {
			ptr1 = ptr1.getNext();
			
			if(ptr2 == null)
				ptr2 = head;
			else
				ptr2 = ptr2.getNext();
		}
		
		if(ptr2!=null) {
			ptr1.setNext(head);
			head = ptr2.getNext();
			ptr2.setNext(null);
		}
		
		return head;
	}
}
