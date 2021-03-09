package linkedlist;

public class Main {

	public static void main(String[] args) {
		LinkedList myList = new LinkedList();
		
		myList.add(1, 5);
		
		myList.add(0, 1);
		myList.add(1, 2);
		myList.addBegin(0);
		myList.addEnd(3);
		
		myList.print();
		
//		myList.deleteBegin();
//		myList.print();
//		
//		myList.deleteEnd();
//		myList.print();
//		
//		myList.deleteBegin();
//		myList.print();
//		
//		myList.delete(3);
//		myList.print();
//		
//		myList.delete(0);
//		myList.print();
		
		System.out.println("Length : "+myList.getLength());
		System.out.println();
		
//		Q1 obj = new Q1();
//		//System.out.println(obj.getN_NodeFromEnd(myList, 5));
//		
//		ListNode ptr = myList.getHead(), nNode = myList.getHead();
//		
//		System.out.println(obj.recursiveGetN_NodeFromEnd(ptr, nNode, 0));
//		System.out.println(obj.recursiveN_Node2(myList.getHead(), 5));
		
//		Q2 obj = new Q2();
//		
//		obj.insertInSorted(myList, 3);
//		
//		myList.print();
//		System.out.println("MyList2");
//		LinkedList myList2 = new LinkedList();
//		myList2.addBegin(1);
//		myList2.addBegin(4);
//		myList2.print();
//		
//		Q3 obj1 = new Q3();
		
//		obj1.reverse(myList2);
//		
//		myList2.print();
		
		Q4 obj = new Q4();
		LinkedList newList = new LinkedList();
		newList.addEnd(9);
		newList.addEnd(2);
		newList.addEnd(2);
		newList.addEnd(9);
		newList.addEnd(9);
		newList.addEnd(9);
		
		newList.print();
		
		LinkedList newList2 = new LinkedList();
		newList2.addEnd(1);
		
		newList2.print();
		
//		System.out.println(newList.getHead().getData());
		
//		ListNode head = obj.reverseInPair(newList.getHead());
//		
//		newList.print(head);
//		
//		newList.print(obj.recursiveReverseInPir(head));
		
//		Q5 obj5 = new Q5();
//		System.out.println(obj5.isPalindrome(newList.getHead()));
		
		//newList.print(Q3.reverseRecursive(newList.getHead()));
		
		//newList.print(Q6.reverseInKPairs(newList.getHead(), 2));
		
		//System.out.println(Q7.josephus(13, 2));
		
		//System.out.println(Q11.findNode(newList.getHead(), 1).getData());
		
//		newList.print(Q16.removeDuplicates(newList.getHead()));
		
		newList.print(Q17.addNodes(newList.getHead(), newList2.getHead()));
		
		

	}

}
