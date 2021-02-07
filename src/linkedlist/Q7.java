package linkedlist;

/*
 * Josephus circle problem for n nos. and mth pos will be removed
 */
public class Q7 {
	
	public static int josephus(int n, int m) {
		if(n<1)
			return -1;
		
		ListNode head = new ListNode(1);
		ListNode cur = head;
		
		for(int i=2; i<=n; i++) {
			ListNode newNode = new ListNode(i);
			cur.setNext(newNode);
			cur = newNode;
		}
		
		cur.setNext(head); // making list circular
		
		cur = head;
		
		while(cur.getNext()!=cur) {
			int i=1;
			//m-1 for node before m and < as we note want to run while loop for m-1 node
			while(i<m-1) {
				cur = cur.getNext();
				i++;
			}
			
			cur.setNext(cur.getNext().getNext());
			cur = cur.getNext();
		}
		
		
		return cur.getData();
	}

}
