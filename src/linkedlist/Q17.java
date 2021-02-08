package linkedlist;
/*
 * add in linkedlist without reversing nodes
 * eg: 1->2->3 + 9->9, op: 2->2->2
 * 
 * hint : use recursion
 */
public class Q17 {
	//recurssive fn
	public static int add(ListNode one, int size1, ListNode two, int size2, ListNode res){
        
        int pcarry = 0, ccarry = 0;
        
        if(one == null && two == null)
            return 0;
        
        if(size1>size2){
            pcarry = add(one.getNext(), size1-1, two, size2, res);
            int sum = one.getData() + pcarry;
            ccarry = sum/10;
            sum = sum%10;
            addFirst(res, sum);
        }
        else if(size1 < size2){
            pcarry = add(one, size1, two.getNext(), size2-1, res);
            int sum = two.getData() + pcarry;
            ccarry = sum/10;
            sum = sum%10;
            addFirst(res, sum);
        }
        else{
            pcarry = add(one.getNext(), size1-1, two.getNext(), size2-1,  res);
            int sum = one.getData() + two.getData() + pcarry;
            ccarry = sum/10;
            sum = sum%10;
            addFirst(res, sum);
        }
            
            
        return ccarry;
            
    }
	
	//caller
	public static ListNode addNodes(ListNode head1, ListNode head2) {
		ListNode res = new ListNode(0);
		int carry = add(head1, findLength(head1), head2, findLength(head2), res);
		
		if(carry > 0) {
			addFirst(res, carry);
		}
		
		return res.getNext();
	}
	
	
	
	public static ListNode addFirst(ListNode node, int data) {
		ListNode newNode = new ListNode(data);
		
		newNode.setNext(node.getNext());
		node.setNext(newNode);
		
		return node;
	}
	
	public static int findLength(ListNode head) {
		int len = 0;
		
		while(head!=null) {
			len++;
			head = head.getNext();
		}
		
		return len;
	}
}
