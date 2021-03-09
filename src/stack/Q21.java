package stack;
import java.util.*;

/*
 * Sliding window Maximun
 */

public class Q21 {
	
	//using stack
	public void way1(int[] a, int k) {
		ArrayDeque<Integer> stack = new ArrayDeque();
	    
	    int[] nextGR = new int[a.length];
	    
	    for(int i=0; i<a.length; i++){
	       
	        while(!stack.isEmpty() && a[stack.peek()]<a[i])
	            nextGR[stack.pop()] = i;
	            
	        stack.push(i);
	        
	    }
	    
	    while(!stack.isEmpty())
	        nextGR[stack.pop()] = -1; //if no next Greater in array
	    
	    ArrayList<Integer> ans = new ArrayList();
	    
	    for(int i=0;i<a.length-k+1; i++){
	        int j=i;
	        
	       while(nextGR[j]!=-1 && nextGR[j]<i+k)
	            j=nextGR[j];
	        
	        ans.add(a[j]);
	    }
	    
	    for(int i=0; i<ans.size(); i++){
	        System.out.println(ans.get(i));
	    }
	}
	
	//using Deque
	public void way2(int[] a, int k) {
		ArrayDeque<Integer> queue = new ArrayDeque();
	    
	    for(int i=0; i<k; i++){
	        
	        while(!queue.isEmpty() && a[queue.peekLast()]<=a[i])
	            queue.pollLast();
	            
	        queue.offer(i);
	    }
	    
	    ArrayList<Integer> ans = new ArrayList();
	    
	    for(int i=k; i<a.length; i++){
	        ans.add(a[queue.peekFirst()]);
	        
	        if(queue.peekFirst() == i-k)
	            queue.pollFirst();
	            
	        while(!queue.isEmpty() && a[queue.peekLast()]<=a[i])
	            queue.pollLast();
	        
	        queue.offer(i); 
	    }
	    
	    ans.add(a[queue.peekFirst()]);
	    
	    for(int i=0; i<ans.size(); i++){
	        System.out.println(ans.get(i));
	    }
	}
}
