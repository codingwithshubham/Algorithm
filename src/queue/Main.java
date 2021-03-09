package queue;

import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		
		DynamicCircularArrayQueue queue = new DynamicCircularArrayQueue();
		LinkedList l;
		
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		queue.enqueue(6);
		
		queue.display();
		
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		
		queue.enqueue(6);
		
		queue.display();
		
		queue.dequeue();
		
		queue.display();
		
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		
		queue.display();
		
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		
		queue.display();
		
		queue.dequeue();
		
		queue.display();
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		
		LinkedQueue queue1 = new LinkedQueue();
		
		queue1.enqueue(1);
		queue1.enqueue(2);
		queue1.enqueue(3);
		queue1.enqueue(4);
		queue1.enqueue(5);
		queue1.enqueue(6);
		
		queue1.display();
		
		queue1.dequeue();
		queue1.dequeue();
		queue1.dequeue();
		queue1.dequeue();
		
		queue1.enqueue(6);
		
		queue1.display();
		
		queue1.dequeue();
		
		queue1.display();
		
		queue1.enqueue(2);
		queue1.enqueue(3);
		queue1.enqueue(4);
		
		queue1.display();
		
		queue1.dequeue();
		queue1.dequeue();
		queue1.dequeue();
		queue1.dequeue();
		
		queue1.display();
		
		queue1.dequeue();
		
		queue1.display();
		
	}

}
