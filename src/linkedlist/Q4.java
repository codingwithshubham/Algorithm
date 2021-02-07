package linkedlist;

//reverse in pairs of 2
public class Q4 {
	
	public static ListNode reverseinPairs(ListNode head) {
		
		ListNode cur = head, next = null;
		
		while(cur!=null && cur.getNext()!=null) {
			
			if(next != null)
				next.setNext(cur.getNext());
			
			next = cur.getNext();
			if(cur == head)
				head = next;
			
			cur.setNext(next.getNext());
			next.setNext(cur);
			
			next = cur;
			cur = cur.getNext();
		}
		
		return head;
	}
	
	//recursive
	public static ListNode recursiveReverseInPair(ListNode head) {
		
		if(head==null || head.getNext()==null)
			return head;
		
		ListNode cur = head, next = head.getNext();
		
		ListNode rest = recursiveReverseInPair(next.getNext());
		
		next.setNext(cur);
		cur.setNext(rest);
		
		return next;
	}
}
