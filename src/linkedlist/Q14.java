package linkedlist;

public class Q14 {
	
	public static ListNode insertionSort(ListNode head) {
		
		ListNode cur = head;
		
		ListNode newHead = null;
		
		while(cur!=null) {
			
			ListNode next = cur.getNext();
			
			if(newHead == null) {
				newHead=cur;
				newHead.setNext(null);
			}
			else {
				boolean inserted = false;				
				
				if(newHead.getData()>cur.getData()) { //dont forget insertion in begin
					cur.setNext(newHead);
					newHead = cur;
					inserted = true;
				}
				
				ListNode ptr = newHead;
				
				while(!inserted && ptr.getNext()!=null) {
					
					if(ptr.getNext().getData()>cur.getData()) {
						ListNode nextPtr = ptr.getNext();
						ptr.setNext(cur);
						cur.setNext(nextPtr);
						
						inserted = true;
						break;
					}
						
					ptr = ptr.getNext();
					
				}
				
				if(!inserted) {
					ptr.setNext(cur);
					cur.setNext(null);
				}	
			}
			
			cur = next;
		}
		
		return newHead;
	}
}
