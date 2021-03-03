package stack;
import java.util.*;

public class Q6 {
	
	public static void recursiveReverse(Stack<Integer> s) {
		if(s.empty())
			return;
		
		int data = s.pop();
		recursiveReverse(s);
		insertAtEnd(s, data);
	}
	
	public static void insertAtEnd(Stack<Integer> s, int data) {
		
		if(s.empty()) {
			s.push(data);
			return;
		}
		
		int temp = s.pop();
		insertAtEnd(s, data);
		s.push(temp);
	}

}
