package linkedlist;
/*
 * Given a singly linked list L: L1-> L2-> L3...-> Ln–1-> Ln, reorder it to: L1->Ln-> L2-> Ln–1......
 */
public class Q12 {

	public static ListNode rearrange(ListNode head) {
		
		if(head == null)
			return head;
		
		ListNode ptr1x = head, ptr2x = head;
		
		while(ptr2x.getNext()!=null && ptr2x.getNext().getNext()!=null) {
			ptr1x= ptr1x.getNext(); 
			ptr2x = ptr2x.getNext().getNext();
		}
		ListNode list1Tail = ptr1x;
		
		ListNode list2Head = ptr1x.getNext();
		
		list1Tail.setNext(null); //never forget to break link with 2nd part
		
		list2Head = Q3.reverse2(list2Head);
		
		ListNode cur = head;
		
		while(list2Head!=null) {
			ListNode next = cur.getNext();
			
			cur.setNext(list2Head);
			list2Head = list2Head.getNext();
			cur = cur.getNext();
			cur.setNext(next);
			cur = cur.getNext();
		}
		
		return head;
	}
}
