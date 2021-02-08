package linkedlist;
/*
 * remove duplicates from unordered list 
 */
public class Q16 {
	
	public static ListNode removeDuplicates(ListNode head) {
		ListNode cur = head;
		
		ListNode processedEnd = head;
		
		while(cur!=null) {
			ListNode ptr = head;
			
			boolean found = false;
			
			while(processedEnd!=null && ptr!=processedEnd.getNext()) {
				if(cur.getData() == ptr.getData()) {
					found = true;
					break;
				}
				
				ptr = ptr.getNext();
			}
			
			if(!found) {
				processedEnd.setNext(cur);
				processedEnd = processedEnd.getNext();
			}
			
			cur = cur.getNext();
		}
		
		if(processedEnd!=null)
			processedEnd.setNext(null);
		
		return head;
	}
}
