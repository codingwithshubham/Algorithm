package linkedlist;

// get Nth node from end
public class Q1 {
	
	//using 2 ptr
	public int getN_NodeFromEnd(LinkedList list, int n) {
		
		if(list.getHead() == null)
			return -1;
		
		if(n<1 || n>list.getLength())
			return -1;
		
		ListNode ptr = list.getHead();
		
		ListNode nNode = list.getHead();
		
		int temp = 1;
		
		//n-1 because index starts from zero
		while(temp<=n-1) {
			ptr = ptr.getNext();
			temp++;
		}
		
		while(ptr.getNext() != null) {
			nNode = nNode.getNext();
			
			ptr = ptr.getNext();
		}
		
		return nNode.getData();	
	}

	public int recursiveGetN_NodeFromEnd(ListNode ptr, ListNode nNode, int n) {
		
		if(n<1)
			return -1;
		
		if(ptr.getNext() == null && n!=1)
			return -1;

			
		if(ptr.getNext() == null)
			return nNode.getData();
		
		ListNode cptr = ptr.getNext(), cnNode=nNode;
		int cn=n;

		if(n == 1)
			cnNode = nNode.getNext();
		
		if(n!=1)
			cn=n-1;
		
		return recursiveGetN_NodeFromEnd(cptr, cnNode, cn);
	}
	
	int count=0;
	public int recursiveN_Node2(ListNode node, int n) {
		
		if(node == null)
			return -1;
		
		int data = recursiveN_Node2(node.getNext(), n);
		if(data == -1) {
			count++;
			
			if(count == n)
				return node.getData();
			
			return -1;
		}
		
		return data;
	}
	
}
