package linkedlist;

import java.util.*;

//check linked list is palindrome or not
public class Q5 {
	
	public static boolean isPalindrome1(ListNode head) {
		
		int length = 0;
		
		ListNode curNode = head;
		
		while(curNode != null) {
			length++;
			
			curNode = curNode.getNext();
		}
		
		int start2 = length/2+1;
		
		Stack<Integer> s = new Stack();
		
		curNode = head;
		
		for(int i=1; i<start2; i++) {
			curNode = curNode.getNext();
		}
		
		while(curNode!=null) {
			s.push(curNode.getData());
			curNode = curNode.getNext();
		}
		
		curNode = head;
		
		for(int i=1; i<start2; i++) {
			if(curNode.getData()!=s.pop())
				return false;
			
			curNode = curNode.getNext();
		}
		
		return true;
		
	}

	public static boolean isPalindrome2(ListNode head) {
		
		int len = 0;
		
		ListNode cur = head;
		
		while(cur!=null) {
			len++;
			
			cur = cur.getNext();
		}
		
		ListNode ptr1 = head, ptr2 = head;
		
		int ptr2Pos = 0;
		
		if(len%2 == 0)
			ptr2Pos = len/2+1;
		else
			ptr2Pos = len/2+2;
		
		for(int i=1; i<ptr2Pos; i++) {
			ptr2 = ptr2.getNext();
		}
		
		ptr2 = Q3.reverse2(ptr2); // O(N)
		
		while(ptr2!=null) {
			if(ptr1.getData() != ptr2.getData())
				return false;
			
			ptr1 = ptr1.getNext();
			ptr2 = ptr2.getNext();
		}
		
		return true;

	}
	
}
