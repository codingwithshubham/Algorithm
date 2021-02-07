package linkedlist;

/*
 * reverse linked list in pairs of k only if k nodes are present 
 */
public class Q6 {
	
	public static ListNode reverseInKPairs(ListNode head, int k) {
		ListNode cur = head;
		
		int len = 0;
		
		while(cur!=null) {
			len++;
			cur=cur.getNext();
		}
		
		if(k<1 || k>len)	//corner case
			return head;
		
		int reverseCount = len/k;
		
		cur = head;
		ListNode preTail = null;
		
		for(int i=1; i<=reverseCount; i++) {
			
			ListNode pre = null;
			ListNode curTail = cur;
			
			int j=1;
			
			while(j<=k) {
				ListNode next = cur.getNext();
				cur.setNext(pre);
				pre = cur;
				cur = next;
				
				j++;
			}
			
			ListNode curHead = pre;
			
			curTail.setNext(cur);
			
			if(preTail == null)
				head = curHead;
			else
				preTail.setNext(curHead);
			
			preTail = curTail;

		}
		return head;
	}
	
	//recursive
	public static ListNode reverseInKPairs2(ListNode head, int k) {
		if(k<1)
			return head;
		
		boolean isKNodePresent = false;
		
		ListNode cur = head;
		
		int i=k;
		
		while(cur!=null && i>0) {
			cur = cur.getNext();
			i--;
		}
		
		if(i==0)
			isKNodePresent = true;
		
		if(!isKNodePresent)
			return head;
		else {
			
			cur = head;
			ListNode pre = null;
			
			ListNode curTail = cur;
			
			i=1;
			
			while(i<=k) {
				ListNode next = cur.getNext();
				cur.setNext(pre);
				pre = cur;
				cur = next;
				
				i++;
			}
			
			ListNode curHead = pre;
			
			curTail.setNext(reverseInKPairs2(cur, k));
			
			return curHead;
		}
	}
}
