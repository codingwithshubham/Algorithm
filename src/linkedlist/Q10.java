package linkedlist;
/*
 * 1st node from end where i%k==0
 */
public class Q10 {
	
	public static ListNode findNode(ListNode head, int k) {
		
		ListNode modNode = null;
		
		ListNode curNode = head;
		
		for(int i=1; i<k && curNode!=null; i++) {//not wanted to run it for kth node
			curNode = curNode.getNext();
		}
		
		if(curNode!=null) {
			curNode = curNode.getNext();
			modNode = head;
		}
		
		while(curNode != null) {
			curNode = curNode.getNext();
			modNode = modNode.getNext();
		}
		
		return modNode;
	}

}
