package tree.bst;
import java.util.*;

/*
 * kth largest
 */
public class Q10 {

	int count=1;
	
	// iterative (inorder) O(K)
	 public int kthLargest(Node root,int K)
	    {
	        //Your code here
	        Stack<Node> nodes = new Stack<>();
	        Stack<Integer> status = new Stack<>();
	        
	        if(root!=null){
	            nodes.push(root);
	            status.push(0);
	            
	            int count = 1;
	            
	            while(!nodes.isEmpty()){
	                
	                int st = status.pop()+1;
	                status.push(st);
	                
	                if(st == 1){
	                    
	                    if(nodes.peek().right!=null){
	                        nodes.push(nodes.peek().right);
	                        status.push(0);
	                    }
	                        
	                }
	                else if(st == 2){
	                    if(count == K){
	                        return nodes.pop().data;
	                    }
	                    else
	                        count++;
	                        
	                    if(nodes.peek().left!=null){
	                        nodes.push(nodes.peek().left);
	                        status.push(0);
	                    }
	                        
	                }
	                else{
	                    
	                    nodes.pop();
	                    status.pop();
	                    
	                }
	            }
	        }
	        
	        return -1;
	        
	    }

	 //recursive O(K)
	 public int kthLargest1(Node root,int K)
	    {
	        //Your code here
	        if(root!=null){
	            int right = kthLargest1(root.right, K);
	            if(right > -1)
	                return right;
	                
	            if(K == count)
	                return root.data;
	            else
	                count++;
	                
	            return kthLargest1(root.left, K);
	        }
	        
	        return -1;
	        
	    }

	 //for O(h) same as Q9
}
