package stack;
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		Stack<Integer> s = new Stack();
		
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		
		System.out.println(s);
		
		Q6.recursiveReverse(s);
		
		System.out.println(s);
			
	}
	
	
}
