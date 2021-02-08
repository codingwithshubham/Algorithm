package linkedlist;
/*
 * Given a linked list and a value K, partition it such that all nodes less than K
 * come before nodes greater than or equal to K. You should preserve the original relative
 * order of the nodes in each of the two partitions. For example, given 1->4->3->2->5->2
 * and K = 3, return 1->2->2->4->3->5.
 */
public class Q15 {
	
	public static ListNode reorder(ListNode head, int k) {
		
		ListNode cur = head;
		ListNode lessThanK = null;
		
		if(head!=null) {
			if(head.getData()<k)
				lessThanK = head;
		}
		
		while(cur!=null && cur.getNext()!=null) {
			ListNode next = cur.getNext();
			
			if(next.getData() < k) {
				cur.setNext(next.getNext());
				
				if(lessThanK == null) {
					lessThanK = next;
					next.setNext(head);
					head = lessThanK;
				}
				else {
					next.setNext(lessThanK.getNext());
					lessThanK.setNext(next);
				}
				
			}
			
			cur = cur.getNext();
		}
		
		return head;
	}

}
