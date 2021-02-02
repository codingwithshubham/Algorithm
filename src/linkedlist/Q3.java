package linkedlist;

//reverse linked list
public class Q3 {
	
	public void reverse(LinkedList myList) {
		
		if(myList.getHead() == null)
			return;
		
		//because intially curNode is head pos
		int length=1;
		
		ListNode curNode = myList.getHead();
		
		while(curNode.getNext()!=null) {
			length++;
			curNode = curNode.getNext();
		}
		
		ListNode frontNode = myList.getHead();
		ListNode endNode = myList.getHead();
		
		int frontIndex=0, endIndex=length-1;
		
		while(frontIndex<endIndex) {
			int k=1;
			
			while(k<=endIndex) {
				endNode = endNode.getNext();
				k++;
			}
			
			int temp = frontNode.getData();
			frontNode.setData(endNode.getData());
			endNode.setData(temp);
			
			frontNode = frontNode.getNext();
			endNode = myList.getHead();
			
			frontIndex++;
			endIndex--;
		}
		
	}

}
