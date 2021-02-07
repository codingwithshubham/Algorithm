package linkedlist;

/*
 * return last node i where i%k==0
 */
public class Q9 {
	
	public static ListNode findNode(ListNode head, int k) {
		ListNode modNode = null;
		
		ListNode curNode = head;
		
		for(int i=1; curNode!=null; i++) {
			if(i%k == 0)
				modNode = curNode;
			
			curNode = curNode.getNext();
		}
		
		return modNode;

	}

}
