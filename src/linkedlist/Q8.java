package linkedlist;
import java.util.*;

/*
 *  clone a linked list having 2 pointers next and random
 */
public class Q8 {
	
	public static RandomListNode clone(RandomListNode head) {
		HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
		
		RandomListNode cur = head;
		
		while(cur!=null) {
			RandomListNode newNode = new RandomListNode(cur.getData());
			map.put(cur, newNode);
			
			cur = cur.getNext();
		}
		
		cur = head;
		
		while(cur!=null) {
			RandomListNode cloneNode = map.get(cur);
			cloneNode.setNext(map.get(cur.getNext()));
			cloneNode.setRandom(map.get(cur.getRandom()));
			
			cur = cur.getNext();
		}
		
		return map.get(head);	//head of clone list
	}

}
