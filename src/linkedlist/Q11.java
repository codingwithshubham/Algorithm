package linkedlist;

/*
 * return n/kth node
 */
public class Q11 {
	
	public static ListNode findNode(ListNode head, int k) {
		
		ListNode nbkNode = null;
		
		ListNode curNode = head;
		
		for(int i=1; curNode!=null; i++) {
			if(i%k==0) {
				if(nbkNode == null)
					nbkNode = head;
				else
					nbkNode = nbkNode.getNext();
			}
			
			curNode = curNode.getNext();
		}
		
		return nbkNode;
	}

}
